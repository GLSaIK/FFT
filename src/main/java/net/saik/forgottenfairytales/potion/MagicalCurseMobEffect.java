package net.saik.forgottenfairytales.potion;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.Items;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.component.DataComponents;

import java.util.List;
import java.util.ArrayList;

@EventBusSubscriber
public class MagicalCurseMobEffect extends MobEffect {
	public MagicalCurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -13487566);
	}

	@SubscribeEvent
	public static void modifyItemComponents(ModifyDefaultComponentsEvent event) {
		Consumable original = Items.HONEY_BOTTLE.components().get(DataComponents.CONSUMABLE);
		if (original != null) {
			List<ConsumeEffect> onConsumeEffects = new ArrayList<>(original.onConsumeEffects());
			onConsumeEffects.add(new RemoveStatusEffectsConsumeEffect(ForgottenFairyTalesModMobEffects.MAGICAL_CURSE));
			Consumable replacementConsumable = new Consumable(original.consumeSeconds(), original.animation(), original.sound(), original.hasConsumeParticles(), onConsumeEffects);
			event.modify(Items.HONEY_BOTTLE, builder -> builder.set(DataComponents.CONSUMABLE, replacementConsumable));
		}
	}
}