package com.brand.adabraniummod.items;

import com.brand.adabraniummod.AdabraniumMod;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	// rods
	public static final Item OBSIDIAN_ROD = register("obsidian_rod", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
	public static final Item ADAMANTIUM_ROD = register("adamantium_rod", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));	
	
	// materials
	public static final Item VIBRANIUM = register("vibranium", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
	public static final Item ADAMANTINE = register("adamantine", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
	
	// ingots
	public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
	public static final Item ADAMANTIUM_INGOT = register("adamantium_ingot", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));
	
	// dusts
	public static final Item VIBRANIUM_DUST = register("vibranium_dust", new Item(new Item.Settings().maxCount(64).group(AdabraniumMod.ADABRANIUM_GROUP)));

	public static Item register(String name, Item item) {
	    return Registry.register(Registry.ITEM, new Identifier(AdabraniumMod.MOD_ID, name), item);
	}
}
