package com.brand.adabranium;

import com.brand.adabranium.itemgroups.AdabraniumGroup;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.potions.PotionsRecipes;
import com.brand.adabranium.worldgen.AdabraniumWorldgenFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Adabranium implements ModInitializer {

    public static final String MOD_ID = "adabranium";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {

        new ModBlocks();
        new ModItems();

        AdabraniumGroup.init();

        PotionsRecipes.registerRecipes();
        AdabraniumWorldgenFeatures.registerConfiguredFeature();

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.identifier().equals(Identifier.withDefaultNamespace("chests/jungle_temple"))) {
                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .setBonusRolls(ConstantValue.exactly(0.0f))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                        .add(LootItem.lootTableItem(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE).setWeight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.identifier().equals(Identifier.withDefaultNamespace("chests/desert_pyramid"))) {
                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .setBonusRolls(ConstantValue.exactly(0.0f))
                        .add(EmptyLootItem.emptyItem().setWeight(6))
                        .add(LootItem.lootTableItem(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE).setWeight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.identifier().equals(Identifier.withDefaultNamespace("chests/ancient_city"))) {
                LootPool pool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .setBonusRolls(ConstantValue.exactly(0.0f))
                        .add(EmptyLootItem.emptyItem().setWeight(5))
                        .add(LootItem.lootTableItem(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE).setWeight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
    }

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}


