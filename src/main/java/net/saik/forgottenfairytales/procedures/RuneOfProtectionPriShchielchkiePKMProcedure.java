package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

public class RuneOfProtectionPriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.RUNE_OF_PROTECTION_EFFECT, (int) Double.POSITIVE_INFINITY, 0));
		}
	}
}