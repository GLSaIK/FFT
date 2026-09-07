package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MagetablePriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (1 == (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1)) {
			if (Direction.NORTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.SOUTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.EAST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.WEST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		} else if (2 == (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip43 ? blockstate.getValue(_getip43) : -1)) {
			if (Direction.NORTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.SOUTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.EAST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.WEST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		} else if (3 == (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip69 ? blockstate.getValue(_getip69) : -1)) {
			if (Direction.NORTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.SOUTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.EAST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.WEST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		} else if (4 == (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip95 ? blockstate.getValue(_getip95) : -1)) {
			if (Direction.NORTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.SOUTH == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.EAST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			} else if (Direction.WEST == (getDirectionFromBlockState(blockstate))) {
				if (!((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ForgottenFairyTalesModBlocks.MAGETABLE.get())) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}