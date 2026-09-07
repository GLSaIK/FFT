package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.Entity;

public class PultaPriPriekrashchieniiIspolzovaniiaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("pull", 0);
	}
}