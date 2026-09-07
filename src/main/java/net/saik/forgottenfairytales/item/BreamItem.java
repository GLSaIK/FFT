package net.saik.forgottenfairytales.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class BreamItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 135, 4f, 0, 6, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:bream_repair_items")));

	public BreamItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 4f, -3f));
	}
}