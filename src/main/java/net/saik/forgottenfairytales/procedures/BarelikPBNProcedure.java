package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class BarelikPBNProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getDisplayName().getString()).equals("pbncot")) {
			return true;
		}
		return false;
	}
}