package com.brand.adabraniummod.items;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumArmorSet;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumAxe;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumHoe;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumPaxel;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumPickaxe;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumShovel;
import com.brand.adabraniummod.stuff.adamantium.AdamantiumSword;
import com.brand.adabraniummod.stuff.nether.NetherArmorSet;
import com.brand.adabraniummod.stuff.nether.NetherAxe;
import com.brand.adabraniummod.stuff.nether.NetherHoe;
import com.brand.adabraniummod.stuff.nether.NetherPaxel;
import com.brand.adabraniummod.stuff.nether.NetherPickaxe;
import com.brand.adabraniummod.stuff.nether.NetherShovel;
import com.brand.adabraniummod.stuff.nether.NetherSword;
import com.brand.adabraniummod.stuff.oneshotium.OneshotiumSword;
import com.brand.adabraniummod.stuff.vanilla.diamond.DiamondPaxel;
import com.brand.adabraniummod.stuff.vanilla.golden.GoldenPaxel;
import com.brand.adabraniummod.stuff.vanilla.iron.IronPaxel;
import com.brand.adabraniummod.stuff.vanilla.netherite.NetheritePaxel;
import com.brand.adabraniummod.stuff.vanilla.stone.StonePaxel;
import com.brand.adabraniummod.stuff.vanilla.wooden.WoodenPaxel;
import com.brand.adabraniummod.stuff.vibranium.VibraniumArmorSet;
import com.brand.adabraniummod.stuff.vibranium.VibraniumAxe;
import com.brand.adabraniummod.stuff.vibranium.VibraniumHoe;
import com.brand.adabraniummod.stuff.vibranium.VibraniumPaxel;
import com.brand.adabraniummod.stuff.vibranium.VibraniumPickaxe;
import com.brand.adabraniummod.stuff.vibranium.VibraniumShovel;
import com.brand.adabraniummod.stuff.vibranium.VibraniumSword;
import net.minecraft.util.registry.Registry;

public class FullSets
{
	 public static void registerItems()
	    {	        
	        // vibranium
		    VibraniumArmorSet.registerArmor();
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_pickaxe", new VibraniumPickaxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_axe", new VibraniumAxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_shovel", new VibraniumShovel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_hoe", new VibraniumHoe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_sword", new VibraniumSword());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_paxel", new VibraniumPaxel());
	        
	        // adamantium
		    AdamantiumArmorSet.registerArmor();
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_pickaxe", new AdamantiumPickaxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_axe", new AdamantiumAxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_shovel", new AdamantiumShovel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_hoe", new AdamantiumHoe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_sword", new AdamantiumSword());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_paxel", new AdamantiumPaxel());
	        
	        // netherbrick
	        NetherArmorSet.registerArmor();
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_pickaxe", new NetherPickaxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_axe", new NetherAxe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_shovel", new NetherShovel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_hoe", new NetherHoe());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_sword", new NetherSword());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_paxel", new NetherPaxel());
	        
	        // vanilla
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":wooden_paxel", new WoodenPaxel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":stone_paxel", new StonePaxel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":iron_paxel", new IronPaxel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":golden_paxel", new GoldenPaxel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":diamond_paxel", new DiamondPaxel());
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":netherite_paxel", new NetheritePaxel());
	        
	        // oneshotium [unobtainable in survival]
	        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":oneshotium_sword", new OneshotiumSword());
	    }
	}
