package com.brand.adabraniummod.stuff.adamantium;

import com.brand.adabraniummod.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialAdamantiumPaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 75000;
    }

    @Override
    public float getMiningSpeed()
    {
        return 35f;
    }

    @Override
    public float getAttackDamage()
    {
        return 16f;
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
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }
}
