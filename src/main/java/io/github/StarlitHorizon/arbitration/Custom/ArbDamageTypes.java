package io.github.StarlitHorizon.arbitration.Custom;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class ArbDamageTypes implements ModInitializer {
	// :::1

	public static final ResourceKey<DamageType> FAIRY_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "fairy"));
	public static final ResourceKey<DamageType> PULVERISE_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "pulverise"));
	public static final ResourceKey<DamageType> BLEED_DAMAGE = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "bleed"));
	// :::1

	@Override
	public void onInitialize() {
	}
}
