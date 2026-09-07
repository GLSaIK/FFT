package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class StunKazhdyiTikVoVriemiaEffiektaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > entity.getPersistentData().getDoubleOr("fixhealth", 0)) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) entity.getPersistentData().getDoubleOr("fixhealth", 0));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < entity.getPersistentData().getDoubleOr("fixhealth", 0)) {
			entity.getPersistentData().putDouble("fixhealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
		}
	}
}