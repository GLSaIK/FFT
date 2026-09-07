package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModParticleTypes;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BarrierDisplayProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ForgottenFairyTalesModMobEffects.RUNE_OF_PROTECTION_EFFECT)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x + 4), (y + 1), z, 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x - 4), (y + 1), z, 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), x, (y + 1), (z + 4), 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), x, (y + 1), (z - 4), 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x + 3), (y + 1), (z + 3), 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x - 3), (y + 1), (z + 3), 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x - 3), (y + 1), (z - 3), 1, 0, 0, 0, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BARRIER.get()), (x + 3), (y + 1), (z - 3), 1, 0, 0, 0, 0);
		}
	}
}