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
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DepthAverageDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class AdabraniumConfiguredFeatures {

    private static final BlockState AIR;
    private static final BlockState GRASS_BLOCK;
    private static final BlockState GRASS;
    private static final BlockState FERN;
    private static final BlockState JUNGLE_LEAVES;
    private static final BlockState VINE;
    private static final BlockState HEART_SHAPED_PLANT_CONFIG;
    public static final ConfiguredFeature<?, ?> VIBRANIUM_ORE;
    public static final ConfiguredFeature<?, ?> ADAMANTINE_ORE;
    public static final ConfiguredFeature<?, ?> HEART_SHAPED_PLANT;

    // Will run when registerAndAddConfiguredFeatures is called
    static {
        AIR = Blocks.AIR.getDefaultState();
        GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
        GRASS = Blocks.GRASS.getDefaultState();
        FERN = Blocks.FERN.getDefaultState();
        JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
        VINE = Blocks.VINE.getDefaultState();
        HEART_SHAPED_PLANT_CONFIG = ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2);

        VIBRANIUM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.VIBRANIUM_ORE.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 20)).spreadHorizontally().repeat(2));
        ADAMANTINE_ORE = Feature.NO_SURFACE_ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.ADAMANTINE_ORE.getDefaultState(), 3)).decorate(Decorator.DEPTH_AVERAGE.configure(new DepthAverageDecoratorConfig(12, 12)).spreadHorizontally().repeat(1));
        HEART_SHAPED_PLANT = Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(HEART_SHAPED_PLANT_CONFIG, ImmutableList.of(GRASS_BLOCK), ImmutableList.of(AIR, GRASS, FERN), ImmutableList.of(AIR, JUNGLE_LEAVES, VINE))).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.35F, 4)));

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