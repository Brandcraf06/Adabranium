package com.brand.adabraniummod.stuff;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.adamantium.MaterialAdamantiumArmor;
import com.brand.adabraniummod.stuff.adamantium.MaterialAdamantiumPaxel;
import com.brand.adabraniummod.stuff.adamantium.MaterialAdamantiumTool;
import com.brand.adabraniummod.stuff.nether.MaterialNetherArmor;
import com.brand.adabraniummod.stuff.nether.MaterialNetherPaxel;
import com.brand.adabraniummod.stuff.nether.MaterialNetherTool;
import com.brand.adabraniummod.stuff.oneshotium.MaterialOneshotiumTool;
import com.brand.adabraniummod.stuff.vanilla.diamond.MaterialDiamondPaxel;
import com.brand.adabraniummod.stuff.vanilla.golden.MaterialGoldenPaxel;
import com.brand.adabraniummod.stuff.vanilla.iron.MaterialIronPaxel;
import com.brand.adabraniummod.stuff.vanilla.stone.MaterialStonePaxel;
import com.brand.adabraniummod.stuff.vanilla.wooden.MaterialWoodenPaxel;
import com.brand.adabraniummod.stuff.vibranium.MaterialVibraniumArmor;
import com.brand.adabraniummod.stuff.vibranium.MaterialVibraniumPaxel;
import com.brand.adabraniummod.stuff.vibranium.MaterialVibraniumTool;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FullStuffs { 

		public static final MaterialVibraniumArmor materialVibraniumArmor = new MaterialVibraniumArmor();
		public static final MaterialVibraniumTool materialVibraniumTool = new MaterialVibraniumTool();	
		public static final MaterialAdamantiumArmor materialAdamantiumArmor = new MaterialAdamantiumArmor();
		public static final MaterialAdamantiumTool materialAdamantiumTool = new MaterialAdamantiumTool();
		public static final MaterialNetherArmor materialNetherArmor = new MaterialNetherArmor();
		public static final MaterialNetherTool materialNetherTool = new MaterialNetherTool();
		public static final MaterialOneshotiumTool materialOneshotiumTool = new MaterialOneshotiumTool();
		public static final MaterialAdamantiumPaxel materialAdamantiumPaxel = new MaterialAdamantiumPaxel();
		public static final MaterialVibraniumPaxel materialVibraniumPaxel = new MaterialVibraniumPaxel();
		public static final MaterialNetherPaxel materialNetherPaxel = new MaterialNetherPaxel();
		
        // vanilla
		public static final MaterialWoodenPaxel materialWoodenPaxel = new MaterialWoodenPaxel();
		public static final MaterialStonePaxel materialStonePaxel = new MaterialStonePaxel();
		public static final MaterialGoldenPaxel materialGoldenPaxel = new MaterialGoldenPaxel();
		public static final MaterialIronPaxel materialIronPaxel = new MaterialIronPaxel();
		public static final MaterialDiamondPaxel materialDiamondPaxel = new MaterialDiamondPaxel();
		
		public static Item register(String name, Item item) {
		    return Registry.register(Registry.ITEM, new Identifier(AdabraniumMod.MOD_ID, name), item);
		}
	}

   
