package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.SwordvoinPriUdariePoSushchnostiInstrumientomProcedure;
import net.saik.forgottenfairytales.procedures.SwordvoinKazhdyiTikVInvientarieProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SwordvoinItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 6f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:swordvoin_repair_items")));

	public SwordvoinItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 4f, -3.1f));
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(ForgottenFairyTalesModItems.SWORDVOIN.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		SwordvoinPriUdariePoSushchnostiInstrumientomProcedure.execute(entity, sourceentity);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		SwordvoinKazhdyiTikVInvientarieProcedure.execute(entity, itemstack);
	}
}