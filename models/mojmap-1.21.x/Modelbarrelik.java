// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbarrelik<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "barrelik"), "main");
	private final ModelPart bone;
	private final ModelPart bone12;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone5;
	private final ModelPart left_s;
	private final ModelPart bone9;

	public Modelbarrelik(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone12 = this.bone.getChild("bone12");
		this.bone2 = this.bone12.getChild("bone2");
		this.bone3 = this.bone12.getChild("bone3");
		this.bone4 = this.bone12.getChild("bone4");
		this.bone5 = this.bone12.getChild("bone5");
		this.left_s = this.bone12.getChild("left_s");
		this.bone9 = this.bone12.getChild("bone9");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone12 = bone.addOrReplaceChild("bone12",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -19.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-8.0F, -19.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.256F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = bone12.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(64, 14).addBox(2.0F,
				0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition bone3 = bone12.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(16, 64).addBox(-6.0F,
				0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition bone4 = bone12.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 64).addBox(-4.0F,
				-2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -11.0F, 0.0F));

		PartDefinition bone5 = bone12.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F,
				-2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -11.0F, 0.0F));

		PartDefinition left_s = bone12.addOrReplaceChild("left_s", CubeListBuilder.create(),
				PartPose.offset(0.0F, -8.0F, 11.0F));

		PartDefinition bone9 = bone12.addOrReplaceChild("bone9", CubeListBuilder.create(),
				PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition cube_r1 = bone9
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(64, 24).addBox(-3.0F, -11.0F, 0.0F, 7.0F, 12.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = bone9.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(33, 66).addBox(-3.0F, -11.0F, 0.0F, 7.0F, 12.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}