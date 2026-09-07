package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class BerryBreadItem extends Item {
	public BerryBreadItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(3).saturationModifier(1f).build()));
	}
}