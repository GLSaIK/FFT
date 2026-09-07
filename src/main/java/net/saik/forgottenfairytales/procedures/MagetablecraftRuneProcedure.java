package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MagetablecraftRuneProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return true && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.SMOOTH_STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == Blocks.STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.COBBLESTONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == Blocks.SMOOTH_STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Blocks.GOLD_BLOCK.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Items.GOLD_NUGGET
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(9).getItem() : ItemStack.EMPTY).getItem() == Blocks.COBBLESTONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == Blocks.SMOOTH_STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(11).getItem() : ItemStack.EMPTY).getItem() == Blocks.STONE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(12).getItem() : ItemStack.EMPTY).getItem() == Blocks.COBBLESTONE.asItem()
				&& true && true && true;
	}
}