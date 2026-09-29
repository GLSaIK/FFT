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

public record WarriorTableJEIRecipe(
    List<ItemStack> outputs,
    List<Ingredient> recipeItems
) implements Recipe<RecipeInput> {

    public WarriorTableJEIRecipe(
        List<ItemStack> outputs,
        List<Ingredient> recipeItems
    ) {
        this.outputs = outputs;
        this.recipeItems = recipeItems;
    }


    // =========================================================
    // JEI
    // =========================================================

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }


    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.recipeItems);
    }


    // =========================================================
    // RECIPE MATCHING
    // =========================================================

		private static final int[] SLOT_MAPPING = {
		    1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10
		};
		
		@Override
		public boolean matches(
		    RecipeInput input,
		    Level level
		) {
		
		    if (input.size() != SLOT_MAPPING.length) {
		        return false;
		    }
		
		    for (int i = 0; i < recipeItems.size(); i++) {
		
		        Ingredient ingredient = recipeItems.get(i);
		
		        // i — позиция в JSON
		        // SLOT_MAPPING[i] — настоящий ID слота стола
		        int actualSlot = SLOT_MAPPING[i];
		
		        ItemStack stack = input.getItem(actualSlot);
		
		        if (isEmptyIngredient(ingredient)) {
		
		            if (!stack.isEmpty()) {
		                return false;
		            }
		
		            continue;
		        }
		
		        if (!ingredient.test(stack)) {
		            return false;
		        }
		    }
		
		    return true;
		}


    /**
     * Проверяет, является ли Ingredient специальным
     * пустым ингредиентом JEI.
     *
     * В JSON это:
     *
     * #forgotten_fairy_tales:jei_empty_tag
     *
     * После загрузки Ingredient содержит Items.AIR.
     */
    private static boolean isEmptyIngredient(Ingredient ingredient) {

        return ingredient.items()
            .findFirst()
            .map(holder -> holder.value() == Items.AIR)
            .orElse(true);
    }


    // =========================================================
    // RECIPE RESULT
    // =========================================================

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


    // =========================================================
    // GETTERS
    // =========================================================

    public List<Ingredient> getIngredients() {
        return recipeItems;
    }


    public List<ItemStack> getResultItems() {
        return outputs;
    }


    // =========================================================
    // RECIPE TYPE
    // =========================================================

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return Type.INSTANCE;
    }


    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }


    // =========================================================
    // RECIPE TYPE REGISTRATION
    // =========================================================

    public static class Type
        implements RecipeType<WarriorTableJEIRecipe> {

        private Type() {
        }

        public static final RecipeType<WarriorTableJEIRecipe> INSTANCE =
            new Type();
    }


    // =========================================================
    // SERIALIZER
    // =========================================================

    public static class Serializer
        implements RecipeSerializer<WarriorTableJEIRecipe> {

        public static final Serializer INSTANCE =
            new Serializer();


        private static final MapCodec<WarriorTableJEIRecipe> CODEC =
            RecordCodecBuilder.mapCodec(builder ->
                builder.group(

                    ItemStack.OPTIONAL_CODEC
                        .listOf()
                        .fieldOf("outputs")
                        .forGetter(
                            WarriorTableJEIRecipe::outputs
                        ),

                    Ingredient.CODEC
                        .listOf()
                        .fieldOf("ingredients")
                        .forGetter(
                            WarriorTableJEIRecipe::recipeItems
                        )

                ).apply(
                    builder,
                    WarriorTableJEIRecipe::new
                )
            );


        public static final StreamCodec<
            RegistryFriendlyByteBuf,
            WarriorTableJEIRecipe
        > STREAM_CODEC =
            StreamCodec.of(
                Serializer::toNetwork,
                Serializer::fromNetwork
            );


        @Override
        public MapCodec<WarriorTableJEIRecipe> codec() {
            return CODEC;
        }


        @Override
        public StreamCodec<
            RegistryFriendlyByteBuf,
            WarriorTableJEIRecipe
        > streamCodec() {
            return STREAM_CODEC;
        }


        // =====================================================
        // NETWORK → RECIPE
        // =====================================================

        private static WarriorTableJEIRecipe fromNetwork(
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


            return new WarriorTableJEIRecipe(
                outputs,
                inputs
            );
        }


        // =====================================================
        // RECIPE → NETWORK
        // =====================================================

        private static void toNetwork(
            RegistryFriendlyByteBuf buf,
            WarriorTableJEIRecipe recipe
        ) {

            buf.writeVarInt(
                recipe.getIngredients().size()
            );


            for (Ingredient ingredient :
                recipe.getIngredients()) {

                /*
                 * JEI использует Items.AIR как обозначение
                 * пустого слота.
                 *
                 * На клиент отправляем нормальный
                 * EmptyIngredient.
                 */

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