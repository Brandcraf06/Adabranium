package com.brand.adabranium.content.stuff.full;

import com.brand.adabranium.content.ModItems;
import com.brand.adabranium.content.stuff.base.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

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

    public FullStuffs(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, float axeattackDamage, float axeattackSpeed, int hoeattackDamage, float hoeattackSpeed, boolean isFireproof) {

        Item.Settings settings = new Item.Settings();
        if (isFireproof)
            settings = settings.fireproof();

        this.helmet = ModItems.register(type + "_helmet", new ArmorItem(armorMaterial, ArmorItem.Type.HELMET, (settings)));
        this.chestplate = ModItems.register(type + "_chestplate", new ArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, (settings)));
        this.leggings = ModItems.register(type + "_leggings", new ArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, (settings)));
        this.boots = ModItems.register(type + "_boots", new ArmorItem(armorMaterial, ArmorItem.Type.BOOTS, (settings)));
        this.shovel = ModItems.register(type + "_shovel", new BaseShovel(toolMaterial, 1.5F, -3.0F, (settings)));
        this.axe = ModItems.register(type + "_axe", new BaseAxe(toolMaterial, axeattackDamage, axeattackSpeed, (settings)));
        this.pickaxe = ModItems.register(type + "_pickaxe", new BasePickaxe(toolMaterial, 1, -2.8F, (settings)));
        this.hoe = ModItems.register(type + "_hoe", new BaseHoe(toolMaterial, hoeattackDamage, hoeattackSpeed, (settings)));
        this.sword = ModItems.register(type + "_sword", new BaseSword(toolMaterial, 3, -2.4f, (settings)));

        LIST.add(this);
    }

    public static ArrayList<FullStuffs> values() {
        return LIST;
    }
}
