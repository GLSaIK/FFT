/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class ForgottenFairyTalesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ForgottenFairyTalesMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> LASER2 = REGISTRY.register("laser2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "laser2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DRY = REGISTRY.register("dry", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "dry")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LOAD = REGISTRY.register("load", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "load")));
	public static final DeferredHolder<SoundEvent, SoundEvent> TPT = REGISTRY.register("tpt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "tpt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BOOK = REGISTRY.register("book", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "book")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCKSW2 = REGISTRY.register("blocksw2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "blocksw2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WRENCH = REGISTRY.register("wrench", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "wrench")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SALT = REGISTRY.register("salt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "salt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SALT2 = REGISTRY.register("salt2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "salt2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SALT3 = REGISTRY.register("salt3", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "salt3")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SHOT = REGISTRY.register("shot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "shot")));
}