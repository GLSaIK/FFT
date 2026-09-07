package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class MilkwithenzymesPriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CAULDRON) {
			world.setBlock(BlockPos.containing(x, y, z), ForgottenFairyTalesModBlocks.CAULDRONWITHFERMENTEDMILK.get().defaultBlockState(), 3);
			itemstack.shrink(1);
		}
	}
}