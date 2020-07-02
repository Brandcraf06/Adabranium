package com.brand.adabraniummod.generation;

import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.content.ModBlocks;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountDepthDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

public class Gen {
	   private static final BlockState AIR;
	   private static final BlockState GRASS_BLOCK;
	   private static final BlockState GRASS;
	   private static final BlockState FERN;
	   private static final BlockState JUNGLE_LEAVES;
	   private static final BlockState VINE;
	   private static final BlockState HEART_SHAPED_PLANT;
	   
	public static void addCoolOres(Biome biome) {
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.VIBRANIUM_ORE.getDefaultState(), 4)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(2, 0, 0, 20))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.NO_SURFACE_ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, ModBlocks.ADAMANTINE_ORE.getDefaultState(), 3)).createDecoratedFeature(Decorator.COUNT_DEPTH_AVERAGE.configure(new CountDepthDecoratorConfig(1, 12, 12))));
			  }
	public static void addHeartShapedHerb(Biome biome) {
	        if (biome.getCategory() == Biome.Category.JUNGLE) {
		        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.configure(new SimpleBlockFeatureConfig(HEART_SHAPED_PLANT, ImmutableList.of(GRASS_BLOCK), ImmutableList.of(AIR, GRASS, FERN), ImmutableList.of(AIR, JUNGLE_LEAVES, VINE))).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
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