package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class NetherSword extends SwordItem
{
    public NetherSword()
    {
    	super(FullStuffs.materialNetherTool, 3, -2.4F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
