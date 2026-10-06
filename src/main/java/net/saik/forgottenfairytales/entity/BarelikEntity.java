package net.saik.forgottenfairytales.entity;

import net.saik.forgottenfairytales.world.inventory.BarelickuiMenu;
import net.saik.forgottenfairytales.procedures.*;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;
import net.saik.forgottenfairytales.client.model.animations.barrelikAnimation;

import net.neoforged.neoforge.items.wrapper.EntityHandsInvWrapper;
import net.neoforged.neoforge.items.wrapper.EntityArmorInvWrapper;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import io.netty.buffer.Unpooled;

public class BarelikEntity extends TamableAnimal {

	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> ANIM = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_ss0 = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_ss4 = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_pet = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_fed = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_timer = SynchedEntityData.defineId(BarelikEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState1 = new AnimationState();
	public final AnimationState animationState2 = new AnimationState();

	public BarelikEntity(EntityType<BarelikEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
		if (ANIM.equals(data)) {
			switch (this.entityData.get(ANIM)) {
				case -2 :
					this.animationState1.stop();
					break;
				case -3 :
					this.animationState2.stop();
					break;
				case 1 :
					this.animationState1.start(this.tickCount);
					break;
				case 2 :
					this.animationState2.start(this.tickCount);
					break;
			}
		}
		super.onSyncedDataUpdated(data);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(TEXTURE, "barelik");
		builder.define(ANIM, 0);
		builder.define(DATA_ss0, 0);
		builder.define(DATA_ss4, false);
		builder.define(DATA_pet, false);
		builder.define(DATA_fed, false);
		builder.define(DATA_timer, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canUse() && DfhProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canContinueToUse() && DfhProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canUse() && DfhProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canContinueToUse() && DfhProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.goalSelector.addGoal(5, new TemptGoal(this, 1, Ingredient.of(Items.COOKIE), false) {
			@Override
			public boolean canUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canUse() && Dfh2Procedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = BarelikEntity.this.getX();
				double y = BarelikEntity.this.getY();
				double z = BarelikEntity.this.getZ();
				Entity entity = BarelikEntity.this;
				Level world = BarelikEntity.this.level();
				return super.canContinueToUse() && Dfh2Procedure.execute(entity);
			}
		});
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		BarelikPriRanieniiSushchnostiProcedure.execute(world, entity);
		return super.hurtServer(level, damagesource, amount);
	}

	private final ItemStackHandler inventory = new ItemStackHandler(10);
	private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this), new EntityArmorInvWrapper(this));

	public CombinedInvWrapper getCombinedInventory() {
		return combined;
	}

	@Override
	protected void dropEquipment(ServerLevel serverLevel) {
		super.dropEquipment(serverLevel);
		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack itemstack = inventory.getStackInSlot(i);
			if (!itemstack.isEmpty() && !EnchantmentHelper.has(itemstack, EnchantmentEffectComponents.PREVENT_EQUIPMENT_DROP)) {
				this.spawnAtLocation(serverLevel, itemstack);
			}
		}
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putString("Texture", this.getTexture());
		valueOutput.putInt("Datass0", this.entityData.get(DATA_ss0));
		valueOutput.putBoolean("Datass4", this.entityData.get(DATA_ss4));
		valueOutput.putBoolean("Datapet", this.entityData.get(DATA_pet));
		valueOutput.putBoolean("Datafed", this.entityData.get(DATA_fed));
		valueOutput.putInt("Datatimer", this.entityData.get(DATA_timer));
		inventory.serialize(valueOutput.child("InventoryCustom"));
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.setTexture(valueInput.getStringOr("Texture", "barelik"));
		this.entityData.set(DATA_ss0, valueInput.getIntOr("Datass0", 0));
		this.entityData.set(DATA_ss4, valueInput.getBooleanOr("Datass4", false));
		this.entityData.set(DATA_pet, valueInput.getBooleanOr("Datapet", false));
		this.entityData.set(DATA_fed, valueInput.getBooleanOr("Datafed", false));
		this.entityData.set(DATA_timer, valueInput.getIntOr("Datatimer", 0));
		valueInput.child("InventoryCustom").ifPresent(input -> inventory.deserialize(input));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.SUCCESS;
		if (sourceentity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Barrel");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
					packetBuffer.writeBlockPos(sourceentity.blockPosition());
					packetBuffer.writeByte(0);
					packetBuffer.writeVarInt(BarelikEntity.this.getId());
					return new BarelickuiMenu(id, inventory, packetBuffer);
				}
			}, buf -> {
				buf.writeBlockPos(sourceentity.blockPosition());
				buf.writeByte(0);
				buf.writeVarInt(this.getId());
			});
		}
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.SUCCESS : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.SUCCESS;
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.SUCCESS;
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		BarelikPriShchielchkiePKMPoSushchnostiProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState1.animateWhen(BarelikUsloviieProighryvaniiaProcedure.execute(this), this.tickCount);
			if (this.animationState2.isStarted()) {
				float elapsedSeconds = this.animationState2.getTimeInMillis(this.tickCount) / 1000.0F;
				if (elapsedSeconds >= barrelikAnimation.appearances_afk_block.lengthInSeconds()) {
					if (!barrelikAnimation.appearances_afk_block.looping())
						this.animationState2.stop();
					else
						this.animationState2.start(this.tickCount);
				}
			}
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		BarelikPriObnovlieniiTikaSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		BarelikEntity retval = ForgottenFairyTalesModEntities.BARELIK.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Blocks.STRUCTURE_BLOCK.asItem()).test(stack);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.TEMPT_RANGE, 10);
		return builder;
	}
}