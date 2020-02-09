package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class NetherBasePickaxe extends PickaxeItem
{   
    public NetherBasePickaxe(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, -1, -2.8f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}