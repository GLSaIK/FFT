package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

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

public class WarriordrinkPriShchielchkiePKMPoBlokuProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.UP) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y + 1, z), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack12 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack12.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack12);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.DOWN) {
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y - 1, z), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack25 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack25.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack25);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.NORTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y, z - 1), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack38 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack38.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack38);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x, y, z + 1), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack51 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack51.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack51);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.WEST) {
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x - 1, y, z), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack64 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack64.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack64);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.VOID_AIR
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CAVE_AIR) {
				world.setBlock(BlockPos.containing(x + 1, y, z), ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK.get().defaultBlockState(), 3);
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack77 = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack77.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack77);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
	}
}