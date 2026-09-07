package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@EventBusSubscriber
public class KatanaspawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (ForgottenFairyTalesModVariables.MapVariables.get(world).s == false) {
			ForgottenFairyTalesModVariables.MapVariables.get(world).x = 10000 * Math.cos(Mth.nextDouble(RandomSource.create(), 0, 2 * Math.PI));
			ForgottenFairyTalesModVariables.MapVariables.get(world).y = 10000 * Math.sin(Mth.nextDouble(RandomSource.create(), 0, 2 * Math.PI));
			ForgottenFairyTalesModVariables.MapVariables.get(world).s = true;
			ForgottenFairyTalesModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}