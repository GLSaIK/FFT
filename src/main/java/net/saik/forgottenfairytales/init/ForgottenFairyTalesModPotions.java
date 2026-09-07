/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

public class ForgottenFairyTalesModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<Potion, Potion> BROKENARMOR = REGISTRY.register("brokenarmor", () -> new Potion("brokenarmor", new MobEffectInstance(ForgottenFairyTalesModMobEffects.BROKEN_ARMOR, 3600, 0, false, true)));
}