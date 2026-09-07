package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.RuneOfProtectionPriShchielchkiePKMProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class RuneOfProtectionItem extends Item {
	public RuneOfProtectionItem(Item.Properties properties) {
		super(properties.durability(1));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		RuneOfProtectionPriShchielchkiePKMProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}