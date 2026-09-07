package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;

public class NozniKazhdyiTikVInvientarie2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double itemn = 0;
		double loops = 0;
		boolean t = false;
		if (!hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.KATANA.get())) && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.NOZNI.get()) {
			if (entity instanceof LivingEntity _entity) {
				_entity.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(ResourceLocation.parse("forgotten_fairy_tales:katana"));
			}
			entity.getPersistentData().putDouble("katanatimer", 0);
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack6 = ItemStack.EMPTY.copy();
				_setstack6.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack6);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if (hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.KATANA.get())) && hasEntityInInventory(entity, new ItemStack(ForgottenFairyTalesModItems.NOZNI.get()))
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.NOZNI.get())) {
			entity.getPersistentData().putDouble("katanatimer", 0);
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.NOZNI.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}