package com.brand.adabranium.registry.stuff.potions;

import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

public class PotionsRecipes {

    public static void registerRecipes() {
        register(Potions.AWKWARD, ModItems.HEART_SHAPED_HERB, ModItems.TOUGHNESS);
        register(ModItems.TOUGHNESS, Items.GLOWSTONE_DUST, ModItems.STRONG_TOUGHNESS);
        register(ModItems.TOUGHNESS, Items.REDSTONE, ModItems.LONG_TOUGHNESS);
    }

    public static void register(Holder<Potion> input, Item ingredient, Holder<Potion> output) {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.addMix(input, ingredient, output);
        });
    }


}