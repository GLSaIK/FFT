package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class JulienneItem extends Item {
	public JulienneItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(1.5f).build(), Consumables.defaultFood().consumeSeconds(2F).build()));
	}
}