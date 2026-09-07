package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class ZgutikUsloviieW2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Mob _mobEnt0 && _mobEnt0.isAggressive()) {
			return true;
		}
		return false;
	}
}