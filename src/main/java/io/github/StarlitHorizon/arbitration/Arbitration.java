package io.github.StarlitHorizon.arbitration;

import io.github.StarlitHorizon.arbitration.Custom.component.ArbComponents;
import io.github.StarlitHorizon.arbitration.Custom.effect.ArbEffects;
import io.github.StarlitHorizon.arbitration.Custom.entities.ArbEntTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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
		ArbComponents.initialize();
		ArbEntTypes.registerModEntityTypes();

		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_ESSENCE)) {
			String mode = stack.getOrDefault(ArbComponents.ESSENCE_MODE,"Fairy");
			tooltip.add(1, Component.translatable("item.arbitration.essence_mode.info1",mode).withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			tooltip.add(2, Component.translatable("item.arbitration.essence_mode.info2").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
		}});
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_FAIRY)) {
				tooltip.add(1, Component.translatable("item.arbitration.fairy.lore").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			}});
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_CHAIN)) {
				tooltip.add(1, Component.translatable("item.arbitration.chain.lore").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			}});
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_PILLAR)) {
				tooltip.add(1, Component.translatable("item.arbitration.pillar.lore").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			}});
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.BINAH_LOCK)) {
				tooltip.add(1, Component.translatable("item.arbitration.lock.lore").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			}});
		ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
			if (stack.is(ArbItems.MIMICRY)) {
				tooltip.add(1, Component.translatable("item.arbitration.mimicry.lore").withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));
			}});
		LOGGER.info("Arbitration: god help me");
	}
}
