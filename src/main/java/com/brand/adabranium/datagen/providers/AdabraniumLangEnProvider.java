package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.itemgroups.AdabraniumGroup;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AdabraniumLangEnProvider extends FabricLanguageProvider {
    public AdabraniumLangEnProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add(AdabraniumGroup.ADABRANIUM_GROUP, "Adabranium");

        translationBuilder.add(ModBlocks.ADAMANTIUM_ORE, "Adamantium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE, "Deepslate Adamantium Ore");
        translationBuilder.add(ModItems.ADAMANTIUM, "Adamantium");
        translationBuilder.add(ModItems.ADAMANTIUM_INGOT, "Adamantium Ingot");
        translationBuilder.add(ModBlocks.ADAMANTIUM_BLOCK, "Adamantium Block");


        translationBuilder.add(ModBlocks.VIBRANIUM_ORE, "Vibranium Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE, "Deepslate Vibranium Ore");
        translationBuilder.add(ModItems.VIBRANIUM, "Vibranium");
        translationBuilder.add(ModItems.VIBRANIUM_INGOT, "Vibranium Ingot");
        translationBuilder.add(ModItems.VIBRANIUM_DUST, "Vibranium Dust");
        translationBuilder.add(ModBlocks.VIBRANIUM_BLOCK, "Vibranium Block");

        translationBuilder.add(ModBlocks.HEART_SHAPED_PLANT, "Heart Shaped Plant");
        translationBuilder.add(ModItems.HEART_SHAPED_HERB, "Heart Shaped Herb");
        translationBuilder.add(ModItems.VIBRANIUM_SOUP, "Vibranium Soup");

        for (FullStuffs fullStuffs : FullStuffs.values()) {
            translationBuilder.add(fullStuffs.helmet, name(fullStuffs.equipmentKey.identifier().getPath() + " Helmet"));
            translationBuilder.add(fullStuffs.chestplate, name(fullStuffs.equipmentKey.identifier().getPath() + " Chestplate"));
            translationBuilder.add(fullStuffs.leggings, name(fullStuffs.equipmentKey.identifier().getPath() + " Leggings"));
            translationBuilder.add(fullStuffs.boots, name(fullStuffs.equipmentKey.identifier().getPath() + " Boots"));
            translationBuilder.add(fullStuffs.pickaxe, name(fullStuffs.equipmentKey.identifier().getPath() + " Pickaxe"));
            translationBuilder.add(fullStuffs.axe, name(fullStuffs.equipmentKey.identifier().getPath() + " Axe"));
            translationBuilder.add(fullStuffs.shovel, name(fullStuffs.equipmentKey.identifier().getPath() + " Shovel"));
            translationBuilder.add(fullStuffs.hoe, name(fullStuffs.equipmentKey.identifier().getPath() + " Hoe"));
            translationBuilder.add(fullStuffs.sword, name(fullStuffs.equipmentKey.identifier().getPath() + " Sword"));
        }
        translationBuilder.add(ModItems.ONESHOTIUM_SWORD, "Oneshotium Sword");

        // Potions
        translationBuilder.add("item.minecraft.potion.effect.toughness", "Potion of Toughness");
        translationBuilder.add("item.minecraft.splash_potion.effect.toughness", "Splash Potion of Toughness");
        translationBuilder.add("item.minecraft.lingering_potion.effect.toughness", "Lingering Potion of Toughness");
        translationBuilder.add("item.minecraft.tipped_arrow.effect.toughness", "Arrow Potion of Toughness");

        // Smithing Template
        translationBuilder.add("item.adabranium.smithing_template.vibranium_upgrade.applies_to", "Netherite Equipment");
        translationBuilder.add("item.adabranium.smithing_template.vibranium_upgrade.ingredients", "Vibranium Ingot");
        translationBuilder.add("item.adabranium.smithing_template.vibranium_upgrade.base_slot_description", "Add netherite armor, weapon, or tool");
        translationBuilder.add("item.adabranium.smithing_template.vibranium_upgrade.additions_slot_description", "Add Vibranium Ingot");
        translationBuilder.add(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, "Vibranium Upgrade");

        translationBuilder.add("item.adabranium.smithing_template.adamantium_upgrade.applies_to", "Vibranium Equipment");
        translationBuilder.add("item.adabranium.smithing_template.adamantium_upgrade.ingredients", "Adamantium Ingot");
        translationBuilder.add("item.adabranium.smithing_template.adamantium_upgrade.base_slot_description", "Add vibranium armor, weapon, or tool");
        translationBuilder.add("item.adabranium.smithing_template.adamantium_upgrade.additions_slot_description", "Add Adamantium Ingot");
        translationBuilder.add(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, "Adamantium Upgrade");

        // Advancements
        advancement(translationBuilder, "root", "Adabranium", "Marvel powerful materials");
        advancement(translationBuilder, "wakanda_forever", "Wakanda Forever", "Craft a vibranium ingot, with vibranium and obsidian, and be the King of Wakanda");
        advancement(translationBuilder, "vibranium_pickaxe", "A Strong Pick", "Upgrade a Netherite pickaxe to vibranium");
        advancement(translationBuilder, "adamantium_ingot", "Virtually Indestructible Metal", "Make an adamantium ingot with adamantium and vibranium ingots");
        advancement(translationBuilder, "purple_panther", "Purple Panther", "Upgrade a piece of Netherite armor to vibranium");
        advancement(translationBuilder, "panther_powers", "Panther Powers", "Collect some heart shaped herbs in a jungle to craft a vibranium soup");
        advancement(translationBuilder, "adamantium_pickaxe", "The Strongest Pick", "Upgrade a vibranium pickaxe to adamantium");
        advancement(translationBuilder, "adamantium_armor", "Mineverine", "Upgrade a full vibranium armor to adamantium");
        advancement(translationBuilder, "premium_hoe", "Premium Hoe", "Make a useful adamantium hoe");

    }

    private void advancement(TranslationBuilder builder, String id, String title, String description) {
        builder.add("advancements.adabranium." + id + ".title", title);
        builder.add("advancements.adabranium." + id + ".description", description);
    }

    public static String name(String id) {
        return Arrays.stream(id.split("_"))
                .map(part -> Character.toUpperCase(part.charAt(0)) + part.substring(1))
                .collect(Collectors.joining(" "));
    }
}
