package com.brand.adabraniummod.stuff.nether;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialNetherTool implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 381;
    }

    @Override
    public float getMiningSpeed()
    {
        return 8.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 2.0f;
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
