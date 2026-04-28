package hori.arbitration;

import hori.arbitration.materials.CloakMat.CloakMat;
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
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ArbItems {
    public static final ResourceKey<CreativeModeTab> ARB_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "arb_creative_tab")
    );
    public static final CreativeModeTab ARB_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ArbItems.BINAH_ARBITER_CLOAK))
            .title(Component.translatable("creativeTab.arbitration"))
            .displayItems((_, output) -> {
                output.accept(ArbItems.BASIC_ARBITER_CLOAK);
                output.accept(ArbItems.IMPROVED_ARBITER_CLOAK);
                output.accept(ArbItems.REFINED_ARBITER_CLOAK);
                output.accept(ArbItems.BINAH_ARBITER_CLOAK);
            })
            .build();

    public static final Item CLOTH = register(
            "cloth",
            Item::new,
            new Item.Properties()
                    .repairable(CloakMat.REPAIRS_T0_CLOAK)
    );

    public static final Item IMPROVED_CLOTH = register(
            "improved_cloth",
            Item::new,
            new Item.Properties()
                    .repairable(CloakMat.REPAIRS_T1_CLOAK)
    );

    public static final Item REFINED_CLOTH = register(
            "refined_cloth",
            Item::new,
            new Item.Properties()
                    .repairable(CloakMat.REPAIRS_T2_CLOAK)
    );

    public static final Item BASIC_ARBITER_CLOAK = register(
            "basic_arbiter_cloak",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CloakMat.BASIC_CLOAK,
                            ArmorType.CHESTPLATE
                    )
                    .durability(
                            ArmorType.CHESTPLATE.getDurability(
                            CloakMat.BASE_DURABILITY
                            )
                    )
    );

    public static final Item IMPROVED_ARBITER_CLOAK = register(
            "improved_arbiter_cloak",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CloakMat.IMPROVED_CLOAK,
                            ArmorType.CHESTPLATE
                    )
                    .durability(
                            (int) (ArmorType.CHESTPLATE.getDurability(
                                    CloakMat.BASE_DURABILITY
                            )*1.5)
                    )
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.MAX_HEALTH, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-1.1"),
                                                    2.0,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-1.2"),
                                                    0.1,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-1.3"),
                                                    0.1,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-1.4"),
                                                    6,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-1.5"),
                                                    0.5,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .build()
                    )
    );

    public static final Item REFINED_ARBITER_CLOAK = register(
            "refined_arbiter_cloak",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CloakMat.REFINED_CLOAK,
                            ArmorType.CHESTPLATE
                    )
                    .durability(
                            ArmorType.CHESTPLATE.getDurability(
                                    CloakMat.BASE_DURABILITY
                            )*2
                    )
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.MAX_HEALTH, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-2.1"),
                                                    5.0,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-2.2"),
                                                    0.2,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-2.3"),
                                                    0.2,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-2.4"),
                                                    9,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuff0-2.5"),
                                                    2.5,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .build()
                    ).rarity(Rarity.UNCOMMON)
    );

    public static final Item BINAH_ARBITER_CLOAK = register(
            "binah_arbiter_cloak",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(
                            CloakMat.BINAH_CLOAK,
                            ArmorType.CHESTPLATE
                    )
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.MAX_HEALTH, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.1"),
                                                    20.0,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.MAX_HEALTH, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.2"),
                                                    2.5,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.3"),
                                                    0.75,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.4"),
                                                    1.5,
                                                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.5"),
                                                    25,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(
                                            Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.6"),
                                                    15,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .add(Attributes.STEP_HEIGHT, new AttributeModifier(
                                                    Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cbuffb.7"),
                                                    1,
                                                    AttributeModifier.Operation.ADD_VALUE),
                                            EquipmentSlotGroup.CHEST)
                                    .build()
                    )
                    .component(DataComponents.UNBREAKABLE, Unit.INSTANCE)
                    .rarity(Rarity.EPIC).fireResistant()
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
                .register((creativeTab) -> creativeTab.accept(ArbItems.BINAH_ARBITER_CLOAK));
    }
}
