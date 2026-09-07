package net.saik.forgottenfairytales.entity;

import net.saik.forgottenfairytales.procedures.StrausingoUsloviieProighryvaniiaProcedure;
import net.saik.forgottenfairytales.procedures.StrausingoPriRanieniiSushchnostiProcedure;
import net.saik.forgottenfairytales.procedures.StrausingoPriGibieliSushchnostiProcedure;
import net.saik.forgottenfairytales.procedures.StrausingoAttackProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.core.registries.BuiltInRegistries;

public class StrausingoEntity extends Animal {

	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(StrausingoEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> ANIM = SynchedEntityData.defineId(StrausingoEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_Ataack = SynchedEntityData.defineId(StrausingoEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_sit = SynchedEntityData.defineId(StrausingoEntity.class, EntityDataSerializers.BOOLEAN);
	public final AnimationState animationState1 = new AnimationState();
	public final AnimationState animationState2 = new AnimationState();

	public StrausingoEntity(EntityType<StrausingoEntity> type, Level world) {
		super(type, world);
		xpReward = 4;
		setNoAi(false);
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
		builder.define(TEXTURE, "strausingo");
		builder.define(ANIM, 0);
		builder.define(DATA_Ataack, false);
		builder.define(DATA_sit, false);
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
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1, Ingredient.of(Items.WHEAT_SEEDS), true));
		this.goalSelector.addGoal(4, new BreedGoal(this, 1));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));
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

		StrausingoPriRanieniiSushchnostiProcedure.execute(world, x, y, z, immediatesourceentity);
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		StrausingoPriGibieliSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), source.getDirectEntity());
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putString("Texture", this.getTexture());
		valueOutput.putBoolean("DataAtaack", this.entityData.get(DATA_Ataack));
		valueOutput.putBoolean("Datasit", this.entityData.get(DATA_sit));
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.setTexture(valueInput.getStringOr("Texture", "strausingo"));
		this.entityData.set(DATA_Ataack, valueInput.getBooleanOr("DataAtaack", false));
		this.entityData.set(DATA_sit, valueInput.getBooleanOr("Datasit", false));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState1.animateWhen(StrausingoAttackProcedure.execute(this), this.tickCount);
			this.animationState2.animateWhen(StrausingoUsloviieProighryvaniiaProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		StrausingoEntity retval = ForgottenFairyTalesModEntities.STRAUSINGO.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Items.WHEAT_SEEDS).test(stack);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(ForgottenFairyTalesModEntities.STRAUSINGO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8), RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 1);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		builder = builder.add(Attributes.TEMPT_RANGE, 10);
		return builder;
	}
}