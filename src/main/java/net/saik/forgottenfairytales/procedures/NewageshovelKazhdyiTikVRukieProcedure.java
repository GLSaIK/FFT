package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class NewageshovelKazhdyiTikVRukieProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.SPEEDBUST, 5, 0, false, false));
		}
	}
}