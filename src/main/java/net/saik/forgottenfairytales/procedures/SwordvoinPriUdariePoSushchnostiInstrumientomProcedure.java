package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.entity.ColomnEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

public class SwordvoinPriUdariePoSushchnostiInstrumientomProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 20) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.BLEEDING, 60, 1, true, true));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) > 20 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < 50) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.BLEEDING, 100, 1, true, true));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 50) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.BLEEDING, 160, 1, true, true));
		}
		if (!(entity instanceof ColomnEntity)) {
			entity.push((sourceentity.getLookAngle().x * 0.3), (sourceentity.getLookAngle().y * 0.1), (sourceentity.getLookAngle().z * 0.3));
		}
	}
}