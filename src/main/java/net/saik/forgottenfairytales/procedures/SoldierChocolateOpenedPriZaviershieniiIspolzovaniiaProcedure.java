package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

public class SoldierChocolateOpenedPriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack t = ItemStack.EMPTY;
		t = itemstack.copy();
		if (world instanceof ServerLevel _level) {
			entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).soldierchocolate.hurtAndBreak(1, _level, null, _stkprov -> {
			});
		}
		if (true == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SPEED, 300, 0));
			if (Mth.nextInt(RandomSource.create(), 1, 4) == 4) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 300, 0));
			}
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 600, 0));
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack7 = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).soldierchocolate.copy();
			_setstack7.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack7);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
	}
}