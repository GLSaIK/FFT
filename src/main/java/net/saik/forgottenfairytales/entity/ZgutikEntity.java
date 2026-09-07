package net.saik.forgottenfairytales.entity;

import net.saik.forgottenfairytales.procedures.ZgutikUsloviieWProcedure;
import net.saik.forgottenfairytales.procedures.ZgutikUsloviieW2Procedure;
import net.saik.forgottenfairytales.procedures.ZgutikUsloviieProighryvaniiaProcedure;
import net.saik.forgottenfairytales.procedures.ZgutikPriObnovlieniiTikaSushchnostiProcedure;
import net.saik.forgottenfairytales.procedures.ZgutikPlayerCollidesWithThisEntityProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModEntities;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.core.registries.BuiltInRegistries;

public class ZgutikEntity extends Monster {

	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ZgutikEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> ANIM = SynchedEntityData.defineId(ZgutikEntity.class, EntityDataSerializers.INT);
	public final AnimationState animationState0 = new AnimationState();

	public ZgutikEntity(EntityType<ZgutikEntity> type, Level world) {
		super(type, world);
		xpReward = 8;
		setNoAi(false);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
		if (ANIM.equals(data)) {
			switch (this.entityData.get(ANIM)) {
				case -1 :
					this.animationState0.stop();
					break;
				case 0 :
					this.animationState0.start(this.tickCount);
					break;
			}
		}
		super.onSyncedDataUpdated(data);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(TEXTURE, "zgutik");
		builder.define(ANIM, 0);
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
		this.goalSelector.addGoal(1, new BreakDoorGoal(this, e -> true) {
			@Override
			public boolean canUse() {
				double x = ZgutikEntity.this.getX();
				double y = ZgutikEntity.this.getY();
				double z = ZgutikEntity.this.getZ();
				Entity entity = ZgutikEntity.this;
				Level world = ZgutikEntity.this.level();
				return super.canUse() && ZgutikUsloviieW2Procedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = ZgutikEntity.this.getX();
				double y = ZgutikEntity.this.getY();
				double z = ZgutikEntity.this.getZ();
				Entity entity = ZgutikEntity.this;
				Level world = ZgutikEntity.this.level();
				return super.canUse() && ZgutikUsloviieWProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = ZgutikEntity.this.getX();
				double y = ZgutikEntity.this.getY();
				double z = ZgutikEntity.this.getZ();
				Entity entity = ZgutikEntity.this;
				Level world = ZgutikEntity.this.level();
				return super.canContinueToUse() && ZgutikUsloviieWProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = ZgutikEntity.this.getX();
				double y = ZgutikEntity.this.getY();
				double z = ZgutikEntity.this.getZ();
				Entity entity = ZgutikEntity.this;
				Level world = ZgutikEntity.this.level();
				return super.canUse() && ZgutikUsloviieWProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = ZgutikEntity.this.getX();
				double y = ZgutikEntity.this.getY();
				double z = ZgutikEntity.this.getZ();
				Entity entity = ZgutikEntity.this;
				Level world = ZgutikEntity.this.level();
				return super.canContinueToUse() && ZgutikUsloviieWProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.7, true) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(6, new HurtByTargetGoal(this).setAlertOthers());
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
		if (damagesource.getDirectEntity() instanceof AbstractThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.setTexture(valueInput.getStringOr("Texture", "zgutik"));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level().isClientSide()) {
			this.animationState0.animateWhen(ZgutikUsloviieProighryvaniiaProcedure.execute(this), this.tickCount);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		ZgutikPriObnovlieniiTikaSushchnostiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		ZgutikPlayerCollidesWithThisEntityProcedure.execute(this.level(), sourceentity);
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(ForgottenFairyTalesModEntities.ZGUTIK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
				RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 8);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 20);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
		return builder;
	}
}