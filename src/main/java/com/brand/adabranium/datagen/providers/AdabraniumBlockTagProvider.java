package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class AdabraniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public AdabraniumBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);

        this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);

        this.valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

        this.valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);
    }
}
