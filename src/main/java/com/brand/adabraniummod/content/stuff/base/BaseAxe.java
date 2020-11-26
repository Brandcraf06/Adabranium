package com.brand.adabraniummod.content.stuff.base;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class BaseAxe extends AxeItem {
    public BaseAxe(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
