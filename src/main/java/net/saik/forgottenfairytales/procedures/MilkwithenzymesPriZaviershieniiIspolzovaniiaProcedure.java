package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class MilkwithenzymesPriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.ABSORPTION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HASTE);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.REGENERATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WATER_BREATHING);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.STRENGTH);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.SPEED);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.SLOW_FALLING);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.SATURATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.RESISTANCE);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.REGENERATION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.NIGHT_VISION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.LUCK);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.JUMP_BOOST);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.INSTANT_HEALTH);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DOLPHINS_GRACE);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 1, false, true));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 300, 1, false, true));
	}
}