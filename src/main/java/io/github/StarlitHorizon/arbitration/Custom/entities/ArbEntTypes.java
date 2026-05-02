package io.github.StarlitHorizon.arbitration.Custom.entities;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ArbEntTypes {
	public static final EntityType<ArbPillar> ARB_PILLAR = register(
		"arb_pillar",
		EntityType.Builder.<ArbPillar>of(ArbPillar::new, MobCategory.MISC)
			.sized(0.75F,0.75F)
			.noLootTable()
			.clientTrackingRange(4)
			.updateInterval(10)
	);

	private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, name));
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
	}

	public static void registerModEntityTypes() {
		Arbitration.LOGGER.info("Registering EntityTypes for " + Arbitration.MOD_ID);
	}
}
