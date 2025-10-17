package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class AdabraniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public AdabraniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);

        this.getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);
    }
}
