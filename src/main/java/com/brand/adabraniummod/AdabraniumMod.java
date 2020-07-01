package com.brand.adabraniummod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.brand.adabraniummod.content.ModBlocks;
import com.brand.adabraniummod.generation.Gen;
import com.brand.adabraniummod.items.FullSets;
import com.brand.adabraniummod.items.ModItems;
import com.brand.adabraniummod.items.ModPotions;
import com.brand.adabraniummod.items.potions.PotionsRecipes;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class AdabraniumMod implements ModInitializer {
	
	public static final String MOD_ID = "adabraniummod";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ItemGroup ADABRANIUM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "adabranium_group"), () -> new ItemStack(ModItems.VIBRANIUM_INGOT));
	
	@Override
	public void onInitialize() {
		
		for (Biome biome : Registry.BIOME)
		{
		Gen.addCoolOres(biome);
		Gen.addHeartShapedHerb(biome);
		}
		
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> Gen.addCoolOres(biome));
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> Gen.addHeartShapedHerb(biome));
		
		new ModBlocks();
		new ModItems();
		new ModPotions();
		new FullStuffs();
		PotionsRecipes.registerRecipes();
		FullSets.registerItems();
		
	}
}

