package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.BarelikEntity;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class BarelikPriRanieniiSushchnostiProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BarelikEntity _datEntL0 && _datEntL0.getEntityData().get(BarelikEntity.DATA_ss4)) {
			if (4 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
				if (entity instanceof BarelikEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 3);
				ForgottenFairyTalesMod.queueServerWork(5, () -> {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
				});
			} else if (7 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
				if (entity instanceof BarelikEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 3);
				ForgottenFairyTalesMod.queueServerWork(5, () -> {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 7);
				});
			}
		}
	}
}