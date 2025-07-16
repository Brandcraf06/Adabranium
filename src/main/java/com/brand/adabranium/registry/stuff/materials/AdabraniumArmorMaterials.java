package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.registry.stuff.equipment.AdaEquipmentAssetKeys;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import com.google.common.collect.Maps;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;

import java.util.Map;
public class AdabraniumArmorMaterials {
    public interface ArmorMaterials {
        ArmorMaterial VIBRANIUM = new ArmorMaterial(49, createDefenseMap(5, 8, 10, 5, 11), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, AdabraniumItemTags.VIBRANIUM_MATERIALS, AdaEquipmentAssetKeys.VIBRANIUM);
        ArmorMaterial ADAMANTIUM = new ArmorMaterial(56, createDefenseMap(6, 10, 12, 6, 11), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, AdabraniumItemTags.ADAMANTIUM_MATERIALS, AdaEquipmentAssetKeys.ADAMANTIUM);
        ArmorMaterial NETHER_BRICK = new ArmorMaterial(22, createDefenseMap(2, 5, 6, 2, 5), 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, AdabraniumItemTags.NETHER_BRICK_MATERIALS, AdaEquipmentAssetKeys.NETHER_BRICK);

        private static Map<EquipmentType, Integer> createDefenseMap(int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int bodyDefense) {
            return Maps.newEnumMap(Map.of(EquipmentType.BOOTS, bootsDefense, EquipmentType.LEGGINGS, leggingsDefense, EquipmentType.CHESTPLATE, chestplateDefense, EquipmentType.HELMET, helmetDefense, EquipmentType.BODY, bodyDefense));
        }
    }
}