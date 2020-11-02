package com.brand.adabraniummod.stuff.tools;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.base.BaseSword;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumSwords {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, 3, -2.4f, "vibranium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, 3, -2.4f, "adamantium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, 3, -2.4f, "nether", new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    public static Item ONESHOTIUM = register(AdabraniumToolMaterials.ONESHOTIUM, 0, 0.0f, "oneshotium", new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
   
    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, AdabraniumMod.id(materialname + "_sword"), new BaseSword(material, attackDamage, attackSpeed, settings));
    }
}
