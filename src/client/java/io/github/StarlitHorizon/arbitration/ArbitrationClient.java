package io.github.StarlitHorizon.arbitration;

import io.github.StarlitHorizon.arbitration.Custom.entities.ArbEntTypes;
import io.github.StarlitHorizon.arbitration.entity.ArbEntityModelLayers;
import io.github.StarlitHorizon.arbitration.entity.ArbPillarEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class ArbitrationClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ArbEntityModelLayers.registerModelLayers();
		EntityRenderers.register(ArbEntTypes.ARB_PILLAR, ArbPillarEntityRenderer::new);
		EntityRenderers.register(ArbEntTypes.ARB_FAIRY, ThrownItemRenderer::new);
	}
}
