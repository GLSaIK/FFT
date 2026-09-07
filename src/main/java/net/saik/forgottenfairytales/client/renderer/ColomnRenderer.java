package net.saik.forgottenfairytales.client.renderer;

import net.saik.forgottenfairytales.entity.ColomnEntity;
import net.saik.forgottenfairytales.client.model.Modelcolomnnew;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ColomnRenderer extends MobRenderer<ColomnEntity, LivingEntityRenderState, Modelcolomnnew> {
	private ColomnEntity entity = null;

	public ColomnRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcolomnnew(context.bakeLayer(Modelcolomnnew.LAYER_LOCATION)), 1f);
		this.addLayer(new RenderLayer<>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("forgotten_fairy_tales:textures/entities/colomntexture.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, LivingEntityRenderState state, float headYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
			}
		});
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(ColomnEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		if (entity != null)
			return ResourceLocation.parse("forgotten_fairy_tales:textures/entities/" + entity.getTexture() + ".png");
		return ResourceLocation.parse("forgotten_fairy_tales:textures/entities/colomntexture.png");
	}
}