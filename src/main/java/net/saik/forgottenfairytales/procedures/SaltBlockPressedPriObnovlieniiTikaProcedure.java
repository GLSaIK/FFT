package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SaltBlockPressedPriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double t = 0;
		boolean n = false;
		t = 2;
		for (int index0 = 0; index0 < 10; index0++) {
			if (!((world.getBlockState(BlockPos.containing(x, y + t, z))).getBlock() == Blocks.POINTED_DRIPSTONE && ((world.getBlockState(BlockPos.containing(x, y + t + 2, z))).getBlock() == Blocks.WATER
					|| ((world.getBlockState(BlockPos.containing(x, y + t + 2, z))).getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp5
							&& (world.getBlockState(BlockPos.containing(x, y + t + 2, z))).getValue(_getbp5)) == true))) {
				t = t + 1;
			} else {
				n = true;
			}
		}
		if (n == true) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Timer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Timer") >= 60) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_12.get().defaultBlockState(), 3);
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
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.SALT_CRYSTAL_12.get()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_22.get().defaultBlockState(), 3);
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
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.SALT_CRYSTAL_22.get()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_32.get().defaultBlockState(), 3);
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
			} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.SALT_CRYSTAL_32.get()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SALT_CRYSTAL_4.get().defaultBlockState(), 3);
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
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Timer", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}