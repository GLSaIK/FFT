package net.saik.forgottenfairytales;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.level.Level;

import java.util.Map;

public class CWRecipeT implements Recipe<CWRecipeInput> {

    private static final Codec<Integer> INTEGER_KEY_CODEC =
        Codec.STRING.xmap(
            Integer::parseInt,
            String::valueOf
        );

    private static final Codec<Map<Integer, Ingredient>> INGREDIENTS_CODEC =
        Codec.unboundedMap(
            INTEGER_KEY_CODEC,
            Ingredient.CODEC
        );

    public static MapCodec<CWRecipeT> createCodec(
        RecipeType<CWRecipeT> type,
        int slotCount
    ) {
        return RecordCodecBuilder.mapCodec(instance ->
            instance.group(

                INGREDIENTS_CODEC
                    .fieldOf("ingredients")
                    .forGetter(CWRecipeT::getIngredients),

                ItemStack.CODEC
                    .fieldOf("result")
                    .forGetter(CWRecipeT::getResult)

            ).apply(
                instance,
                (ingredients, result) ->
                    new CWRecipeT(
                        ingredients,
                        result,
                        type,
                        slotCount
                    )
            )
        );
    }


    private final Map<Integer, Ingredient> ingredients;
    private final ItemStack result;

    private final RecipeType<CWRecipeT> type;
    private final int slotCount;


    public CWRecipeT(
        Map<Integer, Ingredient> ingredients,
        ItemStack result,
        RecipeType<CWRecipeT> type,
        int slotCount
    ) {
        this.ingredients = ingredients;
        this.result = result;
        this.type = type;
        this.slotCount = slotCount;
    }


    public Map<Integer, Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredient(int slot) {
        return ingredients.get(slot);
    }

    public ItemStack getResult() {
        return result;
    }


    @Override
    public boolean matches(
        CWRecipeInput input,
        Level level
    ) {

        // Рецепт и стол должны иметь одинаковое количество слотов
        if (input.size() != slotCount) {
            return false;
        }

        for (int slot = 0; slot < slotCount; slot++) {

            Ingredient ingredient = ingredients.get(slot);
            ItemStack stack = input.getItem(slot);


            // В рецепте этот слот не указан.
            // Значит он должен быть пустым.
            if (ingredient == null) {

                if (!stack.isEmpty()) {
                    return false;
                }

                continue;
            }


            // Ингредиент указан, но слот пустой.
            if (stack.isEmpty()) {
                return false;
            }


            // Проверяем предмет.
            if (!ingredient.test(stack)) {
                return false;
            }
        }

        return true;
    }


    @Override
    public ItemStack assemble(
        CWRecipeInput input,
        HolderLookup.Provider registries
    ) {
        return result.copy();
    }


    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }


    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }


    @Override
    public RecipeSerializer<? extends Recipe<CWRecipeInput>> getSerializer() {
        return switch (type.toString()) {
            default -> {
                if (type == CWRecipeTypes.CW_RECIPE_TYPE.get()) {
                    yield CWRecipeTypes.CW_RECIPE_SERIALIZER.get();
                }

                if (type == CWRecipeTypes.MAGE_RECIPE_TYPE.get()) {
                    yield CWRecipeTypes.MAGE_RECIPE_SERIALIZER.get();
                }

                if (type == CWRecipeTypes.WARRIOR_RECIPE_TYPE.get()) {
                    yield CWRecipeTypes.WARRIOR_RECIPE_SERIALIZER.get();
                }

                throw new IllegalStateException(
                    "Unknown CW recipe type: " + type
                );
            }
        };
    }


    @Override
    public RecipeType<? extends Recipe<CWRecipeInput>> getType() {
        return type;
    }
}