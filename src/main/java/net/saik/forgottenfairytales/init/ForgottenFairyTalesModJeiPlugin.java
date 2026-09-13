package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.jei_recipes.*;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.List;

@JeiPlugin
public class ForgottenFairyTalesModJeiPlugin implements IModPlugin {
	public static IRecipeType<WarriorTableJEIRecipe> WarriorTableJEI_Type = IRecipeType.create(WarriorTableJEIRecipeCategory.UID, WarriorTableJEIRecipe.class);
	public static IRecipeType<ConstructorsWorkbenchJeiRecipe> ConstructorsWorkbenchJei_Type = IRecipeType.create(ConstructorsWorkbenchJeiRecipeCategory.UID, ConstructorsWorkbenchJeiRecipe.class);
	public static IRecipeType<MageTableJeiRecipe> MageTableJei_Type = IRecipeType.create(MageTableJeiRecipeCategory.UID, MageTableJeiRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("forgotten_fairy_tales:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new WarriorTableJEIRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ConstructorsWorkbenchJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new MageTableJeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		List<WarriorTableJEIRecipe> WarriorTableJEIRecipes = ForgottenFairyTalesModRecipeTypes.recipes.byType(WarriorTableJEIRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(WarriorTableJEI_Type, WarriorTableJEIRecipes);
		List<ConstructorsWorkbenchJeiRecipe> ConstructorsWorkbenchJeiRecipes = ForgottenFairyTalesModRecipeTypes.recipes.byType(ConstructorsWorkbenchJeiRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(ConstructorsWorkbenchJei_Type, ConstructorsWorkbenchJeiRecipes);
		List<MageTableJeiRecipe> MageTableJeiRecipes = ForgottenFairyTalesModRecipeTypes.recipes.byType(MageTableJeiRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(MageTableJei_Type, MageTableJeiRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addCraftingStations(WarriorTableJEI_Type, VanillaTypes.ITEM_STACK, List.of(new ItemStack(ForgottenFairyTalesModBlocks.WARRIORS_FORGE.get().asItem())));
		registration.addCraftingStations(ConstructorsWorkbenchJei_Type, VanillaTypes.ITEM_STACK, List.of(new ItemStack(ForgottenFairyTalesModBlocks.CONSTRUCTOR_SWORKBENCH.get().asItem())));
		registration.addCraftingStations(MageTableJei_Type, VanillaTypes.ITEM_STACK, List.of(new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get().asItem())));
	}
}