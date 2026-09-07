package net.saik.forgottenfairytales;
import net.saik.forgottenfairytales.network.ForgottenFairyTalesModVariables;
import net.neoforged.api.distmarker.Dist;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
@EventBusSubscriber(
    modid = "forgotten_fairy_tales",
    value = Dist.CLIENT
)
public class ZoomProcedureProcedure {

    @SubscribeEvent
    public static void onComputeFov(ViewportEvent.ComputeFov event) {

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player == null)
            return;

        if (minecraft.player.getData(
                ForgottenFairyTalesModVariables.PLAYER_VARIABLES
        ).IsZommed) {

            float fov = 35.0f -
                    5.0f * ZoomCrollProcedure.zoomLevel;

            event.setFOV(fov);
        }
    }
}