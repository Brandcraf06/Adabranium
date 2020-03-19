package com.brand.adabraniummod.stuff.vanilla.diamond;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialDiamondPaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 4690;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 8.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 4.0f;
    }

    @Override
    public int getMiningLevel()
    {
        return 3;
    }

    @Override
    public int getEnchantability()
    {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
}
