package net.saik.forgottenfairytales.client.particle;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;

public class BrownSmokeParticleParticle extends TextureSheetParticle {
	public static BrownSmokeParticleParticleProvider provider(SpriteSet spriteSet) {
		return new BrownSmokeParticleParticleProvider(spriteSet);
	}

	public static class BrownSmokeParticleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BrownSmokeParticleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new BrownSmokeParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected BrownSmokeParticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.5f, 0.5f);
		this.quadSize *= 5f;
		this.lifetime = (int) Math.max(1, 85 + (this.random.nextInt(20) - 10));
		this.gravity = -0.1f;
		this.hasPhysics = true;
		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
    	super.tick();

    	float lifeProgress = (float) this.age / (float) this.lifetime;

    	if (lifeProgress > 0.90f) {
        	float fadeProgress = (lifeProgress - 0.90f) / 0.10f;
        this.alpha = 1.0f - fadeProgress * fadeProgress;
    	}
	}
}