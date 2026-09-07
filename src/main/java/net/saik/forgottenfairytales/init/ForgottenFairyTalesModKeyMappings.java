/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import org.lwjgl.glfw.GLFW;

import net.saik.forgottenfairytales.network.ZoomMessage;
import net.saik.forgottenfairytales.network.ZMessage;
import net.saik.forgottenfairytales.network.TestsdMessage;
import net.saik.forgottenfairytales.network.ReloadMessage;
import net.saik.forgottenfairytales.network.HatkeyMessage;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(Dist.CLIENT)
public class ForgottenFairyTalesModKeyMappings {
	public static final KeyMapping TESTSD = new KeyMapping("key.forgotten_fairy_tales.testsd", GLFW.GLFW_KEY_I, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new TestsdMessage(0, 0));
				TestsdMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping HATKEY = new KeyMapping("key.forgotten_fairy_tales.hatkey", GLFW.GLFW_KEY_TAB, "key.categories.fft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new HatkeyMessage(0, 0));
				HatkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping RELOAD = new KeyMapping("key.forgotten_fairy_tales.reload", GLFW.GLFW_KEY_R, "key.categories.fft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new ReloadMessage(0, 0));
				ReloadMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping Z = new KeyMapping("key.forgotten_fairy_tales.z", GLFW.GLFW_KEY_Z, "key.categories.fft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new ZMessage(0, 0));
				ZMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ZOOMKEY = new KeyMapping("key.forgotten_fairy_tales.zoomkey", GLFW.GLFW_KEY_C, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new ZoomMessage(0, 0));
				ZoomMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				ZOOMKEY_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - ZOOMKEY_LASTPRESS);
				ClientPacketDistributor.sendToServer(new ZoomMessage(1, dt));
				ZoomMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long ZOOMKEY_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TESTSD);
		event.register(HATKEY);
		event.register(RELOAD);
		event.register(Z);
		event.register(ZOOMKEY);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				TESTSD.consumeClick();
				HATKEY.consumeClick();
				RELOAD.consumeClick();
				Z.consumeClick();
				ZOOMKEY.consumeClick();
			}
		}
	}
}