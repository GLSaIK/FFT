package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.world.inventory.BigBlastFurnaceGUIMenu;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class FireclayBricksPriShchielchkiePKMPoBlokuProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double oneforX = 0;
		double oneforZ = 0;
		if (entity.getData(ForgottenFairyTalesModVariables.PLAYER_VARIABLES).eng == true && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.CLAY_BALL) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) != 1
					&& (blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip5 ? blockstate.getValue(_getip5) : -1) != 2) {
				oneforX = 0;
				oneforZ = 0;
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
						&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
					oneforX = 1;
					oneforZ = 1;
				} else if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
					oneforX = -1;
					oneforZ = -1;
				} else if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
						&& (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
					oneforX = 1;
					oneforZ = -1;
				} else if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
						&& (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
					oneforX = -1;
					oneforZ = 1;
				}
				if (oneforX != 0 || oneforZ != 0) {
					if ((world.getBlockState(BlockPos.containing(x + oneforX, y, z + oneforZ))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							&& (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							&& (world.getBlockState(BlockPos.containing(x + oneforX, y - 1, z))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							&& (world.getBlockState(BlockPos.containing(x, y - 1, z + oneforZ))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()
							&& (world.getBlockState(BlockPos.containing(x + oneforX, y - 1, z + oneforZ))).getBlock() == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
						world.setBlock(BlockPos.containing(x, y, z), ForgottenFairyTalesModBlocks.BIG_BLAST_FURNACE.get().defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("blasting", 0);
								_blockEntity.getPersistentData().putDouble("Fuel", 0);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (oneforX == 1 && oneforZ == 1) {
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
						} else if (oneforX == -1 && oneforZ == -1) {
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
						} else if (oneforX == 1 && oneforZ == -1) {
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
						} else if (oneforX == -1 && oneforZ == 1) {
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
						}
						{
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x + oneforX, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + oneforX, y, z);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y, z + oneforZ);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z + oneforZ);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x + oneforX, y, z + oneforZ);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + oneforX, y, z + oneforZ);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y - 1, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y - 1, z);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x + oneforX, y - 1, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + oneforX, y - 1, z);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x, y - 1, z + oneforZ);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y - 1, z + oneforZ);
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
							int _value = 1;
							BlockPos _pos = BlockPos.containing(x + oneforX, y - 1, z + oneforZ);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + oneforX, y - 1, z + oneforZ);
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
					}
				}
			}
		}
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip81 ? blockstate.getValue(_getip81) : -1) == 1) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MasterX"), getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MasterY"),
						getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MasterZ"));
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("BigBlastFurnaceGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new BigBlastFurnaceGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
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