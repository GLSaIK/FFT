package net.saik.forgottenfairytales.client.renderer;

import net.saik.forgottenfairytales.entity.DflkhjEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class DflkhjRenderer extends HumanoidMobRenderer<DflkhjEntity, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
	private DflkhjEntity entity = null;

	public DflkhjRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HumanoidRenderState>(context.bakeLayer(ModelLayers.PLAYER)), 0.6f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
	}

	@Override
	public HumanoidRenderState createRenderState() {
		return new HumanoidRenderState();
	}

	@Override
	public void extractRenderState(DflkhjEntity entity, HumanoidRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(HumanoidRenderState state) {
		if (entity != null)
			return ResourceLocation.parse("forgotten_fairy_tales:textures/entities/" + entity.getTexture() + ".png");
		return ResourceLocation.parse("forgotten_fairy_tales:textures/entities/emptu.png");
	}
}