// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelshotgun<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "shotgun"), "main");
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart bone6;
	private final ModelPart bone5;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone15;
	private final ModelPart bone16;
	private final ModelPart bone17;
	private final ModelPart bone18;
	private final ModelPart bone19;
	private final ModelPart bone20;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone12;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart bone21;
	private final ModelPart bone22;
	private final ModelPart bone23;
	private final ModelPart bone24;
	private final ModelPart bone25;
	private final ModelPart bone26;

	public Modelshotgun(ModelPart root) {
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.bone = root.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.bone4 = this.bone2.getChild("bone4");
		this.bone3 = this.bone4.getChild("bone3");
		this.bone6 = this.bone4.getChild("bone6");
		this.bone5 = this.bone4.getChild("bone5");
		this.bone7 = this.bone4.getChild("bone7");
		this.bone8 = this.bone4.getChild("bone8");
		this.bone15 = this.bone2.getChild("bone15");
		this.bone16 = this.bone15.getChild("bone16");
		this.bone17 = this.bone15.getChild("bone17");
		this.bone18 = this.bone15.getChild("bone18");
		this.bone19 = this.bone15.getChild("bone19");
		this.bone20 = this.bone15.getChild("bone20");
		this.bone9 = this.bone2.getChild("bone9");
		this.bone10 = this.bone9.getChild("bone10");
		this.bone11 = this.bone9.getChild("bone11");
		this.bone12 = this.bone9.getChild("bone12");
		this.bone13 = this.bone9.getChild("bone13");
		this.bone14 = this.bone9.getChild("bone14");
		this.bone21 = this.bone2.getChild("bone21");
		this.bone22 = this.bone21.getChild("bone22");
		this.bone23 = this.bone21.getChild("bone23");
		this.bone24 = this.bone21.getChild("bone24");
		this.bone25 = this.bone21.getChild("bone25");
		this.bone26 = this.bone21.getChild("bone26");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(26, 16).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 20.0F, -1.5F, 2.2579F, 0.1261F, 1.1978F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 21.0F, 8.5F, -1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r1 = right_arm
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(26, 0).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(24, 39)
						.addBox(-1.5F, -6.5F, -7.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 39)
						.addBox(-1.0F, -6.5F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 23.5F, 2.5F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(42, 35).addBox(-0.5F, -2.5347F, -1.101F, 1.0F, 2.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2F, -5.1833F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(42, 9).addBox(-1.0F, -1.0F, 0.975F, 2.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2F, -5.5F, -8.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(42, 6).addBox(-1.0F, -1.0F, 0.975F, 2.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.2F, -5.5F, -8.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(42, 33)
						.addBox(-0.5F, -1.5F, 1.8833F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(42, 0)
						.addBox(-0.5F, 0.5F, -1.1167F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.2F, -5.1833F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r6 = bone.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(42, 30).addBox(0.0F, -1.0F, -0.5F, 0.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.1F, -5.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bone.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(42, 12).addBox(-0.5F, -1.0F, -0.4F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.4F, -2.5F, -1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r8 = bone.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(12, 38).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.275F, -0.4F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r9 = bone.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 38).addBox(-1.0F, -1.5F, -3.5F, 2.0F, 3.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.5F, -1.5F, -0.7418F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(26, 32)
						.addBox(-1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-1.5F, -2.0F, -10.025F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(24, 38)
						.addBox(-0.5F, -3.0F, -10.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -4.5F, -7.0F));

		PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.2F, -1.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2F, -1.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(42, 3).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.2066F, -5.3912F, -0.6545F, 0.0F, 0.0F));

		PartDefinition bone4 = bone2.addOrReplaceChild("bone4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.24F, -1.08F, -10.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition bone3 = bone4.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(42, 14).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.06F, 0.58F, 0.0F));

		PartDefinition bone6 = bone4.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(42, 20).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.14F, -0.42F, 0.0F));

		PartDefinition bone5 = bone4.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(42, 17).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.26F, 0.18F, 0.0F));

		PartDefinition bone7 = bone4.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(42, 23).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.16F, -0.42F, 0.0F));

		PartDefinition bone8 = bone4.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(42, 26).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.34F, 0.08F, 0.0F));

		PartDefinition bone15 = bone2.addOrReplaceChild("bone15", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.24F, -1.08F, -10.0F, 0.0F, 0.0F, -1.309F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(42, 14).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.06F, 0.58F, 0.0F));

		PartDefinition bone17 = bone15.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(42, 20).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.14F, -0.42F, 0.0F));

		PartDefinition bone18 = bone15.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(42, 17).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.26F, 0.18F, 0.0F));

		PartDefinition bone19 = bone15.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(42, 23).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.16F, -0.42F, 0.0F));

		PartDefinition bone20 = bone15.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(42, 26).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.34F, 0.08F, 0.0F));

		PartDefinition bone9 = bone2.addOrReplaceChild("bone9", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.16F, -1.08F, -10.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(42, 14).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.06F, 0.58F, 0.0F));

		PartDefinition bone11 = bone9.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(42, 20).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.14F, -0.42F, 0.0F));

		PartDefinition bone12 = bone9.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(42, 17).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.26F, 0.18F, 0.0F));

		PartDefinition bone13 = bone9.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(42, 23).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.16F, -0.42F, 0.0F));

		PartDefinition bone14 = bone9.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(42, 26).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.34F, 0.08F, 0.0F));

		PartDefinition bone21 = bone2.addOrReplaceChild("bone21", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.16F, -1.08F, -10.0F, 0.0F, 0.0F, -1.8326F));

		PartDefinition bone22 = bone21.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(42, 14).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.06F, 0.48F, 0.0F));

		PartDefinition bone23 = bone21.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(42, 20).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.14F, -0.42F, 0.0F));

		PartDefinition bone24 = bone21.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(42, 17).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.26F, 0.18F, 0.0F));

		PartDefinition bone25 = bone21.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(42, 23).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.16F, -0.42F, 0.0F));

		PartDefinition bone26 = bone21.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(42, 26).addBox(0.0F,
				-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.34F, 0.08F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}