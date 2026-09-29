package net.saik.forgottenfairytales.jei_recipes;

import mezz.jei.api.recipe.transfer.IRecipeTransferInfo;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.types.IRecipeType;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForgottenFairyTalesRecipeTransferInfo<C extends AbstractContainerMenu, R>
        implements IRecipeTransferInfo<C, R> {

    private final Class<? extends C> containerClass;
    private final IRecipeType<R> recipeType;
    private final int[] recipeSlotIndexes;
    private final int inventorySlotStart;
    private final int inventorySlotCount;

    public ForgottenFairyTalesRecipeTransferInfo(
            Class<? extends C> containerClass,
            IRecipeType<R> recipeType,
            int[] recipeSlotIndexes,
            int inventorySlotStart,
            int inventorySlotCount
    ) {
        this.containerClass = containerClass;
        this.recipeType = recipeType;
        this.recipeSlotIndexes = recipeSlotIndexes;
        this.inventorySlotStart = inventorySlotStart;
        this.inventorySlotCount = inventorySlotCount;
    }

    @Override
    public Class<? extends C> getContainerClass() {
        return containerClass;
    }

    @Override
    public Optional<MenuType<C>> getMenuType() {
        return Optional.empty();
    }

    @Override
    public IRecipeType<R> getRecipeType() {
        return recipeType;
    }

    @Override
    public boolean canHandle(C container, R recipe) {
        return container.getClass() == containerClass;
    }

    @Override
    @Nullable
    public IRecipeTransferError getHandlingError(C container, R recipe) {
        return null;
    }

    @Override
    public List<Slot> getRecipeSlots(C container, R recipe) {
        List<Slot> slots = new ArrayList<>(recipeSlotIndexes.length);

        for (int index : recipeSlotIndexes) {
            slots.add(container.getSlot(index));
        }

        return slots;
    }

    @Override
    public List<Slot> getInventorySlots(C container, R recipe) {
        List<Slot> slots = new ArrayList<>(inventorySlotCount);

        for (int i = 0; i < inventorySlotCount; i++) {
            slots.add(container.getSlot(inventorySlotStart + i));
        }

        return slots;
    }

    @Override
    public boolean requireCompleteSets(C container, R recipe) {
        return true;
    }
}