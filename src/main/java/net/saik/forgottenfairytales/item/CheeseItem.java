package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CheeseItem extends Item {
	public CheeseItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.5f).build(), Consumables.defaultFood().consumeSeconds(0.8F).build()));
	}
}