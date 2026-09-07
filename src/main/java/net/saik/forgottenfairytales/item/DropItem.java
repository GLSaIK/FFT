package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DropItem extends Item {
	public DropItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON));
	}
}