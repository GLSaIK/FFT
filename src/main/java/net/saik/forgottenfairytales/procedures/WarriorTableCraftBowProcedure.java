package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class WarriorTableCraftBowProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRONROD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.ROASTEDBONE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRONROD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.STEEL_BONE_BOW.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.ROASTEDBONE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(7).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& true;
	}
}