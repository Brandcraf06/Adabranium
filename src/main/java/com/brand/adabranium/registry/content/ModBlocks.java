package com.brand.adabranium.registry.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    public static final Block VIBRANIUM_ORE = register("vibranium_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(7, 14), settings), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).strength(6.0f, 6.0f).requiresTool());
    public static final Block DEEPSLATE_VIBRANIUM_ORE = register("deepslate_vibranium_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(7, 14), settings), AbstractBlock.Settings.copyShallow(VIBRANIUM_ORE).strength(9.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block ADAMANTIUM_ORE = register("adamantium_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(7, 14), settings), AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).strength(14.0f, 9.0f).requiresTool());
    public static final Block DEEPSLATE_ADAMANTIUM_ORE = register("deepslate_adamantium_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(7, 14), settings), AbstractBlock.Settings.copyShallow(ADAMANTIUM_ORE).strength(21.0f, 9.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block VIBRANIUM_BLOCK = register("vibranium_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(25.0f, 600.0f).sounds(BlockSoundGroup.NETHERITE).requiresTool());
    public static final Block ADAMANTIUM_BLOCK = register("adamantium_block", Block::new, AbstractBlock.Settings.create().mapColor(MapColor.GREEN).strength(50.0f, 1200.0f).sounds(BlockSoundGroup.NETHERITE).requiresTool());
    public static final Block HEART_SHAPED_PLANT = register("heart_shaped_plant", HeartShapedPlantBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).strength(0).sounds(BlockSoundGroup.GRASS).luminance((state) -> 8).ticksRandomly().noCollision().breakInstantly().pistonBehavior(PistonBehavior.DESTROY));


    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings, Item.Settings itemSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Adabranium.id(id));
        Block block = factory.apply(blockSettings.registryKey(key));
        Registry.register(Registries.BLOCK, key, block);
        var itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, key.getValue());
        Registry.register(Registries.ITEM, itemRegistryKey, new BlockItem(block, itemSettings.registryKey(itemRegistryKey).useBlockPrefixedTranslationKey()));
        return block;
    }

    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(id, factory, settings, new Item.Settings());
    }
}

