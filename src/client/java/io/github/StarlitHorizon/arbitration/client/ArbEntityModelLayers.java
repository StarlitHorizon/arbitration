package client.java.io.github.StarlitHorizon.arbitration.client;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ArbEntityModelLayers {
	public static final ModelLayerLocation ARB_PILLAR = createMain("arb_pillar");

	private static ModelLayerLocation createMain(String name) {
		return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, name), "main");
	}

	public static void registerModelLayers() {
		ModelLayerRegistry.registerModelLayer(ArbEntityModelLayers.ARB_PILLAR, ArbPillarEntityModel::getTexturedModelData);
	}
}
