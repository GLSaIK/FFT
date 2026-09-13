package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MageTableCraftOrangeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.RESIN_CLUMP.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.RESIN_CLUMP.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.DROP
						.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(9).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == Blocks.RESIN_CLUMP.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(11).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_INGOT
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(12).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(13).getItem() : ItemStack.EMPTY).getItem() == Blocks.RESIN_CLUMP.asItem()
				&& true && true;
	}
}