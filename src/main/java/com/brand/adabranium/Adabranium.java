package com.brand.adabranium;

import com.brand.adabranium.itemgroups.AdabraniumGroup;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.potions.PotionsRecipes;
import com.brand.adabranium.worldgen.AdabraniumWorldgenFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
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
            if (key.getValue().equals(Identifier.ofVanilla("chests/jungle_temple"))) {
                LootPool pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .bonusRolls(ConstantLootNumberProvider.create(0.0f))
                        .with(EmptyEntry.builder().weight(2))
                        .with(ItemEntry.builder(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE).weight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.getValue().equals(Identifier.ofVanilla("chests/desert_pyramid"))) {
                LootPool pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .bonusRolls(ConstantLootNumberProvider.create(0.0f))
                        .with(EmptyEntry.builder().weight(6))
                        .with(ItemEntry.builder(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE).weight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.getValue().equals(Identifier.ofVanilla("chests/ancient_city"))) {
                LootPool pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0f))
                        .bonusRolls(ConstantLootNumberProvider.create(0.0f))
                        .with(EmptyEntry.builder().weight(5))
                        .with(ItemEntry.builder(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE).weight(1))
                        .build();

                tableBuilder.pool(pool);
            }
        });
    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}


