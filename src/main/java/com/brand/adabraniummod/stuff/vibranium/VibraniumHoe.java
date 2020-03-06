package com.brand.adabraniummod.stuff.vibranium;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class VibraniumHoe extends HoeItem
{
	public VibraniumHoe()
    {
        super(FullStuffs.materialVibraniumTool, -0.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
