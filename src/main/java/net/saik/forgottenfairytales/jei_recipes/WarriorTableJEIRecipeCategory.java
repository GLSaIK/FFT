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

public class WarriorTableJEIRecipeCategory implements IRecipeCategory<WarriorTableJEIRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("forgotten_fairy_tales:warrior_table_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("forgotten_fairy_tales:textures/screens/warriors_forge_ui_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	private final Minecraft mc = Minecraft.getInstance();

	public WarriorTableJEIRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 90);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ForgottenFairyTalesModBlocks.WARRIORS_FORGE.get().asItem()));
	}

	@Override
	public IRecipeType<WarriorTableJEIRecipe> getRecipeType() {
		return ForgottenFairyTalesModJeiPlugin.WarriorTableJEI_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Warrior Table JEI");
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
	public void draw(WarriorTableJEIRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, WarriorTableJEIRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 20).add(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 20).add(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 98, 20).add(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 38).add(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 38).add(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 98, 38).add(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 62, 56).add(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 80, 56).add(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 98, 56).add(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.INPUT, 17, 38).add(recipe.getIngredients().get(9));
		builder.addSlot(RecipeIngredientRole.INPUT, 125, 56).add(recipe.getIngredients().get(10));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 152, 37).add(actualOutputs.get(0));
	}
}