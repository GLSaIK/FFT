package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class WeldingmaskKazhdyiTikDliaShliemaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof EnderMan) {
					if (entityiterator instanceof Mob) {
						try {
							((Mob) entityiterator).setTarget(null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}