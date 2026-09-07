package net.saik.forgottenfairytales.item;

import net.saik.forgottenfairytales.procedures.UndeadHunterSwordPriUdariePoSushchnostiInstrumientomProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

@EventBusSubscriber
public class UndeadHunterSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 6f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:undead_hunter_sword_repair_items")));

	public UndeadHunterSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 1f, -1.8f));
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(ForgottenFairyTalesModItems.UNDEAD_HUNTER_SWORD.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		UndeadHunterSwordPriUdariePoSushchnostiInstrumientomProcedure.execute(entity, sourceentity);
	}
}