/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.block.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ForgottenFairyTalesModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ForgottenFairyTalesMod.MODID);
	public static final DeferredBlock<Block> COLOMNTR;
	public static final DeferredBlock<Block> VASA;
	public static final DeferredBlock<Block> WARRIORDRINKBLOCK;
	public static final DeferredBlock<Block> LIVINGSTONE;
	public static final DeferredBlock<Block> CAULDRONWITHFERMENTEDMILK;
	public static final DeferredBlock<Block> CAULDRONEWITHCHEESE;
	public static final DeferredBlock<Block> SUNSHAKEBLOCK;
	public static final DeferredBlock<Block> BEDROCKWITHKATANA;
	public static final DeferredBlock<Block> CONSTRUCTOR_SWORKBENCH;
	public static final DeferredBlock<Block> MAGETABLE;
	public static final DeferredBlock<Block> WARRIORS_FORGE;
	public static final DeferredBlock<Block> PICNIC_BASKET_BLOCK;
	public static final DeferredBlock<Block> L_IVING_FRAGMENT;
	public static final DeferredBlock<Block> SALT_CRYSTAL_1;
	public static final DeferredBlock<Block> SALT_BLOCK;
	public static final DeferredBlock<Block> SALT_CRYSTAL_2;
	public static final DeferredBlock<Block> SALT_CRYSTAL_3;
	public static final DeferredBlock<Block> SALT_CRYSTAL_4;
	public static final DeferredBlock<Block> LORE_VASE;
	public static final DeferredBlock<Block> STRAUSINGOEGG;
	public static final DeferredBlock<Block> IRON_PLATE_BLOCK;
	public static final DeferredBlock<Block> SALT_BLOCK_PRESSED;
	public static final DeferredBlock<Block> SALT_CRYSTAL_12;
	public static final DeferredBlock<Block> SALT_CRYSTAL_22;
	public static final DeferredBlock<Block> SALT_CRYSTAL_32;
	public static final DeferredBlock<Block> SALT_CRYSTAL_42;
	public static final DeferredBlock<Block> SMOKE_PIPE;
	public static final DeferredBlock<Block> PYRITE;
	public static final DeferredBlock<Block> SMOKE_PIPE_CORNERED;
	public static final DeferredBlock<Block> FIRECLAY_BRICKS;
	public static final DeferredBlock<Block> BIG_BLAST_FURNACE;
	public static final DeferredBlock<Block> CHAR_COAL_BLOCK;
	public static final DeferredBlock<Block> RAW_PYRITE_BLOCK;
	static {
		COLOMNTR = register("colomntr", ColomntrBlock::new);
		VASA = register("vasa", VasaBlock::new);
		WARRIORDRINKBLOCK = register("warriordrinkblock", WarriordrinkblockBlock::new);
		LIVINGSTONE = register("livingstone", LivingstoneBlock::new);
		CAULDRONWITHFERMENTEDMILK = register("cauldronwithfermentedmilk", CauldronwithfermentedmilkBlock::new);
		CAULDRONEWITHCHEESE = register("cauldronewithcheese", CauldronewithcheeseBlock::new);
		SUNSHAKEBLOCK = register("sunshakeblock", SunshakeblockBlock::new);
		BEDROCKWITHKATANA = register("bedrockwithkatana", BedrockwithkatanaBlock::new);
		CONSTRUCTOR_SWORKBENCH = register("constructor_sworkbench", ConstructorSworkbenchBlock::new);
		MAGETABLE = register("magetable", MagetableBlock::new);
		WARRIORS_FORGE = register("warriors_forge", WarriorsForgeBlock::new);
		PICNIC_BASKET_BLOCK = register("picnic_basket_block", PicnicBasketBlockBlock::new);
		L_IVING_FRAGMENT = register("l_iving_fragment", LIvingFragmentBlock::new);
		SALT_CRYSTAL_1 = register("salt_crystal_1", SaltCrystal1Block::new);
		SALT_BLOCK = register("salt_block", SaltBlockBlock::new);
		SALT_CRYSTAL_2 = register("salt_crystal_2", SaltCrystal2Block::new);
		SALT_CRYSTAL_3 = register("salt_crystal_3", SaltCrystal3Block::new);
		SALT_CRYSTAL_4 = register("salt_crystal_4", SaltCrystal4Block::new);
		LORE_VASE = register("lore_vase", LoreVaseBlock::new);
		STRAUSINGOEGG = register("strausingoegg", StrausingoeggBlock::new);
		IRON_PLATE_BLOCK = register("iron_plate_block", IronPlateBlockBlock::new);
		SALT_BLOCK_PRESSED = register("salt_block_pressed", SaltBlockPressedBlock::new);
		SALT_CRYSTAL_12 = register("salt_crystal_12", SaltCrystal12Block::new);
		SALT_CRYSTAL_22 = register("salt_crystal_22", SaltCrystal22Block::new);
		SALT_CRYSTAL_32 = register("salt_crystal_32", SaltCrystal32Block::new);
		SALT_CRYSTAL_42 = register("salt_crystal_42", SaltCrystal42Block::new);
		SMOKE_PIPE = register("smoke_pipe", SmokePipeBlock::new);
		PYRITE = register("pyrite", PyriteBlock::new);
		SMOKE_PIPE_CORNERED = register("smoke_pipe_cornered", SmokePipeCorneredBlock::new);
		FIRECLAY_BRICKS = register("fireclay_bricks", FireclayBricksBlock::new);
		BIG_BLAST_FURNACE = register("big_blast_furnace", BigBlastFurnaceBlock::new);
		CHAR_COAL_BLOCK = register("char_coal_block", CharCoalBlockBlock::new);
		RAW_PYRITE_BLOCK = register("raw_pyrite_block", RawPyriteBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}