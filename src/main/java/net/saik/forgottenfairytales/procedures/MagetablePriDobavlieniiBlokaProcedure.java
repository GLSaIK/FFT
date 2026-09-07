package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class MagetablePriDobavlieniiBlokaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double WX = 0;
		double WY = 0;
		double WZ = 0;
		if (1 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1)
				&& 2 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1)
				&& 3 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1)
				&& 4 != (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1)) {
			if (Direction.NORTH == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()) {
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.NORTH;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 3)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.NORTH;
						BlockPos _pos = BlockPos.containing(x + 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 2)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.NORTH;
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 4)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.NORTH;
						BlockPos _pos = BlockPos.containing(x, y, z - 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Direction.SOUTH == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()) {
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.SOUTH;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 3)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.SOUTH;
						BlockPos _pos = BlockPos.containing(x - 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 2)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.SOUTH;
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 4)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.SOUTH;
						BlockPos _pos = BlockPos.containing(x, y, z + 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Direction.EAST == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()) {
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.EAST;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 3)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.EAST;
						BlockPos _pos = BlockPos.containing(x, y, z + 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 2)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.EAST;
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 4)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.EAST;
						BlockPos _pos = BlockPos.containing(x + 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if (Direction.WEST == (getBlockDirection(world, BlockPos.containing(x, y, z)))) {
				if (Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
						&& Blocks.CAVE_AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()
						|| Blocks.AIR == (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() && Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()
								&& Blocks.AIR == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
					{
						int _value = 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.WEST;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 3)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.WEST;
						BlockPos _pos = BlockPos.containing(x, y, z - 1);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 2)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.WEST;
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), (new Object() {
						public BlockState with(BlockState _bs, String _property, int _newValue) {
							Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
							return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
						}
					}.with(ForgottenFairyTalesModBlocks.MAGETABLE.get().defaultBlockState(), "blockstate", 4)), 3);
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("MasterX", x);
							_blockEntity.getPersistentData().putDouble("MasterY", y);
							_blockEntity.getPersistentData().putDouble("MasterZ", z);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					{
						Direction _dir = Direction.WEST;
						BlockPos _pos = BlockPos.containing(x - 1, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
							world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get()));
						entityToSpawn.setPickUpDelay(2);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
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