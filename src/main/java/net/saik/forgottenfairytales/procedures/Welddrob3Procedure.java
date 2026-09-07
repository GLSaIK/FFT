package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Welddrob3Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double itemn = 0;
		double loops = 0;
		double n = 0;
		if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get()))) {
			loops = 0;
			itemn = 0;
			for (int index0 = 0; index0 < 36; index0++) {
				if (ForgottenFairyTalesModItems.BULLETSHOTGUN.get() == (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler1 ? _modHandler1.getStackInSlot((int) loops).copy() : ItemStack.EMPTY)
						.getItem()) {
					itemn = itemn + (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler3 ? _modHandler3.getStackInSlot((int) loops).copy() : ItemStack.EMPTY).getCount();
				}
				loops = loops + 1;
			}
			if (!hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get()))) {
				return "" + Math.round(itemn);
			}
			if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get()))) {
				return Math.round(itemn) + " + " + Math.round(entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch);
			}
		} else if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get()))) {
			if (!hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BULLETSHOTGUN.get()))) {
				return "" + Math.round(entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).pouch);
			}
		}
		return "" + 0;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}