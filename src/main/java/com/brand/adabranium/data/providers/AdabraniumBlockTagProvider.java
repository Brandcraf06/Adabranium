package com.brand.adabranium.data.providers;

import com.brand.adabranium.content.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class AdabraniumBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public AdabraniumBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public FabricTagBuilder getOrCreateTagBuilder(Identifier id) {
        TagKey<Block> tag = TagKey.of(RegistryKeys.BLOCK, id);
        return this.getOrCreateTagBuilder(tag);
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

        this.getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_ORE)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
                .add(ModBlocks.ADAMANTIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_ORE)
                .add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.ADAMANTIUM_BLOCK);
    }
}
