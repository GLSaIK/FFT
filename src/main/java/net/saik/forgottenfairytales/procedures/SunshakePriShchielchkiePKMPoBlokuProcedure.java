package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SunshakePriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack14 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack14.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack14);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.DOWN) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y - 1, z), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack29 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack29.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack29);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y, z - 1), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack44 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack44.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack44);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y, z + 1), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack59 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack59.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack59);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x - 1, y, z), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack74 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack74.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack74);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x + 1, y, z), ForgottenFairyTalesModBlocks.SUNSHAKEBLOCK.get().defaultBlockState(), 3);
				{
					Direction _dir = (entity.getDirection());
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty _dp && _dp.getPossibleValues().contains(_dir)) {
						world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
					} else if (_bs.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis())) {
						world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
					}
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack89 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack89.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack89);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
	}
}