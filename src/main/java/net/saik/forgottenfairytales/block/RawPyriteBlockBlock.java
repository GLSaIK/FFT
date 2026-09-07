package net.saik.forgottenfairytales.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class RawPyriteBlockBlock extends Block {
	public RawPyriteBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(5f, 6f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}