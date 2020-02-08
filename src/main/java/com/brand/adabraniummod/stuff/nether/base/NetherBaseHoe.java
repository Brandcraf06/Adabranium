package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class NetherBaseHoe extends HoeItem
{
    protected NetherBaseHoe(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, -1.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
