package com.brand.adabraniummod.stuff.vanilla.netherite;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialNetheritePaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 6108;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 9.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 5.0f;
    }

    @Override
    public int getMiningLevel()
    {
        return 4;
    }

    @Override
    public int getEnchantability()
    {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
}
