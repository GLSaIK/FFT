package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.BrokenteleportPriShchielchkiePKMProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class BrokenteleportItem extends Item {
	public BrokenteleportItem(Item.Properties properties) {
		super(properties.durability(15));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.forgotten_fairy_tales.brokenteleport.description_0"));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		BrokenteleportPriShchielchkiePKMProcedure.execute(world, entity, entity.getItemInHand(hand));
		return ar;
	}
}