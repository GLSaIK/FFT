package net.saik.forgottenfairytales.client.renderer.block;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlockEntities;
import net.saik.forgottenfairytales.client.model.animations.SwerhAnimation;
import net.saik.forgottenfairytales.client.model.ModelSwerh;
import net.saik.forgottenfairytales.block.entity.LIvingFragmentBlockEntity;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.animation.KeyframeAnimation;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class LIvingFragmentRenderer implements BlockEntityRenderer<LIvingFragmentBlockEntity> {
	private final CustomHierarchicalModel model;
	private final ResourceLocation texture;
	private final LivingEntityRenderState renderState;

	LIvingFragmentRenderer(BlockEntityRendererProvider.Context context) {
		this.model = new CustomHierarchicalModel(context.bakeLayer(ModelSwerh.LAYER_LOCATION));
		this.texture = ResourceLocation.parse("forgotten_fairy_tales:textures/block/swerh_stone.png");
		this.renderState = new LivingEntityRenderState();
	}

	private void updateRenderState(LIvingFragmentBlockEntity blockEntity, float partialTick) {
		int tickCount = (int) blockEntity.getLevel().getGameTime();
		renderState.ageInTicks = tickCount + partialTick;
		blockEntity.animationState0.animateWhen(true, tickCount);
	}

	@Override
	public void render(LIvingFragmentBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight, Vec3 cameraPos) {
		updateRenderState(blockEntity, partialTick);
		poseStack.pushPose();
		poseStack.scale(-1, -1, 1);
		poseStack.translate(-0.5, -0.5, 0.5);
		poseStack.translate(0, -1, 0);
		VertexConsumer builder = renderer.getBuffer(RenderType.entityCutout(texture));
		model.setupBlockEntityAnim(blockEntity, renderState);
		model.renderToBuffer(poseStack, builder, light, overlayLight);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ForgottenFairyTalesModBlockEntities.L_IVING_FRAGMENT.get(), LIvingFragmentRenderer::new);
	}

	private static final class CustomHierarchicalModel extends ModelSwerh {
		private final KeyframeAnimation keyframeAnimation0;

		public CustomHierarchicalModel(ModelPart root) {
			super(root);
			this.keyframeAnimation0 = SwerhAnimation.one.bake(root);
		}

		public void setupBlockEntityAnim(LIvingFragmentBlockEntity blockEntity, LivingEntityRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);
			this.keyframeAnimation0.apply(blockEntity.animationState0, state.ageInTicks, 1f);
			super.setupAnim(state);
		}
	}
}