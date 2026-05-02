package io.github.StarlitHorizon.arbitration.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ArbPillarEntityModel extends EntityModel<ArbPillarEntityRenderState> {
	private final ModelPart cube;
	public ArbPillarEntityModel(ModelPart root) {
		super(root);
		this.cube = root.getChild(PartNames.BODY);
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition root = modelData.getRoot();
		root.addOrReplaceChild(
			PartNames.BODY,
			CubeListBuilder.create().addBox(
				/* x */ -8,
				/* y */ -3,
				/* z */ -24,
				/* width */ 16,
				/* height */ 16,
				/* depth */ 48
			),
			PartPose.offset(0, 0, 0)
		);
		return LayerDefinition.create(modelData, 128, 128);
	}

}
