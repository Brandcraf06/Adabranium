package com.brand.adabraniummod.stuff.vanilla.iron;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialIronPaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 764;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 6.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 3.0f;
    }

    @Override
    public int getMiningLevel()
    {
        return 2;
    }

    @Override
    public int getEnchantability()
    {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
