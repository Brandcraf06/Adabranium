package com.brand.adabraniummod.content.stuff.base;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BaseSword extends SwordItem {
    public BaseSword(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
