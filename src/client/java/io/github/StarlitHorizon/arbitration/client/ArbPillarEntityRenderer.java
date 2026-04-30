package client.java.io.github.StarlitHorizon.arbitration.client;

import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillarEntityRenderState;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class ArbPillarEntityRenderer extends EntityRenderer<ArbPillar, ArbPillarEntityRenderState> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "textures/entity/pillarTexture.png");

	public ArbPillarEntityRenderer(EntityRendererProvider.Context context) {
		super(context);
		new ArbPillarEntityModel(context.bakeLayer(ArbEntityModelLayers.ARB_PILLAR));
	}

	public ArbPillarEntityRenderState createRenderState() {
		return new ArbPillarEntityRenderState();
	}

	public Identifier getTextureLocation(ArbPillarEntityRenderState state) {
		return TEXTURE;
	}

}
