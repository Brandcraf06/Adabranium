package com.brand.adabraniummod.stuff.oneshotium;

import com.brand.adabraniummod.items.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MaterialOneshotiumTool implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 1000000;
    }

    @Override
    public float getMiningSpeed()
    {
        return 23f;
    }

    @Override
    public float getAttackDamage()
    {
        return 999998f;
    }

    @Override
    public int getMiningLevel()
    {
        return 3;
    }

    @Override
    public int getEnchantability()
    {
        return 100;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }
}
