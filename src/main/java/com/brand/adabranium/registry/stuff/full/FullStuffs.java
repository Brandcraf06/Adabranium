package com.brand.adabranium.registry.stuff.full;

import com.brand.adabranium.registry.content.ModItems;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;

import java.util.ArrayList;

public class FullStuffs {
    private static final ArrayList<FullStuffs> LIST = new ArrayList<>();

    public Item helmet;
    public Item chestplate;
    public Item leggings;
    public Item boots;
    public Item axe;
    public Item hoe;
    public Item pickaxe;
    public Item shovel;
    public Item sword;
    public Item item;
    public RegistryKey<EquipmentAsset> equipmentKey;

    public FullStuffs(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, int hoeattackDamage, float hoeattackSpeed, boolean isFireproof, RegistryKey<EquipmentAsset> equipmentKey) {

        this.equipmentKey = equipmentKey;
        Item.Settings itemSettings = new Item.Settings();
        if (isFireproof)
            itemSettings = itemSettings.fireproof();

        this.helmet = ModItems.register(type + "_helmet", (itemSettings.armor(armorMaterial, EquipmentType.HELMET)));
        this.chestplate = ModItems.register(type + "_chestplate", (itemSettings.armor(armorMaterial, EquipmentType.CHESTPLATE)));
        this.leggings = ModItems.register(type + "_leggings", (itemSettings.armor(armorMaterial, EquipmentType.LEGGINGS)));
        this.boots = ModItems.register(type + "_boots", (itemSettings.armor(armorMaterial, EquipmentType.BOOTS)));

        this.shovel = ModItems.register(type + "_shovel", (settings) -> new ShovelItem(toolMaterial, 1.5F, -3.0F, settings), itemSettings);
        this.axe = ModItems.register(type + "_axe", (settings) -> new AxeItem(toolMaterial, axeattackDamage, axeattackSpeed, settings), itemSettings);
        this.pickaxe = ModItems.register(type + "_pickaxe", itemSettings.pickaxe(toolMaterial, 1.0F, -2.8F));
        this.hoe = ModItems.register(type + "_hoe", (settings) -> new HoeItem(toolMaterial, hoeattackDamage, hoeattackSpeed, settings), itemSettings);
        this.sword = ModItems.register(type + "_sword", (new Item.Settings()).sword(toolMaterial, 3, -2.4f));

        LIST.add(this);
    }

    public FullStuffs(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, int hoeattackDamage, float hoeattackSpeed, RegistryKey<EquipmentAsset> equipmentKey) {
        this(type, armorMaterial, toolMaterial, axeattackDamage, axeattackSpeed, hoeattackDamage, hoeattackSpeed, false, equipmentKey);
    }

    public static ArrayList<FullStuffs> values() {
        return LIST;
    }
}
