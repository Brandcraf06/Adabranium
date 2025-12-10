package com.brand.adabranium.itemgroups;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AdabraniumGroup {

    public static final ResourceKey<CreativeModeTab> ADABRANIUM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Adabranium.id("adabranium_group"));

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ADABRANIUM_GROUP, FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.adabranium.adabranium_group"))
                .icon(() -> new ItemStack(ModItems.VIBRANIUM_INGOT))
                .build()
        );

        ItemGroupEvents.modifyEntriesEvent(ADABRANIUM_GROUP).register((entries) -> {
            entries.accept(ModBlocks.VIBRANIUM_ORE);
            entries.accept(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
            entries.accept(ModBlocks.ADAMANTIUM_ORE);
            entries.accept(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
            entries.accept(ModItems.VIBRANIUM);
            entries.accept(ModItems.VIBRANIUM_INGOT);
            entries.accept(ModItems.VIBRANIUM_DUST);
            entries.accept(ModBlocks.VIBRANIUM_BLOCK);
            entries.accept(ModItems.ADAMANTIUM);
            entries.accept(ModItems.ADAMANTIUM_INGOT);
            entries.accept(ModBlocks.ADAMANTIUM_BLOCK);

            entries.accept(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE);
            entries.accept(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE);

            for (FullStuffs stuff : FullStuffs.values()) {
                entries.accept(stuff.helmet);
                entries.accept(stuff.chestplate);
                entries.accept(stuff.leggings);
                entries.accept(stuff.boots);
                entries.accept(stuff.sword);
                entries.accept(stuff.shovel);
                entries.accept(stuff.pickaxe);
                entries.accept(stuff.axe);
                entries.accept(stuff.hoe);
            }

            entries.accept(ModBlocks.HEART_SHAPED_PLANT);
            entries.accept(ModItems.HEART_SHAPED_HERB);
            entries.accept(ModItems.VIBRANIUM_SOUP);

            entries.accept(ModItems.ONESHOTIUM_SWORD);

        });
    }
}

