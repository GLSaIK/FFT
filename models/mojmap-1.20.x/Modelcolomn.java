// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcolomn<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "colomn"), "main");
	private final ModelPart bone2;
	private final ModelPart bone;
	private final ModelPart bone16;
	private final ModelPart bone7;
	private final ModelPart bone10;
	private final ModelPart bone14;
	private final ModelPart bone17;
	private final ModelPart bone3;
	private final ModelPart bone4;
	private final ModelPart bone8;
	private final ModelPart bone12;
	private final ModelPart bone5;
	private final ModelPart bone9;
	private final ModelPart bone13;
	private final ModelPart bone6;
	private final ModelPart bone11;
	private final ModelPart bone15;

	public Modelcolomn(ModelPart root) {
		this.bone2 = root.getChild("bone2");
		this.bone = this.bone2.getChild("bone");
		this.bone16 = this.bone.getChild("bone16");
		this.bone7 = this.bone2.getChild("bone7");
		this.bone10 = this.bone7.getChild("bone10");
		this.bone14 = this.bone10.getChild("bone14");
		this.bone17 = this.bone7.getChild("bone17");
		this.bone3 = this.bone2.getChild("bone3");
		this.bone4 = this.bone2.getChild("bone4");
		this.bone8 = this.bone4.getChild("bone8");
		this.bone12 = this.bone8.getChild("bone12");
		this.bone5 = this.bone2.getChild("bone5");
		this.bone9 = this.bone5.getChild("bone9");
		this.bone13 = this.bone9.getChild("bone13");
		this.bone6 = this.bone2.getChild("bone6");
		this.bone11 = this.bone6.getChild("bone11");
		this.bone15 = this.bone11.getChild("bone15");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition bone = bone2.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(64, 26)
						.addBox(2.0F, -14.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(56, 82)
						.addBox(2.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(1.0F)),
				PartPose.offset(-10.0F, 0.0F, 0.0F));

		PartDefinition bone16 = bone.addOrReplaceChild("bone16",
				CubeListBuilder.create().texOffs(24, 78)
						.addBox(3.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -2.0F, -24.0F, 24.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(24, 78)
						.addBox(3.0F, -6.0F, -25.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 12.0F));

		PartDefinition cube_r1 = bone16.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(64, 54).addBox(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r2 = bone16.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r3 = bone16.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(68, 54).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -17.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r4 = bone16.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(24, 78).addBox(-1.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -11.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r5 = bone16.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -10.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r6 = bone16.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r7 = bone16.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r8 = bone16.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r9 = bone16.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(68, 54).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r10 = bone16.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(68, 54).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -17.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r11 = bone16.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r12 = bone16.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -10.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r13 = bone16.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(24, 78).addBox(-1.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -11.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r14 = bone16.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(64, 54).addBox(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r15 = bone16
				.addOrReplaceChild("cube_r15",
						CubeListBuilder.create().texOffs(68, 54).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r16 = bone16
				.addOrReplaceChild("cube_r16",
						CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r17 = bone16
				.addOrReplaceChild("cube_r17",
						CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r18 = bone16
				.addOrReplaceChild("cube_r18",
						CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone7 = bone2.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(72, 54)
						.addBox(2.0F, 2.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(64, 26)
						.addBox(2.0F, 1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(1.0F)),
				PartPose.offset(-10.0F, -92.0F, 0.0F));

		PartDefinition bone10 = bone7.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 78).addBox(1.1F,
				-13.0F, 4.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(17.0F, 18.0F, -7.0F));

		PartDefinition bone14 = bone10.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(42, 78).addBox(
				-1.0F, -4.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.2F, -7.0F, 7.5F));

		PartDefinition bone17 = bone7.addOrReplaceChild("bone17",
				CubeListBuilder.create().texOffs(24, 78)
						.addBox(3.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -2.0F, -24.0F, 24.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).texOffs(24, 78)
						.addBox(3.0F, -6.0F, -25.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -1.0F, -12.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bone17.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(64, 54).addBox(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r20 = bone17.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r21 = bone17.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(68, 54).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -17.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r22 = bone17.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(24, 78).addBox(-1.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -11.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r23 = bone17.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, 0.0F, -10.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r24 = bone17.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(8.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r25 = bone17.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r26 = bone17.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r27 = bone17.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(68, 54).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 0.0F, -25.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r28 = bone17.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(68, 54).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -17.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r29 = bone17.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -15.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r30 = bone17.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -10.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r31 = bone17.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(24, 78).addBox(-1.0F, -6.0F, 0.0F, 4.0F, 6.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -11.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r32 = bone17.addOrReplaceChild("cube_r32",
				CubeListBuilder.create().texOffs(64, 54).addBox(1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(17.0F, 0.0F, -7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r33 = bone17
				.addOrReplaceChild("cube_r33",
						CubeListBuilder.create().texOffs(68, 54).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r34 = bone17
				.addOrReplaceChild("cube_r34",
						CubeListBuilder.create().texOffs(38, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r35 = bone17
				.addOrReplaceChild("cube_r35",
						CubeListBuilder.create().texOffs(34, 78).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r36 = bone17
				.addOrReplaceChild("cube_r36",
						CubeListBuilder.create().texOffs(64, 54).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 26).addBox(-15.0F,
				-16.0F, -1.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -14.0F, -7.0F));

		PartDefinition bone4 = bone2.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(0, 26).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone8 = bone4.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 78).addBox(1.1F,
				-13.0F, 4.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 0.0F, -7.0F));

		PartDefinition bone12 = bone8.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(42, 78).addBox(-1.0F,
				-4.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(2.2F, -7.0F, 7.5F));

		PartDefinition bone5 = bone2.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 26).addBox(-15.0F,
				-16.0F, -1.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -46.0F, -7.0F));

		PartDefinition bone9 = bone5.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(12, 78).addBox(4.0F,
				-13.0F, -1.1F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 0.0F, 0.0F));

		PartDefinition bone13 = bone9.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(42, 79).addBox(-1.0F,
				-4.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offset(7.5F, -7.0F, -2.2F));

		PartDefinition bone6 = bone2.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 26).addBox(-15.0F,
				-16.0F, -1.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -62.0F, -7.0F));

		PartDefinition bone11 = bone6.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(12, 78)
				.addBox(-10.0F, -13.0F, 1.1F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 1.0F, 14.0F));

		PartDefinition bone15 = bone11.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(42, 79).addBox(0.0F,
				-4.0F, -1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.1F)), PartPose.offset(-7.5F, -7.0F, 2.2F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}