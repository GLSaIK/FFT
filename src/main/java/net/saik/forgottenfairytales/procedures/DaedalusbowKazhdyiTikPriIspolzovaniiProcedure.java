package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class DaedalusbowKazhdyiTikPriIspolzovaniiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.BUNCH_OF_ARROWS.get())) || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if (entity.getPersistentData().getDoubleOr("dedPull", 0) < 30) {
				entity.getPersistentData().putDouble("dedPull", (entity.getPersistentData().getDoubleOr("dedPull", 0) + 1));
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}