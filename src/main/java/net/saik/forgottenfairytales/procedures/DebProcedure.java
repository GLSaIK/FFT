package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class DebProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean l = false;
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.debug = !entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).debug;
			_vars.markSyncDirty();
		}
	}
}