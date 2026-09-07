/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.world.inventory.*;
import net.saik.forgottenfairytales.network.MenuStateUpdateMessage;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class ForgottenFairyTalesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<KlassuimagMenu>> KLASSUIMAG = REGISTRY.register("klassuimag", () -> IMenuTypeExtension.create(KlassuimagMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KlassuiengMenu>> KLASSUIENG = REGISTRY.register("klassuieng", () -> IMenuTypeExtension.create(KlassuiengMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KlassuibardMenu>> KLASSUIBARD = REGISTRY.register("klassuibard", () -> IMenuTypeExtension.create(KlassuibardMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<KlassuivoinMenu>> KLASSUIVOIN = REGISTRY.register("klassuivoin", () -> IMenuTypeExtension.create(KlassuivoinMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<HatguiMenu>> HATGUI = REGISTRY.register("hatgui", () -> IMenuTypeExtension.create(HatguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DebugintMenu>> DEBUGINT = REGISTRY.register("debugint", () -> IMenuTypeExtension.create(DebugintMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BarelickuiMenu>> BARELICKUI = REGISTRY.register("barelickui", () -> IMenuTypeExtension.create(BarelickuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ConstructorsWorkbenchUIMenu>> CONSTRUCTORS_WORKBENCH_UI = REGISTRY.register("constructors_workbench_ui", () -> IMenuTypeExtension.create(ConstructorsWorkbenchUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MagetableuiMenu>> MAGETABLEUI = REGISTRY.register("magetableui", () -> IMenuTypeExtension.create(MagetableuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<WarriorsForgeUIMenu>> WARRIORS_FORGE_UI = REGISTRY.register("warriors_forge_ui", () -> IMenuTypeExtension.create(WarriorsForgeUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BasketUIMenu>> BASKET_UI = REGISTRY.register("basket_ui", () -> IMenuTypeExtension.create(BasketUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CartridgePouchUIMenu>> CARTRIDGE_POUCH_UI = REGISTRY.register("cartridge_pouch_ui", () -> IMenuTypeExtension.create(CartridgePouchUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BigBlastFurnaceGUIMenu>> BIG_BLAST_FURNACE_GUI = REGISTRY.register("big_blast_furnace_gui", () -> IMenuTypeExtension.create(BigBlastFurnaceGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof ForgottenFairyTalesModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				ClientPacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}