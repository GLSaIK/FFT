package net.saik.forgottenfairytales.item.inventory;

import net.saik.forgottenfairytales.world.inventory.BasketUIMenu;
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
public class PicnicBasketInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == ForgottenFairyTalesModItems.PICNIC_BASKET.get()) {
			Player player = event.getPlayer();
			if (player.containerMenu instanceof BasketUIMenu)
				player.closeContainer();
		}
	}

	public PicnicBasketInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 16);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 48;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != ForgottenFairyTalesModItems.PICNIC_BASKET.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}