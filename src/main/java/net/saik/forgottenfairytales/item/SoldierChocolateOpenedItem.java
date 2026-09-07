package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.SoldierChocolateOpenedPriZaviershieniiIspolzovaniiaProcedure;
import net.saik.forgottenfairytales.procedures.SoldierChocolateOpenedPriPriekrashchieniiIspolzovaniiaProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

public class SoldierChocolateOpenedItem extends Item {
	public SoldierChocolateOpenedItem(Item.Properties properties) {
		super(properties.durability(4).food((new FoodProperties.Builder()).nutrition(1).saturationModifier(3f).build(), Consumables.defaultFood().consumeSeconds(1F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		SoldierChocolateOpenedPriZaviershieniiIspolzovaniiaProcedure.execute(world, entity, itemstack);
		return retval;
	}

	@Override
	public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int time) {
		SoldierChocolateOpenedPriPriekrashchieniiIspolzovaniiaProcedure.execute(entity, itemstack);
	}
}