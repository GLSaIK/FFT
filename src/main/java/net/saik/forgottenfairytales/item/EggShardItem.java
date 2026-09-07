package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class EggShardItem extends Item {
	public EggShardItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.5f).build()));
	}
}