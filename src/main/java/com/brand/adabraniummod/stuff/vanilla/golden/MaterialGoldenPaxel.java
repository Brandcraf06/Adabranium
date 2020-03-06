package com.brand.adabraniummod.stuff.vanilla.golden;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialGoldenPaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 96;
    }

    @Override
    public float getMiningSpeed()
    {
        return 12.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 1.0f;
    }

    @Override
    public int getMiningLevel()
    {
        return 0;
    }

    @Override
    public int getEnchantability()
    {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }
}
