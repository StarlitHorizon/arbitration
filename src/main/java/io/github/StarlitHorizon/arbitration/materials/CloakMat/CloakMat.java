package io.github.StarlitHorizon.arbitration.materials.CloakMat;

import io.github.StarlitHorizon.arbitration.Arbitration;
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

    public static final ResourceKey<EquipmentAsset> BINAH_CLOAK_ARMOR_MAT_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "cloakbinah"));

    public static final TagKey<Item> REPAIRS_T0_CLOAK = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(Arbitration.MOD_ID, "repairs_t0_cloak"));

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
}
