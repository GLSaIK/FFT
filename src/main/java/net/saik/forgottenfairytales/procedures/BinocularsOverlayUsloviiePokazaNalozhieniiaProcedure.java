package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class BinocularsOverlayUsloviiePokazaNalozhieniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).IsZommed) {
			return true;
		}
		return false;
	}
}