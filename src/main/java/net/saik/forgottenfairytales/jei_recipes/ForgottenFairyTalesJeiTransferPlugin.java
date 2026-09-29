package net.saik.forgottenfairytales.jei_recipes;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeTransferRegistration;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModJeiPlugin;
import net.saik.forgottenfairytales.world.inventory.ConstructorsWorkbenchUIMenu;
import net.saik.forgottenfairytales.world.inventory.MagetableuiMenu;
import net.saik.forgottenfairytales.world.inventory.WarriorsForgeUIMenu;

import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class ForgottenFairyTalesJeiTransferPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.parse(
            "forgotten_fairy_tales:jei_transfer_plugin"
        );
    }

    @Override
    public void registerRecipeTransferHandlers(
        IRecipeTransferRegistration registration
    ) {

        // ============================================================
        // WARRIOR TABLE
        // ============================================================
        //
        // JEI ingredient order:
        //
        // 0  -> GUI slot 1
        // 1  -> GUI slot 2
        // 2  -> GUI slot 3
        // 3  -> GUI slot 4
        // 4  -> GUI slot 5
        // 5  -> GUI slot 6
        // 6  -> GUI slot 7
        // 7  -> GUI slot 8
        // 8  -> GUI slot 9
        // 9  -> GUI slot 0
        // 10 -> GUI slot 10
        //
        // Player inventory: 12..47
        //

        registration.addRecipeTransferHandler(
            new ForgottenFairyTalesRecipeTransferInfo<>(
                WarriorsForgeUIMenu.class,
                ForgottenFairyTalesModJeiPlugin.WarriorTableJEI_Type,
                new int[] {
                    1, 2, 3, 4, 5,
                    6, 7, 8, 9, 0, 10
                },
                12,
                36
            )
        );


        // ============================================================
        // CONSTRUCTORS WORKBENCH
        // ============================================================
        //
        // JEI ingredient order:
        //
        // 0  -> GUI slot 1
        // 1  -> GUI slot 2
        // ...
        // 20 -> GUI slot 21
        // 21 -> GUI slot 0
        //
        // Player inventory: 23..58
        //

        registration.addRecipeTransferHandler(
            new ForgottenFairyTalesRecipeTransferInfo<>(
                ConstructorsWorkbenchUIMenu.class,
                ForgottenFairyTalesModJeiPlugin.ConstructorsWorkbenchJei_Type,
                new int[] {
                    1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18,
                    19, 20, 21, 0
                },
                23,
                36
            )
        );


        // ============================================================
        // MAGE TABLE
        // ============================================================
        //
        // JEI ingredient order:
        //
        // 0  -> GUI slot 1
        // 1  -> GUI slot 2
        // ...
        // 12 -> GUI slot 13
        // 13 -> GUI slot 0
        //
        // Player inventory: 15..50
        //

        registration.addRecipeTransferHandler(
            new ForgottenFairyTalesRecipeTransferInfo<>(
                MagetableuiMenu.class,
                ForgottenFairyTalesModJeiPlugin.MageTableJei_Type,
                new int[] {
                    1, 2, 3, 4, 5, 6, 7,
                    8, 9, 10, 11, 12, 13, 0
                },
                15,
                36
            )
        );
    }
}