package net.saik.forgottenfairytales;

import com.mojang.serialization.MapCodec;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CWRecipeSerializer implements RecipeSerializer<CWRecipeT> {

    private final Supplier<RecipeType<CWRecipeT>> recipeType;
    private final int slotCount;

    private final MapCodec<CWRecipeT> codec;

    private final StreamCodec<
        RegistryFriendlyByteBuf,
        CWRecipeT
    > streamCodec;


    public CWRecipeSerializer(
        Supplier<RecipeType<CWRecipeT>> recipeType,
        int slotCount
    ) {
        this.recipeType = recipeType;
        this.slotCount = slotCount;

        this.codec = CWRecipeT.createCodec(
            recipeType.get(),
            slotCount
        );

        this.streamCodec = StreamCodec.composite(

            INGREDIENTS_STREAM_CODEC,
            CWRecipeT::getIngredients,

            ItemStack.STREAM_CODEC,
            CWRecipeT::getResult,

            (ingredients, result) ->
                new CWRecipeT(
                    ingredients,
                    result,
                    recipeType.get(),
                    slotCount
                )
        );
    }


    private static final StreamCodec<
        RegistryFriendlyByteBuf,
        Map<Integer, Ingredient>
    > INGREDIENTS_STREAM_CODEC = StreamCodec.of(

        (buf, map) -> {

            buf.writeVarInt(map.size());

            for (Map.Entry<Integer, Ingredient> entry : map.entrySet()) {

                buf.writeVarInt(entry.getKey());

                Ingredient.CONTENTS_STREAM_CODEC.encode(
                    buf,
                    entry.getValue()
                );
            }
        },

        buf -> {

            int size = buf.readVarInt();

            Map<Integer, Ingredient> map =
                new HashMap<>();

            for (int i = 0; i < size; i++) {

                int slot = buf.readVarInt();

                Ingredient ingredient =
                    Ingredient.CONTENTS_STREAM_CODEC.decode(buf);

                map.put(slot, ingredient);
            }

            return map;
        }
    );


    @Override
    public MapCodec<CWRecipeT> codec() {
        return codec;
    }


    @Override
    public StreamCodec<RegistryFriendlyByteBuf, CWRecipeT> streamCodec() {
        return streamCodec;
    }
}