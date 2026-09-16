package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GoldenSaddleEffectProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;

		// Только лошадь
		if (entity instanceof Horse horse) {

			// Получаем предмет из реального слота седла
			ItemStack saddle = horse.getItemBySlot(EquipmentSlot.SADDLE);

			// Проверяем, что это именно Golden Saddle
			if (saddle.is(ForgottenFairyTalesModItems.GOLDEN_SADDLE.get())) {

				// Speed I на 2 секунды
				if (!horse.level().isClientSide()) {
					horse.addEffect(new MobEffectInstance(
						MobEffects.SPEED,
						40,
						1,
						true,
						false
					));
				}
			}
		}
	}
}