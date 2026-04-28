package hori.arbitration.materials.CloakMat;

import hori.arbitration.Arbitration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class CloakMat {

    public static final int BASE_DURABILITY = 15;

    public static final ResourceKey<EquipmentAsset> BASIC_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak0-0"));
    public static final ResourceKey<EquipmentAsset> IMPROVED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak0-1"));
    public static final ResourceKey<EquipmentAsset> REFINED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak0-2"));
    public static final ResourceKey<EquipmentAsset> BINAH_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloakbinah"));
    public static final ResourceKey<EquipmentAsset> ARMOURED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-tr-1"));
    public static final ResourceKey<EquipmentAsset> REINFORCED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-tr-2"));
    public static final ResourceKey<EquipmentAsset> ENHANCED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ar-1"));
    public static final ResourceKey<EquipmentAsset> INFUSED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ar-2"));
    public static final ResourceKey<EquipmentAsset> FANCY_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ta-1"));
    public static final ResourceKey<EquipmentAsset> DECORATED_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ta-2"));
    public static final ResourceKey<EquipmentAsset> RITUALIST_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ce-1"));
    public static final ResourceKey<EquipmentAsset> CEREMONIAL_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloak-ce-2"));

    public static final TagKey<Item> REPAIRS_T0_CLOAK = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "repairs_t0_cloak"));
    public static final TagKey<Item> REPAIRS_T1_CLOAK = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "repairs_t1_cloak"));
    public static final TagKey<Item> REPAIRS_T2_CLOAK = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "repairs_t2_cloak"));

    public static final ArmorMaterial BASIC_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 3
            ),
            12,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_T0_CLOAK,
            BASIC_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial IMPROVED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 0
            ),
            15,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_T0_CLOAK,
            IMPROVED_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial REFINED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 0
            ),
            18,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_T0_CLOAK,
            REFINED_CLOAK_ARMOR_MAT_KEY
    );

    public static final ArmorMaterial BINAH_CLOAK = new ArmorMaterial(
            50,
            Map.of(
                    ArmorType.CHESTPLATE, 0
            ),
            30,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_T0_CLOAK,
            BINAH_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial ARMOURED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 5
            ),
            12,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            1.5F,
            0.0F,
            REPAIRS_T1_CLOAK,
            ARMOURED_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial REINFORCED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 7
            ),
            12,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            2.5F,
            0.0F,
            REPAIRS_T2_CLOAK,
            REINFORCED_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial ENHANCED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 4
            ),
            18,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_T1_CLOAK,
            ENHANCED_CLOAK_ARMOR_MAT_KEY
    );
    public static final ArmorMaterial INFUSED_CLOAK = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.CHESTPLATE, 6
            ),
            20,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            1.0F,
            0.0F,
            REPAIRS_T2_CLOAK,
            INFUSED_CLOAK_ARMOR_MAT_KEY
    );
}