// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBunchOfArrowsR<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bunchofarrowsr"), "main");
	private final ModelPart arrows;

	public ModelBunchOfArrowsR(ModelPart root) {
		this.arrows = root.getChild("arrows");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrows = partdefinition.addOrReplaceChild("arrows", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-1.0F, 23.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r1 = arrows.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(62, 23)
						.addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(43, 26)
						.addBox(1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(62, 23)
						.addBox(5.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 1.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = arrows.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 4.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r3 = arrows.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 4.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r4 = arrows.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -1.0F, 3.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r5 = arrows.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(62, 23).addBox(1.0F, -1.5F, -11.0F, 0.0F, 3.0F, 12.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 6.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r6 = arrows
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(43, 26).addBox(-1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r7 = arrows
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(43, 26).addBox(-1.5F, -1.0F, -11.0F, 3.0F, 0.0F, 12.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		arrows.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}