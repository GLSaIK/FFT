package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

public class WeldingmaskoverlayUsloviiePokazaNalozhieniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ForgottenFairyTalesModItems.WELDINGMASK_HELMET.get() == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
				&& entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == true && entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).IsZommed == true) {
			return true;
		}
		return false;
	}
}