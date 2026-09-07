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
public class Modelhat extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "modelhat"), "main");
	public final ModelPart bone;
	public final ModelPart group;

	public Modelhat(ModelPart root) {
		super(root);
		this.bone = root.getChild("bone");
		this.group = this.bone.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition group = bone.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.8F, -7.9F, 16.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-6.0F, -13.6F, -5.9F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(40, 47)
						.addBox(-6.0F, -14.6F, -5.9F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 20).addBox(5.0F, -14.6F, -5.9F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 58)
						.addBox(-5.0F, -14.6F, 3.1F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(26, 60).addBox(-5.0F, -14.6F, -5.9F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.15F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 56).addBox(1.0F, -3.1F, 2.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.1F, -4.6F, -7.9F, 0.0F, 0.0F, -0.192F));
		PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 33).addBox(0.0F, 2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8F, -5.9F, -7.9F, 0.0F, 0.0F, -0.192F));
		PartDefinition cube_r3 = group.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(14, 62).addBox(-9.0F, -4.0F, 12.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(12, 62).addBox(-9.0F, -4.0F, 22.2F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.6F, -11.7F, -17.0F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r4 = group.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(10, 62).addBox(-9.0F, -4.0F, 12.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 62).addBox(-9.0F, -4.0F, 1.8F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -12.0F, -6.8F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r5 = group.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 60).addBox(-8.0F, -3.0F, 6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.7F, -23.5F, -6.9F, 0.0F, 0.0F, 0.637F));
		PartDefinition cube_r6 = group.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(8, 62).addBox(-13.0F, -4.0F, 12.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 62).addBox(-13.0F, -4.0F, 14.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 62)
						.addBox(-13.0F, -4.0F, 19.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 62).addBox(-13.0F, -4.0F, 16.9F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.2F, -11.0F, -16.2F, 0.0F, 0.0F, 0.2443F));
		PartDefinition cube_r7 = group.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(52, 60).addBox(-12.0F, -3.8F, 6.4F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.4F, -14.9F, -7.9F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r8 = group.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 49).addBox(-9.0F, -3.0F, 5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.1F, -22.85F, -6.9F, 0.0F, 0.0F, 0.3316F));
		PartDefinition cube_r9 = group.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 49).addBox(-10.0F, -3.0F, 4.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, -20.3F, -6.9F, 0.0F, 0.0F, 0.3316F));
		PartDefinition cube_r10 = group.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(40, 35).addBox(-11.0F, -4.0F, 3.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -16.7F, -6.9F, 0.0F, 0.0F, 0.3316F));
		PartDefinition cube_r11 = group.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 35).addBox(-12.0F, -4.0F, 2.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -14.0F, -6.9F, 0.0F, 0.0F, 0.2182F));
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