package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class NetherPickaxe extends PickaxeItem
{
    public NetherPickaxe()
    {
    	super(FullStuffs.materialNetherTool, 1, -2.8F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
