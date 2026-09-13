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
public class ModelFlagellantsbreastplate extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "model_flagellantsbreastplate"), "main");
	public final ModelPart bone4;
	public final ModelPart bone;
	public final ModelPart bone2;
	public final ModelPart bone3;

	public ModelFlagellantsbreastplate(ModelPart root) {
		super(root);
		this.bone4 = root.getChild("bone4");
		this.bone = this.bone4.getChild("bone");
		this.bone2 = this.bone4.getChild("bone2");
		this.bone3 = this.bone4.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone4 = partdefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition bone = bone4.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.4F)).texOffs(0, 48).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.29F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition bone2 = bone4.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 4).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.0F, 2.0F, -0.2082F, 0.4836F, -0.386F));
		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 8).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 2.0F, 0.026F, 0.5225F, 0.5773F));
		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 2).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0914F, 0.2457F, 0.8403F));
		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 6).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -1.0F, -1.0F, 0.7532F, -1.1777F, -1.0757F));
		PartDefinition cube_r5 = bone2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 10).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 1.0F, 1.0F, 0.3381F, -0.0886F, -0.8442F));
		PartDefinition cube_r6 = bone2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -1.0F, 0.0F, 0.0F, -0.3491F, 0.48F));
		PartDefinition bone3 = bone4.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(24, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.29F)),
				PartPose.offset(5.0F, 0.0F, 0.0F));
		PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 25).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.7F, 7.0F, 2.7F, -3.0774F, -1.0407F, 2.3289F));
		PartDefinition cube_r8 = bone3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 14).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7F, 8.0F, 2.7F, -2.0302F, -1.0407F, 2.3289F));
		PartDefinition cube_r9 = bone3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 12).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.7F, 5.0F, 2.7F, -0.7518F, -0.8453F, 0.8479F));
		PartDefinition cube_r10 = bone3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 27).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3F, 5.0F, 1.7F, -0.9599F, -0.5672F, 0.5672F));
		PartDefinition cube_r11 = bone3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 29).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.3F, 7.0F, -2.3F, -1.5708F, 0.8727F, 1.4399F));
		PartDefinition cube_r12 = bone3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 27).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.3F, 5.0F, -2.3F, -1.5708F, 0.6545F, 0.5672F));
		PartDefinition cube_r13 = bone3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 29).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 7.0F, 0.0F, -1.1781F, 0.0F, 0.5672F));
		PartDefinition cube_r14 = bone3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(24, 25).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 9.0F, 0.0F, -1.1781F, 0.0F, 0.5672F));
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