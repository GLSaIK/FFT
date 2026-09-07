// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelSwerh<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "swerh"), "main");
	private final ModelPart group2;
	private final ModelPart bone4;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone;
	private final ModelPart bone5;

	public ModelSwerh(ModelPart root) {
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

		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create(),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		PartDefinition bone4 = group2.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(1, 36).addBox(-0.5F,
				-2.0F, 7.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.1F));

		PartDefinition bone2 = group2.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(1, 36).addBox(-0.5F,
				-2.0F, -8.1F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.0F));

		PartDefinition bone3 = group2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(1, 36).addBox(-8.1F,
				-2.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -8.0F, 8.0F));

		PartDefinition bone = group2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(1, 36).addBox(-1.9F,
				-5.0F, 1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 6.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}