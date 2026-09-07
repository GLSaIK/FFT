package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class PrahvoinPriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).voin == false && entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).mag == false
				&& entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(ForgottenFairyTalesModItems.PRAHVOIN.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u0422\u0435\u043F\u0435\u0440\u044C \u0432\u044B \u0412\u043E\u0438\u043D"), true);
			if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
				AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:fftachieve"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
				AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:warrior_achieve"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			ForgottenFairyTalesMod.queueServerWork(5, () -> {
				if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.SWORDVOIN.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.UNDEAD_HUNTER_SWORD.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			});
			{
				ForgottenFairyTalesModVariables.PlayerVariables _vars = entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES);
				_vars.voin = true;
				_vars.markSyncDirty();
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u0412\u044B \u0443\u0436\u0435 \u0432\u044B\u0431\u0440\u0430\u043B\u0438 \u0441\u0432\u043E\u0439 \u043A\u043B\u0430\u0441\u0441"), true);
		}
	}
}