package net.saik.forgottenfairytales.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;

public class ColomnPriGibieliOtEtoiSushchnostiDrughoiProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (world.players().size() > 1) {
			if (world.getDifficulty() == Difficulty.EASY) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 7);
			} else if (world.getDifficulty() == Difficulty.NORMAL) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 17);
			} else if (world.getDifficulty() == Difficulty.HARD) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.setHealth((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 30);
			}
		}
	}
}