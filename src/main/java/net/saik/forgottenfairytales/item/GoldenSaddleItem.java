package net.saik.forgottenfairytales.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class GoldenSaddleItem extends Item {
    public GoldenSaddleItem(Item.Properties properties) {
        super(
            properties.component(
                DataComponents.EQUIPPABLE,
                Equippable.builder(EquipmentSlot.SADDLE)
                    .setEquipOnInteract(true)
                    .setAsset(
                        ResourceKey.create(
                            EquipmentAssets.ROOT_ID,
                            ResourceLocation.fromNamespaceAndPath(
                                "forgotten_fairy_tales",
                                "golden_saddle"
                            )
                        )
                    )
                    .build()
            )
        );
    }
}