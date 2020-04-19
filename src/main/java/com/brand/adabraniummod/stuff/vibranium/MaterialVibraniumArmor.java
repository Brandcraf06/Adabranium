package com.brand.adabraniummod.stuff.vibranium;

import com.brand.adabraniummod.items.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MaterialVibraniumArmor implements ArmorMaterial
{
    private static final int[] BASE_DURABILITY = new int[]{8, 10, 10, 7};
    private static final int[] PROTECTION_AMOUNTS =  {
            5,
            8,
            10,
            5
    };

    @Override
    public int getDurability(EquipmentSlot equipmentSlot)
    {
        return BASE_DURABILITY[equipmentSlot.getEntitySlotId()] * 850;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot equipmentSlot)
    {
        return PROTECTION_AMOUNTS[equipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability()
    {
        return 12;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
    }

    @Override
    public String getName()
    {
        return "vibranium";
    }

    @Override
    public float getToughness()
    {
        return 3;
	}
}