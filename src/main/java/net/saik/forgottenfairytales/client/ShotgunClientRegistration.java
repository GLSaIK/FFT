package net.saik.forgottenfairytales.client;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import net.saik.forgottenfairytales.init.ForgottenFairyTalesModItems;

public class ShotgunClientRegistration {

    public static void register(RegisterClientExtensionsEvent event) {
        event.registerItem(
            new ShotgunClientExtensions(),
            ForgottenFairyTalesModItems.SHOTGUN.get(),
            ForgottenFairyTalesModItems.BFS.get()
        );
    }
}