package io.github.StarlitHorizon.arbitration.Custom.effect;

import io.github.StarlitHorizon.arbitration.Arbitration;
import io.github.StarlitHorizon.arbitration.Custom.ArbDamageTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class BleedEffect extends MobEffect {
	protected BleedEffect() {
		super(MobEffectCategory.HARMFUL, 0x9e0000);
	}
	@Override
	public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
		int interval = 15 >> amplifier;
		return interval > 0 ? tickCount % interval == 0 : true;
	}

	// Called when the effect is applied.
	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		entity.hurtServer(level,
			new DamageSource(
				level.registryAccess()
					.lookupOrThrow(Registries.DAMAGE_TYPE)
					.get(ArbDamageTypes.BLEED_DAMAGE.identifier()).orElseThrow()),
			1);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
