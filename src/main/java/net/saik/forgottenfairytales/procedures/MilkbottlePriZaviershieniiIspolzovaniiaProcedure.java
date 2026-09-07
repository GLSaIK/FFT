package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MilkbottlePriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;

		if (!(entity instanceof LivingEntity living))
			return;

		// Список всех негативных эффектов
		List<MobEffectInstance> negativeEffects = new ArrayList<>();

		for (MobEffectInstance effect : living.getActiveEffects()) {
			if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
				negativeEffects.add(effect);
			}
		}

		// Если негативных эффектов нет — ничего не делаем
		if (negativeEffects.isEmpty())
			return;

		// Выбираем случайный негативный эффект
		MobEffectInstance selectedEffect =
				negativeEffects.get(new Random().nextInt(negativeEffects.size()));

		// Отнимаем 10 секунд = 200 тиков
		int newDuration = selectedEffect.getDuration() - 200;

		// Удаляем старый эффект
		living.removeEffect(selectedEffect.getEffect());

		// Если после вычитания эффект ещё должен существовать — возвращаем его
		if (newDuration > 0) {
			living.addEffect(new MobEffectInstance(
					selectedEffect.getEffect(),
					newDuration,
					selectedEffect.getAmplifier(),
					selectedEffect.isAmbient(),
					selectedEffect.isVisible(),
					selectedEffect.showIcon()
			));
		}
	}
}