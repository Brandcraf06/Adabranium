package com.brand.adabranium.registry.stuff.full;

import com.brand.adabranium.registry.content.ModItems;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;

public class FullStuffs {
    private static final ArrayList<FullStuffs> LIST = new ArrayList<>();

    public String type;
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

    public FullStuffs(String type, int armorDurabilityMultiplier, RegistryEntry<ArmorMaterial> armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, int hoeattackDamage, float hoeattackSpeed, boolean isFireproof) {

        this.type = type;

        Item.Settings itemSettings = new Item.Settings();
        if (isFireproof)
            itemSettings = itemSettings.fireproof();

        this.helmet = ModItems.register(type + "_helmet", new ArmorItem(armorMaterial, ArmorItem.Type.HELMET, (itemSettings.maxDamage(ArmorItem.Type.HELMET.getMaxDamage(armorDurabilityMultiplier)))));
        this.chestplate = ModItems.register(type + "_chestplate", new ArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, (itemSettings.maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(armorDurabilityMultiplier)))));
        this.leggings = ModItems.register(type + "_leggings", new ArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, (itemSettings.maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(armorDurabilityMultiplier)))));
        this.boots = ModItems.register(type + "_boots", new ArmorItem(armorMaterial, ArmorItem.Type.BOOTS, (itemSettings.maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(armorDurabilityMultiplier)))));


        this.shovel = ModItems.register(type + "_shovel", new ShovelItem(toolMaterial, (itemSettings.attributeModifiers(ShovelItem.createAttributeModifiers(toolMaterial, 1.5F, -3.0F)))));
        this.axe = ModItems.register(type + "_axe", new AxeItem(toolMaterial, (itemSettings.attributeModifiers(AxeItem.createAttributeModifiers(toolMaterial, axeattackDamage, axeattackSpeed)))));
        this.pickaxe = ModItems.register(type + "_pickaxe", new PickaxeItem(toolMaterial, (itemSettings.attributeModifiers(PickaxeItem.createAttributeModifiers(toolMaterial, 1.0F, -2.8F)))));
        this.hoe = ModItems.register(type + "_hoe", new HoeItem(toolMaterial, (itemSettings.attributeModifiers(HoeItem.createAttributeModifiers(toolMaterial, hoeattackDamage, hoeattackSpeed)))));
        this.sword = ModItems.register(type + "_sword", new SwordItem(toolMaterial, (itemSettings.attributeModifiers(SwordItem.createAttributeModifiers(toolMaterial, 3, -2.4F)))));

        LIST.add(this);
    }

    public static ArrayList<FullStuffs> values() {
        return LIST;
    }
}
