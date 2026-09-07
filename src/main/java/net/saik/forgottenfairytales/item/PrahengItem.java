package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.ViborengProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class PrahengItem extends Item {
	public PrahengItem(Item.Properties properties) {
		super(properties.stacksTo(1).fireResistant());
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		ViborengProcedure.execute(world, entity);
		return ar;
	}
}