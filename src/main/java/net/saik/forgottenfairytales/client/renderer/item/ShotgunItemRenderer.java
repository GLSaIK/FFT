package net.saik.forgottenfairytales.client.renderer.item;

import org.joml.Vector3f;

import org.checkerframework.checker.units.qual.s;

import net.saik.forgottenfairytales.client.model.animations.shotgunAnimation;
import net.saik.forgottenfairytales.client.model.Modelshotgun;
import net.saik.forgottenfairytales.client.ItemArms;

import net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.Minecraft;

import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.WeakHashMap;
import java.util.Set;
import java.util.Optional;
import java.util.Map;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;
import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class ShotgunItemRenderer implements SpecialModelRenderer<ItemStack> {
	@SubscribeEvent
	public static void registerItemRenderers(RegisterSpecialModelRendererEvent event) {
		event.register(ResourceLocation.parse("forgotten_fairy_tales:shotgun"), ShotgunItemRenderer.Unbaked.MAP_CODEC);
	}

	private static final Map<Integer, Function<EntityModelSet, ShotgunItemRenderer>> MODELS = Map
			.ofEntries(Map.entry(-1, modelSet -> new ShotgunItemRenderer(new AnimatedModel(modelSet.bakeLayer(Modelshotgun.LAYER_LOCATION)), ResourceLocation.parse("forgotten_fairy_tales:textures/item/shotgunnew.png"))));
	private final EntityModel<LivingEntityRenderState> model;
	private final ResourceLocation texture;
	private final LivingEntityRenderState renderState;
	private final long start;

	private ShotgunItemRenderer(EntityModel<LivingEntityRenderState> model, ResourceLocation texture) {
		this.model = model;
		this.texture = texture;
		this.renderState = new LivingEntityRenderState();
		this.start = System.currentTimeMillis();
	}

	@Override
	public void render(ItemStack itemstack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean glint) {
		updateRenderState(itemstack);
		poseStack.pushPose();
		poseStack.translate(0.5, displayContext == ItemDisplayContext.GUI ? 1.525 : displayContext == ItemDisplayContext.GROUND ? 2.0 : 1.5, 0.45);
		poseStack.scale(1, -1, displayContext == ItemDisplayContext.GUI ? -1 : 1);
		poseStack.mulPose(Axis.YP.rotationDegrees(displayContext == ItemDisplayContext.GUI ? 180f : 0));
		poseStack.scale(-1, 1, 1);
		renderState.ageInTicks = (System.currentTimeMillis() - start) / 50.0f;
		if (model instanceof AnimatedModel animatedModel)
			animatedModel.setupItemStackAnim(this, itemstack, renderState);
		else
			model.setupAnim(renderState);
		VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(bufferSource, model.renderType(texture), false, glint);
		boolean isFirstPerson = displayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND;
		boolean isThirdPerson = displayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND || displayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
		if (!isFirstPerson)
			resetAnimations(model);
		try {
			if (isFirstPerson && Minecraft.getInstance().player != null && (model.root().getChild("left_arm") != null || model.root().getChild("right_arm") != null)) {
				AbstractClientPlayer player = Minecraft.getInstance().player;
				PlayerRenderer playerRenderer = (PlayerRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(player);
				PlayerModel playerModel = playerRenderer.getModel();
				ResourceLocation skinTexture = player.getSkin().texture();
				ItemArms.renderPartWithArms(model, poseStack, vertexConsumer, bufferSource, packedLight, packedOverlay, playerModel, skinTexture, player.isInvisible());
			} else {
				ModelPart leftArm = model.root().getChild("left_arm");
				ModelPart rightArm = model.root().getChild("right_arm");
				if (leftArm != null)
					leftArm.skipDraw = true;
				if (rightArm != null) {
					rightArm.skipDraw = true;
					rightArm.offsetScale(new Vector3f(-rightArm.xScale, -rightArm.yScale, -rightArm.zScale));
				}
				model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay);
			}
		} catch (Exception ignored) {
		}
		poseStack.popPose();
	}

	@Override
	public ItemStack extractArgument(ItemStack itemstack) {
		return itemstack;
	}

	@Override
	public void getExtents(Set<Vector3f> extentsSet) {
		PoseStack posestack = new PoseStack();
		this.model.root().getExtentsForGui(posestack, extentsSet);
	}

	private static boolean isInventory(ItemDisplayContext type) {
		return type == ItemDisplayContext.GUI || type == ItemDisplayContext.FIXED;
	}

	public record Unbaked(int index) implements SpecialModelRenderer.Unbaked {
		public static final MapCodec<ShotgunItemRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder
				.mapCodec(instance -> instance.group(ExtraCodecs.NON_NEGATIVE_INT.optionalFieldOf("index").xmap(opt -> opt.orElse(-1), i -> i == -1 ? Optional.empty() : Optional.of(i)).forGetter(ShotgunItemRenderer.Unbaked::index)).apply(instance,
						ShotgunItemRenderer.Unbaked::new));

		@Override
		public MapCodec<ShotgunItemRenderer.Unbaked> type() {
			return MAP_CODEC;
		}

		@Override
		public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
			return ShotgunItemRenderer.MODELS.get(index).apply(modelSet);
		}
	}

	private static final Map<ItemStack, Map<Integer, AnimationState>> CACHE = new WeakHashMap<>();

	private static Map<Integer, AnimationState> getAnimationState(ItemStack stack) {
		return CACHE.computeIfAbsent(stack, s -> IntStream.range(0, 8).boxed().collect(Collectors.toMap(i -> i, i -> new AnimationState(), (a, b) -> b)));
	}

	private void updateRenderState(ItemStack itemstack) {
		int tickCount = (int) (System.currentTimeMillis() - start) / 50;
		updateAnimation(itemstack, tickCount);
		if (getAnimationState(itemstack).get(0).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(0).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.reload.lengthInSeconds()) {
				if (!shotgunAnimation.reload.looping())
					getAnimationState(itemstack).get(0).stop();
				else
					getAnimationState(itemstack).get(0).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(1).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(1).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.reloadone.lengthInSeconds()) {
				if (!shotgunAnimation.reloadone.looping())
					getAnimationState(itemstack).get(1).stop();
				else
					getAnimationState(itemstack).get(1).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(2).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(2).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.shoot.lengthInSeconds()) {
				if (!shotgunAnimation.shoot.looping())
					getAnimationState(itemstack).get(2).stop();
				else
					getAnimationState(itemstack).get(2).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(3).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(3).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.reloadone.lengthInSeconds()) {
				if (!shotgunAnimation.reloadone.looping())
					getAnimationState(itemstack).get(3).stop();
				else
					getAnimationState(itemstack).get(3).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(4).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(4).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.idle.lengthInSeconds()) {
				if (!shotgunAnimation.idle.looping())
					getAnimationState(itemstack).get(4).stop();
				else
					getAnimationState(itemstack).get(4).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(5).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(5).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.idle.lengthInSeconds()) {
				if (!shotgunAnimation.idle.looping())
					getAnimationState(itemstack).get(5).stop();
				else
					getAnimationState(itemstack).get(5).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(6).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(6).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.idle.lengthInSeconds()) {
				if (!shotgunAnimation.idle.looping())
					getAnimationState(itemstack).get(6).stop();
				else
					getAnimationState(itemstack).get(6).start(tickCount);
			}
		}
		if (getAnimationState(itemstack).get(7).isStarted()) {
			float elapsedSeconds = getAnimationState(itemstack).get(7).getTimeInMillis(tickCount) / 1000.0F;
			if (elapsedSeconds >= shotgunAnimation.idle.lengthInSeconds()) {
				if (!shotgunAnimation.idle.looping())
					getAnimationState(itemstack).get(7).stop();
				else
					getAnimationState(itemstack).get(7).start(tickCount);
			}
		}
	}

	private void updateAnimation(ItemStack itemstack, int tickCount) {
		CompoundTag data = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
		int oldAnim = data.getIntOr("oldAnimState", 0);
		int newAnim = data.getIntOr("animState", 0);
		if (oldAnim != newAnim) {
			switch (newAnim) {
				case -1 :
					getAnimationState(itemstack).get(0).stop();
					break;
				case -2 :
					getAnimationState(itemstack).get(1).stop();
					break;
				case -3 :
					getAnimationState(itemstack).get(2).stop();
					break;
				case -4 :
					getAnimationState(itemstack).get(3).stop();
					break;
				case -5 :
					getAnimationState(itemstack).get(4).stop();
					break;
				case -6 :
					getAnimationState(itemstack).get(5).stop();
					break;
				case -7 :
					getAnimationState(itemstack).get(6).stop();
					break;
				case -8 :
					getAnimationState(itemstack).get(7).stop();
					break;
				case 0 :
					getAnimationState(itemstack).get(0).start(tickCount);
					break;
				case 1 :
					getAnimationState(itemstack).get(1).start(tickCount);
					break;
				case 2 :
					getAnimationState(itemstack).get(2).start(tickCount);
					break;
				case 3 :
					getAnimationState(itemstack).get(3).start(tickCount);
					break;
				case 4 :
					getAnimationState(itemstack).get(4).start(tickCount);
					break;
				case 5 :
					getAnimationState(itemstack).get(5).start(tickCount);
					break;
				case 6 :
					getAnimationState(itemstack).get(6).start(tickCount);
					break;
				case 7 :
					getAnimationState(itemstack).get(7).start(tickCount);
					break;
			}
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putInt("oldAnimState", newAnim));
		}
	}

	private static boolean init = false;

	@SubscribeEvent
	public static void resetItems(ClientTickEvent.Pre event) {
		if (Minecraft.getInstance().player != null && !CACHE.isEmpty() && !init) {
			for (Map.Entry<ItemStack, Map<Integer, AnimationState>> entry : CACHE.entrySet()) {
				ItemStack itemstack = entry.getKey();
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putInt("oldAnimState", itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getIntOr("animState", 0)));
				for (int i = 0; i < 8; i++) {
					getAnimationState(itemstack).get(i).stop();
				}
				init = true;
			}
		}
	}

	@SubscribeEvent
	public static void logOut(ClientPlayerNetworkEvent.LoggingOut event) {
		init = false;
	}

	public void resetAnimations(EntityModel model) {
		model.root().getAllParts().forEach(ModelPart::resetPose);
	}

	private static final class AnimatedModel extends Modelshotgun {
		private final KeyframeAnimation keyframeAnimation0;
		private final KeyframeAnimation keyframeAnimation1;
		private final KeyframeAnimation keyframeAnimation2;
		private final KeyframeAnimation keyframeAnimation3;
		private final KeyframeAnimation keyframeAnimation4;
		private final KeyframeAnimation keyframeAnimation5;
		private final KeyframeAnimation keyframeAnimation6;
		private final KeyframeAnimation keyframeAnimation7;

		public AnimatedModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = shotgunAnimation.reload.bake(root);
			this.keyframeAnimation1 = shotgunAnimation.reloadone.bake(root);
			this.keyframeAnimation2 = shotgunAnimation.shoot.bake(root);
			this.keyframeAnimation3 = shotgunAnimation.reloadone.bake(root);
			this.keyframeAnimation4 = shotgunAnimation.idle.bake(root);
			this.keyframeAnimation5 = shotgunAnimation.idle.bake(root);
			this.keyframeAnimation6 = shotgunAnimation.idle.bake(root);
			this.keyframeAnimation7 = shotgunAnimation.idle.bake(root);
		}

		public void setupItemStackAnim(ShotgunItemRenderer renderer, ItemStack itemstack, LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(renderer.getAnimationState(itemstack).get(0), state.ageInTicks, 1f);
			this.keyframeAnimation1.apply(renderer.getAnimationState(itemstack).get(1), state.ageInTicks, 1f);
			this.keyframeAnimation2.apply(renderer.getAnimationState(itemstack).get(2), state.ageInTicks, 1f);
			this.keyframeAnimation3.apply(renderer.getAnimationState(itemstack).get(3), state.ageInTicks, 1f);
			this.keyframeAnimation4.apply(renderer.getAnimationState(itemstack).get(4), state.ageInTicks, 1f);
			this.keyframeAnimation5.apply(renderer.getAnimationState(itemstack).get(5), state.ageInTicks, 1f);
			this.keyframeAnimation6.apply(renderer.getAnimationState(itemstack).get(6), state.ageInTicks, 1f);
			this.keyframeAnimation7.apply(renderer.getAnimationState(itemstack).get(7), state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}