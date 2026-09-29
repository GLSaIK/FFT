package net.saik.forgottenfairytales.jei_recipes;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;

import java.util.List;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;

public record ConstructorsWorkbenchJeiRecipe(
    List<ItemStack> outputs,
    List<Ingredient> recipeItems
) implements Recipe<RecipeInput> {

    public ConstructorsWorkbenchJeiRecipe(
        List<ItemStack> outputs,
        List<Ingredient> recipeItems
    ) {
        this.outputs = outputs;
        this.recipeItems = recipeItems;
    }


    /*
     * Порядок ингредиентов в JEI:
     *
     * 0 -> слот 1
     * 1 -> слот 2
     * 2 -> слот 3
     * ...
     * N-2 -> слот N-1
     * N-1 -> слот 0
     *
     * Поэтому последний элемент JSON относится
     * к реальному слоту 0.
     */


    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }


    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.recipeItems);
    }


    @Override
    public boolean matches(
        RecipeInput input,
        Level level
    ) {

        if (input.size() != recipeItems.size()) {
            return false;
        }

        for (int i = 0; i < recipeItems.size(); i++) {

            Ingredient ingredient = recipeItems.get(i);

            // Последний ингредиент JEI находится в слоте 0.
            // Остальные идут в слоты 1, 2, 3...
            int actualSlot;

            if (i == recipeItems.size() - 1) {
                actualSlot = 0;
            } else {
                actualSlot = i + 1;
            }

            ItemStack stack = input.getItem(actualSlot);


            // Пустой слот
            if (isEmptyIngredient(ingredient)) {

                if (!stack.isEmpty()) {
                    return false;
                }

                continue;
            }


            // Обычный ингредиент
            if (!ingredient.test(stack)) {
                return false;
            }
        }

        return true;
    }


    private static boolean isEmptyIngredient(Ingredient ingredient) {

        return ingredient.items()
            .findFirst()
            .map(holder -> holder.value() == Items.AIR)
            .orElse(true);
    }


    @Override
    public ItemStack assemble(
        RecipeInput input,
        HolderLookup.Provider holder
    ) {

        if (outputs.isEmpty()) {
            return ItemStack.EMPTY;
        }

        return outputs.get(0).copy();
    }


    public List<Ingredient> getIngredients() {
        return recipeItems;
    }


    public List<ItemStack> getResultItems() {
        return outputs;
    }


    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return Type.INSTANCE;
    }


    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }


    public static class Type
        implements RecipeType<ConstructorsWorkbenchJeiRecipe> {

        private Type() {
        }

        public static final RecipeType<ConstructorsWorkbenchJeiRecipe> INSTANCE =
            new Type();
    }


    public static class Serializer
        implements RecipeSerializer<ConstructorsWorkbenchJeiRecipe> {

        public static final Serializer INSTANCE =
            new Serializer();


        private static final MapCodec<ConstructorsWorkbenchJeiRecipe> CODEC =
            RecordCodecBuilder.mapCodec(builder ->
                builder.group(

                    ItemStack.OPTIONAL_CODEC
                        .listOf()
                        .fieldOf("outputs")
                        .forGetter(
                            ConstructorsWorkbenchJeiRecipe::outputs
                        ),

                    Ingredient.CODEC
                        .listOf()
                        .fieldOf("ingredients")
                        .forGetter(
                            ConstructorsWorkbenchJeiRecipe::recipeItems
                        )

                ).apply(
                    builder,
                    ConstructorsWorkbenchJeiRecipe::new
                )
            );


        public static final StreamCodec<
            RegistryFriendlyByteBuf,
            ConstructorsWorkbenchJeiRecipe
        > STREAM_CODEC =
            StreamCodec.of(
                Serializer::toNetwork,
                Serializer::fromNetwork
            );


        @Override
        public MapCodec<ConstructorsWorkbenchJeiRecipe> codec() {
            return CODEC;
        }


        @Override
        public StreamCodec<
            RegistryFriendlyByteBuf,
            ConstructorsWorkbenchJeiRecipe
        > streamCodec() {
            return STREAM_CODEC;
        }


        private static ConstructorsWorkbenchJeiRecipe fromNetwork(
            RegistryFriendlyByteBuf buf
        ) {

            List<Ingredient> inputs =
                NonNullList.withSize(
                    buf.readVarInt(),
                    EmptyIngredient.create()
                );

            inputs.replaceAll(
                ingredient ->
                    Ingredient.CONTENTS_STREAM_CODEC.decode(buf)
            );


            List<ItemStack> outputs =
                NonNullList.withSize(
                    buf.readVarInt(),
                    ItemStack.EMPTY
                );

            outputs.replaceAll(
                result ->
                    ItemStack.STREAM_CODEC.decode(buf)
            );


            return new ConstructorsWorkbenchJeiRecipe(
                outputs,
                inputs
            );
        }


        private static void toNetwork(
            RegistryFriendlyByteBuf buf,
            ConstructorsWorkbenchJeiRecipe recipe
        ) {

            buf.writeVarInt(
                recipe.getIngredients().size()
            );


            for (Ingredient ingredient :
                recipe.getIngredients()) {

                if (
                    ingredient.items()
                        .findFirst()
                        .map(holder ->
                            holder.value() == Items.AIR
                        )
                        .orElse(true)
                ) {

                    Ingredient.CONTENTS_STREAM_CODEC.encode(
                        buf,
                        EmptyIngredient.create()
                    );

                } else {

                    Ingredient.CONTENTS_STREAM_CODEC.encode(
                        buf,
                        ingredient
                    );
                }
            }


            buf.writeVarInt(
                recipe.getResultItems().size()
            );


            for (ItemStack itemStack :
                recipe.getResultItems()) {

                ItemStack.STREAM_CODEC.encode(
                    buf,
                    itemStack
                );
            }
        }
    }
}