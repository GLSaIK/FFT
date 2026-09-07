/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.potion.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

public class ForgottenFairyTalesModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> SP = REGISTRY.register("sp", () -> new SpMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BROKEN_ARMOR = REGISTRY.register("broken_armor", () -> new DxghMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ARMOR = REGISTRY.register("armor", () -> new ArmorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> VOINBAFF = REGISTRY.register("voinbaff", () -> new VoinbaffMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SPEEDBUST = REGISTRY.register("speedbust", () -> new SpeedbustMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> EFFECTANIMATINGMATTERLIFE = REGISTRY.register("effectanimatingmatterlife", () -> new EffectanimatingmatterlifeMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLOCKREACHDECREASE = REGISTRY.register("blockreachdecrease", () -> new BlockreachdecreaseMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MAGICAL_CURSE = REGISTRY.register("magical_curse", () -> new MagicalCurseMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PICNIC_EFFECT = REGISTRY.register("picnic_effect", () -> new PicnicEffectMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> RUNE_OF_PROTECTION_EFFECT = REGISTRY.register("rune_of_protection_effect", () -> new RuneOfProtectionEffectMobEffect());
}