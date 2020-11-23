package com.brand.adabraniummod.blocks;

import com.brand.adabraniummod.Adabranium;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VibraniumBlock extends Block {

    public VibraniumBlock(String name, float hardness, float resistance) {
        super(FabricBlockSettings.of(Material.METAL).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).strength(hardness, resistance));
        Registry.register(Registry.BLOCK, new Identifier(Adabranium.MOD_ID, name), this);
        Registry.register(Registry.ITEM, new Identifier(Adabranium.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(Adabranium.ADABRANIUM_GROUP)));

    }
}
