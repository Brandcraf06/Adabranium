package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class NetherBaseShovel extends ShovelItem
{
    public NetherBaseShovel(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, -0.5f, -3.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
