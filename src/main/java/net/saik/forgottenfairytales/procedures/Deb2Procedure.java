package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class Deb2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).debug;
	}
}