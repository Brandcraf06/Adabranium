package com.brand.adabraniummod.content;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {


    public static final Block VIBRANIUM_ORE = register("vibranium_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(6.0f, 6.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool(), UniformIntProvider.create(7, 14)));
    public static final Block DEEPSLATE_VIBRANIUM_ORE = register("deepslate_vibranium_ore", new OreBlock(FabricBlockSettings.copyOf(VIBRANIUM_ORE).strength(9.0f, 6.0f), UniformIntProvider.create(7, 14)));
    public static final Block ADAMANTINE_ORE = register("adamantine_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).strength(14.0f, 9.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool(), UniformIntProvider.create(7, 14)));
    public static final Block DEEPSLATE_ADAMANTINE_ORE = register("deepslate_adamantine_ore", new OreBlock(FabricBlockSettings.copyOf(ADAMANTINE_ORE).strength(21.0f, 9.0f), UniformIntProvider.create(7, 14)));
    public static final Block VIBRANIUM_BLOCK = register("vibranium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.PURPLE).strength(25.0f, 600.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool()));
    public static final Block ADAMANTIUM_BLOCK = register("adamantium_block", new Block(FabricBlockSettings.of(Material.METAL, MapColor.GREEN).strength(50.0f, 1200.0f).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool()));
    public static final Block HEART_SHAPED_PLANT = register("heart_shaped_plant", new HeartShapedPlantBlock(FabricBlockSettings.of(Material.PLANT).strength(0).sounds(BlockSoundGroup.GRASS).luminance(9).ticksRandomly().noCollision().breakInstantly()));

    public static Block register(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(Adabranium.MOD_ID, id);
        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(registeredBlock, new Item.Settings().maxCount(64).group(Adabranium.ADABRANIUM_GROUP)));
        }
        return registeredBlock;
    }

    public static Block register(String id, Block block) {
        return register(id, block, true);
    }
}

