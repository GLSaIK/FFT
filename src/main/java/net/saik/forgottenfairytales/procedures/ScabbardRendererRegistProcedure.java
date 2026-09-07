
package net.saik.forgottenfairytales.procedures;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import net.saik.forgottenfairytales.ForgottenFairyTalesMod;


/**
 * Регистрация декоративного RenderLayer для игроков.
 */
@EventBusSubscriber(
        modid = ForgottenFairyTalesMod.MODID
)
public class ScabbardRendererRegistProcedure {

    @SubscribeEvent
    public static void addPlayerLayers(
            EntityRenderersEvent.AddLayers event) {

        /*
         * Получаем все доступные варианты моделей игрока.
         *
         * Используем var, чтобы не зависеть от конкретного
         * имени класса PlayerSkin.Model в этой версии.
         */
        for (var skin : event.getSkins()) {

            /*
             * Получаем рендерер данного варианта игрока.
             */
            EntityRenderer<?, ?> renderer = event.getSkin(skin);

            /*
             * Проверяем, что это именно PlayerRenderer.
             */
            if (renderer instanceof PlayerRenderer playerRenderer) {

                /*
                 * Добавляем наш декоративный слой.
                 */
                playerRenderer.addLayer(
                        new ScabbardRendererProcedure(
                                playerRenderer
                        )
                );
            }
        }
    }
}
