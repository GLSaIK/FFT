package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.entity.BarelikEntity;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class BarelikPriShchielchkiePKMPoSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ForgottenFairyTalesModMobEffects.EFFECTANIMATINGMATTERLIFE)) {
			if ((entity instanceof BarelikEntity _datEntL1 && _datEntL1.getEntityData().get(BarelikEntity.DATA_ss4)) == false) {
				if (sourceentity instanceof Player _player)
					_player.closeContainer();
				if (entity instanceof BarelikEntity _ent3) {
					_ent3.getEntityData().set(BarelikEntity.ANIM, 1000);
					_ent3.getEntityData().set(BarelikEntity.ANIM, 2);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(ForgottenFairyTalesModMobEffects.EFFECTANIMATINGMATTERLIFE);
				if (entity instanceof BarelikEntity _datEntSetL)
					_datEntSetL.getEntityData().set(BarelikEntity.DATA_ss4, true);
				ForgottenFairyTalesMod.queueServerWork(15, () -> {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
					if (entity instanceof BarelikEntity _ent7) {
						_ent7.getEntityData().set(BarelikEntity.ANIM, 1000);
						_ent7.getEntityData().set(BarelikEntity.ANIM, -1 - 2);
					}
				});
			}
		}
		if ((entity instanceof BarelikEntity _datEntL9 && _datEntL9.getEntityData().get(BarelikEntity.DATA_ss4)) == true) {
			if (Items.COOKIE == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && !(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
				if (sourceentity instanceof Player _player)
					_player.closeContainer();
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack17 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack17.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack17);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (1 == Mth.nextInt(RandomSource.create(), 1, 10)) {
					if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
						_toTame.tame(_owner);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 0.3);
					if (7 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
						if (entity instanceof BarelikEntity _datEntSetI)
							_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 2);
						ForgottenFairyTalesMod.queueServerWork(10, () -> {
							if (entity instanceof BarelikEntity _datEntSetI)
								_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 7);
						});
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 5, 1, 1, 1, 0.3);
				}
			}
			if (Items.COOKIE == (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
					&& (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)
					&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) != (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if (sourceentity instanceof Player _player)
					_player.closeContainer();
				if (sourceentity instanceof LivingEntity _entity) {
					ItemStack _setstack35 = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
					_setstack35.setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack35);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, x, y, z, 5, 1, 1, 1, 0.3);
				if (7 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 1);
					ForgottenFairyTalesMod.queueServerWork(10, () -> {
						if (entity instanceof BarelikEntity _datEntSetI)
							_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 7);
					});
				}
			}
		}
		if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
			if (sourceentity instanceof Player _player)
				_player.closeContainer();
		}
	}
}