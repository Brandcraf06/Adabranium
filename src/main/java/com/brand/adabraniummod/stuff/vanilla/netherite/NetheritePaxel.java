package com.brand.adabraniummod.stuff.vanilla.netherite;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;
import com.brand.adabraniummod.stuff.base.PaxelItem;

import net.minecraft.item.Item;


public class NetheritePaxel extends PaxelItem
{
    public NetheritePaxel()
    {
    	super(FullStuffs.materialNetheritePaxel, 0, -2.8f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof());
    }
}
