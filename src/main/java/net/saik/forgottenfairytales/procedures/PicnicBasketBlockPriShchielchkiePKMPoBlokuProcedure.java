package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class PicnicBasketBlockPriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double n = 0;
		ItemStack t = ItemStack.EMPTY;
		t = new ItemStack(ForgottenFairyTalesModItems.PICNIC_BASKET.get()).copy();
		n = 0;
		for (int index0 = 0; index0 < 15; index0++) {
			if (t.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
				ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) n).copy()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) n).getCount());
				_modHandlerItemSetSlot.setStackInSlot((int) n, _setstack);
			}
			n = n + 1;
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, t);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
		world.destroyBlock(BlockPos.containing(x, y, z), false);
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}