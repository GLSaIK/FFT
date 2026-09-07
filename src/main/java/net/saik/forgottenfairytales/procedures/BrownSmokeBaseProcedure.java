package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModParticleTypes;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModBlocks;
import net.saik.forgottenfairytales.entity.ZgutikEntity;
import net.saik.forgottenfairytales.entity.ColomnEntity;
import net.saik.forgottenfairytales.entity.BarelikEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class BrownSmokeBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Sx = 0;
		double Sy = 0;
		double Sz = 0;
		double dir = 0;
		Sx = x;
		Sy = y + 1;
		Sz = z;
		dir = 4;
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE.get()
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE_CORNERED.get()) {
			while ((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE.get()
					|| (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE_CORNERED.get()) {
				if ((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE.get()) {
					if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _getep11
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep11).toString()
							: "").equals("x")) {
						if (dir == 3) {
							Sx = Sx + 1;
							dir = 3;
						} else if (dir == 2) {
							Sx = Sx - 1;
							dir = 2;
						}
					} else if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _getep13
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep13).toString()
							: "").equals("y")) {
						if (dir == 4) {
							Sy = Sy + 1;
							dir = 4;
						} else if (dir == 5) {
							Sy = Sy - 1;
							dir = 5;
						}
					} else if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty _getep15
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep15).toString()
							: "").equals("z")) {
						if (dir == 1) {
							Sz = Sz + 1;
							dir = 1;
						} else if (dir == 0) {
							Sz = Sz - 1;
							dir = 0;
						}
					}
				} else if ((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock() == ForgottenFairyTalesModBlocks.SMOKE_PIPE_CORNERED.get()) {
					if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep19
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep19).toString()
							: "").equals("FLOOR")) {
						if (Direction.NORTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 4) {
								Sz = Sz - 1;
								dir = 0;
							} else if (dir == 1) {
								Sy = Sy - 1;
								dir = 5;
							} else {
								break;
							}
						} else if (Direction.SOUTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 4) {
								Sz = Sz + 1;
								dir = 1;
							} else if (dir == 0) {
								Sy = Sy - 1;
								dir = 5;
							} else {
								break;
							}
						} else if (Direction.WEST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 4) {
								Sx = Sx - 1;
								dir = 2;
							} else if (dir == 3) {
								Sy = Sy - 1;
								dir = 5;
							} else {
								break;
							}
						} else if (Direction.EAST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 4) {
								Sx = Sx + 1;
								dir = 3;
							} else if (dir == 2) {
								Sy = Sy - 1;
								dir = 5;
							} else {
								break;
							}
						} else {
							break;
						}
					} else if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep33
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep33).toString()
							: "").equals("CEILING")) {
						if (Direction.NORTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 5) {
								Sz = Sz - 1;
								dir = 0;
							} else if (dir == 1) {
								Sy = Sy + 1;
								dir = 4;
							} else {
								break;
							}
						} else if (Direction.SOUTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 5) {
								Sz = Sz + 1;
								dir = 1;
							} else if (dir == 0) {
								Sy = Sy + 1;
								dir = 4;
							} else {
								break;
							}
						} else if (Direction.WEST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 5) {
								Sx = Sx - 1;
								dir = 2;
							} else if (dir == 3) {
								Sy = Sy + 1;
								dir = 4;
							} else {
								break;
							}
						} else if (Direction.EAST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 5) {
								Sx = Sx + 1;
								dir = 3;
							} else if (dir == 2) {
								Sy = Sy + 1;
								dir = 4;
							} else {
								break;
							}
						} else {
							break;
						}
					} else if (((world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getBlock().getStateDefinition().getProperty("face") instanceof EnumProperty _getep47
							? (world.getBlockState(BlockPos.containing(Sx, Sy, Sz))).getValue(_getep47).toString()
							: "").equals("WALL")) {
						if (Direction.NORTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 1) {
								Sx = Sx - 1;
								dir = 2;
							} else if (dir == 3) {
								Sz = Sz - 1;
								dir = 0;
							} else {
								break;
							}
						} else if (Direction.SOUTH == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 0) {
								Sx = Sx + 1;
								dir = 3;
							} else if (dir == 2) {
								Sz = Sz + 1;
								dir = 1;
							} else {
								break;
							}
						} else if (Direction.WEST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 3) {
								Sz = Sz + 1;
								dir = 1;
							} else if (dir == 0) {
								Sx = Sx - 1;
								dir = 2;
							} else {
								break;
							}
						} else if (Direction.EAST == (getDirectionFromBlockState((world.getBlockState(BlockPos.containing(Sx, Sy, Sz)))))) {
							if (dir == 2) {
								Sz = Sz - 1;
								dir = 0;
							} else if (dir == 1) {
								Sx = Sx + 1;
								dir = 3;
							} else {
								break;
							}
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}
		}
		{
			final Vec3 _center = new Vec3(Sx, (Sy + 4), Sz);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(11 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!(entityiterator instanceof Creeper || entityiterator instanceof AbstractGolem || entityiterator instanceof ZgutikEntity || entityiterator instanceof BarelikEntity || entityiterator instanceof WitherBoss
						|| entityiterator instanceof WitherSkeleton || entityiterator instanceof Skeleton || entityiterator instanceof SkeletonHorse || entityiterator instanceof ColomnEntity
						|| (entityiterator instanceof Player _plr ? _plr.getAbilities().instabuild : false))) {
					if (!((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ForgottenFairyTalesModItems.WELDINGMASK_HELMET.get()
							&& ForgottenFairyTalesModVariables.MapVariables.get(world).WIP == true)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 140, 0));
					}
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 140, 0));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
				}
				if (entityiterator.getX() == Sx && entityiterator.getZ() == Sz) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 3));
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ForgottenFairyTalesModParticleTypes.BROWN_SMOKE_PARTICLE.get()), (Sx + 0.5), Sy, (Sz + 0.5), 1, 0, 0, 0, 0);
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (blockState.getBlock().getStateDefinition().getProperty("facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (blockState.getBlock().getStateDefinition().getProperty("axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}
}