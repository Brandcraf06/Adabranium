package com.brand.adabraniummod.stuff.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BasePickaxe extends PickaxeItem
{
    public BasePickaxe(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, -1, -2.8f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
