package net.saik.forgottenfairytales;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class CWRecipeInput implements RecipeInput {

    private final ItemStack[] items;

    public CWRecipeInput(ItemStack[] items) {

        if (items == null || items.length == 0) {
            throw new IllegalArgumentException(
                "CWRecipeInput requires at least 1 slot"
            );
        }

        this.items = items;
    }

    @Override
    public ItemStack getItem(int slot) {

        if (slot < 0 || slot >= items.length) {
            throw new IllegalArgumentException(
                "Invalid CW slot: " + slot
            );
        }

        return items[slot];
    }

    @Override
    public int size() {
        return items.length;
    }
}