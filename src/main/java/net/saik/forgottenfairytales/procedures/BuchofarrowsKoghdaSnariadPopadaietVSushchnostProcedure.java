package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

public class BuchofarrowsKoghdaSnariadPopadaietVSushchnostProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		for (int index0 = 0; index0 < 8; index0++) {
			ForgottenFairyTalesMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 10), () -> {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = initArrowProjectile(new Arrow(projectileLevel, 0, 0, 0, new Arrow(EntityType.ARROW, projectileLevel).getPickupItemStackOrigin(), createArrowWeaponItemStack(projectileLevel, 1, (byte) 0)), null, 5,
							false, false, false, AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos((x + Mth.nextDouble(RandomSource.create(), 0.5, 1) * Mth.nextInt(RandomSource.create(), -2, 2)), (y + 10), (z + Mth.nextDouble(RandomSource.create(), 0.5, 1) * Mth.nextInt(RandomSource.create(), -2, 2)));
					_entityToSpawn.shoot(0, (-1), 0, 1, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			});
		}
		if (!immediatesourceentity.level().isClientSide())
			immediatesourceentity.discard();
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}

	private static ItemStack createArrowWeaponItemStack(Level level, int knockback, byte piercing) {
		ItemStack weapon = new ItemStack(Items.ARROW);
		if (knockback > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), knockback);
		if (piercing > 0)
			weapon.enchant(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), piercing);
		return weapon;
	}
}