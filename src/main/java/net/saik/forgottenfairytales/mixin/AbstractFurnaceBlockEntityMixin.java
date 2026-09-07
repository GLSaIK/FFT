package net.saik.forgottenfairytales.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.saik.forgottenfairytales.procedures.BrownSmokeBaseProcedure;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {

    @Inject(
        method = "serverTick",
        at = @At("TAIL")
    )
    private static void addBrownSmoke(
            ServerLevel level,
            BlockPos pos,
            BlockState state,
            AbstractFurnaceBlockEntity furnace,
            CallbackInfo ci
    ) {
        // Только плавильная печь (Blast Furnace)
        if (!(furnace instanceof BlastFurnaceBlockEntity)) {
            return;
        }

        // Только когда печь горит
        if (!state.getValue(AbstractFurnaceBlock.LIT)) {
            return;
        }

        // Раз в 5 тиков
        if (level.getGameTime() % 3 != 0) {
            return;
        }

        // Вызов процедуры MCreator
        BrownSmokeBaseProcedure.execute(
                level,
                pos.getX(),
                pos.getY(),
                pos.getZ()
        );
    }
}