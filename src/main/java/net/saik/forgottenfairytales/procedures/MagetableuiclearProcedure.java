package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class MagetableuiclearProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double n = 0;
		n = 1;
		for (int index0 = 0; index0 < 13; index0++) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				_menu.getSlots().get((int) n).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			n = n + 1;
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(14).getItem() : ItemStack.EMPTY)
				.getItem() == ForgottenFairyTalesModItems.BARELIK_SPAWN_EGG.get()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor _menu) {
				_menu.getSlots().get(14).remove(1);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ForgottenFairyTalesModEntities.BARELIK.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		}
	}
}