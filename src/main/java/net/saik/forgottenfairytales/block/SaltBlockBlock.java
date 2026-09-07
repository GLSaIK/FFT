package net.saik.forgottenfairytales.block;

import net.saik.forgottenfairytales.procedures.SaltBlockPriObnovlieniiTikaProcedure;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class SaltBlockBlock extends Block {
	public SaltBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.MEDIUM_AMETHYST_BUD).strength(1f, 10f).randomTicks().instrument(NoteBlockInstrument.CHIME));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		SaltBlockPriObnovlieniiTikaProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}