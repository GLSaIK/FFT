package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class WarriorsForgeUIKazhdyiTikPokaIntierfieisOtkrytProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (WarriorTableCraftDrinkProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack0 = new ItemStack(ForgottenFairyTalesModItems.WARRIORDRINK.get()).copy();
				_setstack0.setCount(1);
				_menu.getSlots().get(11).set(_setstack0);
				_player.containerMenu.broadcastChanges();
			}
		} else if (WarriorTableCraftSwordProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack1 = new ItemStack(ForgottenFairyTalesModItems.SWORDVOIN.get()).copy();
				_setstack1.setCount(1);
				_menu.getSlots().get(11).set(_setstack1);
				_player.containerMenu.broadcastChanges();
			}
		} else if (WarriorTableCraftBowProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(ForgottenFairyTalesModItems.STEEL_BONE_BOW.get()).copy();
				_setstack2.setCount(1);
				_menu.getSlots().get(11).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
		} else if (WarriorTableCraftBookProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack3 = new ItemStack(ForgottenFairyTalesModItems.BOOK.get()).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(11).set(_setstack3);
				_player.containerMenu.broadcastChanges();
			}
		} else if (WarriorTableCraftSaddleProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack4 = new ItemStack(ForgottenFairyTalesModItems.GOLDEN_SADDLE.get()).copy();
				_setstack4.setCount(1);
				_menu.getSlots().get(11).set(_setstack4);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(11).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}