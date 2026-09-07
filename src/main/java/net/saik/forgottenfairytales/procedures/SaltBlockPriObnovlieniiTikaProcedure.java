package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SaltBlockPriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double n = 0;
		n = Mth.nextInt(RandomSource.create(), 1, 6);
		if (n == 1) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x + 1, y, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.WEST;
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		} else if (n == 2) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x - 1, y, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.EAST;
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		} else if (n == 3) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x, y, z + 1), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.NORTH;
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		} else if (n == 4) {
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x, y, z - 1), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.SOUTH;
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		} else if (n == 5) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x, y - 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.UP;
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		} else if (n == 6) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.WATER) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1.get().defaultBlockState(), 3);
				{
					Direction _dir = Direction.DOWN;
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
			}
		}
	}
}