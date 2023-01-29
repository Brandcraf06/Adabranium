package com.brand.adabranium.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.content.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class AdabraniumGroup {

    private static final ItemGroup ADABRANIUM_GROUP = FabricItemGroup.builder(new Identifier(Adabranium.MOD_ID, "adabranium_group"))
            .displayName(Text.literal("Adabranium"))
            .icon(() -> new ItemStack(ModItems.VIBRANIUM_INGOT))
            .entries((enabledFeatures, entries, operatorEnabled) -> {

                entries.add(ModBlocks.VIBRANIUM_ORE);
                entries.add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
                entries.add(ModBlocks.ADAMANTINE_ORE);
                entries.add(ModBlocks.DEEPSLATE_ADAMANTINE_ORE);
                entries.add(ModItems.VIBRANIUM);
                entries.add(ModItems.VIBRANIUM_INGOT);
                entries.add(ModItems.VIBRANIUM_DUST);
                entries.add(ModBlocks.VIBRANIUM_BLOCK);
                entries.add(ModItems.ADAMANTINE);
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

            })
            .build();

}


