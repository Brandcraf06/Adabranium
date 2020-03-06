package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class NetherHoe extends HoeItem
{
	public NetherHoe()
    {
        super(FullStuffs.materialNetherTool, -1.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
