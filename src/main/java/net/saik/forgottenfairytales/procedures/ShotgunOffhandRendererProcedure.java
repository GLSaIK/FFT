package net.saik.forgottenfairytales.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;
import net.saik.forgottenfairytales.ForgottenFairyTalesMod;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;


@EventBusSubscriber(
        modid = "forgotten_fairy_tales",
        value = Dist.CLIENT
)
public class ShotgunOffhandRendererProcedure {

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player == null) {
            return;
        }

        // RenderHandEvent вызывается только для первого лица,
        // поэтому отдельная проверка камеры здесь не нужна.

        // Нас интересует только предмет в дополнительной руке
        if (event.getHand() != InteractionHand.OFF_HAND) {
            return;
        }

        // Предмет в основной руке
        ItemStack mainHand = minecraft.player.getMainHandItem();

        // Если в основной руке не дробовик — ничего не делаем
        if ((!mainHand.is(ForgottenFairyTalesModItems.BFS.get())) && (!mainHand.is(ForgottenFairyTalesModItems.SHOTGUN.get()))) {
            return;
        }

        PoseStack poseStack = event.getPoseStack();

        // Уводим предмет дополнительной руки вниз
        poseStack.translate(0.0D, -1.0D, 0.0D);
    }
}