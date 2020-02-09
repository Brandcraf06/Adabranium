package com.brand.adabraniummod.stuff.nether.base;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class NetherBaseArmor extends ArmorItem
{
    
    public NetherBaseArmor(ArmorMaterial armorMaterial_1, EquipmentSlot equipmentSlot_1)
    {
        super(armorMaterial_1, equipmentSlot_1, new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP));
   
    }
}