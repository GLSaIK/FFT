package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class PultaKazhdyiTikPriIspolzovaniiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDoubleOr("pull", 0) < 18) {
			entity.getPersistentData().putDouble("pull", (entity.getPersistentData().getDoubleOr("pull", 0) + 1));
		}
	}
}