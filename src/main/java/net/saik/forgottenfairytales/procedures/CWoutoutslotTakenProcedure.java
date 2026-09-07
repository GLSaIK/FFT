package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CWoutoutslotTakenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double gb = 0;
		gb = 1;
		for (int index0 = 0; index0 < 21; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				_menu.getSlots().get((int) gb).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			gb = gb + 1;
		}
	}
}