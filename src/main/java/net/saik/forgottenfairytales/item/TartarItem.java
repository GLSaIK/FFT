package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class TartarItem extends Item {
	public TartarItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.7f).build(), Consumables.defaultFood().consumeSeconds(1.5F).build()));
	}
}