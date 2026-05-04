package io.github.StarlitHorizon.arbitration.Custom.effect;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class ArbEffects implements ModInitializer {
	public static final Holder<MobEffect> FAIRY =
		Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "fairy"),
			new FairyEffect()
		);
	public static final Holder<MobEffect> LOCK =
		Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "lock"),
			new LockEffect()
		);
	public static final Holder<MobEffect> BLEED =
		Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
			Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "bleed"),
			new BleedEffect()
		);
	@Override
	public void onInitialize() {

	}
}
