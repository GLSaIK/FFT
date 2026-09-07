package net.saik.forgottenfairytales.procedures;

import net.saik.forgottenfairytales.entity.StrausingoEntity;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class StrausingoAttack2Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity sourceentity) {
		execute(null, world, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof StrausingoEntity) {
			if (sourceentity instanceof StrausingoEntity _datEntSetL)
				_datEntSetL.getEntityData().set(StrausingoEntity.DATA_Ataack, true);
			ForgottenFairyTalesMod.queueServerWork(10, () -> {
				if (sourceentity instanceof StrausingoEntity _datEntSetL)
					_datEntSetL.getEntityData().set(StrausingoEntity.DATA_Ataack, false);
			});
		}
	}
}