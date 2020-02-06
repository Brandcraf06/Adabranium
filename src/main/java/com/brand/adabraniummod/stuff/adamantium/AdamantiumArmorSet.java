package com.brand.adabraniummod.stuff.adamantium;


import com.brand.adabraniummod.AdabraniumMod;
import com.brand.adabraniummod.stuff.FullStuffs;
import com.brand.adabraniummod.stuff.base.BaseArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.registry.Registry;

public class AdamantiumArmorSet
{
    public static void registerArmor()
    {
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_helmet", new BaseArmor(FullStuffs.materialAdamantiumArmor, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_chestplate", new BaseArmor(FullStuffs.materialAdamantiumArmor, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_leggings", new BaseArmor(FullStuffs.materialAdamantiumArmor, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, AdabraniumMod.MOD_ID + ":adamantium_boots", new BaseArmor(FullStuffs.materialAdamantiumArmor, EquipmentSlot.FEET));
    }
}
