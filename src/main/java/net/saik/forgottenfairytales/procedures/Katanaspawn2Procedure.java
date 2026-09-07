package net.saik.forgottenfairytales.procedures;

import org.checkerframework.checker.units.qual.h;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Katanaspawn2Procedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double l = 0;
		double h = 0;
		if (ForgottenFairyTalesModVariables.MapVariables.get(world).s == true && ForgottenFairyTalesModVariables.MapVariables.get(world).katana == false) {
			if (world.hasChunkAt(BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x, 0, ForgottenFairyTalesModVariables.MapVariables.get(world).y))) {
				l = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).x, (int) ForgottenFairyTalesModVariables.MapVariables.get(world).y) - 9;
				h = l;
				if (world instanceof ServerLevel _serverworld) {
					StructureTemplate template = _serverworld.getStructureManager().getOrCreate(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "katana"));
					if (template != null) {
						template.placeInWorld(_serverworld, BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x, l, ForgottenFairyTalesModVariables.MapVariables.get(world).y),
								BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x, l, ForgottenFairyTalesModVariables.MapVariables.get(world).y),
								new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
					}
				}
				world.destroyBlock(BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19, l, ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11), false);
				for (int index0 = 0; index0 < world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19), (int) (ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11))
						+ 64; index0++) {
					if (!(Blocks.BEDROCK == (world.getBlockState(BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19, h, ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11))).getBlock()
							|| ForgottenFairyTalesModBlocks.BEDROCKWITHKATANA
									.get() == (world.getBlockState(BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19, h, ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11))).getBlock())) {
						world.destroyBlock(BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19, h, ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11), false);
						h = h - 1;
					} else {
						{
							BlockPos _bp = BlockPos.containing(ForgottenFairyTalesModVariables.MapVariables.get(world).x + 19, h, ForgottenFairyTalesModVariables.MapVariables.get(world).y + 11);
							BlockState _bs = ForgottenFairyTalesModBlocks.BEDROCKWITHKATANA.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				}
				ForgottenFairyTalesModVariables.MapVariables.get(world).katana = true;
				ForgottenFairyTalesModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}