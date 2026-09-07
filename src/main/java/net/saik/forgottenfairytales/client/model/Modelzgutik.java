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
public class Modelzgutik extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("forgotten_fairy_tales", "modelzgutik"), "main");
	public final ModelPart base;
	public final ModelPart saw;
	public final ModelPart one;
	public final ModelPart two;
	public final ModelPart three;
	public final ModelPart group;

	public Modelzgutik(ModelPart root) {
		super(root);
		this.base = root.getChild("base");
		this.saw = this.base.getChild("saw");
		this.one = this.base.getChild("one");
		this.two = this.one.getChild("two");
		this.three = this.two.getChild("three");
		this.group = this.base.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition base = partdefinition.addOrReplaceChild("base",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(22, 30).addBox(-1.5F, 3.0F, -1.0F, 1.0F, 4.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 30)
						.addBox(1.5F, 3.0F, -1.0F, 1.0F, 4.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 4).addBox(-0.5F, 6.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-0.5F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 13.0F, 0.0F));
		PartDefinition saw = base.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(22, 16).addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.5F, 0.0F));
		PartDefinition one = base.addOrReplaceChild("one", CubeListBuilder.create().texOffs(32, 7).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 0.5F));
		PartDefinition two = one.addOrReplaceChild("two", CubeListBuilder.create().texOffs(32, 10).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));
		PartDefinition three = two.addOrReplaceChild("three", CubeListBuilder.create().texOffs(32, 13).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));
		PartDefinition group = base.addOrReplaceChild("group", CubeListBuilder.create(), PartPose.offset(0.5F, 2.8F, 0.0F));
		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -8.5F, -8.5F, 0.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
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