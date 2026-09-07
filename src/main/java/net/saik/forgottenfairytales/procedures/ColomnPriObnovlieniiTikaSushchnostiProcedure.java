package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;
import net.saik.forgottenfairytales.entity.ColomnEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class ColomnPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sdfg = 0;
		double r = 0;
		if (!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(80 / 2d), e -> true).isEmpty()) {
			if (entity instanceof ColomnEntity _datEntSetI)
				_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, (int) ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) + 1));
			if ((entity instanceof ColomnEntity _datEntI ? _datEntI.getEntityData().get(ColomnEntity.DATA_sdg) : 0) == 100) {
				if (entity instanceof ColomnEntity _datEntSetI)
					_datEntSetI.getEntityData().set(ColomnEntity.DATA_sdg, 0);
				if (world.getDifficulty() == Difficulty.EASY) {
					sdfg = Mth.nextInt(RandomSource.create(), 1, 2);
					if (sdfg == 1) {
						r = Mth.nextInt(RandomSource.create(), 1, 4);
						if (r == 1) {
							if ((world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.VOID_AIR
									|| (world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.CAVE_AIR) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x + 5, y, z), EntitySpawnReason.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						if (r == 2) {
							if ((world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.VOID_AIR
									|| (world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.CAVE_AIR) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x - 5, y, z), EntitySpawnReason.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						if (r == 3) {
							if ((world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.VOID_AIR
									|| (world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.CAVE_AIR) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z + 5), EntitySpawnReason.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
						if (r == 4) {
							if ((world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.VOID_AIR
									|| (world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.CAVE_AIR) {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z - 5), EntitySpawnReason.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							}
						}
					}
				} else {
					r = Mth.nextInt(RandomSource.create(), 1, 4);
					if (r == 1) {
						if ((world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.VOID_AIR
								|| (world.getBlockState(BlockPos.containing(x + 5, y, z))).getBlock() == Blocks.CAVE_AIR) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x + 5, y, z), EntitySpawnReason.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
					if (r == 2) {
						if ((world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.VOID_AIR
								|| (world.getBlockState(BlockPos.containing(x - 5, y, z))).getBlock() == Blocks.CAVE_AIR) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x - 5, y, z), EntitySpawnReason.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
					if (r == 3) {
						if ((world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.VOID_AIR
								|| (world.getBlockState(BlockPos.containing(x, y, z + 5))).getBlock() == Blocks.CAVE_AIR) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z + 5), EntitySpawnReason.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
					if (r == 4) {
						if ((world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.VOID_AIR
								|| (world.getBlockState(BlockPos.containing(x, y, z - 5))).getBlock() == Blocks.CAVE_AIR) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ForgottenFairyTalesModEntities.LIVINGBRICKS.get().spawn(_level, BlockPos.containing(x, y, z - 5), EntitySpawnReason.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
				}
			}
		}
	}
}