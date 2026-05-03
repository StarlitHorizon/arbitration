package io.github.StarlitHorizon.arbitration;

import io.github.StarlitHorizon.arbitration.Custom.component.ArbComponents;
import io.github.StarlitHorizon.arbitration.Custom.items.*;
import io.github.StarlitHorizon.arbitration.materials.CloakMat.CloakMat;
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
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;

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
            })
            .build();

	public static final Item BINAH_ESSENCE = register(
		"binah_essence",
		BinahEssence::new,
		new Item.Properties()
			.useCooldown(5F)
			.component(ArbComponents.ESSENCE_MODE, "Fairy")
			.rarity(Rarity.EPIC)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_FAIRY = register(
		"fairy",
		BinahFairy::new,
		new Item.Properties()
			.useCooldown(6F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_CHAIN = register(
		"chain",
		BinahChain::new,
		new Item.Properties()
			.useCooldown(6F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_LOCK = register(
		"lock",
		BinahLock::new,
		new Item.Properties()
			.useCooldown(8F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
	);

	public static final Item BINAH_PILLAR = register(
		"pillar",
		BinahPillar::new,
		new Item.Properties()
			.useCooldown(8F)
			.rarity(Rarity.RARE)
			.fireResistant()
			.stacksTo(1)
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
