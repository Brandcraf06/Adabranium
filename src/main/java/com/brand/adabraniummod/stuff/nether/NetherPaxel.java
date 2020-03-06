package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;
import com.brand.adabraniummod.stuff.base.PaxelItem;

import net.minecraft.item.Item;

public class NetherPaxel extends PaxelItem
{
    public NetherPaxel()
    {
    	super(FullStuffs.materialNetherPaxel, 0, -2.8f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
