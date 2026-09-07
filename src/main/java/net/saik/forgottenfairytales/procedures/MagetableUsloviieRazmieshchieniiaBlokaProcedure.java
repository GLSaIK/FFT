package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MagetableUsloviieRazmieshchieniiaBlokaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (1 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1)
				&& 2 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1)
				&& 4 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1)
				&& 5 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1)
				&& 3 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1)) {
			if (Direction.NORTH == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						|| ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()) {
					return true;
				}
			} else if (Direction.SOUTH == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && true
						|| ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()) {
					return true;
				}
			} else if (Direction.EAST == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()
						|| ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()) {
					return true;
				}
			} else if (Direction.WEST == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						|| ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
								&& ForgottenFairyTalesModBlocks.MAGETABLE.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
					return true;
				}
			}
		}
		return false;
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}