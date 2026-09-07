package net.saik.forgottenfairytales.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class LivingstoneBlock extends Block {
	public LivingstoneBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(4f, 7f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}