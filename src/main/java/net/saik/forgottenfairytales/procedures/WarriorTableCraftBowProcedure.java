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
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(7).getItem() : ItemStack.EMPTY)
				.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(6).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.ROASTEDBONE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(1).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRONROD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(2).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.ROASTEDBONE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.IRONROD.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(4).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.STEEL_BONE_BOW.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(5).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get();
	}
}