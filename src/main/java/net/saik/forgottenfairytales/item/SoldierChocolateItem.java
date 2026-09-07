package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.SoldierChocolatePriShchielchkiePKMProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class SoldierChocolateItem extends Item {
	public SoldierChocolateItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SoldierChocolatePriShchielchkiePKMProcedure.execute(entity, entity.getItemInHand(hand));
		return ar;
	}
}