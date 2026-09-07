package net.saik.forgottenfairytales.block;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class WarriordrinkblockBlock extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
	private static final VoxelShape SHAPE_X = Shapes.or(box(0, 5, 5, 2, 11, 11), box(4, 5, 5, 13, 11, 11), box(3, 5, 5, 13, 11, 11), box(2, 6, 6, 3, 10, 10), box(6.4, 7.4, 7.4, 8.6, 9.6, 9.6), box(9.3, 7.3, 7.3, 11.7, 9.7, 9.7),
			box(5.43, 7.43, 7.43, 7.57, 9.57, 9.57));
	private static final VoxelShape SHAPE_Y = Shapes.or(box(5, 0, 5, 11, 2, 11), box(5, 4, 5, 11, 13, 11), box(5, 3, 5, 11, 13, 11), box(6, 2, 6, 10, 3, 10), box(7.4, 6.4, 7.4, 9.6, 8.6, 9.6), box(7.3, 9.3, 7.3, 9.7, 11.7, 9.7),
			box(7.43, 5.43, 7.43, 9.57, 7.57, 9.57));
	private static final VoxelShape SHAPE_Z = Shapes.or(box(5, 5, 14, 11, 11, 16), box(5, 5, 3, 11, 11, 12), box(5, 5, 3, 11, 11, 13), box(6, 6, 13, 10, 10, 14), box(7.4, 7.4, 7.4, 9.6, 9.6, 9.6), box(7.3, 7.3, 4.3, 9.7, 9.7, 6.7),
			box(7.43, 7.43, 8.43, 9.57, 9.57, 10.57));

	public WarriordrinkblockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GLASS).strength(0f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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

	@Override
	public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData, Player entity) {
		return new ItemStack(ForgottenFairyTalesModItems.WARRIORDRINK.get());
	}
}