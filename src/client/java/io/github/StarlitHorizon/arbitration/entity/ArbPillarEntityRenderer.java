package io.github.StarlitHorizon.arbitration.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbPillar;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public class ArbPillarEntityRenderer extends EntityRenderer<ArbPillar, ArbPillarEntityRenderState> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "textures/entity/arb_pillar.png");
	private final ArbPillarEntityModel model;

	public ArbPillarEntityRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.model = new ArbPillarEntityModel(context.bakeLayer(ArbEntityModelLayers.ARB_PILLAR));
	}

	public void submit(
		final ArbPillarEntityRenderState state, final PoseStack poseStack, final SubmitNodeCollector submitNodeCollector, final CameraRenderState camera
	) {
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 180.0F));
		submitNodeCollector.order(0)
			.submitModel(this.model, state, poseStack, TEXTURE, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor, null);
		poseStack.popPose();
		super.submit(state, poseStack, submitNodeCollector, camera);
	}

		@Override
		public ArbPillarEntityRenderState createRenderState () {
			return new ArbPillarEntityRenderState();
		}

		public Identifier getTextureLocation (ArbPillarEntityRenderState state){
			return TEXTURE;
		}

		public void extractRenderState(final ArbPillar entity, final ArbPillarEntityRenderState state, final float partialTicks) {
			super.extractRenderState(entity, state, partialTicks);
			state.yRot = entity.getYRot(partialTicks);
			state.zRot = entity.getYRot(partialTicks);
		}
	}
