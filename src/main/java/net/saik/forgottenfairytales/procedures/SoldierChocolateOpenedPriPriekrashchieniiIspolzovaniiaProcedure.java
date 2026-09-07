package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class SoldierChocolateOpenedPriPriekrashchieniiIspolzovaniiaProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack t = ItemStack.EMPTY;
		if (itemstack.getItem() == ForgottenFairyTalesModItems.SOLDIER_CHOCOLATE_OPENED.get()) {
			{
				ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
				_vars.soldierchocolate = itemstack.copy();
				_vars.markSyncDirty();
			}
		}
	}
}