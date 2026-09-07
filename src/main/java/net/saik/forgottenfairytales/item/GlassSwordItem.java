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
public class GlassSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 4f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:glass_sword_repair_items")));

	public GlassSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 7.5f, -2.6f));
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(ForgottenFairyTalesModItems.GLASS_SWORD.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}
}