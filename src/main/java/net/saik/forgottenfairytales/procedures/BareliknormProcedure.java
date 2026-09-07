package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.BarelikEntity;

import net.minecraft.world.entity.Entity;

public class BareliknormProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (4 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
			return true;
		}
		return false;
	}
}