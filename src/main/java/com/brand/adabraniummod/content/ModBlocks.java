package com.brand.adabraniummod.content;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block VIBRANIUM_ORE = register("vibranium_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f, 6.0f).requiresTool(), UniformIntProvider.create(7, 14)));
    public static final Block DEEPSLATE_VIBRANIUM_ORE = register("deepslate_vibranium_ore", new OreBlock(FabricBlockSettings.copyOf(VIBRANIUM_ORE).strength(9.0f, 6.0f), UniformIntProvider.create(7, 14)));
    public static final Block ADAMANTINE_ORE = register("adamantine_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(14.0f, 9.0f).requiresTool(), UniformIntProvider.create(7, 14)));
    public static final Block DEEPSLATE_ADAMANTINE_ORE = register("deepslate_adamantine_ore", new OreBlock(FabricBlockSettings.copyOf(ADAMANTINE_ORE).strength(21.0f, 9.0f), UniformIntProvider.create(7, 14)));
    public static final Block VIBRANIUM_BLOCK = register("vibranium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).strength(25.0f, 600.0f).requiresTool()));
    public static final Block ADAMANTIUM_BLOCK = register("adamantium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.GREEN).strength(50.0f, 1200.0f).requiresTool()));
    public static final Block HEART_SHAPED_PLANT = register("heart_shaped_plant", new HeartShapedPlantBlock(FabricBlockSettings.of(Material.PLANT).strength(0).sounds(BlockSoundGroup.GRASS).luminance(8).ticksRandomly().noCollision().breakInstantly()));


    public static Block register(String id, Block block, BlockItem item) {
        Registry.register(Registry.BLOCK, Adabranium.id(id), block);
        Registry.register(Registry.ITEM, Adabranium.id(id), item);

        return block;
    }

    public static Block register(String id, Block block, ItemGroup itemGroup) {
        return register(id, block, new BlockItem(block, new Item.Settings().group(itemGroup)));
    }

    public static Block register(String id, Block block) {
        return register(id, block, Adabranium.ADABRANIUM_GROUP);
    }
}

