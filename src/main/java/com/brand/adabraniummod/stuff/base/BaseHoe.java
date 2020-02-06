package com.brand.adabraniummod.stuff.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BaseHoe extends HoeItem
{
    protected BaseHoe(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, -1.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
