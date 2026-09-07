package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ZgutikPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof Mob _mobEnt0 && _mobEnt0.isAggressive()) {
			sx = -1;
			while (sx < 1) {
				sx = sx + 1;
				sy = -1;
				while (sy < 1) {
					sy = sy + 1;
					sz = -1;
					while (sz < 1) {
						sz = sz + 1;
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("minecraft:logsandleaves")))) {
							{
								BlockPos _pos = BlockPos.containing(x + sx, y + sy, z + sz);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + sx, y + sy, z + sz), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				}
			}
		}
	}
}