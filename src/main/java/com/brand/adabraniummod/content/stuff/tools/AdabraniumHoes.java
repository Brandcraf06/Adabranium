package com.brand.adabraniummod.content.stuff.tools;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.content.stuff.base.BaseHoe;
import com.brand.adabraniummod.content.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumHoes {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, -6, -0.0F, "vibranium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, -9, -0.0F, "adamantium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, -2, -1.0F, "nether", new Item.Settings().group(Adabranium.ADABRANIUM_GROUP).fireproof());

    private static Item register(ToolMaterial material, int attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, Adabranium.id(materialname + "_hoe"), new BaseHoe(material, attackDamage, attackSpeed, settings));
    }
}
