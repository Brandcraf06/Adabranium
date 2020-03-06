package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class NetherArmorSet
{
    public static void registerArmor()
    {
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_helmet", new ArmorItem(FullStuffs.materialNetherArmor, EquipmentSlot.HEAD, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_chestplate", new ArmorItem(FullStuffs.materialNetherArmor, EquipmentSlot.CHEST, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_leggings", new ArmorItem(FullStuffs.materialNetherArmor, EquipmentSlot.LEGS, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_boots", new ArmorItem(FullStuffs.materialNetherArmor, EquipmentSlot.FEET, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
    }
}
