package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class CauldronewithcheesePriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing(x, y, z), Blocks.CAULDRON.defaultBlockState(), 3);
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.CHEESE.get()).copy();
			_setstack.setCount(7);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}