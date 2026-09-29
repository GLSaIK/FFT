/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.client.gui.*;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class ForgottenFairyTalesModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ForgottenFairyTalesModMenus.KLASSUIMAG.get(), KlassuimagScreen::new);
		event.register(ForgottenFairyTalesModMenus.KLASSUIENG.get(), KlassuiengScreen::new);
		event.register(ForgottenFairyTalesModMenus.KLASSUIBARD.get(), KlassuibardScreen::new);
		event.register(ForgottenFairyTalesModMenus.KLASSUIVOIN.get(), KlassuivoinScreen::new);
		event.register(ForgottenFairyTalesModMenus.HATGUI.get(), HatguiScreen::new);
		event.register(ForgottenFairyTalesModMenus.DEBUGINT.get(), DebugintScreen::new);
		event.register(ForgottenFairyTalesModMenus.BARELICKUI.get(), BarelickuiScreen::new);
		event.register(ForgottenFairyTalesModMenus.CONSTRUCTORS_WORKBENCH_UI.get(), ConstructorsWorkbenchUIScreen::new);
		event.register(ForgottenFairyTalesModMenus.MAGETABLEUI.get(), MagetableuiScreen::new);
		event.register(ForgottenFairyTalesModMenus.WARRIORS_FORGE_UI.get(), WarriorsForgeUIScreen::new);
		event.register(ForgottenFairyTalesModMenus.BASKET_UI.get(), BasketUIScreen::new);
		event.register(ForgottenFairyTalesModMenus.CARTRIDGE_POUCH_UI.get(), CartridgePouchUIScreen::new);
		event.register(ForgottenFairyTalesModMenus.BIG_BLAST_FURNACE_GUI.get(), BigBlastFurnaceGUIScreen::new);
		event.register(ForgottenFairyTalesModMenus.CHANGE_TABLE_GUI.get(), ChangeTableGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}