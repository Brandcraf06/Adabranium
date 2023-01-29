package com.brand.adabranium.content.stuff.types;

import com.brand.adabranium.content.ModItems;
import com.brand.adabranium.content.stuff.base.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

import java.util.ArrayList;

public class ModStuffs {
    private static final ArrayList<ModStuffs> LIST = new ArrayList<>();

    public final Item helmet;
    public final Item chestplate;
    public final Item leggings;
    public final Item boots;
    public final Item axe;
    public final Item hoe;
    public final Item pickaxe;
    public final Item shovel;
    public final Item sword;

    public ModStuffs(String type, ArmorMaterial armorMaterial, ToolMaterial toolMaterial, int hoeattackDamage) {

        this.helmet = ModItems.register(type + "_helmet", new ArmorItem(armorMaterial, EquipmentSlot.HEAD, (new Item.Settings())));
        this.chestplate = ModItems.register(type + "_chestplate", new ArmorItem(armorMaterial, EquipmentSlot.CHEST, (new Item.Settings())));
        this.leggings = ModItems.register(type + "_leggings", new ArmorItem(armorMaterial, EquipmentSlot.LEGS, (new Item.Settings())));
        this.boots = ModItems.register(type + "_boots", new ArmorItem(armorMaterial, EquipmentSlot.FEET, (new Item.Settings())));
        this.shovel = ModItems.register(type + "_shovel", new BaseShovel(toolMaterial, 1.5F, -3.0F, (new Item.Settings())));
        this.axe = ModItems.register(type + "_axe", new BaseAxe(toolMaterial, 5.0F, -3.0F, (new Item.Settings())));
        this.pickaxe = ModItems.register(type + "_pickaxe", new BasePickaxe(toolMaterial, 1, -2.8F, (new Item.Settings())));
        this.hoe = ModItems.register(type + "_hoe", new BaseHoe(toolMaterial, hoeattackDamage, -0.0F, (new Item.Settings())));
        this.sword = ModItems.register(type + "_sword", new BaseSword(toolMaterial, 3, -2.4f, (new Item.Settings())));

        LIST.add(this);
    }

    public static ArrayList<ModStuffs> values() {
        return LIST;
    }
}
