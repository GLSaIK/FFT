package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class WarriorTableCraftDrinkProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.DROP
						.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Items.HONEY_BOTTLE
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Items.IRON_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRON_PLATE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRON_PLATE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(8).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRON_PLATE.get()
				&& true;
	}
}