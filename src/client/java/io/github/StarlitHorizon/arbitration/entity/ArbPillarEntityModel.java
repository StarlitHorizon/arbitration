package io.github.StarlitHorizon.arbitration.entity;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.world.entity.projectile.Projectile;

public class ArbPillarEntityModel extends EntityModel<ArbPillarEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public ArbPillarEntityModel(ModelPart root) {
		super(root, RenderTypes::entitySolid);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition root = modelData.getRoot();
		root.addOrReplaceChild(
			PartNames.BODY,
			CubeListBuilder.create().addBox(
				-8,
				-8,
				-24,
				16,
				16,
				48
			),
			PartPose.offset(0, 0, 0)
		);
		return LayerDefinition.create(modelData, 128, 128);
	}
}
