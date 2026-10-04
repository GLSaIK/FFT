package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.PrahzeroPriShchielchkiePKMProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class PrahzeroItem extends Item {
	public PrahzeroItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		PrahzeroPriShchielchkiePKMProcedure.execute(entity);
		return ar;
	}
}