package net.saik.forgottenfairytales.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelBunchOfArrowsR extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "model_bunch_of_arrows_r"), "main");
	public final ModelPart arrows;

	public ModelBunchOfArrowsR(ModelPart root) {
		super(root);
		this.arrows = root.getChild("arrows");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition arrows = partdefinition.addOrReplaceChild("arrows", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 23.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition cube_r1 = arrows.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(43, 26)
				.addBox(1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(62, 23).addBox(5.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 1.0F, 6.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r2 = arrows.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 4.0F, 0.0F, 0.3927F, 0.0F));
		PartDefinition cube_r3 = arrows.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 4.0F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r4 = arrows.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 3.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r5 = arrows.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 6.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r6 = arrows.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(43, 26).addBox(-1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r7 = arrows.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(43, 26).addBox(-1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, 0.0F, 0.0F, -0.3927F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}