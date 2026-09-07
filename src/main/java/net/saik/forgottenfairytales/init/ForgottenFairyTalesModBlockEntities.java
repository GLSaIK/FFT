/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.block.entity.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber
public class ForgottenFairyTalesModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CauldronwithfermentedmilkBlockEntity>> CAULDRONWITHFERMENTEDMILK = register("cauldronwithfermentedmilk", ForgottenFairyTalesModBlocks.CAULDRONWITHFERMENTEDMILK,
			CauldronwithfermentedmilkBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BedrockwithkatanaBlockEntity>> BEDROCKWITHKATANA = register("bedrockwithkatana", ForgottenFairyTalesModBlocks.BEDROCKWITHKATANA, BedrockwithkatanaBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConstructorSworkbenchBlockEntity>> CONSTRUCTOR_SWORKBENCH = register("constructor_sworkbench", ForgottenFairyTalesModBlocks.CONSTRUCTOR_SWORKBENCH,
			ConstructorSworkbenchBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagetableBlockEntity>> MAGETABLE = register("magetable", ForgottenFairyTalesModBlocks.MAGETABLE, MagetableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WarriorsForgeBlockEntity>> WARRIORS_FORGE = register("warriors_forge", ForgottenFairyTalesModBlocks.WARRIORS_FORGE, WarriorsForgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PicnicBasketBlockBlockEntity>> PICNIC_BASKET_BLOCK = register("picnic_basket_block", ForgottenFairyTalesModBlocks.PICNIC_BASKET_BLOCK, PicnicBasketBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LIvingFragmentBlockEntity>> L_IVING_FRAGMENT = register("l_iving_fragment", ForgottenFairyTalesModBlocks.L_IVING_FRAGMENT, LIvingFragmentBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LoreVaseBlockEntity>> LORE_VASE = register("lore_vase", ForgottenFairyTalesModBlocks.LORE_VASE, LoreVaseBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StrausingoeggBlockEntity>> STRAUSINGOEGG = register("strausingoegg", ForgottenFairyTalesModBlocks.STRAUSINGOEGG, StrausingoeggBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SaltBlockPressedBlockEntity>> SALT_BLOCK_PRESSED = register("salt_block_pressed", ForgottenFairyTalesModBlocks.SALT_BLOCK_PRESSED, SaltBlockPressedBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FireclayBricksBlockEntity>> FIRECLAY_BRICKS = register("fireclay_bricks", ForgottenFairyTalesModBlocks.FIRECLAY_BRICKS, FireclayBricksBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BigBlastFurnaceBlockEntity>> BIG_BLAST_FURNACE = register("big_blast_furnace", ForgottenFairyTalesModBlocks.BIG_BLAST_FURNACE, BigBlastFurnaceBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CAULDRONWITHFERMENTEDMILK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BEDROCKWITHKATANA.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONSTRUCTOR_SWORKBENCH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAGETABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WARRIORS_FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PICNIC_BASKET_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, L_IVING_FRAGMENT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LORE_VASE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, STRAUSINGOEGG.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SALT_BLOCK_PRESSED.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FIRECLAY_BRICKS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BIG_BLAST_FURNACE.get(), SidedInvWrapper::new);
	}
}