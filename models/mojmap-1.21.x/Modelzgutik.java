// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelzgutik<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "zgutik"), "main");
	private final ModelPart base;
	private final ModelPart saw;
	private final ModelPart one;
	private final ModelPart two;
	private final ModelPart three;
	private final ModelPart group;

	public Modelzgutik(ModelPart root) {
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
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-3.5F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(22, 30)
						.addBox(-1.5F, 3.0F, -1.0F, 1.0F, 4.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 30)
						.addBox(1.5F, 3.0F, -1.0F, 1.0F, 4.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 4)
						.addBox(-0.5F, 6.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
						.addBox(-0.5F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 13.0F, 0.0F));

		PartDefinition saw = base.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(22, 16).addBox(0.0F, -3.5F,
				-3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.5F, 0.0F));

		PartDefinition one = base.addOrReplaceChild("one", CubeListBuilder.create().texOffs(32, 7).addBox(-0.5F, -3.0F,
				0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 0.5F));

		PartDefinition two = one.addOrReplaceChild("two", CubeListBuilder.create().texOffs(32, 10).addBox(-0.5F, -3.0F,
				0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition three = two.addOrReplaceChild("three", CubeListBuilder.create().texOffs(32, 13).addBox(-0.5F,
				-3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition group = base.addOrReplaceChild("group", CubeListBuilder.create(),
				PartPose.offset(0.5F, 2.8F, 0.0F));

		PartDefinition cube_r1 = group
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -8.5F, -8.5F, 0.0F, 17.0F, 17.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}