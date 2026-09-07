package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MagetableuiKazhdyiTikPokaIntierfieisOtkrytProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (MageTableCraftHatProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack0 = new ItemStack(ForgottenFairyTalesModItems.HAT_HELMET.get()).copy();
				_setstack0.setCount(1);
				_menu.getSlots().get(14).set(_setstack0);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftPultaProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack1 = new ItemStack(ForgottenFairyTalesModItems.PULTA.get()).copy();
				_setstack1.setCount(1);
				_menu.getSlots().get(14).set(_setstack1);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftSwordProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack2 = new ItemStack(ForgottenFairyTalesModItems.GLASS_SWORD.get()).copy();
				_setstack2.setCount(1);
				_menu.getSlots().get(14).set(_setstack2);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftOrangeProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack3 = new ItemStack(ForgottenFairyTalesModItems.ANIMATINGMATTERLIFE.get()).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(14).set(_setstack3);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftMultiToolProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack4 = new ItemStack(ForgottenFairyTalesModItems.MULTITOOL.get()).copy();
				_setstack4.setCount(1);
				_menu.getSlots().get(14).set(_setstack4);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftBarelikProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack5 = new ItemStack(ForgottenFairyTalesModItems.BARELIK_SPAWN_EGG.get()).copy();
				_setstack5.setCount(1);
				_menu.getSlots().get(14).set(_setstack5);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MagetablecraftRuneProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack6 = new ItemStack(ForgottenFairyTalesModItems.RUNE_OF_PROTECTION.get()).copy();
				_setstack6.setCount(1);
				_menu.getSlots().get(14).set(_setstack6);
				_player.containerMenu.broadcastChanges();
			}
		} else if (MageTableCraftKnifeProcedure.execute(entity)) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				ItemStack _setstack7 = new ItemStack(ForgottenFairyTalesModItems.RITUAL_KNIFE.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(14).set(_setstack7);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(14).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}