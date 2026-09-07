package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

public class StrausingoPriGibieliSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		ItemStack f = ItemStack.EMPTY;
		ItemStack d = ItemStack.EMPTY;
		f = new ItemStack(ForgottenFairyTalesModItems.STRAUSINGOFEATHER.get()).copy();
		f.setCount(Mth.nextInt(RandomSource.create(), 2, 3));
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, f);
			entityToSpawn.setPickUpDelay(2);
			_level.addFreshEntity(entityToSpawn);
		}
		if ((immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0) {
			d = new ItemStack(Items.COOKED_CHICKEN).copy();
			d.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, d);
				entityToSpawn.setPickUpDelay(2);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			d = new ItemStack(Items.CHICKEN).copy();
			d.setCount(Mth.nextInt(RandomSource.create(), 1, 2));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, d);
				entityToSpawn.setPickUpDelay(2);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}