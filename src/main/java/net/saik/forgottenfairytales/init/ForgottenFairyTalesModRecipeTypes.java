package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.jei_recipes.WarriorTableJEIRecipe;
import net.saik.forgottenfairytales.jei_recipes.MageTableJeiRecipe;
import net.saik.forgottenfairytales.jei_recipes.ConstructorsWorkbenchJeiRecipe;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeMap;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber
public class ForgottenFairyTalesModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "forgotten_fairy_tales");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "forgotten_fairy_tales");
	public static RecipeMap recipes = null;

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("forgotten_fairy_tales").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("warrior_table_jei", () -> WarriorTableJEIRecipe.Type.INSTANCE);
			SERIALIZERS.register("warrior_table_jei", () -> WarriorTableJEIRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("constructors_workbench_jei", () -> ConstructorsWorkbenchJeiRecipe.Type.INSTANCE);
			SERIALIZERS.register("constructors_workbench_jei", () -> ConstructorsWorkbenchJeiRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("mage_table_jei", () -> MageTableJeiRecipe.Type.INSTANCE);
			SERIALIZERS.register("mage_table_jei", () -> MageTableJeiRecipe.Serializer.INSTANCE);
		});
	}

	@SubscribeEvent
	public static void syncRecipes(OnDatapackSyncEvent event) {
		event.sendRecipes(WarriorTableJEIRecipe.Type.INSTANCE);
		event.sendRecipes(ConstructorsWorkbenchJeiRecipe.Type.INSTANCE);
		event.sendRecipes(MageTableJeiRecipe.Type.INSTANCE);
	}

	@EventBusSubscriber(value = Dist.CLIENT)
	public static class RecipeReceiver {
		@SubscribeEvent
		public static void receiveRecipes(RecipesReceivedEvent event) {
			recipes = event.getRecipeMap();
		}

		@SubscribeEvent
		public static void clearRecipes(ClientPlayerNetworkEvent.LoggingOut event) {
			recipes = null;
		}
	}
}