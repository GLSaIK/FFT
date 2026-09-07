package net.saik.forgottenfairytales.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.saik.forgottenfairytales.ForgottenFairyTalesModPlayerAnimationAPI;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;

@Mixin(ItemInHandLayer.class)
public abstract class ItemInHandLayerMixin {
	private String master = null;

	@Inject(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/item/ItemStackRenderState;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V"))
	private void animateItem(ArmedEntityRenderState renderState, ItemStackRenderState itemStackRenderState, HumanoidArm arm, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
		if (master == null) {
			if (!ForgottenFairyTalesModPlayerAnimationAPI.animations.isEmpty())
				master = "forgotten_fairy_tales";
			else
				return;
		}
		if (!master.equals("forgotten_fairy_tales")) {
			return;
		}
		if (renderState instanceof PlayerRenderState state) {
			Player player = (Player) renderState.getRenderData(ForgottenFairyTalesModPlayerAnimationAPI.ClientAttachments.PLAYER);
			if (player == null)
				return;
			ForgottenFairyTalesModPlayerAnimationAPI.PlayerAnimation animation = ForgottenFairyTalesModPlayerAnimationAPI.active_animations.get(player);
			if (animation == null)
				return;
			ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone bone = animation.bones.get(arm == HumanoidArm.LEFT ? "left_item" : "right_item");
			if (bone == null)
				return;
			float animationProgress = player.getPersistentData().getFloatOr("PlayerAnimationProgress", 0);
			Vec3 scale = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.scales, animationProgress, player);
			if (scale != null) {
				poseStack.scale((float) scale.x, (float) scale.y, (float) scale.z);
			}
			Vec3 position = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.positions, animationProgress, player);
			if (position != null) {
				poseStack.translate((float) -position.x * 0.0625f, (float) -position.z * 0.0625f, (float) position.y * 0.0625f);
			}
			Vec3 rotation = ForgottenFairyTalesModPlayerAnimationAPI.PlayerBone.interpolate(bone.rotations, animationProgress, player);
			if (rotation != null) {
				poseStack.mulPose(Axis.ZP.rotationDegrees((float) rotation.y));
				poseStack.mulPose(Axis.YP.rotationDegrees((float) -rotation.z));
				poseStack.mulPose(Axis.XP.rotationDegrees((float) -rotation.x));
			}
		}
	}
}