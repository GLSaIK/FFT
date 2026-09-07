package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.LivingbricksEntity;

import net.minecraft.world.entity.Entity;

public class LivingbricksPriNachalnomPrizyvieSushchnostiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingbricksEntity _ent0) {
			_ent0.getEntityData().set(LivingbricksEntity.ANIM, 1000);
			_ent0.getEntityData().set(LivingbricksEntity.ANIM, 1);
		}
	}
}