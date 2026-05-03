package io.github.StarlitHorizon.arbitration.Custom.effect;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class FairyEffect extends MobEffect {
	protected FairyEffect() {
		super(MobEffectCategory.HARMFUL, 0xc78f00);
	}
	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	// Called when the effect is applied.
	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		addAttributeModifier(
			Attributes.ARMOR,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arbfairyeffect1"),
			-2*(amplifier+1),
			AttributeModifier.Operation.ADD_VALUE
			);
		addAttributeModifier(
			Attributes.ARMOR_TOUGHNESS,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arbfairyeffect2"),
			-(amplifier+1),
			AttributeModifier.Operation.ADD_VALUE
		);
		addAttributeModifier(
			Attributes.MAX_HEALTH,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID,"arbfairyeffect3"),
			-(amplifier+1),
			AttributeModifier.Operation.ADD_VALUE
		);
		return super.applyEffectTick(level, entity, amplifier);
	}
}
