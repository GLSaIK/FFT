package net.saik.forgottenfairytales.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.saik.forgottenfairytales.ForgottenFairyTalesModPlayerAnimationAPI;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import java.util.List;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {
	private String master = null;
	private Minecraft mc = Minecraft.getInstance();

	@Inject(method = "collectVisibleEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z"))
	private void fakeThirdPersonMode(Camera camera, Frustum frustum, List<Entity> entities, CallbackInfoReturnable<Boolean> cir) {
		if (master == null) {
			if (!ForgottenFairyTalesModPlayerAnimationAPI.animations.isEmpty())
				master = "forgotten_fairy_tales";
			else
				return;
		}
		if (!master.equals("forgotten_fairy_tales")) {
			return;
		}
		if (camera.getEntity() instanceof Player player && player.getPersistentData().getBooleanOr("FirstPersonAnimation", false) && mc.player == player && mc.screen == null) {
			((CameraAccessor) camera).setDetached(true);
		}
	}

	@Inject(method = "collectVisibleEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z", shift = At.Shift.AFTER))
	private void resetThirdPerson(Camera camera, Frustum frustum, List<Entity> entities, CallbackInfoReturnable<Boolean> cir) {
		if (master == null) {
			if (!ForgottenFairyTalesModPlayerAnimationAPI.animations.isEmpty())
				master = "forgotten_fairy_tales";
			else
				return;
		}
		if (!master.equals("forgotten_fairy_tales")) {
			return;
		}
		((CameraAccessor) camera).setDetached(false);
	}
}