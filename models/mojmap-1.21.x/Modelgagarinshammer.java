// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelgagarinshammer<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "gagarinshammer"), "main");
	private final ModelPart bone;
	private final ModelPart left_arm;
	private final ModelPart right_arm;

	public Modelgagarinshammer(ModelPart root) {
		this.bone = root.getChild("bone");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(20, 18)
						.addBox(-1.1665F, -13.7096F, -1.37F, 2.0F, 17.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 30).addBox(-1.6665F, -5.7096F, -1.87F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
						.texOffs(0, 0).addBox(-3.1665F, -12.7096F, -5.87F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
						.texOffs(0, 18).addBox(-3.6665F, -13.2096F, -6.37F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(36, 9).addBox(-1.3339F, -9.6614F, -7.02F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.1665F, 20.7096F, -0.13F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(48, 48).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.7038F, 36.9483F, 34.4431F, 2.3015F, 0.1261F, 1.1978F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 20.9128F, 9.4962F, -1.4835F, 0.0F, 0.0F));

		PartDefinition cube_r1 = right_arm
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(34, 48).addBox(-2.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}