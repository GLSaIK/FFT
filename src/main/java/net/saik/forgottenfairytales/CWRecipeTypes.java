package net.saik.forgottenfairytales;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CWRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
        DeferredRegister.create(
            Registries.RECIPE_TYPE,
            ForgottenFairyTalesMod.MODID
        );

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
        DeferredRegister.create(
            Registries.RECIPE_SERIALIZER,
            ForgottenFairyTalesMod.MODID
        );


    // =========================================================
    // CONSTRUCTORS WORKBENCH
    // =========================================================

    public static final Supplier<RecipeType<CWRecipeT>> CW_RECIPE_TYPE =
        RECIPE_TYPES.register(
            "constructors_workbench",
            () -> RecipeType.simple(
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
                    ForgottenFairyTalesMod.MODID,
                    "constructors_workbench"
                )
            )
        );

    public static final Supplier<RecipeSerializer<CWRecipeT>> CW_RECIPE_SERIALIZER =
        RECIPE_SERIALIZERS.register(
            "constructors_workbench",
            () -> new CWRecipeSerializer(
                CW_RECIPE_TYPE,
                22
            )
        );


    // =========================================================
    // MAGE TABLE
    // =========================================================

    public static final Supplier<RecipeType<CWRecipeT>> MAGE_RECIPE_TYPE =
        RECIPE_TYPES.register(
            "mage_table",
            () -> RecipeType.simple(
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
                    ForgottenFairyTalesMod.MODID,
                    "mage_table"
                )
            )
        );

    public static final Supplier<RecipeSerializer<CWRecipeT>> MAGE_RECIPE_SERIALIZER =
        RECIPE_SERIALIZERS.register(
            "mage_table",
            () -> new CWRecipeSerializer(
                MAGE_RECIPE_TYPE,
                14
            )
        );


    // =========================================================
    // WARRIOR TABLE
    // =========================================================

    public static final Supplier<RecipeType<CWRecipeT>> WARRIOR_RECIPE_TYPE =
        RECIPE_TYPES.register(
            "warrior_table",
            () -> RecipeType.simple(
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
                    ForgottenFairyTalesMod.MODID,
                    "warrior_table"
                )
            )
        );

    public static final Supplier<RecipeSerializer<CWRecipeT>> WARRIOR_RECIPE_SERIALIZER =
        RECIPE_SERIALIZERS.register(
            "warrior_table",
            () -> new CWRecipeSerializer(
                WARRIOR_RECIPE_TYPE,
                11
            )
        );


    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
    }
}