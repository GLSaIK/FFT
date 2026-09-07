// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelFlagellantsChestplate<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "flagellantschestplate"), "main");
	private final ModelPart body;
	private final ModelPart bone;
	private final ModelPart bone5;
	private final ModelPart bone4;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart larm;
	private final ModelPart larm2;

	public ModelFlagellantsChestplate(ModelPart root) {
		this.body = root.getChild("body");
		this.bone = this.body.getChild("bone");
		this.bone5 = this.body.getChild("bone5");
		this.bone4 = this.body.getChild("bone4");
		this.bone3 = this.body.getChild("bone3");
		this.bone2 = this.body.getChild("bone2");
		this.larm = root.getChild("larm");
		this.larm2 = root.getChild("larm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.5F, -0.4F, -2.5F, 9.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(-4.0F, 4.6F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone = body.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(8, 27).addBox(-1.0F, -5.75F, 0.0F, 2.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.35F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(16, 27).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.1F, -0.05F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone5 = body.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(4, 27).addBox(-1.0F, -6.75F, 0.0F, 2.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 2.35F, 2.0F, -0.3927F, 0.0F, -0.7854F));

		PartDefinition bone4 = body.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(12, 27).addBox(-1.0F, -5.75F, 0.0F, 2.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 2.35F, 2.0F, -0.3927F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = bone4.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, -0.025F, 0.0F, 0.0F, 0.7854F));

		PartDefinition bone3 = body.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(24, 10).addBox(-1.0F, -6.75F, 0.0F, 2.0F, 7.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 0.35F, 2.0F, -0.3927F, 0.0F, -0.3927F));

		PartDefinition bone2 = body.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -7.75F, 0.0F, 2.0F, 8.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 0.35F, 2.0F, -0.3927F, 0.0F, 0.3927F));

		PartDefinition larm = partdefinition.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(20, 17).addBox(
				-2.0F, -3.4F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 27.0F, 0.0F));

		PartDefinition larm2 = partdefinition.addOrReplaceChild("larm2", CubeListBuilder.create().texOffs(20, 25)
				.addBox(-2.0F, -3.4F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, 27.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		larm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		larm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}