package net.saik.forgottenfairytales.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class PyriteBlock extends Block {
	public PyriteBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(4.5f, 6f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.IRON_XYLOPHONE));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}