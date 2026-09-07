package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.BloodSoupPriZaviershieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class BloodSoupItem extends Item {
	public BloodSoupItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.5f).build()).usingConvertsTo(Items.BOWL));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		BloodSoupPriZaviershieniiIspolzovaniiaProcedure.execute(entity);
		return retval;
	}
}