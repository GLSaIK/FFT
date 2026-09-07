package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PicnictriggerProcedure {
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
		if ((itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0) > 0) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(ForgottenFairyTalesModMobEffects.PICNIC_EFFECT)) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0) + 1));
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0) + 1);
			}
		}
	}
}