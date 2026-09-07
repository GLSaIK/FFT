package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.MilkbottlePriZaviershieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class MilkbottleItem extends Item {
	public MilkbottleItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1f).alwaysEdible().build(), Consumables.DEFAULT_DRINK).usingConvertsTo(Items.GLASS_BOTTLE));
	}

	@Override
	public ItemStack getCraftingRemainder(ItemStack itemstack) {
		return new ItemStack(Items.GLASS_BOTTLE);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		MilkbottlePriZaviershieniiIspolzovaniiaProcedure.execute(world, entity, itemstack);
		return retval;
	}
}