package com.brand.adabranium.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HeartShapedHerbItem extends Item {

    public HeartShapedHerbItem(Item.Properties item$Settings_1) {
        super(item$Settings_1);
    }

    @Environment(EnvType.CLIENT)
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
