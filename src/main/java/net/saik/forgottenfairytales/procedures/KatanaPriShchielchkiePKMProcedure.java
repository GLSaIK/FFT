package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class KatanaPriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double l = 0;
		double bx = 0;
		double by = 0;
		double bz = 0;
		double mx = 0;
		double my = 0;
		double nz = 0;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("KT1", false) != true) {
			if ((entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f") || (entity.getDisplayName().getString()).equals("Dev")) {
				{
					Entity _ent = entity;
					_ent.teleportTo((x + entity.getLookAngle().x * 23), (y + 1 + entity.getLookAngle().y * 23), (z + entity.getLookAngle().z * 23));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((x + entity.getLookAngle().x * 23), (y + 1 + entity.getLookAngle().y * 23), (z + entity.getLookAngle().z * 23), _ent.getYRot(), _ent.getXRot());
				}
				l = 0;
				while (l < 23) {
					l = l + 1;
					bx = Math.floor(x + entity.getLookAngle().x * l);
					by = Math.floor(y + 1 + entity.getLookAngle().y * l);
					bz = Math.floor(z + entity.getLookAngle().z * l);
					{
						final Vec3 _center = new Vec3(bx, by, bz);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.SONIC_BOOM)), 613);
							}
						}
					}
					mx = -2;
					while (mx < 1) {
						mx = mx + 1;
						my = -2;
						while (my < 1) {
							my = my + 1;
							nz = -2;
							while (nz < 1) {
								nz = nz + 1;
								rx = bx + mx + Mth.nextInt(RandomSource.create(), -2, 2);
								ry = by + my + Mth.nextInt(RandomSource.create(), -2, 2);
								rz = bz + nz + Mth.nextInt(RandomSource.create(), -2, 2);
								if (!((world.getBlockState(BlockPos.containing(bx + mx, by + my, bz + nz))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(bx + mx, by + my, bz + nz))).getBlock() == Blocks.VOID_AIR)
										&& !((world.getBlockState(BlockPos.containing(bx + mx, by + my, bz + nz))).getBlock() == Blocks.CAVE_AIR)) {
									world.destroyBlock(BlockPos.containing(bx + mx, by + my, bz + nz), false);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.END_ROD, (bx + mx), (by + my), (bz + nz), 1, 1, 1, 1, 0);
								}
								if (!((world.getBlockState(BlockPos.containing(rx, ry, rz))).getBlock() == Blocks.AIR) && !((world.getBlockState(BlockPos.containing(rx, ry, rz))).getBlock() == Blocks.VOID_AIR)
										&& !((world.getBlockState(BlockPos.containing(rx, ry, rz))).getBlock() == Blocks.CAVE_AIR)) {
									world.destroyBlock(BlockPos.containing(rx, ry, rz), false);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.END_ROD, rx, ry, rz, 1, 1, 1, 1, 0);
								}
							}
						}
					}
				}
			} else if (140 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("KD", 0) && !(entity.getStringUUID()).equals("24bbfadd-ee8b-4128-b8a1-c129e856dc7f")
					&& !(entity.getDisplayName().getString()).equals("Dev")) {
				{
					final String _tagName = "KD";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								_ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}