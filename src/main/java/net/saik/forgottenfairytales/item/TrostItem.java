package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.TrostPriUdariePoSushchnostiInstrumientomProcedure;
import net.saik.forgottenfairytales.procedures.TrostKazhdyiTikVRukieProcedure;

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

import javax.annotation.Nullable;

public class TrostItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100, 6f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:trost_repair_items")));

	public TrostItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 1f, -3f).fireResistant());
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		TrostPriUdariePoSushchnostiInstrumientomProcedure.execute(entity, sourceentity);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			TrostKazhdyiTikVRukieProcedure.execute(entity);
	}
}