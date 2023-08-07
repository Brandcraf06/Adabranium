package com.brand.adabranium.worldgen;

import com.brand.adabranium.Adabranium;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class AdabraniumWorldgenFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Adabranium.id("ore_vibranium"));
    public static final RegistryKey<PlacedFeature> PLACED_VIBRANIUM = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("ore_vibranium"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_ADAMANTINE = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Adabranium.id("ore_adamantium"));
    public static final RegistryKey<PlacedFeature> PLACED_ADAMANTINE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("ore_adamantium"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> HEART_SHAPED_PLANT = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Adabranium.id("heart_shaped_plant"));
    public static final RegistryKey<PlacedFeature> PLACED_HEART_SHAPED_PLANT = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("heart_shaped_plant"));


    public static void registerConfiguredFeature() {

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("ore_vibranium")));

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("ore_adamantium")));

        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Adabranium.id("heart_shaped_plant")));

    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}
