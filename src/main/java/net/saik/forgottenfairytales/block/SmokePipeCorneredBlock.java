package net.saik.forgottenfairytales.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SmokePipeCorneredBlock extends Block {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<AttachFace> FACE = FaceAttachedHorizontalDirectionalBlock.FACE;
	private static final VoxelShape SHAPE_1_NORTH_FLOOR = Shapes.or(box(3, 3, 0, 13, 13, 1), box(1, 4, 4, 4, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 1, 12, 12, 4), box(3, 4, 1, 4, 12, 2), box(12, 4, 1, 13, 12, 2), box(3, 12, 1, 13, 13, 2),
			box(3, 3, 1, 13, 4, 2), box(1, 3, 3, 2, 13, 4), box(0, 3, 3, 1, 13, 13), box(1, 3, 12, 2, 13, 13));
	private static final VoxelShape SHAPE_1_NORTH_WALL = Shapes.or(box(3, 3, 0, 13, 13, 1), box(1, 4, 4, 4, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 1, 12, 12, 4), box(3, 4, 1, 4, 12, 2), box(12, 4, 1, 13, 12, 2), box(3, 12, 1, 13, 13, 2),
			box(3, 3, 1, 13, 4, 2), box(1, 3, 3, 2, 13, 4), box(0, 3, 3, 1, 13, 13), box(1, 3, 12, 2, 13, 13));
	private static final VoxelShape SHAPE_1_NORTH_CEILING = Shapes.or(box(3, 3, 0, 13, 13, 1), box(12, 4, 4, 15, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 1, 12, 12, 4), box(12, 4, 1, 13, 12, 2), box(3, 4, 1, 4, 12, 2), box(3, 3, 1, 13, 4, 2),
			box(3, 12, 1, 13, 13, 2), box(14, 3, 3, 15, 13, 4), box(15, 3, 3, 16, 13, 13), box(14, 3, 12, 15, 13, 13));
	private static final VoxelShape SHAPE_1_SOUTH_FLOOR = Shapes.or(box(3, 3, 15, 13, 13, 16), box(12, 4, 4, 15, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 12, 12, 12, 15), box(12, 4, 14, 13, 12, 15), box(3, 4, 14, 4, 12, 15),
			box(3, 12, 14, 13, 13, 15), box(3, 3, 14, 13, 4, 15), box(14, 3, 12, 15, 13, 13), box(15, 3, 3, 16, 13, 13), box(14, 3, 3, 15, 13, 4));
	private static final VoxelShape SHAPE_1_SOUTH_WALL = Shapes.or(box(3, 3, 15, 13, 13, 16), box(12, 4, 4, 15, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 12, 12, 12, 15), box(12, 4, 14, 13, 12, 15), box(3, 4, 14, 4, 12, 15),
			box(3, 12, 14, 13, 13, 15), box(3, 3, 14, 13, 4, 15), box(14, 3, 12, 15, 13, 13), box(15, 3, 3, 16, 13, 13), box(14, 3, 3, 15, 13, 4));
	private static final VoxelShape SHAPE_1_SOUTH_CEILING = Shapes.or(box(3, 3, 15, 13, 13, 16), box(1, 4, 4, 4, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 12, 12, 12, 15), box(3, 4, 14, 4, 12, 15), box(12, 4, 14, 13, 12, 15),
			box(3, 3, 14, 13, 4, 15), box(3, 12, 14, 13, 13, 15), box(1, 3, 12, 2, 13, 13), box(0, 3, 3, 1, 13, 13), box(1, 3, 3, 2, 13, 4));
	private static final VoxelShape SHAPE_1_EAST_FLOOR = Shapes.or(box(15, 3, 3, 16, 13, 13), box(4, 4, 1, 12, 12, 4), box(4, 4, 4, 12, 12, 12), box(12, 4, 4, 15, 12, 12), box(14, 4, 3, 15, 12, 4), box(14, 4, 12, 15, 12, 13),
			box(14, 12, 3, 15, 13, 13), box(14, 3, 3, 15, 4, 13), box(12, 3, 1, 13, 13, 2), box(3, 3, 0, 13, 13, 1), box(3, 3, 1, 4, 13, 2));
	private static final VoxelShape SHAPE_1_EAST_WALL = Shapes.or(box(15, 3, 3, 16, 13, 13), box(4, 4, 1, 12, 12, 4), box(4, 4, 4, 12, 12, 12), box(12, 4, 4, 15, 12, 12), box(14, 4, 3, 15, 12, 4), box(14, 4, 12, 15, 12, 13),
			box(14, 12, 3, 15, 13, 13), box(14, 3, 3, 15, 4, 13), box(12, 3, 1, 13, 13, 2), box(3, 3, 0, 13, 13, 1), box(3, 3, 1, 4, 13, 2));
	private static final VoxelShape SHAPE_1_EAST_CEILING = Shapes.or(box(15, 3, 3, 16, 13, 13), box(4, 4, 12, 12, 12, 15), box(4, 4, 4, 12, 12, 12), box(12, 4, 4, 15, 12, 12), box(14, 4, 12, 15, 12, 13), box(14, 4, 3, 15, 12, 4),
			box(14, 3, 3, 15, 4, 13), box(14, 12, 3, 15, 13, 13), box(12, 3, 14, 13, 13, 15), box(3, 3, 15, 13, 13, 16), box(3, 3, 14, 4, 13, 15));
	private static final VoxelShape SHAPE_1_WEST_FLOOR = Shapes.or(box(0, 3, 3, 1, 13, 13), box(4, 4, 12, 12, 12, 15), box(4, 4, 4, 12, 12, 12), box(1, 4, 4, 4, 12, 12), box(1, 4, 12, 2, 12, 13), box(1, 4, 3, 2, 12, 4), box(1, 12, 3, 2, 13, 13),
			box(1, 3, 3, 2, 4, 13), box(3, 3, 14, 4, 13, 15), box(3, 3, 15, 13, 13, 16), box(12, 3, 14, 13, 13, 15));
	private static final VoxelShape SHAPE_1_WEST_WALL = Shapes.or(box(0, 3, 3, 1, 13, 13), box(4, 4, 12, 12, 12, 15), box(4, 4, 4, 12, 12, 12), box(1, 4, 4, 4, 12, 12), box(1, 4, 12, 2, 12, 13), box(1, 4, 3, 2, 12, 4), box(1, 12, 3, 2, 13, 13),
			box(1, 3, 3, 2, 4, 13), box(3, 3, 14, 4, 13, 15), box(3, 3, 15, 13, 13, 16), box(12, 3, 14, 13, 13, 15));
	private static final VoxelShape SHAPE_1_WEST_CEILING = Shapes.or(box(0, 3, 3, 1, 13, 13), box(4, 4, 1, 12, 12, 4), box(4, 4, 4, 12, 12, 12), box(1, 4, 4, 4, 12, 12), box(1, 4, 3, 2, 12, 4), box(1, 4, 12, 2, 12, 13), box(1, 3, 3, 2, 4, 13),
			box(1, 12, 3, 2, 13, 13), box(3, 3, 1, 4, 13, 2), box(3, 3, 0, 13, 13, 1), box(12, 3, 1, 13, 13, 2));
	private static final VoxelShape SHAPE_NORTH_FLOOR = Shapes.or(box(3, 3, 0, 13, 13, 1), box(4, 1, 4, 12, 4, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 1, 12, 12, 4), box(3, 4, 1, 4, 12, 2), box(12, 4, 1, 13, 12, 2), box(3, 12, 1, 13, 13, 2),
			box(3, 3, 1, 13, 4, 2), box(3, 1, 3, 13, 2, 4), box(3, 0, 3, 13, 1, 13), box(3, 1, 12, 13, 2, 13));
	private static final VoxelShape SHAPE_NORTH_WALL = Shapes.or(box(3, 0, 3, 13, 1, 13), box(4, 4, 12, 12, 12, 15), box(4, 4, 4, 12, 12, 12), box(4, 1, 4, 12, 4, 12), box(3, 1, 4, 4, 2, 12), box(12, 1, 4, 13, 2, 12), box(3, 1, 3, 13, 2, 4),
			box(3, 1, 12, 13, 2, 13), box(3, 3, 14, 13, 4, 15), box(3, 3, 15, 13, 13, 16), box(3, 12, 14, 13, 13, 15));
	private static final VoxelShape SHAPE_NORTH_CEILING = Shapes.or(box(3, 3, 0, 13, 13, 1), box(4, 12, 4, 12, 15, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 1, 12, 12, 4), box(12, 4, 1, 13, 12, 2), box(3, 4, 1, 4, 12, 2), box(3, 3, 1, 13, 4, 2),
			box(3, 12, 1, 13, 13, 2), box(3, 14, 3, 13, 15, 4), box(3, 15, 3, 13, 16, 13), box(3, 14, 12, 13, 15, 13));
	private static final VoxelShape SHAPE_SOUTH_FLOOR = Shapes.or(box(3, 3, 15, 13, 13, 16), box(4, 1, 4, 12, 4, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 12, 12, 12, 15), box(12, 4, 14, 13, 12, 15), box(3, 4, 14, 4, 12, 15),
			box(3, 12, 14, 13, 13, 15), box(3, 3, 14, 13, 4, 15), box(3, 1, 12, 13, 2, 13), box(3, 0, 3, 13, 1, 13), box(3, 1, 3, 13, 2, 4));
	private static final VoxelShape SHAPE_SOUTH_WALL = Shapes.or(box(3, 0, 3, 13, 1, 13), box(4, 4, 1, 12, 12, 4), box(4, 4, 4, 12, 12, 12), box(4, 1, 4, 12, 4, 12), box(12, 1, 4, 13, 2, 12), box(3, 1, 4, 4, 2, 12), box(3, 1, 12, 13, 2, 13),
			box(3, 1, 3, 13, 2, 4), box(3, 3, 1, 13, 4, 2), box(3, 3, 0, 13, 13, 1), box(3, 12, 1, 13, 13, 2));
	private static final VoxelShape SHAPE_SOUTH_CEILING = Shapes.or(box(3, 3, 15, 13, 13, 16), box(4, 12, 4, 12, 15, 12), box(4, 4, 4, 12, 12, 12), box(4, 4, 12, 12, 12, 15), box(3, 4, 14, 4, 12, 15), box(12, 4, 14, 13, 12, 15),
			box(3, 3, 14, 13, 4, 15), box(3, 12, 14, 13, 13, 15), box(3, 14, 12, 13, 15, 13), box(3, 15, 3, 13, 16, 13), box(3, 14, 3, 13, 15, 4));
	private static final VoxelShape SHAPE_EAST_FLOOR = Shapes.or(box(15, 3, 3, 16, 13, 13), box(4, 1, 4, 12, 4, 12), box(4, 4, 4, 12, 12, 12), box(12, 4, 4, 15, 12, 12), box(14, 4, 3, 15, 12, 4), box(14, 4, 12, 15, 12, 13),
			box(14, 12, 3, 15, 13, 13), box(14, 3, 3, 15, 4, 13), box(12, 1, 3, 13, 2, 13), box(3, 0, 3, 13, 1, 13), box(3, 1, 3, 4, 2, 13));
	private static final VoxelShape SHAPE_EAST_WALL = Shapes.or(box(3, 0, 3, 13, 1, 13), box(1, 4, 4, 4, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 1, 4, 12, 4, 12), box(4, 1, 3, 12, 2, 4), box(4, 1, 12, 12, 2, 13), box(12, 1, 3, 13, 2, 13),
			box(3, 1, 3, 4, 2, 13), box(1, 3, 3, 2, 4, 13), box(0, 3, 3, 1, 13, 13), box(1, 12, 3, 2, 13, 13));
	private static final VoxelShape SHAPE_EAST_CEILING = Shapes.or(box(15, 3, 3, 16, 13, 13), box(4, 12, 4, 12, 15, 12), box(4, 4, 4, 12, 12, 12), box(12, 4, 4, 15, 12, 12), box(14, 4, 12, 15, 12, 13), box(14, 4, 3, 15, 12, 4),
			box(14, 3, 3, 15, 4, 13), box(14, 12, 3, 15, 13, 13), box(12, 14, 3, 13, 15, 13), box(3, 15, 3, 13, 16, 13), box(3, 14, 3, 4, 15, 13));
	private static final VoxelShape SHAPE_WEST_FLOOR = Shapes.or(box(0, 3, 3, 1, 13, 13), box(4, 1, 4, 12, 4, 12), box(4, 4, 4, 12, 12, 12), box(1, 4, 4, 4, 12, 12), box(1, 4, 12, 2, 12, 13), box(1, 4, 3, 2, 12, 4), box(1, 12, 3, 2, 13, 13),
			box(1, 3, 3, 2, 4, 13), box(3, 1, 3, 4, 2, 13), box(3, 0, 3, 13, 1, 13), box(12, 1, 3, 13, 2, 13));
	private static final VoxelShape SHAPE_WEST_WALL = Shapes.or(box(3, 0, 3, 13, 1, 13), box(12, 4, 4, 15, 12, 12), box(4, 4, 4, 12, 12, 12), box(4, 1, 4, 12, 4, 12), box(4, 1, 12, 12, 2, 13), box(4, 1, 3, 12, 2, 4), box(3, 1, 3, 4, 2, 13),
			box(12, 1, 3, 13, 2, 13), box(14, 3, 3, 15, 4, 13), box(15, 3, 3, 16, 13, 13), box(14, 12, 3, 15, 13, 13));
	private static final VoxelShape SHAPE_WEST_CEILING = Shapes.or(box(0, 3, 3, 1, 13, 13), box(4, 12, 4, 12, 15, 12), box(4, 4, 4, 12, 12, 12), box(1, 4, 4, 4, 12, 12), box(1, 4, 3, 2, 12, 4), box(1, 4, 12, 2, 12, 13), box(1, 3, 3, 2, 4, 13),
			box(1, 12, 3, 2, 13, 13), box(3, 14, 3, 4, 15, 13), box(3, 15, 3, 13, 16, 13), box(12, 14, 3, 13, 15, 13));

	public SmokePipeCorneredBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				return 0;
			}
		}.getLightLevel())).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(FACE, AttachFace.WALL));
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
				case NORTH -> switch (state.getValue(FACE)) {
					case FLOOR -> SHAPE_1_NORTH_FLOOR;
					case WALL -> SHAPE_1_NORTH_WALL;
					case CEILING -> SHAPE_1_NORTH_CEILING;
				};
				case SOUTH -> switch (state.getValue(FACE)) {
					case FLOOR -> SHAPE_1_SOUTH_FLOOR;
					case WALL -> SHAPE_1_SOUTH_WALL;
					case CEILING -> SHAPE_1_SOUTH_CEILING;
				};
				case EAST -> switch (state.getValue(FACE)) {
					case FLOOR -> SHAPE_1_EAST_FLOOR;
					case WALL -> SHAPE_1_EAST_WALL;
					case CEILING -> SHAPE_1_EAST_CEILING;
				};
				case WEST -> switch (state.getValue(FACE)) {
					case FLOOR -> SHAPE_1_WEST_FLOOR;
					case WALL -> SHAPE_1_WEST_WALL;
					case CEILING -> SHAPE_1_WEST_CEILING;
				};
				default -> switch (state.getValue(FACE)) {
					case FLOOR -> SHAPE_1_NORTH_FLOOR;
					case WALL -> SHAPE_1_NORTH_WALL;
					case CEILING -> SHAPE_1_NORTH_CEILING;
				};
			});
		}
		return (switch (state.getValue(FACING)) {
			case NORTH -> switch (state.getValue(FACE)) {
				case FLOOR -> SHAPE_NORTH_FLOOR;
				case WALL -> SHAPE_NORTH_WALL;
				case CEILING -> SHAPE_NORTH_CEILING;
			};
			case SOUTH -> switch (state.getValue(FACE)) {
				case FLOOR -> SHAPE_SOUTH_FLOOR;
				case WALL -> SHAPE_SOUTH_WALL;
				case CEILING -> SHAPE_SOUTH_CEILING;
			};
			case EAST -> switch (state.getValue(FACE)) {
				case FLOOR -> SHAPE_EAST_FLOOR;
				case WALL -> SHAPE_EAST_WALL;
				case CEILING -> SHAPE_EAST_CEILING;
			};
			case WEST -> switch (state.getValue(FACE)) {
				case FLOOR -> SHAPE_WEST_FLOOR;
				case WALL -> SHAPE_WEST_WALL;
				case CEILING -> SHAPE_WEST_CEILING;
			};
			default -> switch (state.getValue(FACE)) {
				case FLOOR -> SHAPE_NORTH_FLOOR;
				case WALL -> SHAPE_NORTH_WALL;
				case CEILING -> SHAPE_NORTH_CEILING;
			};
		});
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, FACE, BLOCKSTATE);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
	
	    if (context.getClickedFace().getAxis() == Direction.Axis.Y) {
	
	        return super.getStateForPlacement(context)
	            .setValue(
	                FACE,
	                context.getClickedFace().getOpposite() == Direction.UP
	                    ? AttachFace.CEILING
	                    : AttachFace.FLOOR
	            )
	            .setValue(FACING, context.getHorizontalDirection())
	            .setValue(BLOCKSTATE, 0);
	
	    }
	
	    return super.getStateForPlacement(context)
	        .setValue(FACE, AttachFace.WALL)
	        .setValue(FACING, context.getClickedFace().getOpposite())
	        .setValue(BLOCKSTATE, 1);
	}
	
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}