package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.level.LevelAccessor;

public class WIPProcedure {
	public static void execute(LevelAccessor world) {
		boolean l = false;
		ForgottenFairyTalesModVariables.MapVariables.get(world).WIP = !ForgottenFairyTalesModVariables.MapVariables.get(world).WIP;
		ForgottenFairyTalesModVariables.MapVariables.get(world).markSyncDirty();
	}
}