package com.brand.adabraniummod.stuff.adamantium;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class AdamantiumHoe extends HoeItem
{
	public AdamantiumHoe()
    {
        super(FullStuffs.materialAdamantiumTool, -0.0F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
