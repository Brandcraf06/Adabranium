package com.brand.adabranium.worldgen;

import com.brand.adabranium.Adabranium;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AdabraniumWorldgenFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_VIBRANIUM = ResourceKey.create(Registries.CONFIGURED_FEATURE, Adabranium.id("ore_vibranium"));
    public static final ResourceKey<PlacedFeature> PLACED_VIBRANIUM = ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("ore_vibranium"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ADAMANTIUM = ResourceKey.create(Registries.CONFIGURED_FEATURE, Adabranium.id("ore_adamantium"));
    public static final ResourceKey<PlacedFeature> PLACED_ADAMANTIUM = ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("ore_adamantium"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> HEART_SHAPED_PLANT = ResourceKey.create(Registries.CONFIGURED_FEATURE, Adabranium.id("heart_shaped_plant"));
    public static final ResourceKey<PlacedFeature> PLACED_HEART_SHAPED_PLANT = ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("heart_shaped_plant"));


    public static void registerConfiguredFeature() {

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("ore_vibranium")));

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("ore_adamantium")));

        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ResourceKey.create(Registries.PLACED_FEATURE, Adabranium.id("heart_shaped_plant")));

    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacement.of(count), heightModifier);
    }
}
