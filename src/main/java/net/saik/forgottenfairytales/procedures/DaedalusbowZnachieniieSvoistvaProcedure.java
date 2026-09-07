package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class DaedalusbowZnachieniieSvoistvaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDoubleOr("dedPull", 0) / 30;
	}
}