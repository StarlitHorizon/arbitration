package hori.arbitration;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Arbitration implements ModInitializer {
	public static final String MOD_ID = "arbitration";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ArbItems.initialize();
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_ARBITER_CLOAK)) {
				tooltip.add(1,Component.translatable("item.arbitration.binah_cloak_lore1").withStyle(ChatFormatting.ITALIC,ChatFormatting.GOLD));
				tooltip.add(2,Component.translatable("item.arbitration.binah_cloak_lore2").withStyle(ChatFormatting.ITALIC,ChatFormatting.GOLD));
			}
		});
		LOGGER.info("god help me");
	}
}