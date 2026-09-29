package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class ChangeTableGuiButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 3) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.SWORDVOIN
					.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack3 = new ItemStack(ForgottenFairyTalesModItems.UNDEAD_HUNTER_SWORD.get()).copy();
					_setstack3.setCount(1);
					_menu.getSlots().get(0).set(_setstack3);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == ForgottenFairyTalesModItems.UNDEAD_HUNTER_SWORD.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack7 = new ItemStack(ForgottenFairyTalesModItems.SWORDVOIN.get()).copy();
					_setstack7.setCount(1);
					_menu.getSlots().get(0).set(_setstack7);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == ForgottenFairyTalesModItems.PULTA.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack11 = new ItemStack(ForgottenFairyTalesModItems.CURSED_MAGIC_LAUNCHER.get()).copy();
					_setstack11.setCount(1);
					_menu.getSlots().get(0).set(_setstack11);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == ForgottenFairyTalesModItems.CURSED_MAGIC_LAUNCHER.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack15 = new ItemStack(ForgottenFairyTalesModItems.PULTA.get()).copy();
					_setstack15.setCount(1);
					_menu.getSlots().get(0).set(_setstack15);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == ForgottenFairyTalesModItems.SHOTGUN.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack19 = new ItemStack(ForgottenFairyTalesModItems.BFS.get()).copy();
					_setstack19.setCount(1);
					_menu.getSlots().get(0).set(_setstack19);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(0).getItem() : ItemStack.EMPTY)
					.getItem() == ForgottenFairyTalesModItems.BFS.get()) {
				if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
					ItemStack _setstack23 = new ItemStack(ForgottenFairyTalesModItems.SHOTGUN.get()).copy();
					_setstack23.setCount(1);
					_menu.getSlots().get(0).set(_setstack23);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(3));
			}
		}
	}
}