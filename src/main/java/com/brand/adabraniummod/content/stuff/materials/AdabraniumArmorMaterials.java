package com.brand.adabraniummod.content.stuff.materials;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.content.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum AdabraniumArmorMaterials implements ArmorMaterial {
    VIBRANIUM("vibranium", Adabranium.CONFIG.vibraniumArmorDurabilityMultiplier, new int[]{5, 8, 10, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> {
        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
    }),
    ADAMANTIUM("adamantium", Adabranium.CONFIG.adamantiumArmorDurabilityMultiplier, new int[]{7, 10, 12, 7}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, 0.1F, () -> {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }),
    NETHER_BRICK("nether", Adabranium.CONFIG.netherArmorDurabilityMultiplier, new int[]{2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    });
    private final String name;
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    AdabraniumArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}