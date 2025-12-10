package com.brand.adabranium.registry.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.blocks.HeartShapedPlantBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {
    public static final Block VIBRANIUM_ORE = register("vibranium_ore", settings -> new DropExperienceBlock(UniformInt.of(7, 14), settings), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(6.0f, 6.0f).requiresCorrectToolForDrops());
    public static final Block DEEPSLATE_VIBRANIUM_ORE = register("deepslate_vibranium_ore", settings -> new DropExperienceBlock(UniformInt.of(7, 14), settings), BlockBehaviour.Properties.ofFullCopy(VIBRANIUM_ORE).strength(9.0f, 6.0f).sound(SoundType.DEEPSLATE));
    public static final Block ADAMANTIUM_ORE = register("adamantium_ore", settings -> new DropExperienceBlock(UniformInt.of(7, 14), settings), BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(14.0f, 9.0f).requiresCorrectToolForDrops());
    public static final Block DEEPSLATE_ADAMANTIUM_ORE = register("deepslate_adamantium_ore", settings -> new DropExperienceBlock(UniformInt.of(7, 14), settings), BlockBehaviour.Properties.ofFullCopy(ADAMANTIUM_ORE).strength(21.0f, 9.0f).sound(SoundType.DEEPSLATE));
    public static final Block VIBRANIUM_BLOCK = register("vibranium_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(25.0f, 600.0f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops());
    public static final Block ADAMANTIUM_BLOCK = register("adamantium_block", Block::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(50.0f, 1200.0f).sound(SoundType.NETHERITE_BLOCK).requiresCorrectToolForDrops());
    public static final Block HEART_SHAPED_PLANT = register("heart_shaped_plant", HeartShapedPlantBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(0).sound(SoundType.GRASS).lightLevel((state) -> 8).randomTicks().noCollision().instabreak().pushReaction(PushReaction.DESTROY));


    public static Block register(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties blockSettings, Item.Properties itemSettings) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Adabranium.id(id));
        Block block = factory.apply(blockSettings.setId(key));
        Registry.register(BuiltInRegistries.BLOCK, key, block);
        var itemRegistryKey = ResourceKey.create(Registries.ITEM, key.identifier());
        Registry.register(BuiltInRegistries.ITEM, itemRegistryKey, new BlockItem(block, itemSettings.setId(itemRegistryKey).useBlockDescriptionPrefix()));
        return block;
    }

    public static Block register(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return register(id, factory, settings, new Item.Properties());
    }
}

