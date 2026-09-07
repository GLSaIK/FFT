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
public class ModelSwerh extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "model_swerh"), "main");
	public final ModelPart group2;
	public final ModelPart bone4;
	public final ModelPart bone2;
	public final ModelPart bone3;
	public final ModelPart bone;
	public final ModelPart bone5;

	public ModelSwerh(ModelPart root) {
		super(root);
		this.group2 = root.getChild("group2");
		this.bone4 = this.group2.getChild("bone4");
		this.bone2 = this.group2.getChild("bone2");
		this.bone3 = this.group2.getChild("bone3");
		this.bone = this.group2.getChild("bone");
		this.bone5 = root.getChild("bone5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offset(8.0F, 24.0F, -8.0F));
		PartDefinition bone4 = group2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(1, 36).addBox(-0.5F, -2.0F, 7.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.1F));
		PartDefinition bone2 = group2.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(1, 36).addBox(-0.5F, -2.0F, -8.1F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.0F));
		PartDefinition bone3 = group2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(1, 36).addBox(-8.1F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.0F));
		PartDefinition bone = group2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(1, 36).addBox(-1.9F, -5.0F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 6.0F));
		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

	}

}