package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class WarriorsForgePriShchielchkiePKMPoBlokuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (true != entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}