package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class ChokolatteItem extends Item {
	public ChokolatteItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(1f).build()));
	}
}