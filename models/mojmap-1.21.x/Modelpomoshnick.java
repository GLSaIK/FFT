// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelpomoshnick<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "pomoshnick"), "main");
	private final ModelPart bone9;
	private final ModelPart head;
	private final ModelPart bone10;
	private final ModelPart bone8;
	private final ModelPart bone11;
	private final ModelPart bone7;
	private final ModelPart bone12;
	private final ModelPart bone6;
	private final ModelPart bone13;
	private final ModelPart bone5;
	private final ModelPart bone14;
	private final ModelPart bone4;
	private final ModelPart bone15;
	private final ModelPart bone3;
	private final ModelPart bone16;
	private final ModelPart bone2;
	private final ModelPart bone17;
	private final ModelPart bone;

	public Modelpomoshnick(ModelPart root) {
		this.bone9 = root.getChild("bone9");
		this.head = this.bone9.getChild("head");
		this.bone10 = this.bone9.getChild("bone10");
		this.bone8 = this.bone10.getChild("bone8");
		this.bone11 = this.bone10.getChild("bone11");
		this.bone7 = this.bone11.getChild("bone7");
		this.bone12 = this.bone11.getChild("bone12");
		this.bone6 = this.bone12.getChild("bone6");
		this.bone13 = this.bone12.getChild("bone13");
		this.bone5 = this.bone13.getChild("bone5");
		this.bone14 = this.bone13.getChild("bone14");
		this.bone4 = this.bone14.getChild("bone4");
		this.bone15 = this.bone14.getChild("bone15");
		this.bone3 = this.bone15.getChild("bone3");
		this.bone16 = this.bone15.getChild("bone16");
		this.bone2 = this.bone16.getChild("bone2");
		this.bone17 = this.bone16.getChild("bone17");
		this.bone = this.bone17.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = bone9.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 72)
						.addBox(-3.0F, -26.0F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(13, 72)
						.addBox(-2.5F, -26.0F, 0.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.002F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone8 = bone10.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(64, 54).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("bone11", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone7 = bone11.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(64, 36).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition bone12 = bone11.addOrReplaceChild("bone12", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone6 = bone12.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(64, 18).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition bone13 = bone12.addOrReplaceChild("bone13", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone5 = bone13.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(64, 0).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition bone14 = bone13.addOrReplaceChild("bone14", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone4 = bone14.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 54).addBox(-8.0F,
				-2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition bone15 = bone14.addOrReplaceChild("bone15", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone3 = bone15.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 36).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition bone16 = bone15.addOrReplaceChild("bone16", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone2 = bone16.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 18).addBox(-8.0F,
				-4.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone17 = bone16.addOrReplaceChild("bone17", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = bone17.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F,
				-2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}