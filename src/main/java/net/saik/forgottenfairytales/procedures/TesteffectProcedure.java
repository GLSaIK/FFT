package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TesteffectProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ForgottenFairyTalesModMobEffects.VOINBAFF)) {
			if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OBSIDIAN)
					&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.CRYING_OBSIDIAN) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERITE_BLOCK)
					&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.ANCIENT_DEBRIS) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REINFORCED_DEEPSLATE)) {
				if (!((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DIAMOND_BLOCK || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.IRON_BLOCK
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.COBBLED_DEEPSLATE || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.INFESTED_DEEPSLATE
						|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DEEPSLATE)) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				} else {
					ForgottenFairyTalesMod.queueServerWork(2, () -> {
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
							world.destroyBlock(_pos, false);
						}
					});
				}
			}
		}
	}
}