package com.brand.adabranium.worldgen;

import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdabraniumWorldgenProvider extends FabricDynamicRegistryProvider {
    public AdabraniumWorldgenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.add(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.ORE_VIBRANIUM);
        entries.add(registries.getOrThrow(RegistryKeys.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_VIBRANIUM);
        entries.add(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.ORE_ADAMANTIUM);
        entries.add(registries.getOrThrow(RegistryKeys.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_ADAMANTIUM);
        entries.add(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE), AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT);
        entries.add(registries.getOrThrow(RegistryKeys.PLACED_FEATURE), AdabraniumWorldgenFeatures.PLACED_HEART_SHAPED_PLANT);
    }

    public static void bootstrapConfiguredFeatures(Registerable<ConfiguredFeature<?, ?>> registerable) {
        RuleTest stone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> vibranium_list = List.of(OreFeatureConfig.createTarget(stone, ModBlocks.VIBRANIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(deepslate, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> adamantium_list = List.of(OreFeatureConfig.createTarget(stone, ModBlocks.ADAMANTIUM_ORE.getDefaultState()), OreFeatureConfig.createTarget(deepslate, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.getDefaultState()));

        ConfiguredFeatures.register(registerable, AdabraniumWorldgenFeatures.ORE_VIBRANIUM, Feature.ORE, new OreFeatureConfig(vibranium_list, 4, 0.2f));
        ConfiguredFeatures.register(registerable, AdabraniumWorldgenFeatures.ORE_ADAMANTIUM, Feature.ORE, new OreFeatureConfig(adamantium_list, 5, 1.0F));
        ConfiguredFeatures.register(registerable, AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT, Feature.FLOWER, new RandomPatchFeatureConfig(64, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEART_SHAPED_PLANT.getDefaultState().with(HeartShapedPlantBlock.AGE, 2))))));
    }

    public static void bootstrapPlacedFeatures(Registerable<PlacedFeature> registerable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        // limestone
        RegistryEntry<ConfiguredFeature<?, ?>> vibranium = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.ORE_VIBRANIUM);
        PlacedFeatures.register(registerable, AdabraniumWorldgenFeatures.PLACED_VIBRANIUM, vibranium, AdabraniumWorldgenFeatures.modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72))));

        // bluestone
        RegistryEntry<ConfiguredFeature<?, ?>> adamantium = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.ORE_ADAMANTIUM);
        PlacedFeatures.register(registerable, AdabraniumWorldgenFeatures.PLACED_ADAMANTIUM, adamantium, List.of(new PlacementModifier[]{SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-72), YOffset.aboveBottom(72)), BiomePlacementModifier.of()}));

        // rainbow rose
        RegistryEntry<ConfiguredFeature<?, ?>> heart_shaped_plant = configuredFeatures.getOrThrow(AdabraniumWorldgenFeatures.HEART_SHAPED_PLANT);
        PlacedFeatures.register(registerable, AdabraniumWorldgenFeatures.PLACED_HEART_SHAPED_PLANT, heart_shaped_plant, List.of(new PlacementModifier[]{RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()}));
    }

    @Override
    public String getName() {
        return "Adabranium World Gen";
    }
}
