package net.saik.forgottenfairytales.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;

public class GoldenSaddleItem extends Item {
    public GoldenSaddleItem(Item.Properties properties) {
        super(
            properties.component(
                DataComponents.EQUIPPABLE,
                Equippable.builder(EquipmentSlot.SADDLE)
                    .setEquipOnInteract(true)
                    .build()
            )
        );
    }
}