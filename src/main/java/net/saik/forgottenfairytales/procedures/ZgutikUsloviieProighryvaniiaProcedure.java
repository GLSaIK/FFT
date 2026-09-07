package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class ZgutikUsloviieProighryvaniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.onGround()) {
			return true;
		}
		return false;
	}
}