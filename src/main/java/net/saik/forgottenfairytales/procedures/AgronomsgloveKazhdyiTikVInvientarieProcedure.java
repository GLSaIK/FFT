package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class AgronomsgloveKazhdyiTikVInvientarieProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDisplayName().getString()).equals("Dev") || (entity.getStringUUID()).equals("622afaed-a32b-4def-b957-00e5df2465a3")) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.POISON)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.POISON);
				if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) || !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.VOID_AIR)
						|| !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.CAVE_AIR)) {
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y - 1, z + Mth.nextInt(RandomSource.create(), -1, 1)), Blocks.MOSS_BLOCK.defaultBlockState(), 3);
					if (world instanceof Level _level) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
							if (!_level.isClientSide())
								_level.levelEvent(2005, _bp, 0);
						}
					}
				}
			}
		}
	}
}