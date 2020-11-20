package com.brand.adabraniummod.stuff.tools;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.base.BasePickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumPickaxes {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, 1, -2.8f, "vibranium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, 1, -2.8f, "adamantium", (new Item.Settings()).group(AdabraniumMod.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, 1, -2.8F, "nether", new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());

    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, AdabraniumMod.id(materialname + "_pickaxe"), new BasePickaxe(material, attackDamage, attackSpeed, settings));
    }
}
