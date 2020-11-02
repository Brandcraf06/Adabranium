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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import com.brand.adabraniummod.content.ModBlocks;

public class OreBlockBase extends Block {

	public OreBlockBase(String name, float hardness, float resistance) {
		super(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, 3).strength(hardness, resistance));
		Registry.register(Registry.BLOCK, new Identifier(AdabraniumMod.MOD_ID, name), this);
		Registry.register(Registry.ITEM,new Identifier(AdabraniumMod.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));

	}

	protected int getExperienceWhenMined(Random random) {
		if (this == ModBlocks.ADAMANTINE_ORE) {
			return MathHelper.nextInt(random, 7, 17);
		} else {
			return this == ModBlocks.VIBRANIUM_ORE ? MathHelper.nextInt(random, 7, 14) : 0;
		}
	}

	public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
		super.onStacksDropped(state, world, pos, stack);
		if (EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, stack) == 0) {
			int i = this.getExperienceWhenMined(world.random);
			if (i > 0) {
				this.dropExperience(world, pos, i);
			}
		}

	}
}
