package com.brand.adabranium.registry.stuff.full;

import com.brand.adabranium.registry.content.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.ArrayList;
import java.util.List;

public record FullStuffs(
        boolean fireResistant,
        Item helmet,
        Item chestplate,
        Item leggings,
        Item boots,
        Item shovel,
        Item axe,
        Item pickaxe,
        Item hoe,
        Item sword,
        Item spear,
        ResourceKey<EquipmentAsset> equipmentKey
) {

    public static final List<FullStuffs> LIST = new ArrayList<>();

    public static List<FullStuffs> values() {
        return LIST;
    }

    public static Builder of(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, float hoeattackDamage, float hoeattackSpeed, float spearSwingDuration, float spearDamageMultiplier, float spearDelayTicks, float spearDismountMaxDurationTicks, float spearDismountMinSpeed, float spearKnockbackMaxDurationTicks, float spearDamageMaxDurationTicks, boolean fireResistant, ResourceKey<EquipmentAsset> equipmentKey) {
        return new Builder(type, armorMaterial, toolMaterial, axeattackDamage, axeattackSpeed, hoeattackDamage, hoeattackSpeed, spearSwingDuration, spearDamageMultiplier, spearDelayTicks, spearDismountMaxDurationTicks, spearDismountMinSpeed, spearKnockbackMaxDurationTicks, spearDamageMaxDurationTicks, fireResistant, equipmentKey);
    }

    public record Builder(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage,
                          float axeattackSpeed, float hoeattackDamage, float hoeattackSpeed, float spearSwingDuration,
                          float spearDamageMultiplier, float spearDelayTicks, float spearDismountMaxDurationTicks,
                          float spearDismountMinSpeed, float spearKnockbackMaxDurationTicks,
                          float spearDamageMaxDurationTicks, boolean fireResistant,
                          ResourceKey<EquipmentAsset> equipmentKey) {

        public Item.Properties itemProperties() {
            Item.Properties itemProperties = new Item.Properties();
            if (fireResistant) {
                itemProperties = itemProperties.fireResistant();
            }
            return itemProperties;
        }

        public FullStuffs register() {

            Item helmet = ModItems.register(type + "_helmet", (itemProperties().humanoidArmor(armorMaterial, ArmorType.HELMET)));
            Item chestplate = ModItems.register(type + "_chestplate", (itemProperties().humanoidArmor(armorMaterial, ArmorType.CHESTPLATE)));
            Item leggings = ModItems.register(type + "_leggings", (itemProperties().humanoidArmor(armorMaterial, ArmorType.LEGGINGS)));
            Item boots = ModItems.register(type + "_boots", (itemProperties().humanoidArmor(armorMaterial, ArmorType.BOOTS)));

            Item shovel = ModItems.register(type + "_shovel", (properties) -> new ShovelItem(toolMaterial, 1.5F, -3.0F, properties), itemProperties());
            Item axe = ModItems.register(type + "_axe", (properties) -> new AxeItem(toolMaterial, axeattackDamage, axeattackSpeed, properties), itemProperties());
            Item pickaxe = ModItems.register(type + "_pickaxe", itemProperties().pickaxe(toolMaterial, 1.0F, -2.8F));
            Item hoe = ModItems.register(type + "_hoe", (properties) -> new HoeItem(toolMaterial, hoeattackDamage, hoeattackSpeed, properties), itemProperties());
            Item sword = ModItems.register(type + "_sword", (itemProperties().sword(toolMaterial, 3, -2.4f)));
            Item spear = ModItems.register(type + "_spear", (itemProperties().spear(toolMaterial, spearSwingDuration, spearDamageMultiplier, spearDelayTicks, spearDismountMaxDurationTicks, spearDismountMinSpeed, spearKnockbackMaxDurationTicks, 5.1F, spearDamageMaxDurationTicks, 4.6F)));

            FullStuffs bundle = new FullStuffs(fireResistant, helmet, chestplate, leggings, boots, shovel, axe, pickaxe, hoe, sword, spear, equipmentKey);

            LIST.add(bundle);
            return bundle;
        }
    }
}
