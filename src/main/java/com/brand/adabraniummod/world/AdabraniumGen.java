package com.brand.adabraniummod.world;

import me.shedaniel.cloth.api.dynamic.registry.v1.BiomesRegistry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;

public class AdabraniumGen {

    public static void addCoolOres(RegistryKey<Biome> registryKey, Biome biome) {
        BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> AdabraniumConfiguredFeatures.VIBRANIUM_ORE);
        BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> AdabraniumConfiguredFeatures.ADAMANTINE_ORE);
    }

    public static void addHeartShapedHerb(RegistryKey<Biome> registryKey, Biome biome) {
        if (biome.getCategory() == Biome.Category.JUNGLE) {
            BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> AdabraniumConfiguredFeatures.HEART_SHAPED_PLANT);
        }
    }
}