package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean sp = false;
		if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.STONE_BRICK_STAIRS
				&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.STONE_BRICK_STAIRS
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.STONE_BRICKS
				&& (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == Blocks.STONE_BRICKS
				&& (world.getBlockState(BlockPos.containing(x, y + 5, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.STONE_BRICK_STAIRS
				&& (world.getBlockState(BlockPos.containing(x, y + 5, z - 1))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x, y + 5, z + 1))).getBlock() == Blocks.STONE_BRICK_STAIRS
				&& (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.STONE_BRICK_STAIRS
				&& !world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty()) {
			ForgottenFairyTalesMod.queueServerWork(100, () -> {
				if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.STONE_BRICK_STAIRS
						&& (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.STONE_BRICK_STAIRS
						&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.STONE_BRICKS
						&& (world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x, y + 4, z))).getBlock() == Blocks.STONE_BRICKS
						&& (world.getBlockState(BlockPos.containing(x, y + 5, z))).getBlock() == Blocks.STONE_BRICKS && (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.STONE_BRICK_STAIRS
						&& (world.getBlockState(BlockPos.containing(x, y + 5, z - 1))).getBlock() == Blocks.STONE_BRICK_STAIRS && (world.getBlockState(BlockPos.containing(x, y + 5, z + 1))).getBlock() == Blocks.STONE_BRICK_STAIRS
						&& (world.getBlockState(BlockPos.containing(x + 1, y + 5, z))).getBlock() == Blocks.STONE_BRICK_STAIRS) {
					world.destroyBlock(BlockPos.containing(x, y, z), false);
					world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
					world.destroyBlock(BlockPos.containing(x, y, z + 1), false);
					world.destroyBlock(BlockPos.containing(x, y, z - 1), false);
					world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 2, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 3, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 4, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 5, z), false);
					world.destroyBlock(BlockPos.containing(x + 1, y + 5, z), false);
					world.destroyBlock(BlockPos.containing(x, y + 5, z - 1), false);
					world.destroyBlock(BlockPos.containing(x, y + 5, z + 1), false);
					world.destroyBlock(BlockPos.containing(x - 1, y + 5, z), false);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = ForgottenFairyTalesModEntities.COLOMN.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				}
			});
		}
	}
}