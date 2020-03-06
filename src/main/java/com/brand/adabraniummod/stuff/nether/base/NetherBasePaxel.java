package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.base.PaxelItem;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class NetherBasePaxel extends PaxelItem
{
    public NetherBasePaxel(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, 3, -2.8f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
