package net.saik.forgottenfairytales.network;

import net.saik.forgottenfairytales.procedures.*;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

@EventBusSubscriber
public record DebugintButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<DebugintButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ForgottenFairyTalesMod.MODID, "debugint_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DebugintButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DebugintButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DebugintButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<DebugintButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DebugintButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			M22Procedure.execute(entity);
		}
		if (buttonID == 1) {

			M12Procedure.execute(entity);
		}
		if (buttonID == 2) {

			M32Procedure.execute(entity);
		}
		if (buttonID == 3) {

			DayProcedure.execute(world);
		}
		if (buttonID == 4) {

			NightProcedure.execute(world);
		}
		if (buttonID == 5) {

			LockdayProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			WclearProcedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			WrainProcedure.execute(world, x, y, z);
		}
		if (buttonID == 8) {

			WlockProcedure.execute(world, x, y, z);
		}
		if (buttonID == 9) {

			D11Procedure.execute(entity);
		}
		if (buttonID == 10) {

			D22Procedure.execute(entity);
		}
		if (buttonID == 11) {

			F32Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ForgottenFairyTalesMod.addNetworkMessage(DebugintButtonMessage.TYPE, DebugintButtonMessage.STREAM_CODEC, DebugintButtonMessage::handleData);
	}
}