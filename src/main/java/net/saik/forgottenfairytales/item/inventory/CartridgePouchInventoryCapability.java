package net.saik.forgottenfairytales.item.inventory;

import net.saik.forgottenfairytales.world.inventory.CartridgePouchUIMenu;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nonnull;

@EventBusSubscriber
public class CartridgePouchInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof CartridgePouchUIMenu)
				player.closeContainer();
		}
	}

	public CartridgePouchInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 5);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}