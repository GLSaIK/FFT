package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.NutrientblockPriPriekrashchieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class NutrientblockItem extends Item {
	public NutrientblockItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.5f).build(), Consumables.defaultFood().consumeSeconds(2.5F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		NutrientblockPriPriekrashchieniiIspolzovaniiaProcedure.execute(entity);
		return retval;
	}
}