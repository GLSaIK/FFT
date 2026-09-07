package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class M32Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.eng = !entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng;
			_vars.markSyncDirty();
		}
	}
}