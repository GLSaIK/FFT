package net.saik.forgottenfairytales.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.saik.forgottenfairytales.ForgottenFairyTalesModPlayerAnimationAPI;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.Minecraft;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(PlayerRenderer.class)
public abstract class PlayerAnimationRendererMixin extends LivingEntityRenderer<AbstractClientPlayer, PlayerRenderState, PlayerModel> {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	public PlayerAnimationRendererMixin(EntityRendererProvider.Context context, boolean slim) {
		super(null, null, 0.5f);
	}

	@Inject(method = "Lnet/minecraft/client/renderer/entity/player/PlayerRenderer;setupRotations(Lnet/minecraft/client/renderer/entity/state/PlayerRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;FF)V", at = @At("RETURN"))
	private void setupRotations(PlayerRenderState renderState, PoseStack poseStack, float bodyRot, float scale_, CallbackInfo ci) {
		Player player = (Player) renderState.getRenderData(ForgottenFairyTalesModPlayerAnimationAPI.ClientAttachments.PLAYER);
		if (player == null)
			return;
		if (master == null) {
			if (!ForgottenFairyTalesModPlayerAnimationAPI.animations.isEmpty())
				master = "forgotten_fairy_tales";
			else
				return;
		}
		if (!master.equals("forgotten_fairy_tales"))
			return;
		ForgottenFairyTalesModPlayerAnimationAPI.PlayerAnimation animation = ForgottenFairyTalesModPlayerAnimationAPI.active_animations.get(player);
		if (animation == null)
			return;
		ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone bone = animation.bones.get("body");
		if (bone == null)
			return;
		boolean firstPerson = player.getPersistentData().getBooleanOr("FirstPersonAnimation", false) && mc.options.getCameraType().isFirstPerson() && player == mc.player && mc.screen == null;
		float animationProgress = player.getPersistentData().getFloatOr("PlayerAnimationProgress", 0);
		Vec3 scale = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress, player);
		if (scale != null) {
			poseStack.scale((float) scale.x, (float) scale.y, (float) scale.z);
		}
		Vec3 position = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress, player);
		if (position != null) {
			if (!firstPerson)
				poseStack.translate((float) -position.x * 0.0625f, (float) (position.y * 0.0625f) + 0.75f, (float) position.z * 0.0625f);
		}
		Vec3 rotation = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress, player);
		if (rotation != null) {
			if (!firstPerson)
				poseStack.mulPose(Axis.ZP.rotationDegrees((float) rotation.z));
			poseStack.mulPose(Axis.YP.rotationDegrees((float) -rotation.y));
			if (!firstPerson)
				poseStack.mulPose(Axis.XP.rotationDegrees((float) -rotation.x));
		}
		if (position != null) {
			if (!firstPerson)
				poseStack.translate(0, -0.75f, 0);
		}
	}
}