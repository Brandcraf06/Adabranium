package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class NetherShovel extends ShovelItem
{
    public NetherShovel()
    {
    	super(FullStuffs.materialNetherTool, 1.5F, -3.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
