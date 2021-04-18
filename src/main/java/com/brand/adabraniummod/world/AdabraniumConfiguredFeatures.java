package com.brand.adabraniummod.world;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.content.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DepthAverageDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class AdabraniumConfiguredFeatures {

    public static final ImmutableList<OreFeatureConfig.Target> VIBRANIUM_ORE_TARGETS;
    public static final ImmutableList<OreFeatureConfig.Target> ADAMANTINE_ORE_TARGETS;
    public static final ConfiguredFeature<?, ?> VIBRANIUM_ORE;
    public static final ConfiguredFeature<?, ?> ADAMANTINE_ORE;
    public static final BlockState HEART_SHAPED_PLANT_CONFIG;
    public static final ConfiguredFeature<?, ?> HEART_SHAPED_PLANT;

    static {
        VIBRANIUM_ORE_TARGETS = ImmutableList.of(OreFeatureConfig.create(OreFeatureConfig.Rules.STONE_ORE_REPLACEABLES, ModBlocks.VIBRANIUM_ORE.getDefaultState()), OreFeatureConfig.create(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
        ADAMANTINE_ORE_TARGETS = ImmutableList.of(OreFeatureConfig.create(OreFeatureConfig.Rules.STONE_ORE_REPLACEABLES, ModBlocks.ADAMANTINE_ORE.getDefaultState()), OreFeatureConfig.create(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ADAMANTINE_ORE.getDefaultState()));
        VIBRANIUM_ORE = Feature.ORE.configure(new OreFeatureConfig(VIBRANIUM_ORE_TARGETS, 4)).method_36296(YOffset.getBottom(), YOffset.fixed(20)).spreadHorizontally().repeat(2);
        ADAMANTINE_ORE = Feature.SCATTERED_ORE.configure(new OreFeatureConfig(ADAMANTINE_ORE_TARGETS, 3, 1.0F)).method_36297(YOffset.fixed(0), YOffset.fixed(24)).spreadHorizontally().repeat(1);
        HEART_SHAPED_PLANT_CONFIG = ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2);
        HEART_SHAPED_PLANT = Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(new SimpleBlockStateProvider(HEART_SHAPED_PLANT_CONFIG),
                ImmutableList.of(Blocks.GRASS_BLOCK.getDefaultState()),
                ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.GRASS.getDefaultState(), Blocks.FERN.getDefaultState()),
                ImmutableList.of(Blocks.AIR.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), Blocks.VINE.getDefaultState()))).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.35F, 4)));
    }

    public static void registerConfiguredFeature() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Adabranium.MOD_ID, "vibranium_ore"), VIBRANIUM_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Adabranium.MOD_ID, "adamantine_ore"), ADAMANTINE_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Adabranium.MOD_ID, "heart_shaped_plant"), HEART_SHAPED_PLANT);
    }

    public static void registerBiomeModifications() {
        BuiltinRegistries.CONFIGURED_FEATURE.getKey(VIBRANIUM_ORE)
                .ifPresent(key -> BiomeModifications.addFeature(ctx -> true, GenerationStep.Feature.UNDERGROUND_ORES, key));
        BuiltinRegistries.CONFIGURED_FEATURE.getKey(ADAMANTINE_ORE)
                .ifPresent(key -> BiomeModifications.addFeature(ctx -> true, GenerationStep.Feature.UNDERGROUND_ORES, key));
        BuiltinRegistries.CONFIGURED_FEATURE.getKey(HEART_SHAPED_PLANT)
                .ifPresent(key -> BiomeModifications.addFeature(ctx -> ctx.getBiome().getCategory() == Biome.Category.JUNGLE,
                        GenerationStep.Feature.VEGETAL_DECORATION, key));
    }
}