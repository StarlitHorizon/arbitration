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

public class LockEffect extends MobEffect {
	protected LockEffect() {
		super(MobEffectCategory.HARMFUL, 0xc78f00);
	}
	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	// Called when the effect is applied.
	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		if (entity.hasEffect(ArbEffects.FAIRY)){
			entity.hurtServer(level,
				new DamageSource(
				level.registryAccess()
					.lookupOrThrow(Registries.DAMAGE_TYPE)
					.get(ArbDamageTypes.PULVERISE_DAMAGE.identifier()).orElseThrow()),
				(float) ((entity.getMaxHealth()/1.5)+entity.getArmorValue()));
			entity.removeEffect(ArbEffects.FAIRY);
			entity.removeEffect(ArbEffects.LOCK);
		}
		addAttributeModifier(
			Attributes.ATTACK_SPEED,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arblockeffect1"),
			-0.5,
			AttributeModifier.Operation.ADD_VALUE
			);
		addAttributeModifier(
			Attributes.ATTACK_DAMAGE,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arblockeffect2"),
			(double) -0.5,
			AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
		);
		addAttributeModifier(
			Attributes.MAX_HEALTH,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arblockeffect3"),
			-2,
			AttributeModifier.Operation.ADD_VALUE
		);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
