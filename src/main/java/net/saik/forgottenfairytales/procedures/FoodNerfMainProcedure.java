package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoodNerfMainProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0) > 0) {
			if (!(itemstack.getItem() == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).previousfood.getItem())) {
				{
					ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
					_vars.previousfood = itemstack.copy();
					_vars.foodcount = 1;
					_vars.markSyncDirty();
				}
			} else if (itemstack.getItem() == entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).previousfood.getItem()) {
				{
					ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
					_vars.foodcount = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount + 1;
					_vars.markSyncDirty();
				}
				if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount >= 20 && entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount < 40) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u041C\u043E\u0436\u0435\u0442 \u0447\u0442\u043E \u0442\u043E \u0434\u0440\u0443\u0433\u043E\u0435..."), true);
				} else if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount >= 40 && entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount < 64) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u00A7o\u041C\u0435\u043D\u044F \u0443\u0436\u0435 \u043C\u0443\u0442\u0438\u0442"), true);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 600, 0));
				} else if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount >= 64) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A74\u00A7l\u042F \u043D\u0435 \u043C\u043E\u0433\u0443 \u044D\u0442\u043E \u0431\u043E\u043B\u044C\u0448\u0435 \u0435\u0441\u0442\u044C..."), true);
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0));
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0)));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 1800, 2));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) ((entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).foodcount - 63) * 600), 0));
				}
			}
		}
	}
}