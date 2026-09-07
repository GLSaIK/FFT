package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.t;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BigBlastFurnacePriObnovlieniiTikaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		ItemStack t = ItemStack.EMPTY;
		boolean r = false;
		boolean p = false;
		double n = 0;
		double c = 0;
		double oneforX = 0;
		double oneforZ = 0;
		double c2 = 0;
		if ((getDirectionFromBlockState(blockstate)) == Direction.NORTH) {
			oneforX = 1;
			oneforZ = 1;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH) {
			oneforX = -1;
			oneforZ = -1;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST) {
			oneforX = 1;
			oneforZ = -1;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST) {
			oneforX = -1;
			oneforZ = 1;
		}
		if (oneforX != 0 || oneforZ != 0) {
			if (!((world.getBlockState(BlockPos.containing(x + oneforX, y, z))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x, y, z + oneforZ))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x + oneforX, y, z + oneforZ))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x + oneforX, y - 1, z))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x, y - 1, z + oneforZ))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get()
					&& (world.getBlockState(BlockPos.containing(x + oneforX, y - 1, z + oneforZ))).getBlock() == ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get())) {
				world.setBlock(BlockPos.containing(x, y, z), ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get().defaultBlockState(), 3);
			}
		}
		r = false;
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() == 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("blasting", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fuel") == 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("blasting", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 0) {
			if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_IRON || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_COPPER
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_GOLD)
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 128) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0
						|| (getItemStackFromItemStackSlot(world, (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()))).getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem())
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0
								|| (getItemStackFromItemStackSlot(world, (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()))).getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem())
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 64 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 64)) {
					r = true;
				}
			} else if (((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_IRON_BLOCK.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_COPPER_BLOCK.asItem()
					|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_GOLD_BLOCK.asItem())
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() <= 118) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_IRON_BLOCK.asItem()) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 || Items.IRON_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0 || Items.IRON_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60)) {
						r = true;
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_GOLD_BLOCK.asItem()) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 || Items.GOLD_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0 || Items.GOLD_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60)) {
						r = true;
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_COPPER_BLOCK.asItem()) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 || Items.COPPER_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0 || Items.COPPER_INGOT == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem())
							&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60 || itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60)) {
						r = true;
					}
				}
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ForgottenFairyTalesModItems.PYRITE_ORE.get()
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 64 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.IRON_INGOT)
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 64 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == ForgottenFairyTalesModItems.SULFUR.get())) {
				r = true;
			} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ForgottenFairyTalesModBlocks.RAW_PYRITE_BLOCK.get().asItem()
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() < 60 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == Items.IRON_INGOT)
					&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() < 60 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == ForgottenFairyTalesModItems.SULFUR.get())) {
				r = true;
			}
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fuel") == 0 && r == true) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.COAL || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.CHARCOAL) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("Fuel", 1000);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ForgottenFairyTalesModBlocks.CHAR_COAL_BLOCK.get().asItem()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Blocks.COAL_BLOCK.asItem()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("Fuel", 9000);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.LAVA_BUCKET) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("Fuel", 13000);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						int _slotid = 0;
						ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
						_stk.shrink(1);
						_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") == 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fuel") == 0) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fuel") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Fuel", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fuel") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
			if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
				BrownSmokeBaseProcedure.execute(world, x, y, z);
			}
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() > 0 && r == true) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_IRON || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_COPPER
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Items.RAW_GOLD) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") < 200) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") == 200) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						t = (getItemStackFromItemStackSlot(world, (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()))).copy();
						c = 1;
						p = false;
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_GOLD_BLOCK.asItem()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_IRON_BLOCK.asItem()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_COPPER_BLOCK.asItem()) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") < 1800) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") == 1800) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_IRON_BLOCK.asItem()) {
							t = new ItemStack(Items.IRON_INGOT).copy();
						} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_GOLD_BLOCK.asItem()) {
							t = new ItemStack(Items.GOLD_INGOT).copy();
						} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == Blocks.RAW_COPPER_BLOCK.asItem()) {
							t = new ItemStack(Items.COPPER_INGOT).copy();
						}
						c = 10;
						p = false;
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ForgottenFairyTalesModItems.PYRITE_ORE.get()) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") < 300) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") == 300) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						p = true;
						c = Mth.nextInt(RandomSource.create(), 1, 3);
						c2 = 1;
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
				} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ForgottenFairyTalesModBlocks.RAW_PYRITE_BLOCK.get().asItem()) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") < 2300) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") + 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blasting") == 2300) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						p = true;
						c = Mth.nextInt(RandomSource.create(), 1, 3) * 10;
						c2 = 10;
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							int _slotid = 1;
							ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
							_stk.shrink(1);
							_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
						}
					}
				}
				if (c > 0) {
					if (p == false && !(t.getItem() == ItemStack.EMPTY.getItem())) {
						if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() == 0 || t.getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()) {
							if (c <= 64 - itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()) {
								n = c;
							} else {
								n = 64 - itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount();
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								ItemStack _setstack = t.copy();
								_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + n));
								_itemHandlerModifiable.setStackInSlot(2, _setstack);
							}
							if (n < c) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = t.copy();
									_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + c - n));
									_itemHandlerModifiable.setStackInSlot(3, _setstack);
								}
							}
						} else if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0 || t.getItem() == (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem()) {
							if (c <= 64 - itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()) {
								n = c;
							} else {
								n = 64 - itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount();
							}
							if (n < c) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = t.copy();
									_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + c - n));
									_itemHandlerModifiable.setStackInSlot(3, _setstack);
								}
							}
						}
					} else {
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(Items.IRON_NUGGET).copy();
							_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() + c));
							_itemHandlerModifiable.setStackInSlot(2, _setstack);
						}
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = new ItemStack(ForgottenFairyTalesModItems.SULFUR.get()).copy();
							_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() + c2));
							_itemHandlerModifiable.setStackInSlot(3, _setstack);
						}
					}
				}
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp209 && blockstate.getValue(_getbp209)) == true
				&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip211 ? blockstate.getValue(_getip211) : -1) == 0) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp214 && blockstate.getValue(_getbp214)) == false
				&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip216 ? blockstate.getValue(_getip216) : -1) == 1) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
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

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static ItemStack getItemStackFromItemStackSlot(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput, serverLevel.registryAccess()).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}