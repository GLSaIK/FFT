package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.NewageshovelKazhdyiTikVRukieProcedure;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

public class NewageshovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1720, 8f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:newageshovel_repair_items")));

	public NewageshovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -2.9f, properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		if (equipmentSlot == EquipmentSlot.MAINHAND)
			NewageshovelKazhdyiTikVRukieProcedure.execute(entity);
	}
}