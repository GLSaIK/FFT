package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.CoffesurpriseProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import java.util.function.Consumer;

@EventBusSubscriber
public class CoffeItem extends Item {
	public CoffeItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1).fireResistant().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).alwaysEdible().build(), Consumables.DEFAULT_DRINK));
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		event.modify(ForgottenFairyTalesModItems.COFFE.get(), builder -> builder.set(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStack(ForgottenFairyTalesModItems.COFFE.get()))));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.forgotten_fairy_tales.coffe.description_0"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		CoffesurpriseProcedure.execute(world, entity);
		return retval;
	}
}