package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.StrausingoEntity;

import net.minecraft.world.entity.Entity;

public class StrausingoAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof StrausingoEntity _datEntL0 && _datEntL0.getEntityData().get(StrausingoEntity.DATA_Ataack);
	}
}