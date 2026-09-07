/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.entity.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class ForgottenFairyTalesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<ColomnEntity>> COLOMN = register("colomn",
			EntityType.Builder.<ColomnEntity>of(ColomnEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune()

					.sized(1f, 6f));
	public static final DeferredHolder<EntityType<?>, EntityType<BeamEntity>> BEAM = register("beam",
			EntityType.Builder.<BeamEntity>of(BeamEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<DflkhjEntity>> DFLKHJ = register("dflkhj",
			EntityType.Builder.<DflkhjEntity>of(DflkhjEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<ShbutEntity>> SHBUT = register("shbut",
			EntityType.Builder.<ShbutEntity>of(ShbutEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FireballlEntity>> FIREBALLL = register("fireballl",
			EntityType.Builder.<FireballlEntity>of(FireballlEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BuchofarrowsEntity>> BUCHOFARROWS = register("buchofarrows",
			EntityType.Builder.<BuchofarrowsEntity>of(BuchofarrowsEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<LivingbricksEntity>> LIVINGBRICKS = register("livingbricks",
			EntityType.Builder.<LivingbricksEntity>of(LivingbricksEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<BarelikEntity>> BARELIK = register("barelik",
			EntityType.Builder.<BarelikEntity>of(BarelikEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedFireballEntity>> CURSED_FIREBALL = register("cursed_fireball",
			EntityType.Builder.<CursedFireballEntity>of(CursedFireballEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<StrausingoEntity>> STRAUSINGO = register("strausingo",
			EntityType.Builder.<StrausingoEntity>of(StrausingoEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<ZgutikEntity>> ZGUTIK = register("zgutik",
			EntityType.Builder.<ZgutikEntity>of(ZgutikEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 0.6f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ForgottenFairyTalesMod.MODID, registryname))));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, BARELIK.get(), (living, context) -> living.getCombinedInventory());
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		ColomnEntity.init(event);
		DflkhjEntity.init(event);
		LivingbricksEntity.init(event);
		BarelikEntity.init(event);
		StrausingoEntity.init(event);
		ZgutikEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(COLOMN.get(), ColomnEntity.createAttributes().build());
		event.put(DFLKHJ.get(), DflkhjEntity.createAttributes().build());
		event.put(LIVINGBRICKS.get(), LivingbricksEntity.createAttributes().build());
		event.put(BARELIK.get(), BarelikEntity.createAttributes().build());
		event.put(STRAUSINGO.get(), StrausingoEntity.createAttributes().build());
		event.put(ZGUTIK.get(), ZgutikEntity.createAttributes().build());
	}
}