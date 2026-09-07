package net.saik.forgottenfairytales;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.api.distmarker.Dist;
@EventBusSubscriber(
    modid = "forgotten_fairy_tales",
    value = Dist.CLIENT
)
public class ZoomCrollProcedure {

    public static int zoomLevel = 1;

    @SubscribeEvent
    public static void onMouseScroll(InputEvent.MouseScrollingEvent event) {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player == null)
            return;

        if (!minecraft.player.getData(
                ForgottenFairyTalesModVariables.PLAYER_VARIABLES
        ).IsZommed) {
            return;
        }

        double scroll = event.getScrollDeltaY();

        if (scroll > 0) {
            if (zoomLevel < 6) {
                zoomLevel++;
            }

        }

        else if (scroll < 0) {
            if (zoomLevel > 1) {
                zoomLevel--;
            }

        }

        event.setCanceled(true);
    }

    public static void resetZoom() {
        zoomLevel = 1;
    }
}