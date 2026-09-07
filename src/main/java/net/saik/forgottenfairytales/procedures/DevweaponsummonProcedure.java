package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DevweaponsummonProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer(), event.getRawText());
	}

	public static void execute(Entity entity, String text) {
		execute(null, entity, text);
	}

	private static void execute(@Nullable Event event, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) {
			if ((entity.getDisplayName().getString()).equals("Dev") || (entity.getStringUUID()).equals("622afaed-a32b-4def-b957-00e5df2465a3")) {
				if (((text).toLowerCase()).equals("\u043F\u0435\u0440\u0447\u0430\u0442\u043A\u0430")) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.AGRONOMSGLOVE.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if ((entity.getDisplayName().getString()).equals("Dev") || (entity.getDisplayName().getString()).equals("vb88")) {
				if (((text).toLowerCase()).equals("\u0442\u0440\u043E\u0441\u0442\u044C")) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.TROST.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if ((entity.getDisplayName().getString()).equals("Dev") || (entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f")) {
				if (((text).toLowerCase()).equals("\u043A\u0430\u0442\u0430\u043D\u0430")) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.KATANA.get()).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}