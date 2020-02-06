package com.brand.adabraniummod.stuff.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BaseSword extends SwordItem
{
    protected BaseSword(ToolMaterial toolMaterial_1)
    {
        super(toolMaterial_1, 1, -2.4f, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
    }
}
