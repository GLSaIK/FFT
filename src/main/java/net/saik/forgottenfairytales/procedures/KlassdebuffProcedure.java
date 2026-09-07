package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class KlassdebuffProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(ForgottenFairyTalesModMobEffects.PICNIC_EFFECT))) {
				if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == true || entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == true
						|| entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin == true) {
					if (entity.isSprinting()) {
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) 0.04);
					}
					if (entity.onGround() || entity.isPassenger()) {
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) 0.005);
					}
					if (entity.isInWater()) {
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) 0.07);
					}
					if (entity instanceof LivingEntity _livEnt9 && _livEnt9.isSleeping()) {
						if (entity instanceof Player _player)
							_player.causeFoodExhaustion((float) 0.1);
					}
				}
			}
		}
	}
}