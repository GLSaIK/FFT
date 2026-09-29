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

public record MageTableJeiRecipe(
    List<ItemStack> outputs,
    List<Ingredient> recipeItems
) implements Recipe<RecipeInput> {

    public MageTableJeiRecipe(
        List<ItemStack> outputs,
        List<Ingredient> recipeItems
    ) {
        this.outputs = outputs;
        this.recipeItems = recipeItems;
    }


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

            /*
             * JEI:
             *
             * ingredients[0] -> slot 1
             * ingredients[1] -> slot 2
             * ...
             * ingredients[N-2] -> slot N-1
             * ingredients[N-1] -> slot 0
             */

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
        implements RecipeType<MageTableJeiRecipe> {

        private Type() {
        }

        public static final RecipeType<MageTableJeiRecipe> INSTANCE =
            new Type();
    }


    public static class Serializer
        implements RecipeSerializer<MageTableJeiRecipe> {

        public static final Serializer INSTANCE =
            new Serializer();


        private static final MapCodec<MageTableJeiRecipe> CODEC =
            RecordCodecBuilder.mapCodec(builder ->
                builder.group(

                    ItemStack.OPTIONAL_CODEC
                        .listOf()
                        .fieldOf("outputs")
                        .forGetter(
                            MageTableJeiRecipe::outputs
                        ),

                    Ingredient.CODEC
                        .listOf()
                        .fieldOf("ingredients")
                        .forGetter(
                            MageTableJeiRecipe::recipeItems
                        )

                ).apply(
                    builder,
                    MageTableJeiRecipe::new
                )
            );


        public static final StreamCodec<
            RegistryFriendlyByteBuf,
            MageTableJeiRecipe
        > STREAM_CODEC =
            StreamCodec.of(
                Serializer::toNetwork,
                Serializer::fromNetwork
            );


        @Override
        public MapCodec<MageTableJeiRecipe> codec() {
            return CODEC;
        }


        @Override
        public StreamCodec<
            RegistryFriendlyByteBuf,
            MageTableJeiRecipe
        > streamCodec() {
            return STREAM_CODEC;
        }


        private static MageTableJeiRecipe fromNetwork(
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


            return new MageTableJeiRecipe(
                outputs,
                inputs
            );
        }


        private static void toNetwork(
            RegistryFriendlyByteBuf buf,
            MageTableJeiRecipe recipe
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