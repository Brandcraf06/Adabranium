package com.brand.adabraniummod.stuff.vanilla.stone;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;

public class MaterialStonePaxel implements ToolMaterial
{
    @Override
    public int getDurability()
    {
        return 395;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return 4.0F;
    }

    @Override
    public float getAttackDamage()
    {
        return 2.0f;
    }

    @Override
    public int getMiningLevel()
    {
        return 1;
    }

    @Override
    public int getEnchantability()
    {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }
}
