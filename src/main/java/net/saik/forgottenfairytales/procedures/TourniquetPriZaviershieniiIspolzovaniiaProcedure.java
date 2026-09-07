package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;


import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.InteractionHand;

import java.util.ArrayList;
import java.util.List;

public class TourniquetPriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;

		if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin) {

		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}


		if (!(entity instanceof LivingEntity living))
			return;

		// список сохранённых эффектов
		final List<MobEffectInstance> savedEffects = new ArrayList<>();

		// сохраняем негативные эффекты
		for (MobEffectInstance effect : living.getActiveEffects()) {
				savedEffects.add(new MobEffectInstance(
						effect.getEffect(),
						effect.getDuration(),
						effect.getAmplifier(),
						effect.isAmbient(),
						effect.isVisible(),
						effect.showIcon()
				));
		}

		// удаляем их
		for (MobEffectInstance effect : savedEffects) {
			living.removeEffect(effect.getEffect());
		}

		// через 1 минуту возвращаем
		ForgottenFairyTalesMod.queueServerWork(1200, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
				for (MobEffectInstance effect : savedEffects) {
					_entity.addEffect(new MobEffectInstance(
							effect.getEffect(),
							effect.getDuration() - 1200,
							effect.getAmplifier(),
							effect.isAmbient(),
							effect.isVisible(),
							effect.showIcon()
					));
				}
			}
		});
	}
}
}