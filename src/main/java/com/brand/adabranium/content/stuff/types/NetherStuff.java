package com.brand.adabranium.content.stuff.types;

import com.brand.adabranium.content.ModItems;
import com.brand.adabranium.content.stuff.base.*;
import com.brand.adabranium.content.stuff.materials.AdabraniumArmorMaterials;
import com.brand.adabranium.content.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class NetherStuff {
    private static final ArrayList<NetherStuff> LIST = new ArrayList<>();

    public final Item helmet;
    public final Item chestplate;
    public final Item leggings;
    public final Item boots;
    public final Item axe;
    public final Item hoe;
    public final Item pickaxe;
    public final Item shovel;
    public final Item sword;

    public NetherStuff(String type) {

        this.helmet = ModItems.register(type + "_helmet", new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.HEAD, (new Item.Settings().fireproof())));
        this.chestplate = ModItems.register(type + "_chestplate", new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.CHEST, (new Item.Settings().fireproof())));
        this.leggings = ModItems.register(type + "_leggings", new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.LEGS, (new Item.Settings().fireproof())));
        this.boots = ModItems.register(type + "_boots", new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.FEET, (new Item.Settings().fireproof())));
        this.shovel = ModItems.register(type + "_shovel", new BaseShovel(AdabraniumToolMaterials.NETHER_BRICK, 1.5F, -3.0F, (new Item.Settings().fireproof())));
        this.axe = ModItems.register(type + "_axe", new BaseAxe(AdabraniumToolMaterials.NETHER_BRICK, 6.0F, -3.1F, (new Item.Settings().fireproof())));
        this.pickaxe = ModItems.register(type + "_pickaxe", new BasePickaxe(AdabraniumToolMaterials.NETHER_BRICK, 1, -2.8F, (new Item.Settings().fireproof())));
        this.hoe = ModItems.register(type + "_hoe", new BaseHoe(AdabraniumToolMaterials.NETHER_BRICK, -2, -1.0F, (new Item.Settings().fireproof())));
        this.sword = ModItems.register(type + "_sword", new BaseSword(AdabraniumToolMaterials.NETHER_BRICK, 3, -2.4f, (new Item.Settings().fireproof())));

        LIST.add(this);
    }

    public static ArrayList<NetherStuff> values() {
        return LIST;
    }
}
