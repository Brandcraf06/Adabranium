package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class AdabraniumItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public AdabraniumItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagProvider blockTagProvider) {
        super(output, registriesFuture, blockTagProvider);
    }

    private void copy(Identifier id) {
        TagKey<Block> blockTag = TagKey.create(Registries.BLOCK, id);
        TagKey<Item> itemTag = TagKey.create(Registries.ITEM, id);

        this.copy(blockTag, itemTag);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

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

        this.valueLookupBuilder(ItemTags.SPEARS)
                .add(ModItems.VIBRANIUM_STUFF.spear)
                .add(ModItems.ADAMANTIUM_STUFF.spear)
                .add(ModItems.NETHER_STUFF.spear);

        this.valueLookupBuilder(AdabraniumItemTags.ADAMANTIUM_MATERIALS).add(ModItems.ADAMANTIUM_INGOT);
        this.valueLookupBuilder(AdabraniumItemTags.VIBRANIUM_MATERIALS).add(ModItems.VIBRANIUM_INGOT);
        this.valueLookupBuilder(AdabraniumItemTags.NETHER_BRICK_MATERIALS).add(Items.NETHER_BRICK);


    }
}
