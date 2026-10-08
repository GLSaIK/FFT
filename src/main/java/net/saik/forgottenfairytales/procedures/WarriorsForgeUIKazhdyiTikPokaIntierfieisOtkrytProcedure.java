package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.CWRecipeInput;
import net.saik.forgottenfairytales.jei_recipes.WarriorTableJEIRecipe;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMenus;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WarriorsForgeUIKazhdyiTikPokaIntierfieisOtkrytProcedure {

    public static void execute(Entity entity) {

        if (!(entity instanceof net.minecraft.server.level.ServerPlayer player)) {
            return;
        }

        if (!(player.containerMenu instanceof ForgottenFairyTalesModMenus.MenuAccessor menu)) {
            return;
        }

        // Количество входных слотов
        int slotCount = 11;

        ItemStack[] items = new ItemStack[slotCount];

        for (int i = 0; i < slotCount; i++) {
            items[i] = menu.getSlots().get(i).getItem().copy();
        }

        CWRecipeInput input = new CWRecipeInput(items);

		var recipes = player.level().recipeAccess()
		    .recipeMap()
		    .byType(WarriorTableJEIRecipe.Type.INSTANCE);

        ItemStack result = ItemStack.EMPTY;

        for (var holder : recipes) {

            if (holder.value().matches(input, player.level())) {

                result = holder.value().assemble(
                    input,
                    player.level().registryAccess()
                );

                break;
            }
        }

        // Следующий слот после входных — выходной
        menu.getSlots().get(slotCount).set(result);

        player.containerMenu.broadcastChanges();
    }
}