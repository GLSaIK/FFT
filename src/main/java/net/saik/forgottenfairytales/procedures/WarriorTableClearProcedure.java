package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class WarriorTableClearProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(0).set(ItemStack.EMPTY);
			_menu.getSlots().get(1).set(ItemStack.EMPTY);
			_menu.getSlots().get(2).set(ItemStack.EMPTY);
			_menu.getSlots().get(3).set(ItemStack.EMPTY);
			_menu.getSlots().get(4).set(ItemStack.EMPTY);
			_menu.getSlots().get(5).set(ItemStack.EMPTY);
			_menu.getSlots().get(6).set(ItemStack.EMPTY);
			_menu.getSlots().get(7).set(ItemStack.EMPTY);
			_menu.getSlots().get(8).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
	}
}