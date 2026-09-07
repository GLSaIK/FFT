package net.saik.forgottenfairytales.block;

import org.checkerframework.checker.units.qual.s;

import net.saik.forgottenfairytales.procedures.MagetablePriShchielchkiePKMPoBlokuProcedure;
import net.saik.forgottenfairytales.procedures.MagetablePriRazrushieniiBlokaIghrokomProcedure;
import net.saik.forgottenfairytales.procedures.MagetablePriObnovlieniiTikaProcedure;
import net.saik.forgottenfairytales.procedures.MagetablePriDobavlieniiBlokaProcedure;
import net.saik.forgottenfairytales.block.entity.MagetableBlockEntity;

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

public class MagetableBlock extends Block implements EntityBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_1_NORTH = Shapes.or(box(20, 16, 3, 28, 17, 12), box(21, 15, 4, 27, 16, 11), box(20, 14, 3, 28, 15, 12), box(13, 0, -14, 15, 13, -12), box(1, 0, -14, 3, 13, -12), box(1, 0, 0, 3, 13, 2),
			box(13, 0, 0, 15, 13, 2), box(29, 0, 13, 31, 13, 15), box(29, 0, 0, 31, 13, 2), box(1, 0, 13, 3, 13, 15), box(3, 7, 13, 29, 9, 15), box(15, 7, 0, 29, 9, 2), box(3, 7, -13, 13, 9, -11), box(13, 7, -12, 15, 9, 0), box(1, 7, -12, 3, 9, 0),
			box(1, 7, 2, 3, 9, 13), box(29, 7, 2, 31, 9, 13), box(23, 15, 13.6, 24, 20, 14.6), box(22, 14, 12.7, 25, 15, 15.7), box(23, 20, 12.1, 24, 22, 13.1), box(2, 16, -11, 5, 17, -8), box(2, 14, -11, 5, 15, -8),
			box(2.3, 15, -10.7, 4.7, 16, -8.3), box(0, 14, 15, 16, 27, 16), box(0, 14, 0, 1, 27, 15), box(0, 13, -16, 16, 14, 0), box(0, 13, 0, 32, 14, 16), box(1, 16, 0.6, 2, 25, 1.6), box(1, 16, 13.6, 2, 25, 14.6),
			box(11, 16.2, 14.9, 15, 27.2, 15.9), box(24.9, 5.1, -0.1, 28.9, 9.1, 2.1));
	private static final VoxelShape SHAPE_1_SOUTH = Shapes.or(box(-12, 16, 4, -4, 17, 13), box(-11, 15, 5, -5, 16, 12), box(-12, 14, 4, -4, 15, 13), box(1, 0, 28, 3, 13, 30), box(13, 0, 28, 15, 13, 30), box(13, 0, 14, 15, 13, 16),
			box(1, 0, 14, 3, 13, 16), box(-15, 0, 1, -13, 13, 3), box(-15, 0, 14, -13, 13, 16), box(13, 0, 1, 15, 13, 3), box(-13, 7, 1, 13, 9, 3), box(-13, 7, 14, 1, 9, 16), box(3, 7, 27, 13, 9, 29), box(1, 7, 16, 3, 9, 28),
			box(13, 7, 16, 15, 9, 28), box(13, 7, 3, 15, 9, 14), box(-15, 7, 3, -13, 9, 14), box(-8, 15, 1.4, -7, 20, 2.4), box(-9, 14, 0.3, -6, 15, 3.3), box(-8, 20, 2.9, -7, 22, 3.9), box(11, 16, 24, 14, 17, 27), box(11, 14, 24, 14, 15, 27),
			box(11.3, 15, 24.3, 13.7, 16, 26.7), box(0, 14, 0, 16, 27, 1), box(15, 14, 1, 16, 27, 16), box(0, 13, 16, 16, 14, 32), box(-16, 13, 0, 16, 14, 16), box(14, 16, 14.4, 15, 25, 15.4), box(14, 16, 1.4, 15, 25, 2.4),
			box(1, 16.2, 0.1, 5, 27.2, 1.1), box(-12.9, 5.1, 13.9, -8.9, 9.1, 16.1));
	private static final VoxelShape SHAPE_1_EAST = Shapes.or(box(4, 16, 20, 13, 17, 28), box(5, 15, 21, 12, 16, 27), box(4, 14, 20, 13, 15, 28), box(28, 0, 13, 30, 13, 15), box(28, 0, 1, 30, 13, 3), box(14, 0, 1, 16, 13, 3),
			box(14, 0, 13, 16, 13, 15), box(1, 0, 29, 3, 13, 31), box(14, 0, 29, 16, 13, 31), box(1, 0, 1, 3, 13, 3), box(1, 7, 3, 3, 9, 29), box(14, 7, 15, 16, 9, 29), box(27, 7, 3, 29, 9, 13), box(16, 7, 13, 28, 9, 15), box(16, 7, 1, 28, 9, 3),
			box(3, 7, 1, 14, 9, 3), box(3, 7, 29, 14, 9, 31), box(1.4, 15, 23, 2.4, 20, 24), box(0.3, 14, 22, 3.3, 15, 25), box(2.9, 20, 23, 3.9, 22, 24), box(24, 16, 2, 27, 17, 5), box(24, 14, 2, 27, 15, 5), box(24.3, 15, 2.3, 26.7, 16, 4.7),
			box(0, 14, 0, 1, 27, 16), box(1, 14, 0, 16, 27, 1), box(16, 13, 0, 32, 14, 16), box(0, 13, 0, 16, 14, 32), box(14.4, 16, 1, 15.4, 25, 2), box(1.4, 16, 1, 2.4, 25, 2), box(0.1, 16.2, 11, 1.1, 27.2, 15),
			box(13.9, 5.1, 24.9, 16.1, 9.1, 28.9));
	private static final VoxelShape SHAPE_1_WEST = Shapes.or(box(3, 16, -12, 12, 17, -4), box(4, 15, -11, 11, 16, -5), box(3, 14, -12, 12, 15, -4), box(-14, 0, 1, -12, 13, 3), box(-14, 0, 13, -12, 13, 15), box(0, 0, 13, 2, 13, 15),
			box(0, 0, 1, 2, 13, 3), box(13, 0, -15, 15, 13, -13), box(0, 0, -15, 2, 13, -13), box(13, 0, 13, 15, 13, 15), box(13, 7, -13, 15, 9, 13), box(0, 7, -13, 2, 9, 1), box(-13, 7, 3, -11, 9, 13), box(-12, 7, 1, 0, 9, 3),
			box(-12, 7, 13, 0, 9, 15), box(2, 7, 13, 13, 9, 15), box(2, 7, -15, 13, 9, -13), box(13.6, 15, -8, 14.6, 20, -7), box(12.7, 14, -9, 15.7, 15, -6), box(12.1, 20, -8, 13.1, 22, -7), box(-11, 16, 11, -8, 17, 14),
			box(-11, 14, 11, -8, 15, 14), box(-10.7, 15, 11.3, -8.3, 16, 13.7), box(15, 14, 0, 16, 27, 16), box(0, 14, 15, 15, 27, 16), box(-16, 13, 0, 0, 14, 16), box(0, 13, -16, 16, 14, 16), box(0.6, 16, 14, 1.6, 25, 15),
			box(13.6, 16, 14, 14.6, 25, 15), box(14.9, 16.2, 1, 15.9, 27.2, 5), box(-0.1, 5.1, -12.9, 2.1, 9.1, -8.9));
	private static final VoxelShape SHAPE_2_NORTH = Shapes.or(box(20, 0, 3, 28, 1, 12), box(21, -1, 4, 27, 0, 11), box(20, -2, 3, 28, -1, 12), box(13, -16, -14, 15, -3, -12), box(1, -16, -14, 3, -3, -12), box(1, -16, 0, 3, -3, 2),
			box(13, -16, 0, 15, -3, 2), box(29, -16, 13, 31, -3, 15), box(29, -16, 0, 31, -3, 2), box(1, -16, 13, 3, -3, 15), box(3, -9, 13, 29, -7, 15), box(15, -9, 0, 29, -7, 2), box(3, -9, -13, 13, -7, -11), box(13, -9, -12, 15, -7, 0),
			box(1, -9, -12, 3, -7, 0), box(1, -9, 2, 3, -7, 13), box(29, -9, 2, 31, -7, 13), box(23, -1, 13.6, 24, 4, 14.6), box(22, -2, 12.7, 25, -1, 15.7), box(23, 4, 12.1, 24, 6, 13.1), box(2, 0, -11, 5, 1, -8), box(2, -2, -11, 5, -1, -8),
			box(2.3, -1, -10.7, 4.7, 0, -8.3), box(0, -2, 15, 16, 11, 16), box(0, -2, 0, 1, 11, 15), box(0, -3, -16, 16, -2, 0), box(0, -3, 0, 32, -2, 16), box(1, 0, 0.6, 2, 9, 1.6), box(1, 0, 13.6, 2, 9, 14.6), box(11, 0.2, 14.9, 15, 11.2, 15.9),
			box(24.9, -10.9, -0.1, 28.9, -6.9, 2.1));
	private static final VoxelShape SHAPE_2_SOUTH = Shapes.or(box(-12, 0, 4, -4, 1, 13), box(-11, -1, 5, -5, 0, 12), box(-12, -2, 4, -4, -1, 13), box(1, -16, 28, 3, -3, 30), box(13, -16, 28, 15, -3, 30), box(13, -16, 14, 15, -3, 16),
			box(1, -16, 14, 3, -3, 16), box(-15, -16, 1, -13, -3, 3), box(-15, -16, 14, -13, -3, 16), box(13, -16, 1, 15, -3, 3), box(-13, -9, 1, 13, -7, 3), box(-13, -9, 14, 1, -7, 16), box(3, -9, 27, 13, -7, 29), box(1, -9, 16, 3, -7, 28),
			box(13, -9, 16, 15, -7, 28), box(13, -9, 3, 15, -7, 14), box(-15, -9, 3, -13, -7, 14), box(-8, -1, 1.4, -7, 4, 2.4), box(-9, -2, 0.3, -6, -1, 3.3), box(-8, 4, 2.9, -7, 6, 3.9), box(11, 0, 24, 14, 1, 27), box(11, -2, 24, 14, -1, 27),
			box(11.3, -1, 24.3, 13.7, 0, 26.7), box(0, -2, 0, 16, 11, 1), box(15, -2, 1, 16, 11, 16), box(0, -3, 16, 16, -2, 32), box(-16, -3, 0, 16, -2, 16), box(14, 0, 14.4, 15, 9, 15.4), box(14, 0, 1.4, 15, 9, 2.4), box(1, 0.2, 0.1, 5, 11.2, 1.1),
			box(-12.9, -10.9, 13.9, -8.9, -6.9, 16.1));
	private static final VoxelShape SHAPE_2_EAST = Shapes.or(box(4, 0, 20, 13, 1, 28), box(5, -1, 21, 12, 0, 27), box(4, -2, 20, 13, -1, 28), box(28, -16, 13, 30, -3, 15), box(28, -16, 1, 30, -3, 3), box(14, -16, 1, 16, -3, 3),
			box(14, -16, 13, 16, -3, 15), box(1, -16, 29, 3, -3, 31), box(14, -16, 29, 16, -3, 31), box(1, -16, 1, 3, -3, 3), box(1, -9, 3, 3, -7, 29), box(14, -9, 15, 16, -7, 29), box(27, -9, 3, 29, -7, 13), box(16, -9, 13, 28, -7, 15),
			box(16, -9, 1, 28, -7, 3), box(3, -9, 1, 14, -7, 3), box(3, -9, 29, 14, -7, 31), box(1.4, -1, 23, 2.4, 4, 24), box(0.3, -2, 22, 3.3, -1, 25), box(2.9, 4, 23, 3.9, 6, 24), box(24, 0, 2, 27, 1, 5), box(24, -2, 2, 27, -1, 5),
			box(24.3, -1, 2.3, 26.7, 0, 4.7), box(0, -2, 0, 1, 11, 16), box(1, -2, 0, 16, 11, 1), box(16, -3, 0, 32, -2, 16), box(0, -3, 0, 16, -2, 32), box(14.4, 0, 1, 15.4, 9, 2), box(1.4, 0, 1, 2.4, 9, 2), box(0.1, 0.2, 11, 1.1, 11.2, 15),
			box(13.9, -10.9, 24.9, 16.1, -6.9, 28.9));
	private static final VoxelShape SHAPE_2_WEST = Shapes.or(box(3, 0, -12, 12, 1, -4), box(4, -1, -11, 11, 0, -5), box(3, -2, -12, 12, -1, -4), box(-14, -16, 1, -12, -3, 3), box(-14, -16, 13, -12, -3, 15), box(0, -16, 13, 2, -3, 15),
			box(0, -16, 1, 2, -3, 3), box(13, -16, -15, 15, -3, -13), box(0, -16, -15, 2, -3, -13), box(13, -16, 13, 15, -3, 15), box(13, -9, -13, 15, -7, 13), box(0, -9, -13, 2, -7, 1), box(-13, -9, 3, -11, -7, 13), box(-12, -9, 1, 0, -7, 3),
			box(-12, -9, 13, 0, -7, 15), box(2, -9, 13, 13, -7, 15), box(2, -9, -15, 13, -7, -13), box(13.6, -1, -8, 14.6, 4, -7), box(12.7, -2, -9, 15.7, -1, -6), box(12.1, 4, -8, 13.1, 6, -7), box(-11, 0, 11, -8, 1, 14),
			box(-11, -2, 11, -8, -1, 14), box(-10.7, -1, 11.3, -8.3, 0, 13.7), box(15, -2, 0, 16, 11, 16), box(0, -2, 15, 15, 11, 16), box(-16, -3, 0, 0, -2, 16), box(0, -3, -16, 16, -2, 16), box(0.6, 0, 14, 1.6, 9, 15),
			box(13.6, 0, 14, 14.6, 9, 15), box(14.9, 0.2, 1, 15.9, 11.2, 5), box(-0.1, -10.9, -12.9, 2.1, -6.9, -8.9));
	private static final VoxelShape SHAPE_3_NORTH = Shapes.or(box(4, 16, 3, 12, 17, 12), box(5, 15, 4, 11, 16, 11), box(4, 14, 3, 12, 15, 12), box(-3, 0, -14, -1, 13, -12), box(-15, 0, -14, -13, 13, -12), box(-15, 0, 0, -13, 13, 2),
			box(-3, 0, 0, -1, 13, 2), box(13, 0, 13, 15, 13, 15), box(13, 0, 0, 15, 13, 2), box(-15, 0, 13, -13, 13, 15), box(-13, 7, 13, 13, 9, 15), box(-1, 7, 0, 13, 9, 2), box(-13, 7, -13, -3, 9, -11), box(-3, 7, -12, -1, 9, 0),
			box(-15, 7, -12, -13, 9, 0), box(-15, 7, 2, -13, 9, 13), box(13, 7, 2, 15, 9, 13), box(7, 15, 13.6, 8, 20, 14.6), box(6, 14, 12.7, 9, 15, 15.7), box(7, 20, 12.1, 8, 22, 13.1), box(-14, 16, -11, -11, 17, -8),
			box(-14, 14, -11, -11, 15, -8), box(-13.7, 15, -10.7, -11.3, 16, -8.3), box(-16, 14, 15, 0, 27, 16), box(-16, 14, 0, -15, 27, 15), box(-16, 13, -16, 0, 14, 0), box(-16, 13, 0, 16, 14, 16), box(-15, 16, 0.6, -14, 25, 1.6),
			box(-15, 16, 13.6, -14, 25, 14.6), box(-5, 16.2, 14.9, -1, 27.2, 15.9), box(8.9, 5.1, -0.1, 12.9, 9.1, 2.1));
	private static final VoxelShape SHAPE_3_SOUTH = Shapes.or(box(4, 16, 4, 12, 17, 13), box(5, 15, 5, 11, 16, 12), box(4, 14, 4, 12, 15, 13), box(17, 0, 28, 19, 13, 30), box(29, 0, 28, 31, 13, 30), box(29, 0, 14, 31, 13, 16),
			box(17, 0, 14, 19, 13, 16), box(1, 0, 1, 3, 13, 3), box(1, 0, 14, 3, 13, 16), box(29, 0, 1, 31, 13, 3), box(3, 7, 1, 29, 9, 3), box(3, 7, 14, 17, 9, 16), box(19, 7, 27, 29, 9, 29), box(17, 7, 16, 19, 9, 28), box(29, 7, 16, 31, 9, 28),
			box(29, 7, 3, 31, 9, 14), box(1, 7, 3, 3, 9, 14), box(8, 15, 1.4, 9, 20, 2.4), box(7, 14, 0.3, 10, 15, 3.3), box(8, 20, 2.9, 9, 22, 3.9), box(27, 16, 24, 30, 17, 27), box(27, 14, 24, 30, 15, 27), box(27.3, 15, 24.3, 29.7, 16, 26.7),
			box(16, 14, 0, 32, 27, 1), box(31, 14, 1, 32, 27, 16), box(16, 13, 16, 32, 14, 32), box(0, 13, 0, 32, 14, 16), box(30, 16, 14.4, 31, 25, 15.4), box(30, 16, 1.4, 31, 25, 2.4), box(17, 16.2, 0.1, 21, 27.2, 1.1),
			box(3.1, 5.1, 13.9, 7.1, 9.1, 16.1));
	private static final VoxelShape SHAPE_3_EAST = Shapes.or(box(4, 16, 4, 13, 17, 12), box(5, 15, 5, 12, 16, 11), box(4, 14, 4, 13, 15, 12), box(28, 0, -3, 30, 13, -1), box(28, 0, -15, 30, 13, -13), box(14, 0, -15, 16, 13, -13),
			box(14, 0, -3, 16, 13, -1), box(1, 0, 13, 3, 13, 15), box(14, 0, 13, 16, 13, 15), box(1, 0, -15, 3, 13, -13), box(1, 7, -13, 3, 9, 13), box(14, 7, -1, 16, 9, 13), box(27, 7, -13, 29, 9, -3), box(16, 7, -3, 28, 9, -1),
			box(16, 7, -15, 28, 9, -13), box(3, 7, -15, 14, 9, -13), box(3, 7, 13, 14, 9, 15), box(1.4, 15, 7, 2.4, 20, 8), box(0.3, 14, 6, 3.3, 15, 9), box(2.9, 20, 7, 3.9, 22, 8), box(24, 16, -14, 27, 17, -11), box(24, 14, -14, 27, 15, -11),
			box(24.3, 15, -13.7, 26.7, 16, -11.3), box(0, 14, -16, 1, 27, 0), box(1, 14, -16, 16, 27, -15), box(16, 13, -16, 32, 14, 0), box(0, 13, -16, 16, 14, 16), box(14.4, 16, -15, 15.4, 25, -14), box(1.4, 16, -15, 2.4, 25, -14),
			box(0.1, 16.2, -5, 1.1, 27.2, -1), box(13.9, 5.1, 8.9, 16.1, 9.1, 12.9));
	private static final VoxelShape SHAPE_3_WEST = Shapes.or(box(3, 16, 4, 12, 17, 12), box(4, 15, 5, 11, 16, 11), box(3, 14, 4, 12, 15, 12), box(-14, 0, 17, -12, 13, 19), box(-14, 0, 29, -12, 13, 31), box(0, 0, 29, 2, 13, 31),
			box(0, 0, 17, 2, 13, 19), box(13, 0, 1, 15, 13, 3), box(0, 0, 1, 2, 13, 3), box(13, 0, 29, 15, 13, 31), box(13, 7, 3, 15, 9, 29), box(0, 7, 3, 2, 9, 17), box(-13, 7, 19, -11, 9, 29), box(-12, 7, 17, 0, 9, 19), box(-12, 7, 29, 0, 9, 31),
			box(2, 7, 29, 13, 9, 31), box(2, 7, 1, 13, 9, 3), box(13.6, 15, 8, 14.6, 20, 9), box(12.7, 14, 7, 15.7, 15, 10), box(12.1, 20, 8, 13.1, 22, 9), box(-11, 16, 27, -8, 17, 30), box(-11, 14, 27, -8, 15, 30),
			box(-10.7, 15, 27.3, -8.3, 16, 29.7), box(15, 14, 16, 16, 27, 32), box(0, 14, 31, 15, 27, 32), box(-16, 13, 16, 0, 14, 32), box(0, 13, 0, 16, 14, 32), box(0.6, 16, 30, 1.6, 25, 31), box(13.6, 16, 30, 14.6, 25, 31),
			box(14.9, 16.2, 17, 15.9, 27.2, 21), box(-0.1, 5.1, 3.1, 2.1, 9.1, 7.1));
	private static final VoxelShape SHAPE_4_NORTH = Shapes.or(box(20, 16, 19, 28, 17, 28), box(21, 15, 20, 27, 16, 27), box(20, 14, 19, 28, 15, 28), box(13, 0, 2, 15, 13, 4), box(1, 0, 2, 3, 13, 4), box(1, 0, 16, 3, 13, 18),
			box(13, 0, 16, 15, 13, 18), box(29, 0, 29, 31, 13, 31), box(29, 0, 16, 31, 13, 18), box(1, 0, 29, 3, 13, 31), box(3, 7, 29, 29, 9, 31), box(15, 7, 16, 29, 9, 18), box(3, 7, 3, 13, 9, 5), box(13, 7, 4, 15, 9, 16), box(1, 7, 4, 3, 9, 16),
			box(1, 7, 18, 3, 9, 29), box(29, 7, 18, 31, 9, 29), box(23, 15, 29.6, 24, 20, 30.6), box(22, 14, 28.7, 25, 15, 31.7), box(23, 20, 28.1, 24, 22, 29.1), box(2, 16, 5, 5, 17, 8), box(2, 14, 5, 5, 15, 8), box(2.3, 15, 5.3, 4.7, 16, 7.7),
			box(0, 14, 31, 16, 27, 32), box(0, 14, 16, 1, 27, 31), box(0, 13, 0, 16, 14, 16), box(0, 13, 16, 32, 14, 32), box(1, 16, 16.6, 2, 25, 17.6), box(1, 16, 29.6, 2, 25, 30.6), box(11, 16.2, 30.9, 15, 27.2, 31.9),
			box(24.9, 5.1, 15.9, 28.9, 9.1, 18.1));
	private static final VoxelShape SHAPE_4_SOUTH = Shapes.or(box(-12, 16, -12, -4, 17, -3), box(-11, 15, -11, -5, 16, -4), box(-12, 14, -12, -4, 15, -3), box(1, 0, 12, 3, 13, 14), box(13, 0, 12, 15, 13, 14), box(13, 0, -2, 15, 13, 0),
			box(1, 0, -2, 3, 13, 0), box(-15, 0, -15, -13, 13, -13), box(-15, 0, -2, -13, 13, 0), box(13, 0, -15, 15, 13, -13), box(-13, 7, -15, 13, 9, -13), box(-13, 7, -2, 1, 9, 0), box(3, 7, 11, 13, 9, 13), box(1, 7, 0, 3, 9, 12),
			box(13, 7, 0, 15, 9, 12), box(13, 7, -13, 15, 9, -2), box(-15, 7, -13, -13, 9, -2), box(-8, 15, -14.6, -7, 20, -13.6), box(-9, 14, -15.7, -6, 15, -12.7), box(-8, 20, -13.1, -7, 22, -12.1), box(11, 16, 8, 14, 17, 11),
			box(11, 14, 8, 14, 15, 11), box(11.3, 15, 8.3, 13.7, 16, 10.7), box(0, 14, -16, 16, 27, -15), box(15, 14, -15, 16, 27, 0), box(0, 13, 0, 16, 14, 16), box(-16, 13, -16, 16, 14, 0), box(14, 16, -1.6, 15, 25, -0.6),
			box(14, 16, -14.6, 15, 25, -13.6), box(1, 16.2, -15.9, 5, 27.2, -14.9), box(-12.9, 5.1, -2.1, -8.9, 9.1, 0.1));
	private static final VoxelShape SHAPE_4_EAST = Shapes.or(box(-12, 16, 20, -3, 17, 28), box(-11, 15, 21, -4, 16, 27), box(-12, 14, 20, -3, 15, 28), box(12, 0, 13, 14, 13, 15), box(12, 0, 1, 14, 13, 3), box(-2, 0, 1, 0, 13, 3),
			box(-2, 0, 13, 0, 13, 15), box(-15, 0, 29, -13, 13, 31), box(-2, 0, 29, 0, 13, 31), box(-15, 0, 1, -13, 13, 3), box(-15, 7, 3, -13, 9, 29), box(-2, 7, 15, 0, 9, 29), box(11, 7, 3, 13, 9, 13), box(0, 7, 13, 12, 9, 15),
			box(0, 7, 1, 12, 9, 3), box(-13, 7, 1, -2, 9, 3), box(-13, 7, 29, -2, 9, 31), box(-14.6, 15, 23, -13.6, 20, 24), box(-15.7, 14, 22, -12.7, 15, 25), box(-13.1, 20, 23, -12.1, 22, 24), box(8, 16, 2, 11, 17, 5), box(8, 14, 2, 11, 15, 5),
			box(8.3, 15, 2.3, 10.7, 16, 4.7), box(-16, 14, 0, -15, 27, 16), box(-15, 14, 0, 0, 27, 1), box(0, 13, 0, 16, 14, 16), box(-16, 13, 0, 0, 14, 32), box(-1.6, 16, 1, -0.6, 25, 2), box(-14.6, 16, 1, -13.6, 25, 2),
			box(-15.9, 16.2, 11, -14.9, 27.2, 15), box(-2.1, 5.1, 24.9, 0.1, 9.1, 28.9));
	private static final VoxelShape SHAPE_4_WEST = Shapes.or(box(19, 16, -12, 28, 17, -4), box(20, 15, -11, 27, 16, -5), box(19, 14, -12, 28, 15, -4), box(2, 0, 1, 4, 13, 3), box(2, 0, 13, 4, 13, 15), box(16, 0, 13, 18, 13, 15),
			box(16, 0, 1, 18, 13, 3), box(29, 0, -15, 31, 13, -13), box(16, 0, -15, 18, 13, -13), box(29, 0, 13, 31, 13, 15), box(29, 7, -13, 31, 9, 13), box(16, 7, -13, 18, 9, 1), box(3, 7, 3, 5, 9, 13), box(4, 7, 1, 16, 9, 3),
			box(4, 7, 13, 16, 9, 15), box(18, 7, 13, 29, 9, 15), box(18, 7, -15, 29, 9, -13), box(29.6, 15, -8, 30.6, 20, -7), box(28.7, 14, -9, 31.7, 15, -6), box(28.1, 20, -8, 29.1, 22, -7), box(5, 16, 11, 8, 17, 14), box(5, 14, 11, 8, 15, 14),
			box(5.3, 15, 11.3, 7.7, 16, 13.7), box(31, 14, 0, 32, 27, 16), box(16, 14, 15, 31, 27, 16), box(0, 13, 0, 16, 14, 16), box(16, 13, -16, 32, 14, 16), box(16.6, 16, 14, 17.6, 25, 15), box(29.6, 16, 14, 30.6, 25, 15),
			box(30.9, 16.2, 1, 31.9, 27.2, 5), box(15.9, 5.1, -12.9, 18.1, 9.1, -8.9));
	private static final VoxelShape SHAPE_NORTH = Shapes.or(box(0, 0, 0, 2, 13, 2), box(14, 0, -16, 16, 13, -14), box(14, 0, 0, 16, 13, 2), box(0, 0, -16, 2, 13, -14), box(30, 0, 14, 32, 13, 16), box(30, 0, 0, 32, 13, 2), box(0, 0, 14, 2, 13, 16),
			box(2, 7, 14, 30, 9, 16), box(0, 7, 2, 2, 9, 14), box(0, 7, -14, 2, 9, 0), box(16, 7, 0, 30, 9, 2), box(2, 7, -16, 14, 9, -14), box(14, 7, -14, 16, 9, 0), box(0, 13, 0, 32, 14, 16), box(30, 7, 2, 32, 9, 14), box(0, 13, -16, 16, 14, 0),
			box(0, 14, 15, 16, 27, 16), box(0, 14, 0, 1, 27, 15), box(22, 14, 12.7, 25, 15, 15.7), box(22, 20.5, 11.1, 25, 20.9, 14.1), box(23, 24.39106, 12.25761, 24, 25.39106, 15.25761), box(23, 15, 13.7, 24, 20, 14.7),
			box(23, 20.6, 12.1, 24, 22.6, 13.1), box(23, 22.70396, 14.5446, 24, 24.70396, 15.5446), box(23, 19.47324, 11.90835, 24, 20.47324, 14.90835), box(7, 14, 2, 9, 16, 4), box(11, 14, 6, 13, 16, 8), box(11, 14, 10, 12, 17, 11),
			box(4, 14, 3, 5, 16, 4), box(7, 14, 10, 9, 17, 12), box(4, 14, 10, 5, 17, 11), box(3, 14, 6, 5, 17, 8), box(20, 16, 3, 28, 17, 12), box(21, 15, 4, 27, 16, 11), box(20, 14, 3, 28, 15, 12), box(12, 14, -10, 13, 15, -4),
			box(12, 15, -10, 13, 15.3, -8), box(23, 20.01828, 14.27608, 24, 23.01828, 15.27608));
	private static final VoxelShape SHAPE_SOUTH = Shapes.or(box(14, 0, 14, 16, 13, 16), box(0, 0, 30, 2, 13, 32), box(0, 0, 14, 2, 13, 16), box(14, 0, 30, 16, 13, 32), box(-16, 0, 0, -14, 13, 2), box(-16, 0, 14, -14, 13, 16),
			box(14, 0, 0, 16, 13, 2), box(-14, 7, 0, 14, 9, 2), box(14, 7, 2, 16, 9, 14), box(14, 7, 16, 16, 9, 30), box(-14, 7, 14, 0, 9, 16), box(2, 7, 30, 14, 9, 32), box(0, 7, 16, 2, 9, 30), box(-16, 13, 0, 16, 14, 16),
			box(-16, 7, 2, -14, 9, 14), box(0, 13, 16, 16, 14, 32), box(0, 14, 0, 16, 27, 1), box(15, 14, 1, 16, 27, 16), box(-9, 14, 0.3, -6, 15, 3.3), box(-9, 20.5, 1.9, -6, 20.9, 4.9), box(-8, 24.39106, 0.74239, -7, 25.39106, 3.74239),
			box(-8, 15, 1.3, -7, 20, 2.3), box(-8, 20.6, 2.9, -7, 22.6, 3.9), box(-8, 22.70396, 0.4554, -7, 24.70396, 1.4554), box(-8, 19.47324, 1.09165, -7, 20.47324, 4.09165), box(7, 14, 12, 9, 16, 14), box(3, 14, 8, 5, 16, 10),
			box(4, 14, 5, 5, 17, 6), box(11, 14, 12, 12, 16, 13), box(7, 14, 4, 9, 17, 6), box(11, 14, 5, 12, 17, 6), box(11, 14, 8, 13, 17, 10), box(-12, 16, 4, -4, 17, 13), box(-11, 15, 5, -5, 16, 12), box(-12, 14, 4, -4, 15, 13),
			box(3, 14, 20, 4, 15, 26), box(3, 15, 24, 4, 15.3, 26), box(-8, 20.01828, 0.72392, -7, 23.01828, 1.72392));
	private static final VoxelShape SHAPE_EAST = Shapes.or(box(14, 0, 0, 16, 13, 2), box(30, 0, 14, 32, 13, 16), box(14, 0, 14, 16, 13, 16), box(30, 0, 0, 32, 13, 2), box(0, 0, 30, 2, 13, 32), box(14, 0, 30, 16, 13, 32), box(0, 0, 0, 2, 13, 2),
			box(0, 7, 2, 2, 9, 30), box(2, 7, 0, 14, 9, 2), box(16, 7, 0, 30, 9, 2), box(14, 7, 16, 16, 9, 30), box(30, 7, 2, 32, 9, 14), box(16, 7, 14, 30, 9, 16), box(0, 13, 0, 16, 14, 32), box(2, 7, 30, 14, 9, 32), box(16, 13, 0, 32, 14, 16),
			box(0, 14, 0, 1, 27, 16), box(1, 14, 0, 16, 27, 1), box(0.3, 14, 22, 3.3, 15, 25), box(1.9, 20.5, 22, 4.9, 20.9, 25), box(0.74239, 24.39106, 23, 3.74239, 25.39106, 24), box(1.3, 15, 23, 2.3, 20, 24), box(2.9, 20.6, 23, 3.9, 22.6, 24),
			box(0.4554, 22.70396, 23, 1.4554, 24.70396, 24), box(1.09165, 19.47324, 23, 4.09165, 20.47324, 24), box(12, 14, 7, 14, 16, 9), box(8, 14, 11, 10, 16, 13), box(5, 14, 11, 6, 17, 12), box(12, 14, 4, 13, 16, 5), box(4, 14, 7, 6, 17, 9),
			box(5, 14, 4, 6, 17, 5), box(8, 14, 3, 10, 17, 5), box(4, 16, 20, 13, 17, 28), box(5, 15, 21, 12, 16, 27), box(4, 14, 20, 13, 15, 28), box(20, 14, 12, 26, 15, 13), box(24, 15, 12, 26, 15.3, 13),
			box(0.72392, 20.01828, 23, 1.72392, 23.01828, 24));
	private static final VoxelShape SHAPE_WEST = Shapes.or(box(0, 0, 14, 2, 13, 16), box(-16, 0, 0, -14, 13, 2), box(0, 0, 0, 2, 13, 2), box(-16, 0, 14, -14, 13, 16), box(14, 0, -16, 16, 13, -14), box(0, 0, -16, 2, 13, -14),
			box(14, 0, 14, 16, 13, 16), box(14, 7, -14, 16, 9, 14), box(2, 7, 14, 14, 9, 16), box(-14, 7, 14, 0, 9, 16), box(0, 7, -14, 2, 9, 0), box(-16, 7, 2, -14, 9, 14), box(-14, 7, 0, 0, 9, 2), box(0, 13, -16, 16, 14, 16),
			box(2, 7, -16, 14, 9, -14), box(-16, 13, 0, 0, 14, 16), box(15, 14, 0, 16, 27, 16), box(0, 14, 15, 15, 27, 16), box(12.7, 14, -9, 15.7, 15, -6), box(11.1, 20.5, -9, 14.1, 20.9, -6), box(12.25761, 24.39106, -8, 15.25761, 25.39106, -7),
			box(13.7, 15, -8, 14.7, 20, -7), box(12.1, 20.6, -8, 13.1, 22.6, -7), box(14.5446, 22.70396, -8, 15.5446, 24.70396, -7), box(11.90835, 19.47324, -8, 14.90835, 20.47324, -7), box(2, 14, 7, 4, 16, 9), box(6, 14, 3, 8, 16, 5),
			box(10, 14, 4, 11, 17, 5), box(3, 14, 11, 4, 16, 12), box(10, 14, 7, 12, 17, 9), box(10, 14, 11, 11, 17, 12), box(6, 14, 11, 8, 17, 13), box(3, 16, -12, 12, 17, -4), box(4, 15, -11, 11, 16, -5), box(3, 14, -12, 12, 15, -4),
			box(-10, 14, 3, -4, 15, 4), box(-10, 15, 3, -8, 15.3, 4), box(14.27608, 20.01828, -8, 15.27608, 23.01828, -7));

	public MagetableBlock(BlockBehaviour.Properties properties) {
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
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.IGNORE).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
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
		MagetablePriDobavlieniiBlokaProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		MagetablePriObnovlieniiTikaProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 2);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		MagetablePriRazrushieniiBlokaIghrokomProcedure.execute();
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
		MagetablePriShchielchkiePKMPoBlokuProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new MagetableBlockEntity(pos, state);
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
		if (tileentity instanceof MagetableBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}