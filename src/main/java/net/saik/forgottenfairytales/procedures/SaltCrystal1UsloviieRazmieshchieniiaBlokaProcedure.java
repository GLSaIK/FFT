package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SaltCrystal1UsloviieRazmieshchieniiaBlokaProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getDirectionFromBlockState(blockstate)) == Direction.DOWN) {
			if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.UP) {
			if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.NORTH) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST) {
			if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST) {
			if (!((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.VOID_AIR)
					&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CAVE_AIR)) {
				return true;
			}
		}
		return false;
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}