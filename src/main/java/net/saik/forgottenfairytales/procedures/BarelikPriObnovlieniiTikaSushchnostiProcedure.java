package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.BarelikEntity;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

public class BarelikPriObnovlieniiTikaSushchnostiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BarelikEntity _datEntL0 && _datEntL0.getEntityData().get(BarelikEntity.DATA_ss4)) {
			if (((findEntityInWorldRange(world, Player.class, x, y, z, 8)) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.COOKIE
					|| ((findEntityInWorldRange(world, Player.class, x, y, z, 8)) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.COOKIE) {
				entity.lookAt(EntityAnchorArgument.Anchor.EYES,
						new Vec3(((findEntityInWorldRange(world, Player.class, x, y, z, 8)).getX()), ((findEntityInWorldRange(world, Player.class, x, y, z, 8)).getY()), ((findEntityInWorldRange(world, Player.class, x, y, z, 8)).getZ())));
				if (4 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 7);
				}
			} else {
				if (7 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
				}
			}
			if (entity instanceof BarelikEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BarelikEntity.DATA_timer, (int) ((entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_timer) : 0) + 1));
			if (4 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0) && 55 < (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_timer) : 0)) {
				if (entity instanceof BarelikEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BarelikEntity.DATA_timer, 0);
				if (entity instanceof BarelikEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 5);
				ForgottenFairyTalesMod.queueServerWork(2, () -> {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
					ForgottenFairyTalesMod.queueServerWork(2, () -> {
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 2) {
							if (entity instanceof BarelikEntity _datEntSetI)
								_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 5);
							ForgottenFairyTalesMod.queueServerWork(2, () -> {
								if (entity instanceof BarelikEntity _datEntSetI)
									_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
							});
						}
					});
				});
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2d > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
				if (entity instanceof BarelikEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 8);
			} else {
				if (8 == (entity instanceof BarelikEntity _datEntI ? _datEntI.getEntityData().get(BarelikEntity.DATA_ss0) : 0)) {
					if (entity instanceof BarelikEntity _datEntSetI)
						_datEntSetI.getEntityData().set(BarelikEntity.DATA_ss0, 4);
				}
			}
		}
		if (((entity.getDisplayName().getString()).toLowerCase()).equals("\u043F\u0430\u0432\u044D\u0442 \u043C\u0438\u043D\u0438")
				&& (entity instanceof LivingEntity _livingEntity37 && _livingEntity37.getAttributes().hasAttribute(Attributes.SCALE) ? _livingEntity37.getAttribute(Attributes.SCALE).getBaseValue() : 0) != 0.5) {
			if (entity instanceof LivingEntity _livingEntity38 && _livingEntity38.getAttributes().hasAttribute(Attributes.SCALE))
				_livingEntity38.getAttribute(Attributes.SCALE).setBaseValue(0.5);
			ForgottenFairyTalesMod.LOGGER.info("1");
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}