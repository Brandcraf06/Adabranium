package com.brand.adabraniummod.blocks;


import java.util.Random;

import com.brand.adabraniummod.AdabraniumMod;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import com.brand.adabraniummod.content.ModBlocks;

public class VibraniumOre extends Block {

public VibraniumOre(String name, float hardness, float resistance) {
	super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3).strength(hardness, resistance));
	Registry.register(Registry.BLOCK, new Identifier(AdabraniumMod.MOD_ID, name), this);
	Registry.register(Registry.ITEM,new Identifier(AdabraniumMod.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));

    }

 protected int getExperienceWhenMined(Random random_1) {
   return this == ModBlocks.VIBRANIUM_ORE ? MathHelper.nextInt(random_1, 7, 14) : 0;
    }
 
 public void onStacksDropped(BlockState blockState_1, World world_1, BlockPos blockPos_1, ItemStack itemStack_1) {
    super.onStacksDropped(blockState_1, world_1, blockPos_1, itemStack_1);
    if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, itemStack_1) == 0) {
       int int_1 = this.getExperienceWhenMined(world_1.random);
       if (int_1 > 0) {
          this.dropExperience(world_1, blockPos_1, int_1);
          
        }  
      }
    }
}

