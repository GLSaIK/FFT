package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.Entity;

public class M12Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.voin = !entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin;
			_vars.markSyncDirty();
		}
	}
}