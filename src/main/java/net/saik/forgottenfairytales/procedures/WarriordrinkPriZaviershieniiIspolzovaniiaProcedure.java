package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class WarriordrinkPriZaviershieniiIspolzovaniiaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin == true) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ForgottenFairyTalesModMobEffects.VOINBAFF, 1200, 0));
			if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel _serverLevel1
					&& _plr1.getAdvancements().getOrStartProgress(_serverLevel1.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:war_drink_achieve"))).isDone())
					&& entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).wardrinkcount < 16) {
				{
					ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
					_vars.wardrinkcount = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).wardrinkcount + 1;
					_vars.markSyncDirty();
				}
			} else if (!(entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel _serverLevel2
					&& _plr2.getAdvancements().getOrStartProgress(_serverLevel2.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:war_drink_achieve"))).isDone())
					&& entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).wardrinkcount == 16) {
				if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
					AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:war_drink_achieve"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		} else if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == true || entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == false
				|| entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == true || entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == false) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 300, 1));
			if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == true) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 1));
			}
		}
	}
}