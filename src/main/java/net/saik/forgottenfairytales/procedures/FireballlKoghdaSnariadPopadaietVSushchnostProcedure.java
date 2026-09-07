package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class FireballlKoghdaSnariadPopadaietVSushchnostProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		entity.igniteForSeconds(3);
		ForgottenFairyTalesMod.queueServerWork(1, () -> {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		});
	}
}