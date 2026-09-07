package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

public class BrokenteleportPriShchielchkiePKMProcedure {

	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;

		// Защита от повторного срабатывания
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
        	.copyTag().getBooleanOr("tt", false)) {

			// Включаем блокировку
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack,
					tag -> tag.putBoolean("tt", true));

			// Проверка переменной
			if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng) {

				// 1 шанс из 3 на неудачу
				if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {

					// Кулдаун
					if (entity instanceof Player player)
						player.getCooldowns().addCooldown(itemstack, 100);

					// Звук неудачи
					if (world instanceof Level level) {
						if (!level.isClientSide()) {
							level.playSound(
									null,
									BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
									BuiltInRegistries.SOUND_EVENT.getValue(
											ResourceLocation.parse("forgotten_fairy_tales:dry")),
									SoundSource.NEUTRAL,
									1,
									1
							);
						}
					}

				} else {

					// Успешный рывок

					// Кулдаун
					if (entity instanceof Player player)
						player.getCooldowns().addCooldown(itemstack, 380);

					// Ломаем предмет
					if (world instanceof ServerLevel serverLevel) {
						itemstack.hurtAndBreak(1, serverLevel, null,
								_item -> {});
					}

					// Звук телепорта
					if (world instanceof Level level) {
						if (!level.isClientSide()) {
							level.playSound(
									null,
									BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
									BuiltInRegistries.SOUND_EVENT.getValue(
											ResourceLocation.parse("forgotten_fairy_tales:tpt")),
									SoundSource.NEUTRAL,
									1,
									1
							);
						}
					}

					// Частицы
					if (world instanceof ServerLevel serverLevel) {
						serverLevel.sendParticles(
								ParticleTypes.EXPLOSION,
								entity.getX(),
								entity.getY(),
								entity.getZ(),
								30,
								3,
								3,
								3,
								1
						);
					}

					// =========================
					// САМ РЫВОК
					// =========================

					// Несколько тиков подряд двигаем игрока
					for (int i = 0; i < 10; i++) {

						int delay = i;

						ForgottenFairyTalesMod.queueServerWork(delay, () -> {

							if (entity == null)
								return;

							// Направление взгляда
							double ang = entity.getYRot();

							// НОРМАЛЬНАЯ скорость
							double speed = 4.5;

							// Движение вперед
							double motionX =
									speed * Math.cos(Math.toRadians(ang + 90));

							double motionZ =
									speed * Math.sin(Math.toRadians(ang + 90));

							entity.setDeltaMovement(
									motionX,
									0.15,
									motionZ
							);

							// Очень важно для синхронизации
							entity.hurtMarked = true;
						});
					}
				}

			} else {

				// Если энергия выключена

				if (world instanceof Level level) {
					if (!level.isClientSide()) {
						level.playSound(
								null,
								BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
								BuiltInRegistries.SOUND_EVENT.getValue(
										ResourceLocation.parse("forgotten_fairy_tales:dry")),
								SoundSource.NEUTRAL,
								1,
								1
						);
					}
				}
			}
		}

		// Снимаем защиту через 5 тиков
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY)
        .copyTag().getBooleanOr("tt", false)) {

			ForgottenFairyTalesMod.queueServerWork(5, () -> {

				CustomData.update(DataComponents.CUSTOM_DATA, itemstack,
						tag -> tag.putBoolean("tt", false));

			});
		}
	}
}