/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.client.renderer.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class ForgottenFairyTalesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.COLOMN.get(), ColomnRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.BEAM.get(), BeamRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.DFLKHJ.get(), DflkhjRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.SHBUT.get(), ShbutRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.FIREBALLL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.BUCHOFARROWS.get(), BuchofarrowsRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.LIVINGBRICKS.get(), LivingbricksRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.BARELIK.get(), BarelikRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.CURSED_FIREBALL.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.STRAUSINGO.get(), StrausingoRenderer::new);
		event.registerEntityRenderer(ForgottenFairyTalesModEntities.ZGUTIK.get(), ZgutikRenderer::new);
	}
}