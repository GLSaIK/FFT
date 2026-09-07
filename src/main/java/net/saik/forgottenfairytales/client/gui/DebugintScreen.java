package net.saik.forgottenfairytales.client.gui;

import net.saik.forgottenfairytales.world.inventory.DebugintMenu;
import net.saik.forgottenfairytales.procedures.*;
import net.saik.forgottenfairytales.network.DebugintButtonMessage;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

public class DebugintScreen extends AbstractContainerScreen<DebugintMenu> implements ForgottenFairyTalesModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_hgfd;
	private Button button_reverse;
	private Button button_reverse1;
	private Button button_dien;
	private Button button_noch;
	private Button button_zalochit;
	private Button button_iasno;
	private Button button_dozhd;
	private Button button_zalochit1;
	private Button button_reverse2;
	private Button button_reverse3;
	private Button button_reverse4;

	public DebugintScreen(DebugintMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("forgotten_fairy_tales:textures/screens/debugint.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, M1Procedure.execute(entity), 29, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.forgotten_fairy_tales.debugint.label_klass"), 25, 4, -12829636, false);
		guiGraphics.drawString(this.font, M2Procedure.execute(entity), 28, 41, -12829636, false);
		guiGraphics.drawString(this.font, M3Procedure.execute(entity), 29, 61, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.forgotten_fairy_tales.debugint.label_drobovik"), 107, 4, -12829636, false);
		guiGraphics.drawString(this.font, D1Procedure.execute(entity), 120, 21, -12829636, false);
		guiGraphics.drawString(this.font, D2Procedure.execute(entity), 120, 39, -12829636, false);
		guiGraphics.drawString(this.font, D3Procedure.execute(entity), 120, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.forgotten_fairy_tales.debugint.label_poghoda"), 20, 107, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.forgotten_fairy_tales.debugint.label_poghoda1"), 127, 107, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_hgfd = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_hgfd"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(0, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 35, 23, 20).build();
		this.addRenderableWidget(button_hgfd);
		button_reverse = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_reverse"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(1, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 15, 23, 20).build();
		this.addRenderableWidget(button_reverse);
		button_reverse1 = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_reverse1"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(2, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 55, 23, 20).build();
		this.addRenderableWidget(button_reverse1);
		button_dien = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_dien"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(3, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 118, 28, 20).build();
		this.addRenderableWidget(button_dien);
		button_noch = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_noch"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(4, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 118, 28, 20).build();
		this.addRenderableWidget(button_noch);
		button_zalochit = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_zalochit"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(5, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 138, 56, 20).build();
		this.addRenderableWidget(button_zalochit);
		button_iasno = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_iasno"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(6, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 106, this.topPos + 118, 32, 20).build();
		this.addRenderableWidget(button_iasno);
		button_dozhd = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_dozhd"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(7, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 138, this.topPos + 118, 32, 20).build();
		this.addRenderableWidget(button_dozhd);
		button_zalochit1 = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_zalochit1"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(8, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 106, this.topPos + 138, 64, 20).build();
		this.addRenderableWidget(button_zalochit1);
		button_reverse2 = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_reverse2"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(9, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 15, 23, 20).build();
		this.addRenderableWidget(button_reverse2);
		button_reverse3 = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_reverse3"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(10, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 35, 23, 20).build();
		this.addRenderableWidget(button_reverse3);
		button_reverse4 = Button.builder(Component.translatable("gui.forgotten_fairy_tales.debugint.button_reverse4"), e -> {
			int x = DebugintScreen.this.x;
			int y = DebugintScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DebugintButtonMessage(11, x, y, z));
				DebugintButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 55, 23, 20).build();
		this.addRenderableWidget(button_reverse4);
	}
}