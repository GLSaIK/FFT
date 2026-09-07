package net.saik.forgottenfairytales.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SmokePipeBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	private static final VoxelShape SHAPE_X = Shapes.or(box(15, 3, 3, 16, 13, 13), box(1, 4, 4, 15, 12, 12), box(14, 12, 3, 15, 13, 13), box(14, 3, 3, 15, 4, 13), box(1, 3, 3, 2, 4, 13), box(0, 3, 3, 1, 13, 13), box(1, 12, 3, 2, 13, 13));
	private static final VoxelShape SHAPE_Y = Shapes.or(box(3, 15, 3, 13, 16, 13), box(4, 1, 4, 12, 15, 12), box(3, 14, 12, 13, 15, 13), box(3, 14, 3, 13, 15, 4), box(3, 1, 3, 13, 2, 4), box(3, 0, 3, 13, 1, 13), box(3, 1, 12, 13, 2, 13));
	private static final VoxelShape SHAPE_Z = Shapes.or(box(3, 3, 0, 13, 13, 1), box(4, 4, 1, 12, 12, 15), box(3, 12, 1, 13, 13, 2), box(3, 3, 1, 13, 4, 2), box(3, 3, 14, 13, 4, 15), box(3, 3, 15, 13, 13, 16), box(3, 12, 14, 13, 13, 15));

	public SmokePipeBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(1f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
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
		return (switch (state.getValue(AXIS)) {
			case X -> SHAPE_X;
			case Y -> SHAPE_Y;
			case Z -> SHAPE_Z;
			default -> SHAPE_Y;
		});
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(AXIS);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(AXIS, context.getClickedFace().getAxis());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return RotatedPillarBlock.rotatePillar(state, rot);
	}
}