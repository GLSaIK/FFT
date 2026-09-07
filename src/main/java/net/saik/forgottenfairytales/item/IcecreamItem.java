package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.IcecreamPriZaviershieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class IcecreamItem extends Item {
	public IcecreamItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.8f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		IcecreamPriZaviershieniiIspolzovaniiaProcedure.execute(entity);
		return retval;
	}
}