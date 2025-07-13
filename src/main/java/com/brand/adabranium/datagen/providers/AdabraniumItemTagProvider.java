package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class AdabraniumItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdabraniumItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    private void copy(Identifier id) {
        TagKey<Block> blockTag = TagKey.of(RegistryKeys.BLOCK, id);
        TagKey<Item> itemTag = TagKey.of(RegistryKeys.ITEM, id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {

        this.valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.VIBRANIUM_INGOT)
                .add(ModItems.ADAMANTIUM_INGOT);

        this.valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(ModItems.VIBRANIUM_STUFF.pickaxe)
                .add(ModItems.ADAMANTIUM_STUFF.pickaxe)
                .add(ModItems.NETHER_STUFF.pickaxe);

        for (FullStuffs fullStuffs : FullStuffs.values()) {
            this.valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                    .add(fullStuffs.helmet)
                    .add(fullStuffs.chestplate)
                    .add(fullStuffs.leggings)
                    .add(fullStuffs.boots);
        }

        this.valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.VIBRANIUM_STUFF.pickaxe)
                .add(ModItems.ADAMANTIUM_STUFF.pickaxe)
                .add(ModItems.NETHER_STUFF.pickaxe);

        this.valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.VIBRANIUM_STUFF.axe)
                .add(ModItems.ADAMANTIUM_STUFF.axe)
                .add(ModItems.NETHER_STUFF.axe);

        this.valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.VIBRANIUM_STUFF.shovel)
                .add(ModItems.ADAMANTIUM_STUFF.shovel)
                .add(ModItems.NETHER_STUFF.shovel);

        this.valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.VIBRANIUM_STUFF.hoe)
                .add(ModItems.ADAMANTIUM_STUFF.hoe)
                .add(ModItems.NETHER_STUFF.hoe);

        this.valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.VIBRANIUM_STUFF.sword)
                .add(ModItems.ADAMANTIUM_STUFF.sword)
                .add(ModItems.NETHER_STUFF.sword);

        this.valueLookupBuilder(AdabraniumItemTags.ADAMANTIUM_MATERIALS).add(ModItems.ADAMANTIUM_INGOT);
        this.valueLookupBuilder(AdabraniumItemTags.VIBRANIUM_MATERIALS).add(ModItems.VIBRANIUM_INGOT);
        this.valueLookupBuilder(AdabraniumItemTags.NETHER_BRICK_MATERIALS).add(Items.NETHER_BRICK);


    }
}
