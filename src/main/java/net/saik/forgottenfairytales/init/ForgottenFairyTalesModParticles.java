/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.saik.forgottenfairytales.init;

import net.saik.forgottenfairytales.client.particle.KatanaParticleParticle;
import net.saik.forgottenfairytales.client.particle.BrownSmokeParticleParticle;
import net.saik.forgottenfairytales.client.particle.BarrierParticle;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class ForgottenFairyTalesModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ForgottenFairyTalesModParticleTypes.BARRIER.get(), BarrierParticle::provider);
		event.registerSpriteSet(ForgottenFairyTalesModParticleTypes.KATANA_PARTICLE.get(), KatanaParticleParticle::provider);
		event.registerSpriteSet(ForgottenFairyTalesModParticleTypes.BROWN_SMOKE_PARTICLE.get(), BrownSmokeParticleParticle::provider);
	}
}