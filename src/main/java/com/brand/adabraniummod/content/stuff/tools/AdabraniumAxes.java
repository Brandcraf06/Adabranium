package com.brand.adabraniummod.content.stuff.tools;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.content.stuff.base.BaseAxe;
import com.brand.adabraniummod.content.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumAxes {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, 5.0F, -3.0F, "vibranium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, 5.0F, -3.0F, "adamantium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, 6.0F, -3.1F, "nether", new Item.Settings().group(Adabranium.ADABRANIUM_GROUP).fireproof());

    private static Item register(ToolMaterial material, float attackDamage, float attackSpeed, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, Adabranium.id(materialname + "_axe"), new BaseAxe(material, attackDamage, attackSpeed, settings));
    }
}