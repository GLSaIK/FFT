package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.ScabbardPriShchielchkiePKMProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class ScabbardItem extends Item {
	public ScabbardItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		ScabbardPriShchielchkiePKMProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}