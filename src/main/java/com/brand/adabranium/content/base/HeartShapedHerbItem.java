package com.brand.adabranium.content.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HeartShapedHerbItem extends Item {

    public HeartShapedHerbItem(Item.Settings item$Settings_1) {
        super(item$Settings_1);
    }

    @Environment(EnvType.CLIENT)
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
