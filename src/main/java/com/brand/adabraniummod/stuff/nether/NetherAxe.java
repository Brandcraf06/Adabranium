package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public class NetherAxe extends AxeItem
{
    public NetherAxe()
    {
        super(FullStuffs.materialNetherTool, 6.0F, -3.1F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
