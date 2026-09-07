package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class D2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "reloading " + entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).reloading;
	}
}