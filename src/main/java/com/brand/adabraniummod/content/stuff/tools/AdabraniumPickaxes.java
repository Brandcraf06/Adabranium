package com.brand.adabraniummod.content.stuff.tools;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.content.stuff.base.BasePickaxe;
import com.brand.adabraniummod.content.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.registry.Registry;

public class AdabraniumPickaxes {

    public static Item VIBRANIUM = register(AdabraniumToolMaterials.VIBRANIUM, "vibranium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item ADAMANTIUM = register(AdabraniumToolMaterials.ADAMANTIUM, "adamantium", (new Item.Settings()).group(Adabranium.ADABRANIUM_GROUP));
    public static Item NETHER_BRICK = register(AdabraniumToolMaterials.NETHER_BRICK, "nether", new Item.Settings().group(Adabranium.ADABRANIUM_GROUP).fireproof());

    private static Item register(ToolMaterial material, String materialname, Item.Settings settings) {
        return Registry.register(Registry.ITEM, Adabranium.id(materialname + "_pickaxe"), new BasePickaxe(material, 1, -2.8F, settings));
    }
}
