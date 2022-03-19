package com.brand.adabraniummod.world;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.content.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class AdabraniumConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> VIBRANIUM_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.VIBRANIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> ADAMANTINE_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ADAMANTINE_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ADAMANTINE_ORE.getDefaultState()));

    public static void registerConfiguredFeature() {

        // vibranium
        ConfiguredFeature<?, ?> ORE_VIBRANIUM = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(VIBRANIUM_ORES, 5, 0f));

        RegistryKey<PlacedFeature> oreVibranium = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Adabranium.id("ore_vibranium"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreVibranium.getValue(), ORE_VIBRANIUM);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreVibranium.getValue(), new PlacedFeature(RegistryEntry.of(ORE_VIBRANIUM), modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreVibranium);

        // adamantium

        ConfiguredFeature<?, ?> ORE_ADAMANTINE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(ADAMANTINE_ORES, 5, 1.0F));

        RegistryKey<PlacedFeature> oreAdamantine = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Adabranium.id("ore_adamantine"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAdamantine.getValue(), ORE_ADAMANTINE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreAdamantine.getValue(), new PlacedFeature(RegistryEntry.of(ORE_ADAMANTINE), List.of(new PlacementModifier[]{SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)), BiomePlacementModifier.of()})));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAdamantine);

        // heart shaped plant

        ConfiguredFeature<?, ?> HEART_SHAPED_PLANT = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(64, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2))))));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Adabranium.id("heart_shaped_plant"), HEART_SHAPED_PLANT);

        RegistryKey<PlacedFeature> heartShapedPlant = RegistryKey.of(Registry.PLACED_FEATURE_KEY, Adabranium.id("heart_shaped_plant"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, heartShapedPlant.getValue(), new PlacedFeature(RegistryEntry.of(HEART_SHAPED_PLANT), List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()})));
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, heartShapedPlant);

    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

}
