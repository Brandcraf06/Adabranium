package com.brand.adabranium.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.content.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AdabraniumGroup {

    public static final RegistryKey<ItemGroup> ADABRANIUM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Adabranium.MOD_ID, "adabranium_group"));

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, ADABRANIUM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup.adabranium.adabranium_group"))
                .icon(() -> new ItemStack(ModItems.VIBRANIUM_INGOT))
                .build()
        );

        ItemGroupEvents.modifyEntriesEvent(ADABRANIUM_GROUP).register((entries) -> {
            entries.add(ModBlocks.VIBRANIUM_ORE);
            entries.add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
            entries.add(ModBlocks.ADAMANTIUM_ORE);
            entries.add(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
            entries.add(ModItems.VIBRANIUM);
            entries.add(ModItems.VIBRANIUM_INGOT);
            entries.add(ModItems.VIBRANIUM_DUST);
            entries.add(ModBlocks.VIBRANIUM_BLOCK);
            entries.add(ModItems.ADAMANTIUM);
            entries.add(ModItems.ADAMANTIUM_INGOT);
            entries.add(ModBlocks.ADAMANTIUM_BLOCK);

            entries.add(ModItems.OBSIDIAN_ROD);
            entries.add(ModItems.ADAMANTIUM_ROD);

            for (FullStuffs stuff : FullStuffs.values()) {
                entries.add(stuff.helmet);
                entries.add(stuff.chestplate);
                entries.add(stuff.leggings);
                entries.add(stuff.boots);
                entries.add(stuff.sword);
                entries.add(stuff.shovel);
                entries.add(stuff.pickaxe);
                entries.add(stuff.axe);
                entries.add(stuff.hoe);
            }

            entries.add(ModBlocks.HEART_SHAPED_PLANT);
            entries.add(ModItems.HEART_SHAPED_HERB);
            entries.add(ModItems.VIBRANIUM_SOUP);

            entries.add(ModItems.ONESHOTIUM_SWORD);

        });
    }
}

