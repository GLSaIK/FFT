package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.m;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class CartridgePouchKazhdyiTikVInvientarieProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double n = 0;
		double m = 0;
		double c = 0;
		double u = 0;
		n = 0;
		c = 0;
		for (int index0 = 0; index0 < 5; index0++) {
			if (ForgottenFairyTalesModItems.BULLETSHOTGUN.get() == (getItemStackFromItemStackSlot((int) n, itemstack)).getItem()) {
				m = m + (getItemStackFromItemStackSlot((int) n, itemstack)).getCount();
				c = c + 1;
			}
			n = n + 1;
		}
		{
			ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
			_vars.pouch = m;
			_vars.markSyncDirty();
		}
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).needammo > 0) {
			u = 0;
			for (int index1 = 0; index1 < 5; index1++) {
				ForgottenFairyTalesMod.LOGGER.info("\u0438\u0449\u0435\u043C");
				if (ForgottenFairyTalesModItems.BULLETSHOTGUN.get() == (getItemStackFromItemStackSlot((int) u, itemstack)).getItem()) {
					ForgottenFairyTalesMod.LOGGER.info("\u043D\u0430\u0448\u043B\u0438");
					if (itemstack.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
						ItemStack _setstack = (getItemStackFromItemStackSlot((int) u, itemstack)).copy();
						_setstack.setCount((getItemStackFromItemStackSlot((int) u, itemstack)).getCount() - 1);
						_modHandlerItemSetSlot.setStackInSlot((int) u, _setstack);
					}
					{
						ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
						_vars.needammo = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).needammo - 1;
						_vars.markSyncDirty();
					}
					break;
				} else {
					ForgottenFairyTalesMod.LOGGER.info("\u043D\u0435 \u043D\u0430\u0448\u043B\u0438");
					u = u + 1;
				}
			}
		}
	}

	private static ItemStack getItemStackFromItemStackSlot(int slotID, ItemStack itemStack) {
		IItemHandler itemHandler = itemStack.getCapability(Capabilities.ItemHandler.ITEM, null);
		if (itemHandler != null)
			return itemHandler.getStackInSlot(slotID).copy();
		return ItemStack.EMPTY;
	}
}