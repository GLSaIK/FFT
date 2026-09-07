package net.saik.forgottenfairytales.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.saik.forgottenfairytales.procedures.WeldingmaskoverlayUsloviiePokazaNalozhieniiaProcedure;
import net.saik.forgottenfairytales.procedures.WelddrobProcedure;
import net.saik.forgottenfairytales.procedures.Welddrob3Procedure;
import net.saik.forgottenfairytales.procedures.Welddrob2Procedure;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class WeldingmaskoverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (WeldingmaskoverlayUsloviiePokazaNalozhieniiaProcedure.execute(entity)) {
			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("forgotten_fairy_tales:textures/screens/binoculares.png"), 0, 0, 0, 0, w, h, w, h);
			if (Welddrob2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("forgotten_fairy_tales:textures/screens/palka_02_1.png"), w - 72, h - 50, 0, 0, 32, 32, 32, 32);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					Welddrob3Procedure.execute(entity), w - 52, h - 30, -6710887, false);
			if (Welddrob2Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						WelddrobProcedure.execute(entity), w - 65, h - 53, -6750208, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.forgotten_fairy_tales.weldingmaskoverlay.label_empty"), w / 2 + 0, 1, -1, false);
		}
	}
}