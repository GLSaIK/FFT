package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class DflkhjPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.hasChunkAt(BlockPos.containing(x, y, z))) {
			world.setBlock(BlockPos.containing(x, y, z), ForgottenFairyTalesModBlocks.COLOMNTR.get().defaultBlockState(), 3);
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}