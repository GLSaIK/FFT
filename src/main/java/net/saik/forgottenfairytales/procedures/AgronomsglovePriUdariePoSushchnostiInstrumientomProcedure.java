package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class AgronomsglovePriUdariePoSushchnostiInstrumientomProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getDisplayName().getString()).equals("Dev") || (sourceentity.getStringUUID()).equals("622afaed-a32b-4def-b957-00e5df2465a3")) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.ABSORPTION)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.ABSORPTION);
			}
			if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.FIRE_RESISTANCE)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
			}
			if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.HASTE)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HASTE, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HASTE);
			}
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.HEALTH_BOOST)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HEALTH_BOOST);
			}
			if (entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
			}
			if (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.WATER_BREATHING)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WATER_BREATHING);
			}
			if (entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(MobEffects.JUMP_BOOST)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.JUMP_BOOST);
			}
			if (entity instanceof LivingEntity _livEnt23 && _livEnt23.hasEffect(MobEffects.STRENGTH)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.STRENGTH);
			}
			if (entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(MobEffects.SPEED)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SPEED, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SPEED);
			}
			if (entity instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(MobEffects.SATURATION)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SATURATION);
			}
			if (entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(MobEffects.RESISTANCE)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.RESISTANCE);
			}
			if (entity instanceof LivingEntity _livEnt35 && _livEnt35.hasEffect(MobEffects.REGENERATION)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.REGENERATION);
			}
			if (entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.NIGHT_VISION)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.NIGHT_VISION);
			}
			if (entity instanceof LivingEntity _livEnt41 && _livEnt41.hasEffect(MobEffects.LUCK)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 600, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.LUCK);
			}
		}
	}
}