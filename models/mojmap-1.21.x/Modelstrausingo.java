// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelstrausingo<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "strausingo"), "main");
	private final ModelPart Ostringo;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart BodyR;
	private final ModelPart Body;
	private final ModelPart Fly;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart Tail;
	private final ModelPart neckhead;
	private final ModelPart neckB;
	private final ModelPart Head;

	public Modelstrausingo(ModelPart root) {
		this.Ostringo = root.getChild("Ostringo");
		this.Legs = this.Ostringo.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.BodyR = this.Ostringo.getChild("BodyR");
		this.Body = this.BodyR.getChild("Body");
		this.Fly = this.BodyR.getChild("Fly");
		this.LeftWing = this.Fly.getChild("LeftWing");
		this.RightWing = this.Fly.getChild("RightWing");
		this.Tail = this.BodyR.getChild("Tail");
		this.neckhead = this.Ostringo.getChild("neckhead");
		this.neckB = this.neckhead.getChild("neckB");
		this.Head = this.neckB.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Ostringo = partdefinition.addOrReplaceChild("Ostringo", CubeListBuilder.create(),
				PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Legs = Ostringo.addOrReplaceChild("Legs", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(64, 20).mirror()
				.addBox(-1.5F, 13.0F, -2.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(38, 69)
				.mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-3.5F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(64, 20)
						.addBox(-1.5F, 13.0F, -2.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 69)
						.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 0.0F, 0.0F));

		PartDefinition BodyR = Ostringo.addOrReplaceChild("BodyR", CubeListBuilder.create().texOffs(21, 55).addBox(
				-2.0F, -5.0F, -14.5F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition Body = BodyR.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-6.0F, -7.0F, -12.0F, 12.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(-5.0F, -9.0F, -10.0F, 10.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 45)
						.addBox(-3.0F, -10.0F, -7.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition Fly = BodyR.addOrReplaceChild("Fly", CubeListBuilder.create(),
				PartPose.offset(6.4F, -3.0F, -6.5F));

		PartDefinition LeftWing = Fly.addOrReplaceChild("LeftWing", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = LeftWing.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(56, 42).mirror()
						.addBox(0.0F, -2.0F, -6.0F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.6F, 1.0F, 5.0F, -0.0091F, 0.0692F, -0.1312F));

		PartDefinition cube_r2 = LeftWing
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(32, 45).addBox(0.0F, -3.0F, -6.0F, 1.0F, 5.0F, 11.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.0698F, 0.0F));

		PartDefinition RightWing = Fly.addOrReplaceChild("RightWing", CubeListBuilder.create(),
				PartPose.offset(-12.8F, 0.0F, 0.0F));

		PartDefinition cube_r3 = RightWing.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(56, 42).addBox(0.0F, -2.0F, -6.0F, 0.0F, 4.0F, 11.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.6F, 1.0F, 5.0F, -0.0091F, -0.0692F, 0.1312F));

		PartDefinition cube_r4 = RightWing.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(32, 45).mirror()
						.addBox(-1.0F, -3.0F, -6.0F, 1.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -0.0698F, 0.0F));

		PartDefinition Tail = BodyR.addOrReplaceChild("Tail", CubeListBuilder.create(),
				PartPose.offset(0.0F, -6.0F, 7.5F));

		PartDefinition cube_r5 = Tail
				.addOrReplaceChild("cube_r5",
						CubeListBuilder.create().texOffs(22, 61).addBox(-3.0F, -7.0F, -1.0F, 6.0F, 7.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7489F, 0.0F, 0.0F));

		PartDefinition neckhead = Ostringo.addOrReplaceChild("neckhead", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -2.0F, -13.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r6 = neckhead.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(56, 57).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 7.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition neckB = neckhead.addOrReplaceChild("neckB", CubeListBuilder.create(),
				PartPose.offset(0.0F, -2.753F, -6.4456F));

		PartDefinition cube_r7 = neckB
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 12.0F, 2.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Head = neckB.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(38, 61)
						.addBox(-2.0F, -3.6F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 14)
						.addBox(-2.0F, -1.6F, -6.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -10.647F, 2.4456F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Ostringo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}