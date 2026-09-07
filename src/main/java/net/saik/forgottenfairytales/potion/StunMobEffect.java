package net.saik.forgottenfairytales.potion;

import net.saik.forgottenfairytales.procedures.StunPriNalozhieniiEffiektaProcedure;
import net.saik.forgottenfairytales.procedures.StunKazhdyiTikVoVriemiaEffiektaProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;

import java.util.List;
import java.util.ArrayList;

@EventBusSubscriber
public class StunMobEffect extends MobEffect {
	public StunMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		StunPriNalozhieniiEffiektaProcedure.execute(entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		StunKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
		return super.applyEffectTick(level, entity, amplifier);
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		Consumable original = Items.HONEY_BOTTLE.components().get(DataComponents.CONSUMABLE);
		if (original != null) {
			List<ConsumeEffect> onConsumeEffects = new ArrayList<>(original.onConsumeEffects());
			onConsumeEffects.add(new RemoveStatusEffectsConsumeEffect(ForgottenFairyTalesModMobEffects.STUN));
			Consumable replacementConsumable = new Consumable(original.consumeSeconds(), original.animation(), original.sound(), original.hasConsumeParticles(), onConsumeEffects);
			event.modify(Items.HONEY_BOTTLE, builder -> builder.set(DataComponents.CONSUMABLE, replacementConsumable));
		}
	}
}