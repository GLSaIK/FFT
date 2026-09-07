package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.WarriordrinkPriZaviershieniiIspolzovaniiaProcedure;
import net.saik.forgottenfairytales.procedures.WarriordrinkPriShchielchkiePKMPoBlokuProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;

public class WarriordrinkItem extends Item {
	public WarriordrinkItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1f).alwaysEdible().build(), Consumables.DEFAULT_DRINK).usingConvertsTo(Items.GLASS_BOTTLE));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		WarriordrinkPriZaviershieniiIspolzovaniiaProcedure.execute(entity);
		return retval;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WarriordrinkPriShchielchkiePKMPoBlokuProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}