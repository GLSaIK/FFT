package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ScabbardPriShchielchkiePKMProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin == true) {
			if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).scabbardTrue == false) {
				{
					ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
					_vars.scabbardTrue = true;
					_vars.markSyncDirty();
				}
				itemstack.shrink(1);
			}
		}
	}
}