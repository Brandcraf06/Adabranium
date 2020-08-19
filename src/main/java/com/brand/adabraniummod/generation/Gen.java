package com.brand.adabraniummod.generation;

import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.content.ModBlocks;
import com.google.common.collect.ImmutableList;

import me.shedaniel.cloth.api.dynamic.registry.v1.BiomesRegistry;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class Gen {
	   private static final BlockState AIR;
	   private static final BlockState GRASS_BLOCK;
	   private static final BlockState GRASS;
	   private static final BlockState FERN;
	   private static final BlockState JUNGLE_LEAVES;
	   private static final BlockState VINE;
	   private static final BlockState HEART_SHAPED_PLANT;
	   
	public static void addCoolOres(RegistryKey<Biome> registryKey, Biome biome) {
		BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.VIBRANIUM_ORE.getDefaultState(), 4)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 20)).spreadHorizontally().repeat(2)));
		BiomesRegistry.registerFeature(biome, GenerationStep.Feature.UNDERGROUND_ORES, () -> Feature.NO_SURFACE_ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.ADAMANTINE_ORE.getDefaultState(), 3)).decorate(Decorator.DEPTH_AVERAGE.configure(new DepthAverageDecoratorConfig(12, 12)).spreadHorizontally().repeat(1)));
			  }
	public static void addHeartShapedHerb(RegistryKey<Biome> registryKey, Biome biome) {
		if (biome.getCategory() == Biome.Category.JUNGLE) {
			BiomesRegistry.registerFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, () -> Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(HEART_SHAPED_PLANT, ImmutableList.of(GRASS_BLOCK), ImmutableList.of(AIR, GRASS, FERN), ImmutableList.of(AIR, JUNGLE_LEAVES, VINE))).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.35F, 4))));
		}
	}

	static {
	AIR = Blocks.AIR.getDefaultState();	
	GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();	 
    GRASS = Blocks.GRASS.getDefaultState();
    FERN = Blocks.FERN.getDefaultState();	   
    JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    VINE = Blocks.VINE.getDefaultState();  
    HEART_SHAPED_PLANT = (BlockState)ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2);
   }
}