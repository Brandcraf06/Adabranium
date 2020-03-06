package com.brand.adabraniummod.stuff.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BasePaxel extends PaxelItem
{
    public BasePaxel(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, 0f, -2.8F, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
