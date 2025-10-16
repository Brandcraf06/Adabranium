package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public record AdabraniumToolMaterials(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
    public static final ToolMaterial VIBRANIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2701, 11.0F, 6.0F, 12, AdabraniumItemTags.VIBRANIUM_MATERIALS);
    public static final ToolMaterial ADAMANTIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3346, 14.0F, 8.0F, 10, AdabraniumItemTags.ADAMANTIUM_MATERIALS);
    public static final ToolMaterial NETHER_BRICK = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 9.0F, 2.0F, 15, AdabraniumItemTags.NETHER_BRICK_MATERIALS);
    public static final ToolMaterial ONESHOTIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000000, 23.0F, 999999.0F, 100, AdabraniumItemTags.ADAMANTIUM_MATERIALS);
}

