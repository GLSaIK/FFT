package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class M3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Eng " + entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng;
	}
}