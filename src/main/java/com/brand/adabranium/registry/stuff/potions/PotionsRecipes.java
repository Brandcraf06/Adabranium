package com.brand.adabranium.registry.stuff.potions;

import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;

public class PotionsRecipes {

    public static void registerRecipes() {
        register(Potions.AWKWARD, ModItems.HEART_SHAPED_HERB, ModItems.TOUGHNESS);
        register(ModItems.TOUGHNESS, Items.GLOWSTONE_DUST, ModItems.STRONG_TOUGHNESS);
        register(ModItems.TOUGHNESS, Items.REDSTONE, ModItems.LONG_TOUGHNESS);
    }

    public static void register(RegistryEntry<Potion> input, Item ingredient, RegistryEntry<Potion> output) {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(input, ingredient, output);
        });
    }


}