package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

@EventBusSubscriber
public class KatanastrAchieveProcedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (x < ForgottenFairyTalesModVariables.MapVariables.get(world).x + 30 && x > ForgottenFairyTalesModVariables.MapVariables.get(world).x - 30 && z < ForgottenFairyTalesModVariables.MapVariables.get(world).y + 30
				&& z > ForgottenFairyTalesModVariables.MapVariables.get(world).y - 30
				&& y < world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).x, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).y) + 30
				&& y > world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).x, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).y) - 30) {
			if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
				AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("forgotten_fairy_tales:katanastr_achieve"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}