package com.brand.adabranium.registry.stuff.full;

import com.brand.adabranium.registry.content.ModItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

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
    public ResourceKey<EquipmentAsset> equipmentKey;

    public FullStuffs(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, int hoeattackDamage, float hoeattackSpeed, boolean isFireproof, ResourceKey<EquipmentAsset> equipmentKey) {

        this.equipmentKey = equipmentKey;
        Item.Properties itemSettings = new Item.Properties();
        if (isFireproof)
            itemSettings = itemSettings.fireResistant();

        this.helmet = ModItems.register(type + "_helmet", (itemSettings.humanoidArmor(armorMaterial, ArmorType.HELMET)));
        this.chestplate = ModItems.register(type + "_chestplate", (itemSettings.humanoidArmor(armorMaterial, ArmorType.CHESTPLATE)));
        this.leggings = ModItems.register(type + "_leggings", (itemSettings.humanoidArmor(armorMaterial, ArmorType.LEGGINGS)));
        this.boots = ModItems.register(type + "_boots", (itemSettings.humanoidArmor(armorMaterial, ArmorType.BOOTS)));

        this.shovel = ModItems.register(type + "_shovel", (settings) -> new ShovelItem(toolMaterial, 1.5F, -3.0F, settings), itemSettings);
        this.axe = ModItems.register(type + "_axe", (settings) -> new AxeItem(toolMaterial, axeattackDamage, axeattackSpeed, settings), itemSettings);
        this.pickaxe = ModItems.register(type + "_pickaxe", itemSettings.pickaxe(toolMaterial, 1.0F, -2.8F));
        this.hoe = ModItems.register(type + "_hoe", (settings) -> new HoeItem(toolMaterial, hoeattackDamage, hoeattackSpeed, settings), itemSettings);
        this.sword = ModItems.register(type + "_sword", (new Item.Properties()).sword(toolMaterial, 3, -2.4f));

        LIST.add(this);
    }

    public static ArrayList<FullStuffs> values() {
        return LIST;
    }
}
