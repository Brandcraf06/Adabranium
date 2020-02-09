package com.brand.adabraniummod.stuff.nether;

import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;
import com.brand.adabraniummod.stuff.nether.base.NetherBaseArmor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class NetherArmorSet
{
    public static void registerArmor()
    {
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_helmet", new NetherBaseArmor(FullStuffs.materialNetherArmor, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_chestplate", new NetherBaseArmor(FullStuffs.materialNetherArmor, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_leggings", new NetherBaseArmor(FullStuffs.materialNetherArmor, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":nether_boots", new NetherBaseArmor(FullStuffs.materialNetherArmor, EquipmentSlot.FEET));
    }
}
