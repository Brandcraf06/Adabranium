package com.brand.adabraniummod.stuff.tools;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.base.BaseShovel;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumShovels {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, 1.5F, -3.0F, "vibranium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, 1.5F, -3.0F, "adamantium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, 1.5F, -3.0F, "nether", new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
   
    private static Item register(ToolMaterial material, float attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, AdabraniumMod.id(materialname + "_shovel"), new BaseShovel(material, attackDamage, attackSpeed, settings));
    }
}
