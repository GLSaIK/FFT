package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class WafflePriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == true) {
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel(3 + (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0));
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) (3 + (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0)));
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 20) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
			}
		}
	}
}