package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class DrProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean l = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.GRANITE_STAIRS.asItem()) {
			l = true;
		} else {
			l = false;
		}
		return l;
	}
}