package com.brand.adabraniummod.stuff.nether;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialNetherPaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 1145;
    }

    @Override
    public float getMiningSpeed()
    {
        return 8.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 2.5f;
    }

    @Override
    public int getMiningLevel()
    {
        return 2;
    }

    @Override
    public int getEnchantability()
    {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    }
}
