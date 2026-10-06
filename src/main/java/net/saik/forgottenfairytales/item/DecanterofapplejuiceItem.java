package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class DecanterofapplejuiceItem extends Item {
	public DecanterofapplejuiceItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(2f).alwaysEdible().build(), Consumables.defaultDrink().consumeSeconds(1.5F).build()).usingConvertsTo(Items.GLASS_BOTTLE));
	}
}