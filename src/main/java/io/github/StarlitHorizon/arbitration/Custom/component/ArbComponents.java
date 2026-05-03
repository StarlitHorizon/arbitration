package io.github.StarlitHorizon.arbitration.Custom.component;

import io.github.StarlitHorizon.arbitration.Arbitration;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;

public class ArbComponents {
	public static final DataComponentType<String> ESSENCE_MODE = Registry.register(
		BuiltInRegistries.DATA_COMPONENT_TYPE,
		Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "essence_mode"),
		DataComponentType.<String>builder().persistent(ExtraCodecs.NON_EMPTY_STRING).build()
	);

	public static void initialize() {
		Arbitration.LOGGER.info("Registering {} components", Arbitration.MOD_ID);
		// Technically this method can stay empty, but some developers like to notify
		// the console, that certain parts of the mod have been successfully initialized
	}
}
