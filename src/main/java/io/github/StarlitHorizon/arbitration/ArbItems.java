package io.github.StarlitHorizon.arbitration;

import io.github.StarlitHorizon.arbitration.Custom.component.ArbComponents;
import io.github.StarlitHorizon.arbitration.Custom.items.*;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ArbItems {
    public static final ResourceKey<CreativeModeTab> ARB_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "arb_creative_tab")
    );
    public static final CreativeModeTab ARB_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ArbItems.BINAH_ESSENCE))
            .title(Component.translatable("creativeTab.arbitration"))
            .displayItems((_, output) -> {
				output.accept(ArbItems.BINAH_FAIRY);
				output.accept(ArbItems.BINAH_CHAIN);
				output.accept(ArbItems.BINAH_PILLAR);
				output.accept(ArbItems.BINAH_LOCK);
				output.accept(ArbItems.BINAH_ESSENCE);
				output.accept(ArbItems.MIMICRY);
				output.accept(ArbItems.SERUMK);
				output.accept(ArbItems.SERUMR);
				output.accept(ArbItems.SERUMW);
            })
            .build();

	public static final Item BINAH_ESSENCE = register(
		"binah_essence",
		BinahEssence::new,
		new Item.Properties()
			.useCooldown(4F)
			.component(ArbComponents.ESSENCE_MODE, "Fairy")
			.rarity(Rarity.EPIC)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_FAIRY = register(
		"fairy",
		BinahFairy::new,
		new Item.Properties()
			.useCooldown(8F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_CHAIN = register(
		"chain",
		BinahChain::new,
		new Item.Properties()
			.useCooldown(8F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_LOCK = register(
		"lock",
		BinahLock::new,
		new Item.Properties()
			.useCooldown(10F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_PILLAR = register(
		"pillar",
		BinahPillar::new,
		new Item.Properties()
			.useCooldown(10F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item MIMICRY = register(
		"mimicry",
		Mimicry::new,
		new Item.Properties()
			.useCooldown(10F)
			.rarity(Rarity.EPIC)
			.fireResistant()
			.stacksTo(1)
			.component(DataComponents.UNBREAKABLE,Unit.INSTANCE)
			.sword(ToolMaterial.NETHERITE,7,-2.9F)
	);

	public static final Item SERUMW = register(
		"serumw",
		Serumw::new,
		new Item.Properties()
			.useCooldown(7.5F)
			.rarity(Rarity.EPIC)
	);

	public static final Item SERUMR = register(
		"serumr",
		Serumr::new,
		new Item.Properties()
			.useCooldown(7.5F)
			.rarity(Rarity.EPIC)
	);

	public static final Item SERUMK = register(
		"serumk",
		Serumk::new,
		new Item.Properties()
			.useCooldown(15F)
			.rarity(Rarity.EPIC)
	);

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, name));
        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));
        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
    public static void initialize() {
        // Register the group.
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ARB_CREATIVE_TAB_KEY, ARB_CREATIVE_TAB);

        CreativeModeTabEvents.modifyOutputEvent(ARB_CREATIVE_TAB_KEY)
                .register((creativeTab) -> creativeTab.accept(ArbItems.BINAH_ESSENCE));
    }
}
