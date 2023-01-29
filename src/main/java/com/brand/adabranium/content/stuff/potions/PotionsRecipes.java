package com.brand.adabranium.content.stuff.potions;

import com.brand.adabranium.content.ModItems;
import com.brand.adabranium.mixin.BrewingRecipeRegistryAccessor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;

public class PotionsRecipes {

    public static void registerRecipes() {
        register("toughness", Potions.AWKWARD, ModItems.HEART_SHAPED_HERB, ModItems.TOUGHNESS);
        register("toughness", ModItems.TOUGHNESS, Items.GLOWSTONE_DUST, ModItems.STRONG_TOUGHNESS);
        register("toughness", ModItems.TOUGHNESS, Items.REDSTONE, ModItems.LONG_TOUGHNESS);
    }

    private static void register(String configKey, Potion base, Item ingredient, Potion result) {
        BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(base, ingredient, result);
    }
}