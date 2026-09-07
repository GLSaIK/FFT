package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class C2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.voin = true;
			_vars.markSyncDirty();
		}
	}
}