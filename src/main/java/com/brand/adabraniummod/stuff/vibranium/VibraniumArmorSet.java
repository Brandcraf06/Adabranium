package com.brand.adabraniummod.stuff.vibranium;


import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;
import com.brand.adabraniummod.stuff.base.BaseArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class VibraniumArmorSet
{
    public static void registerArmor()
    {
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_helmet", new BaseArmor(FullStuffs.materialVibraniumArmor, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_chestplate", new BaseArmor(FullStuffs.materialVibraniumArmor, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_leggings", new BaseArmor(FullStuffs.materialVibraniumArmor, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":vibranium_boots", new BaseArmor(FullStuffs.materialVibraniumArmor, EquipmentSlot.FEET));
    }
}
