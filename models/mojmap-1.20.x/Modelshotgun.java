// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelshotgun<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "shotgun"), "main");
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart gun;
	private final ModelPart trigger;
	private final ModelPart barrel;
	private final ModelPart shoone;
	private final ModelPart shottwo;

	public Modelshotgun(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.gun = root.getChild("gun");
		this.trigger = this.gun.getChild("trigger");
		this.barrel = this.gun.getChild("barrel");
		this.shoone = this.gun.getChild("shoone");
		this.shottwo = this.gun.getChild("shottwo");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
				.texOffs(28, 45).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 26.0F, 11.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(7, 47)
				.addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, 26.0F, -6.0F));

		PartDefinition gun = partdefinition.addOrReplaceChild("gun", CubeListBuilder.create().texOffs(2, 53).mirror()
				.addBox(-1.5454F, -3.1293F, -1.9273F, 3.0F, 3.0F, 1.5F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(19, 52).addBox(-1.5454F, -5.3793F, -9.0523F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0454F, 25.1293F, 9.9273F));

		PartDefinition group2_r1 = gun.addOrReplaceChild("group2_r1",
				CubeListBuilder.create().texOffs(39, 43).addBox(-3.0F, -0.375F, 0.0F, 3.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -2.3147F, -4.7831F, -0.6981F, 0.0F, 0.0F));

		PartDefinition group2_r2 = gun.addOrReplaceChild("group2_r2",
				CubeListBuilder.create().texOffs(39, 48).addBox(-2.0F, -0.25F, -2.625F, 2.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.7046F, -6.8281F, -5.6521F, 0.6109F, 0.0F, 0.0F));

		PartDefinition group2_r3 = gun.addOrReplaceChild("group2_r3",
				CubeListBuilder.create().texOffs(39, 43).addBox(-3.0F, -0.375F, 0.0F, 3.0F, 3.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -3.1281F, -10.0271F, 0.2182F, 0.0F, 0.0F));

		PartDefinition group2_r4 = gun.addOrReplaceChild("group2_r4",
				CubeListBuilder.create().texOffs(37, 55).addBox(-3.0F, 0.0F, -2.625F, 3.0F, 0.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -0.335F, -6.8441F, -0.0873F, 0.0F, 0.0F));

		PartDefinition group2_r5 = gun.addOrReplaceChild("group2_r5",
				CubeListBuilder.create().texOffs(46, 55).addBox(-3.0F, -3.0F, -6.0F, 3.0F, 3.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4546F, -0.1293F, -1.9273F, -0.4363F, 0.0F, 0.0F));

		PartDefinition trigger = gun.addOrReplaceChild("trigger", CubeListBuilder.create(),
				PartPose.offset(0.7046F, -3.1281F, -8.5271F));

		PartDefinition group3_r1 = trigger
				.addOrReplaceChild("group3_r1",
						CubeListBuilder.create().texOffs(39, 37).addBox(-1.5F, -0.375F, 0.0F, 1.5F, 3.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition barrel = gun.addOrReplaceChild("barrel",
				CubeListBuilder.create().texOffs(0, 46)
						.addBox(0.2F, -2.55F, -15.3F, 1.6F, 1.6F, 15.0F, new CubeDeformation(0.1F)).texOffs(24, 18)
						.addBox(-1.3F, -2.55F, -15.3F, 1.6F, 1.6F, 15.1F, new CubeDeformation(0.1F)).texOffs(19, 45)
						.addBox(-1.25F, -2.0F, -13.75F, 3.0F, 2.0F, 13.5F, new CubeDeformation(0.0F)).texOffs(0, 36)
						.addBox(-0.625F, -1.25F, -15.25F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(33, 17)
						.addBox(-1.25F, -2.5F, -15.415F, 1.4F, 1.4F, 0.0F, new CubeDeformation(0.0F)).texOffs(33, 17)
						.addBox(0.35F, -2.5F, -15.415F, 1.4F, 1.4F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.2954F, -2.8793F, -8.8023F));

		PartDefinition bone_r1 = barrel.addOrReplaceChild("bone_r1",
				CubeListBuilder.create().texOffs(17, 28)
						.addBox(-1.45F, -1.95F, -12.151F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 4)
						.addBox(-2.0F, -1.95F, -12.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.75F, -1.0F, -3.625F, -0.0436F, 0.0F, 0.0F));

		PartDefinition shoone = gun.addOrReplaceChild("shoone", CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F,
				-1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0454F, -4.6293F, -24.9273F));

		PartDefinition group_r1 = shoone.addOrReplaceChild("group_r1",
				CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition group_r2 = shoone
				.addOrReplaceChild("group_r2",
						CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition shottwo = gun.addOrReplaceChild("shottwo", CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F,
				-1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.9546F, -4.6293F, -24.9273F));

		PartDefinition group4_r1 = shottwo.addOrReplaceChild("group4_r1",
				CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition group4_r2 = shottwo
				.addOrReplaceChild("group4_r2",
						CubeListBuilder.create().texOffs(50, 27).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

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
		gun.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}