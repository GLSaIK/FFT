package net.saik.forgottenfairytales.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class IronPlateBlockBlock extends Block {
	public IronPlateBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.METAL).strength(5f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.GUITAR));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}