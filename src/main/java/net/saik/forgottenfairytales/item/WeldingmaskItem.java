package net.saik.forgottenfairytales.item;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import java.util.Map;

public abstract class WeldingmaskItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(23, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 9,
			DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_iron")), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("forgotten_fairy_tales:weldingmask_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("forgotten_fairy_tales:weldingmask")));

	private WeldingmaskItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends WeldingmaskItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}
	}
}