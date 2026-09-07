package net.saik.forgottenfairytales.block;

import org.checkerframework.checker.units.qual.s;

import net.saik.forgottenfairytales.procedures.ConstructorSworkbenchPriShchielchkiePKMPoBlokuProcedure;
import net.saik.forgottenfairytales.procedures.ConstructorSworkbenchPriRazrushieniiBlokaIghrokomProcedure;
import net.saik.forgottenfairytales.procedures.ConstructorSworkbenchPriObnovlieniiTikaProcedure;
import net.saik.forgottenfairytales.procedures.ConstructorSworkbenchPriDobavlieniiBlokaProcedure;
import net.saik.forgottenfairytales.block.entity.ConstructorSworkbenchBlockEntity;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ConstructorSworkbenchBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_1_NORTH = Shapes.or(box(0.6, 17.1, 11.9, 11.6, 17.7, 15.1), box(11.6, 17.1, 11.9, 11.9, 18.4, 15.1), box(0.3, 17.1, 11.9, 0.6, 18.4, 15.1), box(0.6, 17.5, 11.6, 11.6, 18.5, 12),
			box(10.2, 14, 3, 11.3, 15.1, 7), box(10.5, 14.3, 7, 11, 14.8, 10), box(10.65, 14.4, 10, 10.85, 14.7, 10.5), box(0, 0, 0, 32, 14, 16), box(0, 14, 13, 32, 32, 16), box(0, 30, 0, 32, 32, 2), box(0, 30, 2, 2, 32, 13),
			box(30, 30, 2, 32, 32, 13), box(-2, 13, 2, 3, 18, 7), box(0, 14, 8, 5, 16, 13));
	private static final VoxelShape SHAPE_1_SOUTH = Shapes.or(box(4.4, 17.1, 0.9, 15.4, 17.7, 4.1), box(4.1, 17.1, 0.9, 4.4, 18.4, 4.1), box(15.4, 17.1, 0.9, 15.7, 18.4, 4.1), box(4.4, 17.5, 4, 15.4, 18.5, 4.4), box(4.7, 14, 9, 5.8, 15.1, 13),
			box(5, 14.3, 6, 5.5, 14.8, 9), box(5.15, 14.4, 5.5, 5.35, 14.7, 6), box(-16, 0, 0, 16, 14, 16), box(-16, 14, 0, 16, 32, 3), box(-16, 30, 14, 16, 32, 16), box(14, 30, 3, 16, 32, 14), box(-16, 30, 3, -14, 32, 14),
			box(13, 13, 9, 18, 18, 14), box(11, 14, 3, 16, 16, 8));
	private static final VoxelShape SHAPE_1_EAST = Shapes.or(box(0.9, 17.1, 0.6, 4.1, 17.7, 11.6), box(0.9, 17.1, 11.6, 4.1, 18.4, 11.9), box(0.9, 17.1, 0.3, 4.1, 18.4, 0.6), box(4, 17.5, 0.6, 4.4, 18.5, 11.6), box(9, 14, 10.2, 13, 15.1, 11.3),
			box(6, 14.3, 10.5, 9, 14.8, 11), box(5.5, 14.4, 10.65, 6, 14.7, 10.85), box(0, 0, 0, 16, 14, 32), box(0, 14, 0, 3, 32, 32), box(14, 30, 0, 16, 32, 32), box(3, 30, 0, 14, 32, 2), box(3, 30, 30, 14, 32, 32), box(9, 13, -2, 14, 18, 3),
			box(3, 14, 0, 8, 16, 5));
	private static final VoxelShape SHAPE_1_WEST = Shapes.or(box(11.9, 17.1, 4.4, 15.1, 17.7, 15.4), box(11.9, 17.1, 4.1, 15.1, 18.4, 4.4), box(11.9, 17.1, 15.4, 15.1, 18.4, 15.7), box(11.6, 17.5, 4.4, 12, 18.5, 15.4), box(3, 14, 4.7, 7, 15.1, 5.8),
			box(7, 14.3, 5, 10, 14.8, 5.5), box(10, 14.4, 5.15, 10.5, 14.7, 5.35), box(0, 0, -16, 16, 14, 16), box(13, 14, -16, 16, 32, 16), box(0, 30, -16, 2, 32, 16), box(2, 30, 14, 13, 32, 16), box(2, 30, -16, 13, 32, -14),
			box(2, 13, 13, 7, 18, 18), box(8, 14, 11, 13, 16, 16));
	private static final VoxelShape SHAPE_2_NORTH = Shapes.or(box(-15.4, 17.1, 11.9, -4.4, 17.7, 15.1), box(-4.4, 17.1, 11.9, -4.1, 18.4, 15.1), box(-15.7, 17.1, 11.9, -15.4, 18.4, 15.1), box(-15.4, 17.5, 11.6, -4.4, 18.5, 12),
			box(-5.8, 14, 3, -4.7, 15.1, 7), box(-5.5, 14.3, 7, -5, 14.8, 10), box(-5.35, 14.4, 10, -5.15, 14.7, 10.5), box(-16, 0, 0, 16, 14, 16), box(-16, 14, 13, 16, 32, 16), box(-16, 30, 0, 16, 32, 2), box(-16, 30, 2, -14, 32, 13),
			box(14, 30, 2, 16, 32, 13), box(-16, 13, 2, -13, 18, 7), box(-16, 14, 8, -11, 16, 13));
	private static final VoxelShape SHAPE_2_SOUTH = Shapes.or(box(20.4, 17.1, 0.9, 31.4, 17.7, 4.1), box(20.1, 17.1, 0.9, 20.4, 18.4, 4.1), box(31.4, 17.1, 0.9, 31.7, 18.4, 4.1), box(20.4, 17.5, 4, 31.4, 18.5, 4.4), box(20.7, 14, 9, 21.8, 15.1, 13),
			box(21, 14.3, 6, 21.5, 14.8, 9), box(21.15, 14.4, 5.5, 21.35, 14.7, 6), box(0, 0, 0, 32, 14, 16), box(0, 14, 0, 32, 32, 3), box(0, 30, 14, 32, 32, 16), box(30, 30, 3, 32, 32, 14), box(0, 30, 3, 2, 32, 14), box(29, 13, 9, 32, 18, 14),
			box(27, 14, 3, 32, 16, 8));
	private static final VoxelShape SHAPE_2_EAST = Shapes.or(box(0.9, 17.1, -15.4, 4.1, 17.7, -4.4), box(0.9, 17.1, -4.4, 4.1, 18.4, -4.1), box(0.9, 17.1, -15.7, 4.1, 18.4, -15.4), box(4, 17.5, -15.4, 4.4, 18.5, -4.4),
			box(9, 14, -5.8, 13, 15.1, -4.7), box(6, 14.3, -5.5, 9, 14.8, -5), box(5.5, 14.4, -5.35, 6, 14.7, -5.15), box(0, 0, -16, 16, 14, 16), box(0, 14, -16, 3, 32, 16), box(14, 30, -16, 16, 32, 16), box(3, 30, -16, 14, 32, -14),
			box(3, 30, 14, 14, 32, 16), box(9, 13, -16, 14, 18, -13), box(3, 14, -16, 8, 16, -11));
	private static final VoxelShape SHAPE_2_WEST = Shapes.or(box(11.9, 17.1, 20.4, 15.1, 17.7, 31.4), box(11.9, 17.1, 20.1, 15.1, 18.4, 20.4), box(11.9, 17.1, 31.4, 15.1, 18.4, 31.7), box(11.6, 17.5, 20.4, 12, 18.5, 31.4),
			box(3, 14, 20.7, 7, 15.1, 21.8), box(7, 14.3, 21, 10, 14.8, 21.5), box(10, 14.4, 21.15, 10.5, 14.7, 21.35), box(0, 0, 0, 16, 14, 32), box(13, 14, 0, 16, 32, 32), box(0, 30, 0, 2, 32, 32), box(2, 30, 30, 13, 32, 32),
			box(2, 30, 0, 13, 32, 2), box(2, 13, 29, 7, 18, 32), box(8, 14, 27, 13, 16, 32));
	private static final VoxelShape SHAPE_3_NORTH = Shapes.or(box(-15.4, 1.1, 11.9, -4.4, 1.7, 15.1), box(-4.4, 1.1, 11.9, -4.1, 2.4, 15.1), box(-15.7, 1.1, 11.9, -15.4, 2.4, 15.1), box(-15.4, 1.5, 11.6, -4.4, 2.5, 12),
			box(-5.8, -2, 3, -4.7, -0.9, 7), box(-5.5, -1.7, 7, -5, -1.2, 10), box(-5.35, -1.6, 10, -5.15, -1.3, 10.5), box(-16, -16, 0, 16, -2, 16), box(-16, -2, 13, 16, 16, 16), box(-16, 14, 0, 16, 16, 2), box(-16, 14, 2, -14, 16, 13),
			box(14, 14, 2, 16, 16, 13), box(-16, -3, 2, -13, 2, 7), box(-16, -2, 8, -11, 0, 13));
	private static final VoxelShape SHAPE_3_SOUTH = Shapes.or(box(20.4, 1.1, 0.9, 31.4, 1.7, 4.1), box(20.1, 1.1, 0.9, 20.4, 2.4, 4.1), box(31.4, 1.1, 0.9, 31.7, 2.4, 4.1), box(20.4, 1.5, 4, 31.4, 2.5, 4.4), box(20.7, -2, 9, 21.8, -0.9, 13),
			box(21, -1.7, 6, 21.5, -1.2, 9), box(21.15, -1.6, 5.5, 21.35, -1.3, 6), box(0, -16, 0, 32, -2, 16), box(0, -2, 0, 32, 16, 3), box(0, 14, 14, 32, 16, 16), box(30, 14, 3, 32, 16, 14), box(0, 14, 3, 2, 16, 14), box(29, -3, 9, 32, 2, 14),
			box(27, -2, 3, 32, 0, 8));
	private static final VoxelShape SHAPE_3_EAST = Shapes.or(box(0.9, 1.1, -15.4, 4.1, 1.7, -4.4), box(0.9, 1.1, -4.4, 4.1, 2.4, -4.1), box(0.9, 1.1, -15.7, 4.1, 2.4, -15.4), box(4, 1.5, -15.4, 4.4, 2.5, -4.4), box(9, -2, -5.8, 13, -0.9, -4.7),
			box(6, -1.7, -5.5, 9, -1.2, -5), box(5.5, -1.6, -5.35, 6, -1.3, -5.15), box(0, -16, -16, 16, -2, 16), box(0, -2, -16, 3, 16, 16), box(14, 14, -16, 16, 16, 16), box(3, 14, -16, 14, 16, -14), box(3, 14, 14, 14, 16, 16),
			box(9, -3, -16, 14, 2, -13), box(3, -2, -16, 8, 0, -11));
	private static final VoxelShape SHAPE_3_WEST = Shapes.or(box(11.9, 1.1, 20.4, 15.1, 1.7, 31.4), box(11.9, 1.1, 20.1, 15.1, 2.4, 20.4), box(11.9, 1.1, 31.4, 15.1, 2.4, 31.7), box(11.6, 1.5, 20.4, 12, 2.5, 31.4), box(3, -2, 20.7, 7, -0.9, 21.8),
			box(7, -1.7, 21, 10, -1.2, 21.5), box(10, -1.6, 21.15, 10.5, -1.3, 21.35), box(0, -16, 0, 16, -2, 32), box(13, -2, 0, 16, 16, 32), box(0, 14, 0, 2, 16, 32), box(2, 14, 30, 13, 16, 32), box(2, 14, 0, 13, 16, 2), box(2, -3, 29, 7, 2, 32),
			box(8, -2, 27, 13, 0, 32));
	private static final VoxelShape SHAPE_4_NORTH = Shapes.or(box(0.6, 1.1, 11.9, 11.6, 1.7, 15.1), box(11.6, 1.1, 11.9, 11.9, 2.4, 15.1), box(0.3, 1.1, 11.9, 0.6, 2.4, 15.1), box(0.6, 1.5, 11.6, 11.6, 2.5, 12), box(10.2, -2, 3, 11.3, -0.9, 7),
			box(10.5, -1.7, 7, 11, -1.2, 10), box(10.65, -1.6, 10, 10.85, -1.3, 10.5), box(0, -16, 0, 32, -2, 16), box(0, -2, 13, 32, 16, 16), box(0, 14, 0, 32, 16, 2), box(0, 14, 2, 2, 16, 13), box(30, 14, 2, 32, 16, 13), box(-2, -3, 2, 3, 2, 7),
			box(0, -2, 8, 5, 0, 13));
	private static final VoxelShape SHAPE_4_SOUTH = Shapes.or(box(4.4, 1.1, 0.9, 15.4, 1.7, 4.1), box(4.1, 1.1, 0.9, 4.4, 2.4, 4.1), box(15.4, 1.1, 0.9, 15.7, 2.4, 4.1), box(4.4, 1.5, 4, 15.4, 2.5, 4.4), box(4.7, -2, 9, 5.8, -0.9, 13),
			box(5, -1.7, 6, 5.5, -1.2, 9), box(5.15, -1.6, 5.5, 5.35, -1.3, 6), box(-16, -16, 0, 16, -2, 16), box(-16, -2, 0, 16, 16, 3), box(-16, 14, 14, 16, 16, 16), box(14, 14, 3, 16, 16, 14), box(-16, 14, 3, -14, 16, 14),
			box(13, -3, 9, 18, 2, 14), box(11, -2, 3, 16, 0, 8));
	private static final VoxelShape SHAPE_4_EAST = Shapes.or(box(0.9, 1.1, 0.6, 4.1, 1.7, 11.6), box(0.9, 1.1, 11.6, 4.1, 2.4, 11.9), box(0.9, 1.1, 0.3, 4.1, 2.4, 0.6), box(4, 1.5, 0.6, 4.4, 2.5, 11.6), box(9, -2, 10.2, 13, -0.9, 11.3),
			box(6, -1.7, 10.5, 9, -1.2, 11), box(5.5, -1.6, 10.65, 6, -1.3, 10.85), box(0, -16, 0, 16, -2, 32), box(0, -2, 0, 3, 16, 32), box(14, 14, 0, 16, 16, 32), box(3, 14, 0, 14, 16, 2), box(3, 14, 30, 14, 16, 32), box(9, -3, -2, 14, 2, 3),
			box(3, -2, 0, 8, 0, 5));
	private static final VoxelShape SHAPE_4_WEST = Shapes.or(box(11.9, 1.1, 4.4, 15.1, 1.7, 15.4), box(11.9, 1.1, 4.1, 15.1, 2.4, 4.4), box(11.9, 1.1, 15.4, 15.1, 2.4, 15.7), box(11.6, 1.5, 4.4, 12, 2.5, 15.4), box(3, -2, 4.7, 7, -0.9, 5.8),
			box(7, -1.7, 5, 10, -1.2, 5.5), box(10, -1.6, 5.15, 10.5, -1.3, 5.35), box(0, -16, -16, 16, -2, 16), box(13, -2, -16, 16, 16, 16), box(0, 14, -16, 2, 16, 16), box(2, 14, 14, 13, 16, 16), box(2, 14, -16, 13, 16, -14),
			box(2, -3, 13, 7, 2, 18), box(8, -2, 11, 13, 0, 16));
	private static final VoxelShape SHAPE_NORTH = Shapes.or(box(0.6, 17.1, 11.9, 11.6, 17.7, 15.1), box(11.6, 17.1, 11.9, 11.9, 18.4, 15.1), box(0.3, 17.1, 11.9, 0.6, 18.4, 15.1), box(0.6, 17.5, 11.6, 11.6, 18.5, 12), box(10.2, 14, 3, 11.3, 15.1, 7),
			box(10.5, 14.3, 7, 11, 14.8, 10), box(10.65, 14.4, 10, 10.85, 14.7, 10.5), box(0, 0, 0, 32, 14, 16), box(0, 14, 13, 32, 32, 16), box(0, 30, 0, 32, 32, 2), box(0, 30, 2, 2, 32, 13), box(30, 30, 2, 32, 32, 13), box(-2, 13, 2, 3, 18, 7),
			box(0, 14, 8, 5, 16, 13));
	private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(4.4, 17.1, 0.9, 15.4, 17.7, 4.1), box(4.1, 17.1, 0.9, 4.4, 18.4, 4.1), box(15.4, 17.1, 0.9, 15.7, 18.4, 4.1), box(4.4, 17.5, 4, 15.4, 18.5, 4.4), box(4.7, 14, 9, 5.8, 15.1, 13),
			box(5, 14.3, 6, 5.5, 14.8, 9), box(5.15, 14.4, 5.5, 5.35, 14.7, 6), box(-16, 0, 0, 16, 14, 16), box(-16, 14, 0, 16, 32, 3), box(-16, 30, 14, 16, 32, 16), box(14, 30, 3, 16, 32, 14), box(-16, 30, 3, -14, 32, 14),
			box(13, 13, 9, 18, 18, 14), box(11, 14, 3, 16, 16, 8));
	private static final VoxelShape SHAPE_EAST = Shapes.or(box(0.9, 17.1, 0.6, 4.1, 17.7, 11.6), box(0.9, 17.1, 11.6, 4.1, 18.4, 11.9), box(0.9, 17.1, 0.3, 4.1, 18.4, 0.6), box(4, 17.5, 0.6, 4.4, 18.5, 11.6), box(9, 14, 10.2, 13, 15.1, 11.3),
			box(6, 14.3, 10.5, 9, 14.8, 11), box(5.5, 14.4, 10.65, 6, 14.7, 10.85), box(0, 0, 0, 16, 14, 32), box(0, 14, 0, 3, 32, 32), box(14, 30, 0, 16, 32, 32), box(3, 30, 0, 14, 32, 2), box(3, 30, 30, 14, 32, 32), box(9, 13, -2, 14, 18, 3),
			box(3, 14, 0, 8, 16, 5));
	private static final VoxelShape SHAPE_WEST = Shapes.or(box(11.9, 17.1, 4.4, 15.1, 17.7, 15.4), box(11.9, 17.1, 4.1, 15.1, 18.4, 4.4), box(11.9, 17.1, 15.4, 15.1, 18.4, 15.7), box(11.6, 17.5, 4.4, 12, 18.5, 15.4), box(3, 14, 4.7, 7, 15.1, 5.8),
			box(7, 14.3, 5, 10, 14.8, 5.5), box(10, 14.4, 5.15, 10.5, 14.7, 5.35), box(0, 0, -16, 16, 14, 16), box(13, 14, -16, 16, 32, 16), box(0, 30, -16, 2, 32, 16), box(2, 30, 14, 13, 32, 16), box(2, 30, -16, 13, 32, -14),
			box(2, 13, 13, 7, 18, 18), box(8, 14, 11, 13, 16, 16));

	public ConstructorSworkbenchBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.BLOCK).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BLOCKSTATE) == 1) {
			return (switch (state.getValue(FACING)) {
				case NORTH -> SHAPE_1_NORTH;
				case SOUTH -> SHAPE_1_SOUTH;
				case EAST -> SHAPE_1_EAST;
				case WEST -> SHAPE_1_WEST;
				default -> SHAPE_1_NORTH;
			});
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return (switch (state.getValue(FACING)) {
				case NORTH -> SHAPE_2_NORTH;
				case SOUTH -> SHAPE_2_SOUTH;
				case EAST -> SHAPE_2_EAST;
				case WEST -> SHAPE_2_WEST;
				default -> SHAPE_2_NORTH;
			});
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return (switch (state.getValue(FACING)) {
				case NORTH -> SHAPE_3_NORTH;
				case SOUTH -> SHAPE_3_SOUTH;
				case EAST -> SHAPE_3_EAST;
				case WEST -> SHAPE_3_WEST;
				default -> SHAPE_3_NORTH;
			});
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return (switch (state.getValue(FACING)) {
				case NORTH -> SHAPE_4_NORTH;
				case SOUTH -> SHAPE_4_SOUTH;
				case EAST -> SHAPE_4_EAST;
				case WEST -> SHAPE_4_WEST;
				default -> SHAPE_4_NORTH;
			});
		}
		return (switch (state.getValue(FACING)) {
			case NORTH -> SHAPE_NORTH;
			case SOUTH -> SHAPE_SOUTH;
			case EAST -> SHAPE_EAST;
			case WEST -> SHAPE_WEST;
			default -> SHAPE_NORTH;
		});
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 2);
		ConstructorSworkbenchPriDobavlieniiBlokaProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		ConstructorSworkbenchPriObnovlieniiTikaProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 2);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		ConstructorSworkbenchPriRazrushieniiBlokaIghrokomProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		ConstructorSworkbenchPriShchielchkiePKMPoBlokuProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ConstructorSworkbenchBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	protected void affectNeighborsAfterRemoval(BlockState blockstate, ServerLevel world, BlockPos blockpos, boolean flag) {
		Containers.updateNeighboursAfterDestroy(blockstate, world, blockpos);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof ConstructorSworkbenchBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}