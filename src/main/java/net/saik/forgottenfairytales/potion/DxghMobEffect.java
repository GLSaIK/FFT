package net.saik.forgottenfairytales.potion;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

public class DxghMobEffect extends MobEffect {
	public DxghMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(ForgottenFairyTalesMod.MODID, "effect.broken_armor_0"), -5, AttributeModifier.Operation.ADD_VALUE);
	}
}