package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.brand.adabranium.registry.content.ModBlocks.*;

public class AdabraniumBlockLootTableProvider extends FabricBlockLootTableProvider {
    public final RegistryWrapper.WrapperLookup registryLookup;

    public AdabraniumBlockLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generate() {
        this.addDrops(VIBRANIUM_BLOCK, ADAMANTIUM_BLOCK);
        this.addDrop(VIBRANIUM_ORE, (block) -> this.oreDrops(block, ModItems.VIBRANIUM));
        this.addDrop(DEEPSLATE_VIBRANIUM_ORE, (block) -> this.oreDrops(block, ModItems.VIBRANIUM));
        this.addDrop(ADAMANTIUM_ORE, (block) -> this.oreDropsNoFortune(block, ModItems.ADAMANTIUM));
        this.addDrop(DEEPSLATE_ADAMANTIUM_ORE, (block) -> this.oreDropsNoFortune(block, ModItems.ADAMANTIUM));

        this.addDrop(HEART_SHAPED_PLANT, (block) -> LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(HEART_SHAPED_PLANT).conditionally(this.createWithSilkTouchOrShearsCondition()).alternatively(ItemEntry.builder(ModItems.HEART_SHAPED_HERB).conditionally(BlockStatePropertyLootCondition.builder(HEART_SHAPED_PLANT).properties(StatePredicate.Builder.create().exactMatch(HeartShapedPlantBlock.AGE, 2)))))));
    }

    public void addDrops(Block... blocks) {
        for (Block block : blocks) this.addDrop(block);
    }

    public LootTable.Builder oreDropsNoFortune(Block withSilkTouch, Item withoutSilkTouch) {
        return this.dropsWithSilkTouch(withSilkTouch, this.applyExplosionDecay(withSilkTouch, ItemEntry.builder(withoutSilkTouch)));
    }
}
