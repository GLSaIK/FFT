package net.saik.forgottenfairytales.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public abstract class MouseZoomMixin {

    @Shadow
    private double accumulatedDX;

    @Shadow
    private double accumulatedDY;

    @Inject(
        method = "handleAccumulatedMovement",
        at = @At("HEAD")
    )
    private void forgottenFairyTales$zoomMouse(CallbackInfo ci) {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player == null)
            return;

        if (minecraft.player.getData(
                ForgottenFairyTalesModVariables.PLAYER_VARIABLES
        ).IsZommed) {

            double sensitivityMultiplier = 0.6;

            this.accumulatedDX *= sensitivityMultiplier;
            this.accumulatedDY *= sensitivityMultiplier;
        }
    }
}