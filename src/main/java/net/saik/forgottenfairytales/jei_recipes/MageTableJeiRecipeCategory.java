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

public class MageTableJeiRecipeCategory implements IRecipeCategory<MageTableJeiRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("forgotten_fairy_tales:mage_table_jei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("forgotten_fairy_tales:textures/screens/magetableui_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	private final Minecraft mc = Minecraft.getInstance();

	public MageTableJeiRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 110);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ForgottenFairyTalesModBlocks.MAGETABLE.get().asItem()));
	}

	@Override
	public IRecipeType<MageTableJeiRecipe> getRecipeType() {
		return ForgottenFairyTalesModJeiPlugin.MageTableJei_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Mage Table Jei");
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
	public void draw(MageTableJeiRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, MageTableJeiRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(1, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 11).add(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 29).add(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 29).add(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 29).add(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 43, 47).add(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 47).add(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 47).add(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 47).add(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 115, 47).add(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.INPUT, 61, 65).add(recipe.getIngredients().get(9));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 65).add(recipe.getIngredients().get(10));
		builder.addSlot(RecipeIngredientRole.INPUT, 97, 65).add(recipe.getIngredients().get(11));
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 83).add(recipe.getIngredients().get(12));
		builder.addSlot(RecipeIngredientRole.INPUT, 7, 47).add(recipe.getIngredients().get(13));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 151, 47).add(actualOutputs.get(0));
	}
}