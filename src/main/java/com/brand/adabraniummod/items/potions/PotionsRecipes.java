package com.brand.adabraniummod.items.potions;

import com.brand.adabraniummod.items.ModItems;
import com.brand.adabraniummod.items.ModPotions;
import com.brand.adabraniummod.mixin.BrewingRecipeRegistryAccessor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;

public class PotionsRecipes {

	public static void registerRecipes() {
		register("toughness", Potions.AWKWARD, ModItems.HEART_SHAPED_HERB, ModPotions.TOUGHNESS);
		register("toughness", ModPotions.TOUGHNESS, Items.GLOWSTONE_DUST, ModPotions.STRONG_TOUGHNESS);
		register("toughness", ModPotions.TOUGHNESS, Items.REDSTONE, ModPotions.LONG_TOUGHNESS);
	}

	private static void register(String configKey, Potion base, Item ingredient, Potion result) {
		BrewingRecipeRegistryAccessor.invokeRegisterPotionRecipe(base, ingredient, result);
	}
}