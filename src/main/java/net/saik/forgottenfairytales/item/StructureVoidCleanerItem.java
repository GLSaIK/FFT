package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

@EventBusSubscriber
public class StructureVoidCleanerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:structure_void_cleaner_repair_items")));

	public StructureVoidCleanerItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 3f, -3f));
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(ForgottenFairyTalesModItems.STRUCTURE_VOID_CLEANER.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}
}