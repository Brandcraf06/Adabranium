package com.brand.adabraniummod.content;

import com.brand.adabraniummod.blocks.AdamantineOre;
import com.brand.adabraniummod.blocks.HeartShapedPlantBlock;
import com.brand.adabraniummod.blocks.VibraniumBlock;
import com.brand.adabraniummod.blocks.VibraniumOre;

public class ModBlocks {

	public static VibraniumOre VIBRANIUM_ORE;
	public static AdamantineOre ADAMANTINE_ORE;
	public static VibraniumBlock VIBRANIUM_BLOCK;
	public static VibraniumBlock ADAMANTIUM_BLOCK;
	public static HeartShapedPlantBlock HEART_SHAPED_PLANT;

	public static void init() {

		VIBRANIUM_ORE = new VibraniumOre("vibranium_ore", 6.0f, 300.0f);
		ADAMANTINE_ORE = new AdamantineOre("adamantine_ore", 25.0f, 300.0f);
		VIBRANIUM_BLOCK = new VibraniumBlock("vibranium_block", 4.0f, 600.0f);
		ADAMANTIUM_BLOCK = new VibraniumBlock("adamantium_block", 50.0f, 1200.0f);
		HEART_SHAPED_PLANT = new HeartShapedPlantBlock("heart_shaped_plant", 0.0f, 0.0f);
		
		
	}
}
