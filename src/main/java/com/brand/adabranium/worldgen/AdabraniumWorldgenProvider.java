package com.brand.adabranium.worldgen;

import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import com.brand.adabranium.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdabraniumWorldgenProvider extends FabricDynamicRegistryProvider {
    public AdabraniumWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    RuleTest stone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    RuleTest deepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    List<Target> vibranium_list = List.of(OreFeatureConfig.createTarget(stone, ModBlocks.VIBRANIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(deepslate, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
    List<Target> adamantine_list = List.of(OreFeatureConfig.createTarget(stone, ModBlocks.ADAMANTINE_ORE.getDefaultState()), OreFeatureConfig.createTarget(deepslate, ModBlocks.DEEPSLATE_ADAMANTINE_ORE.getDefaultState()));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {

        // vibranium
        ConfiguredFeature<?, ?> ORE_VIBRANIUM = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(vibranium_list, 5, 0f));
        RegistryEntry<ConfiguredFeature<?, ?>> ore_vibranium = entries.add(AdabraniumWorldgenFeatures.ORE_VIBRANIUM, ORE_VIBRANIUM);

        PlacedFeature PLACED_VIBRANIUM = new PlacedFeature(ore_vibranium, AdabraniumWorldgenFeatures.modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72))));
        entries.add(AdabraniumWorldgenFeatures.PLACED_VIBRANIUM, PLACED_VIBRANIUM);

        // adamantium
        ConfiguredFeature<?, ?> ORE_ADAMANTINE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(adamantine_list, 5, 1.0F));
        RegistryEntry<ConfiguredFeature<?, ?>> ore_adamantine = entries.add(AdabraniumWorldgenFeatures.ORE_ADAMANTINE, ORE_ADAMANTINE);

        PlacedFeature PLACED_ADAMANTINE = new PlacedFeature(ore_adamantine, List.of(new PlacementModifier[]{SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)), BiomePlacementModifier.of()}));
        entries.add(AdabraniumWorldgenFeatures.PLACED_ADAMANTINE, PLACED_ADAMANTINE);

        // heart shaped plant
        ConfiguredFeature<?, ?> HEART_SHAPED_PLANT = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchFeatureConfig(64, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2))))));
        RegistryEntry<ConfiguredFeature<?, ?>> heart_shaped_plant = entries.add(AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT, HEART_SHAPED_PLANT);

        PlacedFeature PLACED_HEART_SHAPED_PLANT = new PlacedFeature(heart_shaped_plant, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()}));
        entries.add(AdabraniumWorldgenFeatures.PLACED_HEART_SHAPED_PLANT, PLACED_HEART_SHAPED_PLANT);
    }

    @Override
    public String getName() {
        return "Adabranium World Gen";
    }
}
