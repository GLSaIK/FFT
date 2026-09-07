package net.saik.forgottenfairytales.potion;

import net.saik.forgottenfairytales.procedures.BlockreachdecreaseKazhdyiTikVoVriemiaEffiektaProcedure;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModMobEffects;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

@EventBusSubscriber
public class BlockreachdecreaseMobEffect extends MobEffect {
	public BlockreachdecreaseMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13487566);
		this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(ForgottenFairyTalesMod.MODID, "effect.blockreachdecrease_0"), -100, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		BlockreachdecreaseKazhdyiTikVoVriemiaEffiektaProcedure.execute(entity);
		return super.applyEffectTick(level, entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, AbstractContainerScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, ForgottenFairyTalesModMobEffects.BLOCKREACHDECREASE.get());
	}
}