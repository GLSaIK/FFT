package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.BarelikEntity;

import net.minecraft.world.entity.Entity;

public class BarelikUsloviieProighryvaniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof BarelikEntity _datEntL0 && _datEntL0.getEntityData().get(BarelikEntity.DATA_ss4)) == false) {
			return true;
		}
		return false;
	}
}