package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class PultaZnachieniieSvoistvaProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getPersistentData().getDoubleOr("pull", 0) / 18;
	}
}