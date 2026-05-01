package io.github.StarlitHorizon.arbitration.entity;

import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class ArbPillarEntityRenderer extends EntityRenderer<ArbPillar, ArbPillarEntityRenderState> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "textures/entity/pillar_texture.png");
	private ArbPillarEntityModel model;

	public ArbPillarEntityRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.model = new ArbPillarEntityModel(context.bakeLayer(ArbEntityModelLayers.ARB_PILLAR));
	}

	@Override
	public ArbPillarEntityRenderState createRenderState() {
		return new ArbPillarEntityRenderState();
	}

	public Identifier getTextureLocation(ArbPillarEntityRenderState state) {
		return TEXTURE;
	}

}
