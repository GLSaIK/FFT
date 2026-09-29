/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.item.inventory.PicnicBasketInventoryCapability;
import net.saik.forgottenfairytales.item.inventory.CartridgePouchInventoryCapability;
import net.saik.forgottenfairytales.item.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

@EventBusSubscriber
public class ForgottenFairyTalesModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ForgottenFairyTalesMod.MODID);
	public static final DeferredItem<Item> PRAHVOIN;
	public static final DeferredItem<Item> PRAHMAG;
	public static final DeferredItem<Item> PRAHENG;
	public static final DeferredItem<Item> SWORDVOIN;
	public static final DeferredItem<Item> PULTA;
	public static final DeferredItem<Item> COFFE;
	public static final DeferredItem<Item> BOOK;
	public static final DeferredItem<Item> HAT_HELMET;
	public static final DeferredItem<Item> BROKENTELEPORT;
	public static final DeferredItem<Item> BULLETSHOTGUN;
	public static final DeferredItem<Item> KATANA;
	public static final DeferredItem<Item> NOZNI;
	public static final DeferredItem<Item> COLOMNTR;
	public static final DeferredItem<Item> TROST;
	public static final DeferredItem<Item> TARTAR;
	public static final DeferredItem<Item> NUTRIENTBLOCK;
	public static final DeferredItem<Item> DFHG;
	public static final DeferredItem<Item> DROP;
	public static final DeferredItem<Item> VASA;
	public static final DeferredItem<Item> WARRIORDRINK;
	public static final DeferredItem<Item> WARRIORDRINKBLOCK;
	public static final DeferredItem<Item> STEEL_BONE_BOW;
	public static final DeferredItem<Item> REINFORCED_ROPE;
	public static final DeferredItem<Item> BUNCH_OF_ARROWS;
	public static final DeferredItem<Item> LIVINGSTONE;
	public static final DeferredItem<Item> BERRYDELIGHT;
	public static final DeferredItem<Item> CHEESE;
	public static final DeferredItem<Item> MILKWITHENZYMES;
	public static final DeferredItem<Item> CAULDRONWITHFERMENTEDMILK;
	public static final DeferredItem<Item> CAULDRONEWITHCHEESE;
	public static final DeferredItem<Item> AGRONOMSGLOVE;
	public static final DeferredItem<Item> SHOTGUN;
	public static final DeferredItem<Item> JULIENNE;
	public static final DeferredItem<Item> SUNSHAKE;
	public static final DeferredItem<Item> MULTITOOL;
	public static final DeferredItem<Item> NEWAGEPICKAXE;
	public static final DeferredItem<Item> NEWAGEAXE;
	public static final DeferredItem<Item> NEWAGESHOVEL;
	public static final DeferredItem<Item> WAFFLE;
	public static final DeferredItem<Item> GAGARINHAMMER;
	public static final DeferredItem<Item> IRONROD;
	public static final DeferredItem<Item> ICECREAM;
	public static final DeferredItem<Item> ROASTEDBONE;
	public static final DeferredItem<Item> MILKBOTTLE;
	public static final DeferredItem<Item> CACAO;
	public static final DeferredItem<Item> BEDROCKWITHKATANA;
	public static final DeferredItem<Item> BARELIK_SPAWN_EGG;
	public static final DeferredItem<Item> ANIMATINGMATTERLIFE;
	public static final DeferredItem<Item> WELDINGMASK_HELMET;
	public static final DeferredItem<Item> CONSTRUCTOR_SWORKBENCH;
	public static final DeferredItem<Item> ICESWORDBROKEN;
	public static final DeferredItem<Item> MAGETABLE;
	public static final DeferredItem<Item> GLASS_SWORD;
	public static final DeferredItem<Item> DECANTEROFBERRYCOMPOTE;
	public static final DeferredItem<Item> DECANTEROFAPPLEJUICE;
	public static final DeferredItem<Item> TOURNIQUET;
	public static final DeferredItem<Item> WARRIORS_FORGE;
	public static final DeferredItem<Item> PICNIC_BASKET;
	public static final DeferredItem<Item> IRON_PLATE;
	public static final DeferredItem<Item> UNDEAD_HUNTER_SWORD;
	public static final DeferredItem<Item> CURSED_MAGIC_LAUNCHER;
	public static final DeferredItem<Item> CURSED_FIREBALL_ITEM;
	public static final DeferredItem<Item> BERRY_BREAD;
	public static final DeferredItem<Item> CARTRIDGE_POUCH;
	public static final DeferredItem<Item> CHOKOLATTE;
	public static final DeferredItem<Item> BLOOD_SOUP;
	public static final DeferredItem<Item> RUNE_OF_PROTECTION;
	public static final DeferredItem<Item> L_IVING_FRAGMENT;
	public static final DeferredItem<Item> PRAHZERO;
	public static final DeferredItem<Item> SALT_CRYSTAL_1;
	public static final DeferredItem<Item> SALT_BLOCK;
	public static final DeferredItem<Item> SALT_CRYSTAL_2;
	public static final DeferredItem<Item> SALT_CRYSTAL_3;
	public static final DeferredItem<Item> SALT_CRYSTAL_4;
	public static final DeferredItem<Item> SALT;
	public static final DeferredItem<Item> LORE_VASE;
	public static final DeferredItem<Item> BREAM;
	public static final DeferredItem<Item> STRAUSINGOEGG;
	public static final DeferredItem<Item> STRAUSINGO_SPAWN_EGG;
	public static final DeferredItem<Item> STRAUSINGOFEATHER;
	public static final DeferredItem<Item> EGG_SHARD;
	public static final DeferredItem<Item> BFS;
	public static final DeferredItem<Item> ZGUTIK_SPAWN_EGG;
	public static final DeferredItem<Item> IRON_PLATE_BLOCK;
	public static final DeferredItem<Item> FLAGELLANTS_CHESTPLATE_CHESTPLATE;
	public static final DeferredItem<Item> STRUCTURE_VOID_CLEANER;
	public static final DeferredItem<Item> SOLDIER_CHOCOLATE;
	public static final DeferredItem<Item> SOLDIER_CHOCOLATE_OPENED;
	public static final DeferredItem<Item> SALT_BLOCK_PRESSED;
	public static final DeferredItem<Item> SALT_CRYSTAL_12;
	public static final DeferredItem<Item> SALT_CRYSTAL_22;
	public static final DeferredItem<Item> SALT_CRYSTAL_32;
	public static final DeferredItem<Item> SALT_CRYSTAL_42;
	public static final DeferredItem<Item> SMOKE_PIPE;
	public static final DeferredItem<Item> PYRITE;
	public static final DeferredItem<Item> PYRITE_ORE;
	public static final DeferredItem<Item> SMOKE_PIPE_CORNERED;
	public static final DeferredItem<Item> FIRECLAY_BRICK;
	public static final DeferredItem<Item> FIRECLAY_BRICKS;
	public static final DeferredItem<Item> BIG_BLAST_FURNACE;
	public static final DeferredItem<Item> SULFUR;
	public static final DeferredItem<Item> CHAR_COAL_BLOCK;
	public static final DeferredItem<Item> RAW_PYRITE_BLOCK;
	public static final DeferredItem<Item> SCABBARD;
	public static final DeferredItem<Item> RITUAL_KNIFE;
	public static final DeferredItem<Item> BINOCULARS;
	public static final DeferredItem<Item> GOLDEN_SADDLE;
	public static final DeferredItem<Item> CHANGE_TABLE;
	static {
		PRAHVOIN = register("prahvoin", PrahvoinItem::new);
		PRAHMAG = register("prahmag", PrahmagItem::new);
		PRAHENG = register("praheng", PrahengItem::new);
		SWORDVOIN = register("swordvoin", SwordvoinItem::new);
		PULTA = register("pulta", PultaItem::new);
		COFFE = register("coffe", CoffeItem::new);
		BOOK = register("book", BookItem::new);
		HAT_HELMET = register("hat_helmet", HatItem.Helmet::new);
		BROKENTELEPORT = register("brokenteleport", BrokenteleportItem::new);
		BULLETSHOTGUN = register("bulletshotgun", BulletshotgunItem::new);
		KATANA = register("katana", KatanaItem::new);
		NOZNI = register("nozni", NozniItem::new);
		COLOMNTR = block(ForgottenFairyTalesModBlocks.COLOMNTR);
		TROST = register("trost", TrostItem::new);
		TARTAR = register("tartar", TartarItem::new);
		NUTRIENTBLOCK = register("nutrientblock", NutrientblockItem::new);
		DFHG = register("dfhg", DfhgItem::new);
		DROP = register("drop", DropItem::new);
		VASA = block(ForgottenFairyTalesModBlocks.VASA);
		WARRIORDRINK = register("warriordrink", WarriordrinkItem::new);
		WARRIORDRINKBLOCK = block(ForgottenFairyTalesModBlocks.WARRIORDRINKBLOCK);
		STEEL_BONE_BOW = register("steel_bone_bow", DaedalusbowItem::new);
		REINFORCED_ROPE = register("reinforced_rope", ReinforcedRopeItem::new);
		BUNCH_OF_ARROWS = register("bunch_of_arrows", BunchOfArrowsItem::new);
		LIVINGSTONE = block(ForgottenFairyTalesModBlocks.LIVINGSTONE);
		BERRYDELIGHT = register("berrydelight", BerrydelightItem::new);
		CHEESE = register("cheese", CheeseItem::new);
		MILKWITHENZYMES = register("milkwithenzymes", MilkwithenzymesItem::new);
		CAULDRONWITHFERMENTEDMILK = block(ForgottenFairyTalesModBlocks.CAULDRONWITHFERMENTEDMILK);
		CAULDRONEWITHCHEESE = block(ForgottenFairyTalesModBlocks.CAULDRONEWITHCHEESE);
		AGRONOMSGLOVE = register("agronomsglove", AgronomsgloveItem::new);
		SHOTGUN = register("shotgun", ShotgunItem::new);
		JULIENNE = register("julienne", JulienneItem::new);
		SUNSHAKE = register("sunshake", SunshakeItem::new);
		MULTITOOL = register("multitool", MultitoolItem::new);
		NEWAGEPICKAXE = register("newagepickaxe", NewagepickaxeItem::new);
		NEWAGEAXE = register("newageaxe", NewageaxeItem::new);
		NEWAGESHOVEL = register("newageshovel", NewageshovelItem::new);
		WAFFLE = register("waffle", WaffleItem::new);
		GAGARINHAMMER = register("gagarinhammer", GagarinhammerItem::new);
		IRONROD = register("ironrod", IronrodItem::new);
		ICECREAM = register("icecream", IcecreamItem::new);
		ROASTEDBONE = register("roastedbone", RoastedboneItem::new);
		MILKBOTTLE = register("milkbottle", MilkbottleItem::new);
		CACAO = register("cacao", CacaoItem::new);
		BEDROCKWITHKATANA = block(ForgottenFairyTalesModBlocks.BEDROCKWITHKATANA);
		BARELIK_SPAWN_EGG = register("barelik_spawn_egg", properties -> new SpawnEggItem(ForgottenFairyTalesModEntities.BARELIK.get(), properties));
		ANIMATINGMATTERLIFE = register("animatingmatterlife", AnimatingmatterlifeItem::new);
		WELDINGMASK_HELMET = register("weldingmask_helmet", WeldingmaskItem.Helmet::new);
		CONSTRUCTOR_SWORKBENCH = block(ForgottenFairyTalesModBlocks.CONSTRUCTOR_SWORKBENCH);
		ICESWORDBROKEN = register("iceswordbroken", IceswordbrokenItem::new);
		MAGETABLE = block(ForgottenFairyTalesModBlocks.MAGETABLE);
		GLASS_SWORD = register("glass_sword", GlassSwordItem::new);
		DECANTEROFBERRYCOMPOTE = register("decanterofberrycompote", DecanterofberrycompoteItem::new);
		DECANTEROFAPPLEJUICE = register("decanterofapplejuice", DecanterofapplejuiceItem::new);
		TOURNIQUET = register("tourniquet", TourniquetItem::new);
		WARRIORS_FORGE = block(ForgottenFairyTalesModBlocks.WARRIORS_FORGE);
		PICNIC_BASKET = register("picnic_basket", PicnicBasketItem::new);
		IRON_PLATE = register("iron_plate", IronPlateItem::new);
		UNDEAD_HUNTER_SWORD = register("undead_hunter_sword", UndeadHunterSwordItem::new);
		CURSED_MAGIC_LAUNCHER = register("cursed_magic_launcher", CursedMagicLauncherItem::new);
		CURSED_FIREBALL_ITEM = register("cursed_fireball_item", CursedFireballItemItem::new);
		BERRY_BREAD = register("berry_bread", BerryBreadItem::new);
		CARTRIDGE_POUCH = register("cartridge_pouch", CartridgePouchItem::new);
		CHOKOLATTE = register("chokolatte", ChokolatteItem::new);
		BLOOD_SOUP = register("blood_soup", BloodSoupItem::new);
		RUNE_OF_PROTECTION = register("rune_of_protection", RuneOfProtectionItem::new);
		L_IVING_FRAGMENT = block(ForgottenFairyTalesModBlocks.L_IVING_FRAGMENT);
		PRAHZERO = register("prahzero", PrahzeroItem::new);
		SALT_CRYSTAL_1 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_1);
		SALT_BLOCK = block(ForgottenFairyTalesModBlocks.SALT_BLOCK);
		SALT_CRYSTAL_2 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_2);
		SALT_CRYSTAL_3 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_3);
		SALT_CRYSTAL_4 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_4);
		SALT = register("salt", SaltItem::new);
		LORE_VASE = block(ForgottenFairyTalesModBlocks.LORE_VASE);
		BREAM = register("bream", BreamItem::new);
		STRAUSINGOEGG = block(ForgottenFairyTalesModBlocks.STRAUSINGOEGG);
		STRAUSINGO_SPAWN_EGG = register("strausingo_spawn_egg", properties -> new SpawnEggItem(ForgottenFairyTalesModEntities.STRAUSINGO.get(), properties));
		STRAUSINGOFEATHER = register("strausingofeather", StrausingofeatherItem::new);
		EGG_SHARD = register("egg_shard", EggShardItem::new);
		BFS = register("bfs", BFSItem::new);
		ZGUTIK_SPAWN_EGG = register("zgutik_spawn_egg", properties -> new SpawnEggItem(ForgottenFairyTalesModEntities.ZGUTIK.get(), properties));
		IRON_PLATE_BLOCK = block(ForgottenFairyTalesModBlocks.IRON_PLATE_BLOCK);
		FLAGELLANTS_CHESTPLATE_CHESTPLATE = register("flagellants_chestplate_chestplate", FlagellantsChestplateItem.Chestplate::new);
		STRUCTURE_VOID_CLEANER = register("structure_void_cleaner", StructureVoidCleanerItem::new);
		SOLDIER_CHOCOLATE = register("soldier_chocolate", SoldierChocolateItem::new);
		SOLDIER_CHOCOLATE_OPENED = register("soldier_chocolate_opened", SoldierChocolateOpenedItem::new);
		SALT_BLOCK_PRESSED = block(ForgottenFairyTalesModBlocks.SALT_BLOCK_PRESSED);
		SALT_CRYSTAL_12 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_12);
		SALT_CRYSTAL_22 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_22);
		SALT_CRYSTAL_32 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_32);
		SALT_CRYSTAL_42 = block(ForgottenFairyTalesModBlocks.SALT_CRYSTAL_42);
		SMOKE_PIPE = block(ForgottenFairyTalesModBlocks.SMOKE_PIPE);
		PYRITE = block(ForgottenFairyTalesModBlocks.PYRITE);
		PYRITE_ORE = register("pyrite_ore", PyriteOreItem::new);
		SMOKE_PIPE_CORNERED = block(ForgottenFairyTalesModBlocks.SMOKE_PIPE_CORNERED);
		FIRECLAY_BRICK = register("fireclay_brick", FireclayBrickItem::new);
		FIRECLAY_BRICKS = block(ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS);
		BIG_BLAST_FURNACE = block(ForgottenFairyTalesModBlocks.BIG_BLAST_FURNACE);
		SULFUR = register("sulfur", SulfurItem::new);
		CHAR_COAL_BLOCK = block(ForgottenFairyTalesModBlocks.CHAR_COAL_BLOCK);
		RAW_PYRITE_BLOCK = block(ForgottenFairyTalesModBlocks.RAW_PYRITE_BLOCK);
		SCABBARD = register("scabbard", ScabbardItem::new);
		RITUAL_KNIFE = register("ritual_knife", RitualKnifeItem::new);
		BINOCULARS = register("binoculars", BinocularsItem::new);
		GOLDEN_SADDLE = register("golden_saddle", GoldenSaddleItem::new);
		CHANGE_TABLE = block(ForgottenFairyTalesModBlocks.CHANGE_TABLE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new PicnicBasketInventoryCapability(stack), PICNIC_BASKET.get());
		event.registerItem(Capabilities.ItemHandler.ITEM, (stack, context) -> new CartridgePouchInventoryCapability(stack), CARTRIDGE_POUCH.get());
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		public static void registerItemModelProperties(RegisterRangeSelectItemModelPropertyEvent event) {
			event.register(ResourceLocation.parse("forgotten_fairy_tales:pulta/pull"), PultaItem.PullProperty.MAP_CODEC);
			event.register(ResourceLocation.parse("forgotten_fairy_tales:steel_bone_bow/pulling"), DaedalusbowItem.PullingProperty.MAP_CODEC);
			event.register(ResourceLocation.parse("forgotten_fairy_tales:cursed_magic_launcher/cml"), CursedMagicLauncherItem.CmlProperty.MAP_CODEC);
		}
	}
}