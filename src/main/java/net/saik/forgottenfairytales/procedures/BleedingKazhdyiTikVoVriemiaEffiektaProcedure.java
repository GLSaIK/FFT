package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class BleedingKazhdyiTikVoVriemiaEffiektaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 1) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
		}
	}
}