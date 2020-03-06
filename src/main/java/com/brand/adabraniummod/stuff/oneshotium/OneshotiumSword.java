package com.brand.adabraniummod.stuff.oneshotium;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class OneshotiumSword extends SwordItem
{
    public OneshotiumSword()
    {
    	super(FullStuffs.materialOneshotiumTool, 0, 0.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
