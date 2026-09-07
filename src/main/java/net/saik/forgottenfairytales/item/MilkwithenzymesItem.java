package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.MilkwithenzymesPriShchielchkiePKMPoBlokuProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class MilkwithenzymesItem extends Item {
	public MilkwithenzymesItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MilkwithenzymesPriShchielchkiePKMPoBlokuProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}