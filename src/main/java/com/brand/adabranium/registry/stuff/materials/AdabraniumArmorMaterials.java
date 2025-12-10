package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.registry.stuff.equipment.AdabraniumEquipmentAssetKeys;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;
public class AdabraniumArmorMaterials {
    public interface ArmorMaterials {
        ArmorMaterial VIBRANIUM = new ArmorMaterial(49, createDefenseMap(5, 8, 10, 5, 11), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, AdabraniumItemTags.VIBRANIUM_MATERIALS, AdabraniumEquipmentAssetKeys.VIBRANIUM);
        ArmorMaterial ADAMANTIUM = new ArmorMaterial(56, createDefenseMap(6, 10, 12, 6, 11), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, AdabraniumItemTags.ADAMANTIUM_MATERIALS, AdabraniumEquipmentAssetKeys.ADAMANTIUM);
        ArmorMaterial NETHER_BRICK = new ArmorMaterial(22, createDefenseMap(2, 5, 6, 2, 5), 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, AdabraniumItemTags.NETHER_BRICK_MATERIALS, AdabraniumEquipmentAssetKeys.NETHER_BRICK);

        private static Map<ArmorType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
            return Maps.newEnumMap(Map.of(ArmorType.BOOTS, bootsDefense, ArmorType.LEGGINGS, leggingsDefense, ArmorType.CHESTPLATE, chestplateDefense, ArmorType.HELMET, helmetDefense, ArmorType.BODY, bodyDefense));
        }
    }
}