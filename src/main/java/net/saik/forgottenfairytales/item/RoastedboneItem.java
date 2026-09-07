package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.RoastedbonePriZaviershieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class RoastedboneItem extends Item {
	public RoastedboneItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(1f).build(), Consumables.defaultFood().consumeSeconds(1F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		RoastedbonePriZaviershieniiIspolzovaniiaProcedure.execute(entity);
		return retval;
	}
}