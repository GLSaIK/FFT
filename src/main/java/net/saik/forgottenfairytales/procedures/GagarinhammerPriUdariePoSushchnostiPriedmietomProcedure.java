package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.util.Comparator;

public class GagarinhammerPriUdariePoSushchnostiPriedmietomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double ang = 0;
		double speed = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("loaded", false) == true || (sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			{
				final int _animState = -1 - 0;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> {
					tag.putInt("oldAnimState", 10000);
					tag.putInt("animState", _animState);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 10, 1, 1, 1, 0.5);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), sourceentity), 8);
			{
				final String _tagName = "loaded";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			ForgottenFairyTalesMod.queueServerWork(1, () -> {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, ((x + sourceentity.getX()) / 2), ((sourceentity.getY() + y) / 2 + 1), ((sourceentity.getZ() + z) / 2), (float) 0.1, Level.ExplosionInteraction.NONE);
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (!(entityiterator == sourceentity)) {
							entityiterator.push((sourceentity.getLookAngle().x * 1.5), (sourceentity.getLookAngle().y * 1.5), (sourceentity.getLookAngle().z * 1.5));
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC), sourceentity), 7);
						}
					}
				}
			});
		}
	}
}