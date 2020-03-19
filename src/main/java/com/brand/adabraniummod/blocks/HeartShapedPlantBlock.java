package com.brand.adabraniummod.blocks;

import java.util.Random;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.content.ModBlocks;
import com.brand.adabraniummod.items.ModItems;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.Material;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class HeartShapedPlantBlock extends PlantBlock implements Fertilizable {
	   protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D);
	   public static final IntProperty AGE;

	   public HeartShapedPlantBlock(String name, float hardness, float resistance) {
			super(FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.GRASS).ticksRandomly().noCollision().breakInstantly().lightLevel(10).strength(hardness, resistance).build());
			Registry.register(Registry.BLOCK, new Identifier(AdabraniumMod.MOD_ID, name), this);
			Registry.register(Registry.ITEM,new Identifier(AdabraniumMod.MOD_ID, name), new BlockItem(this, new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
			this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
	   }

	   @Environment(EnvType.CLIENT)
	   public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
	      return new ItemStack(ModBlocks.HEART_SHAPED_PLANT);
	   }

	   public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, EntityContext context) {
		      Vec3d vec3d = state.getModelOffset(world, pos);
		      return SHAPE.offset(vec3d.x, vec3d.y, vec3d.z);
	  }

	   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		      super.scheduledTick(state, world, pos, random);
		      int i = (Integer)state.get(AGE);
		      if (i < 2 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) >= 10) {
		         world.setBlockState(pos, (BlockState)state.with(AGE, i + 1), 2);
		      }

		   }

		   public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		      int i = (Integer)state.get(AGE);
		      if (i > 1) {
		         dropStack(world, pos, new ItemStack(ModItems.HEART_SHAPED_HERB, 1));
		         world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
		         world.setBlockState(pos, (BlockState)state.with(AGE, 0), 2);
		         return ActionResult.SUCCESS;
		      } else {
		         return super.onUse(state, world, pos, player, hand, hit);
		      }
		   }

		   protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		      builder.add(AGE);
		   }

		   public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
			   return false;
		   }

		   public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
		      return true;
		   }

		   public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		      int i = Math.min(2, (Integer)state.get(AGE) + 1);
		      world.setBlockState(pos, (BlockState)state.with(AGE, i), 2);
		   }
	   static {
	      AGE = Properties.AGE_2;
	   }

    }
	
