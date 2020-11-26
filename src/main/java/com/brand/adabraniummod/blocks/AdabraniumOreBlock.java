package com.brand.adabraniummod.blocks;

import com.brand.adabraniummod.content.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class AdabraniumOreBlock extends Block {

    public AdabraniumOreBlock(Settings settings) {
        super(settings);
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
