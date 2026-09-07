package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BeamKoghdaSnariadPopadaietVIghrokaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.BROKEN_ARMOR, 60, 0, false, true));
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.beamcount = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).beamcount + 1;
			_vars.markSyncDirty();
		}
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).beamcount == 7) {
			{
				ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
				_vars.beamcount = 0;
				_vars.markSyncDirty();
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -5, 5), y, z + Mth.nextInt(RandomSource.create(), -5, 5)),
						EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
	}
}