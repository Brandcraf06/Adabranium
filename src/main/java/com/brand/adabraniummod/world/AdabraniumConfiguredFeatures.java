package com.brand.adabraniummod.world;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.content.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class AdabraniumConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> VIBRANIUM_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.VIBRANIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> ADAMANTINE_ORES = List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ADAMANTINE_ORE.getDefaultState()), OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ADAMANTINE_ORE.getDefaultState()));
    public static final ConfiguredFeature<?, ?> ORE_VIBRANIUM = ConfiguredFeatures.register("ore_vibranium", Feature.ORE.configure(new OreFeatureConfig(VIBRANIUM_ORES, 3, 0.5f)));
    public static final ConfiguredFeature<?, ?> ORE_ADAMANTINE = ConfiguredFeatures.register("ore_adamantine", Feature.SCATTERED_ORE.configure(new OreFeatureConfig(ADAMANTINE_ORES, 3, 1.0F)));
    public static final ConfiguredFeature<?, ?> HEART_SHAPED_PLANT = ConfiguredFeatures.register("heart_shaped_plant", Feature.FLOWER.configure(new RandomPatchFeatureConfig(64, 0, 0, () -> Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2)))).withInAirFilter())));

    public static void registerConfiguredFeature() {

        // limestone
        RegistryKey<PlacedFeature> oreVibranium = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(Adabranium.MOD_ID, "ore_vibranium"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreVibranium.getValue(), ORE_VIBRANIUM.withPlacement(modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)))));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreVibranium);

        // marble
        RegistryKey<PlacedFeature> oreAdamantine = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(Adabranium.MOD_ID, "ore_adamantine"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oreAdamantine.getValue(), ORE_ADAMANTINE.withPlacement(SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)), BiomePlacementModifier.of()));
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAdamantine);

        // white oak
        RegistryKey<PlacedFeature> heartShapedPlant = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier(Adabranium.MOD_ID, "heart_shaped_plant"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, heartShapedPlant.getValue(), HEART_SHAPED_PLANT.withPlacement(RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()));
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, heartShapedPlant);

    }

    private static List<PlacementModifier> modifiers(PlacementModifier first, PlacementModifier second) {
        return List.of(first, SquarePlacementModifier.of(), second, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier modifier) {
        return modifiers(CountPlacementModifier.of(count), modifier);
    }

}
