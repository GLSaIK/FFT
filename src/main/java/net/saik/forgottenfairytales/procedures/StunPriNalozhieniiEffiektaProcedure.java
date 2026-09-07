package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class StunPriNalozhieniiEffiektaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("fixhealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
	}
}