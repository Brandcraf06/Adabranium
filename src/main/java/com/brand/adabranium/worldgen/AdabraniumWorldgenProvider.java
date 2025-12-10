package com.brand.adabranium.worldgen;

import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdabraniumWorldgenProvider extends FabricDynamicRegistryProvider {
    public AdabraniumWorldgenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.ORE_VIBRANIUM);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_VIBRANIUM);
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.ORE_ADAMANTIUM);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_ADAMANTIUM);
        entries.add(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT);
        entries.add(registries.lookupOrThrow(Registries.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_HEART_SHAPED_PLANT);
    }

    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> registerable) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> vibranium_list = List.of(OreConfiguration.target(stone, ModBlocks.VIBRANIUM_ORE.defaultBlockState()), OreConfiguration.target(deepslate, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> adamantium_list = List.of(OreConfiguration.target(stone, ModBlocks.ADAMANTIUM_ORE.defaultBlockState()), OreConfiguration.target(deepslate, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.defaultBlockState()));

        FeatureUtils.register(registerable, AdabraniumWorldgenFeatures.ORE_VIBRANIUM, Feature.ORE, new OreConfiguration(vibranium_list, 4, 0.2f));
        FeatureUtils.register(registerable, AdabraniumWorldgenFeatures.ORE_ADAMANTIUM, Feature.ORE, new OreConfiguration(adamantium_list, 5, 1.0F));
        FeatureUtils.register(registerable, AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT, Feature.FLOWER, new RandomPatchConfiguration(64, 0, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.HEART_SHAPED_PLANT.defaultBlockState().setValue(HeartShapedPlantBlock.AGE, 2))))));
    }

    public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> registerable) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = registerable.lookup(Registries.CONFIGURED_FEATURE);

        // limestone
        Holder<ConfiguredFeature<?, ?>> vibranium = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.ORE_VIBRANIUM);
        PlacementUtils.register(registerable, AdabraniumWorldgenFeatures.PLACED_VIBRANIUM, vibranium, AdabraniumWorldgenFeatures.modifiersWithCount(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-72), VerticalAnchor.aboveBottom(72))));

        // bluestone
        Holder<ConfiguredFeature<?, ?>> adamantium = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.ORE_ADAMANTIUM);
        PlacementUtils.register(registerable, AdabraniumWorldgenFeatures.PLACED_ADAMANTIUM, adamantium, List.of(new PlacementModifier[]{InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-72), VerticalAnchor.aboveBottom(72)), BiomeFilter.biome()}));

        // rainbow rose
        Holder<ConfiguredFeature<?, ?>> heart_shaped_plant = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT);
        PlacementUtils.register(registerable, AdabraniumWorldgenFeatures.PLACED_HEART_SHAPED_PLANT, heart_shaped_plant, List.of(new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()}));
    }

    @Override
    public String getName() {
        return "Adabranium World Gen";
    }
}
