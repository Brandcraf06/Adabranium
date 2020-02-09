package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class NetherBaseAxe extends AxeItem
{
 
    public NetherBaseAxe(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, 3, -3.0f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    
    }
}