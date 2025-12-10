package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

import static com.brand.adabranium.registry.content.ModBlocks.*;

public class AdabraniumBlockLootTableProvider extends FabricBlockLootTableProvider {
    public final HolderLookup.Provider registryLookup;

    public AdabraniumBlockLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generate() {
        this.addDrops(VIBRANIUM_BLOCK, ADAMANTIUM_BLOCK);
        this.add(VIBRANIUM_ORE, (block) -> this.createOreDrop(block, ModItems.VIBRANIUM));
        this.add(DEEPSLATE_VIBRANIUM_ORE, (block) -> this.createOreDrop(block, ModItems.VIBRANIUM));
        this.add(ADAMANTIUM_ORE, (block) -> this.oreDropsNoFortune(block, ModItems.ADAMANTIUM));
        this.add(DEEPSLATE_ADAMANTIUM_ORE, (block) -> this.oreDropsNoFortune(block, ModItems.ADAMANTIUM));

        this.add(HEART_SHAPED_PLANT, (block) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(HEART_SHAPED_PLANT).when(this.hasShearsOrSilkTouch()).otherwise(LootItem.lootTableItem(ModItems.HEART_SHAPED_HERB).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(HEART_SHAPED_PLANT).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HeartShapedPlantBlock.AGE, 2)))))));
    }

    public void addDrops(Block... blocks) {
        for (Block block : blocks) this.dropSelf(block);
    }

    public LootTable.Builder oreDropsNoFortune(Block withSilkTouch, Item withoutSilkTouch) {
        return this.createSilkTouchDispatchTable(withSilkTouch, this.applyExplosionDecay(withSilkTouch, LootItem.lootTableItem(withoutSilkTouch)));
    }
}
