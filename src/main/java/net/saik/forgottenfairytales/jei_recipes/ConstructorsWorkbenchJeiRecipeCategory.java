package net.saik.forgottenfairytales.jei_recipes;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModJeiPlugin;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;

public class ConstructorsWorkbenchJeiRecipeCategory implements IRecipeCategory<ConstructorsWorkbenchJeiRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("forgotten_fairy_tales:constructors_workbench_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("forgotten_fairy_tales:textures/screens/constructors_workbench_ui_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	private final Minecraft mc = Minecraft.getInstance();

	public ConstructorsWorkbenchJeiRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 105);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ForgottenFairyTalesModBlocks.CONSTRUCTOR_SWORKBENCH.get().asItem()));
	}

	@Override
	public IRecipeType<ConstructorsWorkbenchJeiRecipe> getRecipeType() {
		return ForgottenFairyTalesModJeiPlugin.ConstructorsWorkbenchJei_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Constructors Workbench Jei");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public boolean needsRecipeBorder() {
		return false;
	}

	@Override
	public void draw(ConstructorsWorkbenchJeiRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ConstructorsWorkbenchJeiRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 9).add(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 9).add(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 9).add(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 115, 9).add(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 27).add(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 27).add(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 27).add(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 27).add(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 115, 27).add(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 45).add(recipe.getIngredients().get(9));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 45).add(recipe.getIngredients().get(10));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 45).add(recipe.getIngredients().get(11));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 63).add(recipe.getIngredients().get(12));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 63).add(recipe.getIngredients().get(13));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 63).add(recipe.getIngredients().get(14));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 63).add(recipe.getIngredients().get(15));
		builder.addSlot(RecipeIngredientRole.INPUT, 115, 63).add(recipe.getIngredients().get(16));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 81).add(recipe.getIngredients().get(17));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 81).add(recipe.getIngredients().get(18));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 81).add(recipe.getIngredients().get(19));
		builder.addSlot(RecipeIngredientRole.INPUT, 115, 81).add(recipe.getIngredients().get(20));
		builder.addSlot(RecipeIngredientRole.INPUT, 7, 45).add(recipe.getIngredients().get(21));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 151, 45).add(actualOutputs.get(0));
	}
}