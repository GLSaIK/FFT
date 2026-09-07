package net.saik.forgottenfairytales.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FoodsaltProcedure {
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
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("minecraft:saltfood")))) {
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("salted", false) != true) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("needsaltmsg").getString())), true);
					if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
						if (entity instanceof Player _player)
							_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0) * 0.3));
						if (entity instanceof Player _player)
							_player.getFoodData()
									.setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0) * 0.3));
					}
				}
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("minecraft:balance")))) {
				if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) < 20) {
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).nutrition() : 0) * 0.25));
					if (entity instanceof Player _player)
						_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - (itemstack.has(DataComponents.FOOD) ? itemstack.get(DataComponents.FOOD).saturation() : 0) * 0.25));
				}
			}
		}
	}
}