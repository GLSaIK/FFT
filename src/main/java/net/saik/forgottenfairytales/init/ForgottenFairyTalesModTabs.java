/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class ForgottenFairyTalesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WARRIOR = REGISTRY.register("warrior",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.forgotten_fairy_tales.warrior")).icon(() -> new ItemStack(ForgottenFairyTalesModItems.PRAHVOIN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ForgottenFairyTalesModItems.PRAHVOIN.get());
				tabData.accept(ForgottenFairyTalesModItems.SWORDVOIN.get());
				tabData.accept(ForgottenFairyTalesModItems.BOOK.get());
				tabData.accept(ForgottenFairyTalesModItems.WARRIORDRINK.get());
				tabData.accept(ForgottenFairyTalesModItems.STEEL_BONE_BOW.get());
				tabData.accept(ForgottenFairyTalesModItems.BUNCH_OF_ARROWS.get());
				tabData.accept(ForgottenFairyTalesModItems.TOURNIQUET.get());
				tabData.accept(ForgottenFairyTalesModBlocks.WARRIORS_FORGE.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.UNDEAD_HUNTER_SWORD.get());
				tabData.accept(ForgottenFairyTalesModItems.BREAM.get());
				tabData.accept(ForgottenFairyTalesModItems.FLAGELLANTS_CHESTPLATE_CHESTPLATE.get());
				tabData.accept(ForgottenFairyTalesModItems.SCABBARD.get());
				tabData.accept(ForgottenFairyTalesModItems.GOLDEN_SADDLE.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAGE = REGISTRY.register("mage",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.forgotten_fairy_tales.mage")).icon(() -> new ItemStack(ForgottenFairyTalesModItems.PRAHMAG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ForgottenFairyTalesModItems.PRAHMAG.get());
				tabData.accept(ForgottenFairyTalesModItems.PULTA.get());
				tabData.accept(ForgottenFairyTalesModItems.HAT_HELMET.get());
				tabData.accept(ForgottenFairyTalesModItems.MULTITOOL.get());
				tabData.accept(ForgottenFairyTalesModBlocks.MAGETABLE.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.GLASS_SWORD.get());
				tabData.accept(ForgottenFairyTalesModItems.CURSED_MAGIC_LAUNCHER.get());
				tabData.accept(ForgottenFairyTalesModItems.RUNE_OF_PROTECTION.get());
				tabData.accept(ForgottenFairyTalesModItems.RITUAL_KNIFE.get());
			}).withTabsBefore(WARRIOR.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ENGINEER = REGISTRY.register("engineer",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.forgotten_fairy_tales.engineer")).icon(() -> new ItemStack(ForgottenFairyTalesModItems.PRAHENG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ForgottenFairyTalesModItems.PRAHENG.get());
				tabData.accept(ForgottenFairyTalesModItems.BROKENTELEPORT.get());
				tabData.accept(ForgottenFairyTalesModItems.BULLETSHOTGUN.get());
				tabData.accept(ForgottenFairyTalesModItems.SHOTGUN.get());
				tabData.accept(ForgottenFairyTalesModItems.NEWAGEPICKAXE.get());
				tabData.accept(ForgottenFairyTalesModItems.NEWAGEAXE.get());
				tabData.accept(ForgottenFairyTalesModItems.NEWAGESHOVEL.get());
				tabData.accept(ForgottenFairyTalesModItems.GAGARINHAMMER.get());
				tabData.accept(ForgottenFairyTalesModItems.WELDINGMASK_HELMET.get());
				tabData.accept(ForgottenFairyTalesModBlocks.CONSTRUCTOR_SWORKBENCH.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.CARTRIDGE_POUCH.get());
				tabData.accept(ForgottenFairyTalesModItems.BFS.get());
				tabData.accept(ForgottenFairyTalesModItems.SOLDIER_CHOCOLATE.get());
				tabData.accept(ForgottenFairyTalesModItems.SOLDIER_CHOCOLATE_OPENED.get());
				tabData.accept(ForgottenFairyTalesModItems.FIRECLAY_BRICK.get());
				tabData.accept(ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.BINOCULARS.get());
			}).withTabsBefore(MAGE.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD = REGISTRY.register("food",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.forgotten_fairy_tales.food")).icon(() -> new ItemStack(ForgottenFairyTalesModItems.TARTAR.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ForgottenFairyTalesModItems.TARTAR.get());
				tabData.accept(ForgottenFairyTalesModItems.NUTRIENTBLOCK.get());
				tabData.accept(ForgottenFairyTalesModItems.BERRYDELIGHT.get());
				tabData.accept(ForgottenFairyTalesModItems.CHEESE.get());
				tabData.accept(ForgottenFairyTalesModItems.MILKWITHENZYMES.get());
				tabData.accept(ForgottenFairyTalesModItems.JULIENNE.get());
				tabData.accept(ForgottenFairyTalesModItems.SUNSHAKE.get());
				tabData.accept(ForgottenFairyTalesModItems.WAFFLE.get());
				tabData.accept(ForgottenFairyTalesModItems.ICECREAM.get());
				tabData.accept(ForgottenFairyTalesModItems.ROASTEDBONE.get());
				tabData.accept(ForgottenFairyTalesModItems.DECANTEROFBERRYCOMPOTE.get());
				tabData.accept(ForgottenFairyTalesModItems.DECANTEROFAPPLEJUICE.get());
				tabData.accept(ForgottenFairyTalesModItems.PICNIC_BASKET.get());
				tabData.accept(ForgottenFairyTalesModItems.BERRY_BREAD.get());
				tabData.accept(ForgottenFairyTalesModItems.CHOKOLATTE.get());
				tabData.accept(ForgottenFairyTalesModItems.BLOOD_SOUP.get());
				tabData.accept(ForgottenFairyTalesModItems.SALT.get());
			}).withTabsBefore(ENGINEER.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FFFT = REGISTRY.register("ffft",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.forgotten_fairy_tales.ffft")).icon(() -> new ItemStack(ForgottenFairyTalesModItems.HAT_HELMET.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ForgottenFairyTalesModItems.DROP.get());
				tabData.accept(ForgottenFairyTalesModBlocks.VASA.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.REINFORCED_ROPE.get());
				tabData.accept(ForgottenFairyTalesModBlocks.LIVINGSTONE.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.IRONROD.get());
				tabData.accept(ForgottenFairyTalesModItems.BARELIK_SPAWN_EGG.get());
				tabData.accept(ForgottenFairyTalesModItems.ANIMATINGMATTERLIFE.get());
				tabData.accept(ForgottenFairyTalesModItems.IRON_PLATE.get());
				tabData.accept(ForgottenFairyTalesModBlocks.L_IVING_FRAGMENT.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.SALT_BLOCK.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.LORE_VASE.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.STRAUSINGOEGG.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.STRAUSINGO_SPAWN_EGG.get());
				tabData.accept(ForgottenFairyTalesModItems.EGG_SHARD.get());
				tabData.accept(ForgottenFairyTalesModItems.ZGUTIK_SPAWN_EGG.get());
				tabData.accept(ForgottenFairyTalesModBlocks.IRON_PLATE_BLOCK.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.SALT_BLOCK_PRESSED.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.SMOKE_PIPE.get().asItem());
				tabData.accept(ForgottenFairyTalesModBlocks.PYRITE.get().asItem());
				tabData.accept(ForgottenFairyTalesModItems.PYRITE_ORE.get());
				tabData.accept(ForgottenFairyTalesModBlocks.SMOKE_PIPE_CORNERED.get().asItem());
			}).withTabsBefore(FOOD.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(ForgottenFairyTalesModBlocks.CHAR_COAL_BLOCK.get().asItem());
			tabData.accept(ForgottenFairyTalesModBlocks.RAW_PYRITE_BLOCK.get().asItem());
		}
	}
}