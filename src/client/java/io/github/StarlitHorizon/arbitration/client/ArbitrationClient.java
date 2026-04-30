package client.java.io.github.StarlitHorizon.arbitration.client;

import io.github.StarlitHorizon.arbitration.Custom.entities.ArbEntTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ArbitrationClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ArbEntityModelLayers.registerModelLayers();
		EntityRenderers.register(ArbEntTypes.ARB_PILLAR, ArbPillarEntityRenderer::new);
	}
}
