package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;
import net.saik.forgottenfairytales.entity.ColomnEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ColomnPriRanieniiSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) == 0) {
			if (entity instanceof ColomnEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, 1);
			if ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) == 1) {
				if (entity instanceof ColomnEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, 2);
				if ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) == 2) {
					if (entity instanceof ColomnEntity _datEntSetI)
						_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, 3);
					if ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) == 3) {
						if (entity instanceof ColomnEntity _datEntSetI)
							_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, 0);
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				}
			}
		}
	}
}