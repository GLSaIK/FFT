// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBFS<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "bfs"),
			"main");
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart group2;
	private final ModelPart group3;
	private final ModelPart bone;
	private final ModelPart group;
	private final ModelPart group4;

	public ModelBFS(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.group2 = root.getChild("group2");
		this.group3 = this.group2.getChild("group3");
		this.bone = this.group2.getChild("bone");
		this.group = this.group2.getChild("group");
		this.group4 = this.group2.getChild("group4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -12.0F, 1.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 26.0F, 14.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(27, 4).addBox(-2.0F, -12.0F, 0.75F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(12.0F, 24.3F, -6.0F, 0.48F, 0.0F, -1.5708F));

		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(19, 52)
				.addBox(-1.5454F, -5.3793F, -9.0523F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0454F, 25.1293F, 9.9273F));

		PartDefinition group2_r1 = group2.addOrReplaceChild("group2_r1",
				CubeListBuilder.create().texOffs(32, 46).addBox(-3.0F, -0.375F, 0.0F, 3.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -2.3147F, -4.7831F, -0.6981F, 0.0F, 0.0F));

		PartDefinition group2_r2 = group2.addOrReplaceChild("group2_r2",
				CubeListBuilder.create().texOffs(50, 59).addBox(-1.0F, -0.25F, -2.625F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.4546F, -6.8281F, -5.6521F, 0.6109F, 0.0F, 0.0F));

		PartDefinition group2_r3 = group2.addOrReplaceChild("group2_r3",
				CubeListBuilder.create().texOffs(32, 46).addBox(-3.0F, -0.375F, 0.0F, 3.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -3.1281F, -10.0271F, 0.2182F, 0.0F, 0.0F));

		PartDefinition group2_r4 = group2.addOrReplaceChild("group2_r4",
				CubeListBuilder.create().texOffs(29, 56).addBox(-3.0F, 0.0F, -2.625F, 3.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -0.335F, -6.8441F, -0.0873F, 0.0F, 0.0F));

		PartDefinition group2_r5 = group2.addOrReplaceChild("group2_r5",
				CubeListBuilder.create().texOffs(46, 55).addBox(-3.0F, -3.0F, -6.0F, 3.0F, 3.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -0.1293F, -1.9273F, -0.4363F, 0.0F, 0.0F));

		PartDefinition group3 = group2.addOrReplaceChild("group3", CubeListBuilder.create(),
				PartPose.offset(0.7046F, -3.1281F, -8.5271F));

		PartDefinition group3_r1 = group3
				.addOrReplaceChild("group3_r1",
						CubeListBuilder.create().texOffs(41, 54).addBox(-1.0F, 0.625F, 0.0F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone = group2.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(24, 18)
						.addBox(-1.3F, -4.15F, -15.3F, 3.0F, 3.0F, 15.1F, new CubeDeformation(0.1F)).texOffs(19, 46)
						.addBox(-1.25F, -1.0F, -13.75F, 3.0F, 1.5F, 13.5F, new CubeDeformation(0.0F)).texOffs(0, 36)
						.addBox(-0.725F, -1.25F, -15.25F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(33, 17)
						.addBox(-1.25F, -4.05F, -15.515F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.2954F, -2.8793F, -8.8023F));

		PartDefinition group = group2.addOrReplaceChild("group", CubeListBuilder.create().texOffs(59, 27).addBox(-0.5F,
				-0.5F, 0.4F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0454F, -4.6293F, -23.9273F));

		PartDefinition group_r1 = group.addOrReplaceChild("group_r1",
				CubeListBuilder.create().texOffs(59, 27).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition group_r2 = group
				.addOrReplaceChild("group_r2",
						CubeListBuilder.create().texOffs(59, 27).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition group4 = group2.addOrReplaceChild("group4", CubeListBuilder.create().texOffs(59, 27)
				.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.9546F, -4.6293F, -23.9273F));

		PartDefinition group4_r1 = group4.addOrReplaceChild("group4_r1",
				CubeListBuilder.create().texOffs(59, 27).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition group4_r2 = group4
				.addOrReplaceChild("group4_r2",
						CubeListBuilder.create().texOffs(59, 27).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}