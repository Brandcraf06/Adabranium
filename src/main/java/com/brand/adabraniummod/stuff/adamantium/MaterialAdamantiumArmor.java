package com.brand.adabraniummod.stuff.adamantium;

import com.brand.adabraniummod.items.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MaterialAdamantiumArmor implements ArmorMaterial
{
    private static final int[] BASE_DURABILITY = new int[]{8, 10, 10, 7};
    private static final int[] PROTECTION_AMOUNTS =  {
            7,
            10,
            12,
            7
    };

    @Override
    public int getDurability(EquipmentSlot equipmentSlot)
    {
        return BASE_DURABILITY[equipmentSlot.getEntitySlotId()] * 5000;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot equipmentSlot)
    {
        return PROTECTION_AMOUNTS[equipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability()
    {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }

    @Override
    public String getName()
    {
        return "adamantium";
    }

    @Override
    public float getToughness()
    {
        return 5;
	}
}
