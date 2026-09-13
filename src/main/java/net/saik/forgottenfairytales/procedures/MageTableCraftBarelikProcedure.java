package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class MageTableCraftBarelikProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == Blocks.STRIPPED_OAK_LOG.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(3).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == Blocks.OAK_FENCE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu12 ? _menu12.getSlots().get(6).getItem() : ItemStack.EMPTY).getItem() == Blocks.OAK_SLAB.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(7).getItem() : ItemStack.EMPTY).getItem() == Items.ROTTEN_FLESH
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu16 ? _menu16.getSlots().get(8).getItem() : ItemStack.EMPTY).getItem() == Blocks.OAK_SLAB.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(9).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(10).getItem() : ItemStack.EMPTY).getItem() == Blocks.OAK_FENCE.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(11).getItem() : ItemStack.EMPTY)
						.getItem() == ForgottenFairyTalesModItems.REINFORCED_ROPE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(12).getItem() : ItemStack.EMPTY).getItem() == Blocks.STRIPPED_OAK_LOG
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(13).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
				&& true && true;
	}
}