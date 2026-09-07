package net.saik.forgottenfairytales.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.saik.forgottenfairytales.procedures.*;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class DebugnalozOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
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
		if (Deb2Procedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.forgotten_fairy_tales.debugnaloz.label_klass"), 1, h - 64, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					M1Procedure.execute(entity), 2, h - 53, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					M2Procedure.execute(entity), 2, h - 43, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					M3Procedure.execute(entity), 2, h - 32, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HPProcedure.execute(world, entity), w / 2 + -5, 13, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.forgotten_fairy_tales.debugnaloz.label_empty3"), w / 2 + -5, h / 2 + -106, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.forgotten_fairy_tales.debugnaloz.label_hp1"), w / 2 + -5, 3, -1, false);
			if (DrProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.forgotten_fairy_tales.debugnaloz.label_drobovik"), w / 2 + -182, h / 2 + 55, -1, false);
			if (DrProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D1Procedure.execute(entity), w / 2 + -182, h / 2 + 67, -1, false);
			if (DrProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D2Procedure.execute(entity), w / 2 + -182, h / 2 + 77, -1, false);
			if (DrProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						D3Procedure.execute(entity), w / 2 + -182, h / 2 + 87, -1, false);
		}
	}
}