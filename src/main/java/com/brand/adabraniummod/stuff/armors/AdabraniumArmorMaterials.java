package com.brand.adabraniummod.stuff.armors;

import java.util.function.Supplier;

import com.brand.adabraniummod.items.ModItems;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum AdabraniumArmorMaterials implements ArmorMaterial {
	   VIBRANIUM("vibranium", new int[]{8, 10, 10, 7}, 299, new int[]{5, 8, 10, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F, 0.0F, () -> {
	        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
	    }),
	   ADAMANTIUM("adamantium", new int[]{8, 10, 10, 7}, 428, new int[]{7, 10, 12, 7}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F, 0.1F, () -> {
		   return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
	   }),
	   NETHER_BRICK("nether", new int[]{13, 15, 16, 11}, 20, new int[]{2, 5, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F, 0.0F, () -> {
		   return Ingredient.ofItems(Items.NETHER_BRICK);
	   });
	   private final String name;
	   private final int[] baseDurability;
	   private final int durabilityMultiplier;
	   private final int[] protectionAmounts;
	   private final int enchantability;
	   private final SoundEvent equipSound;
	   private final float toughness;
	   private final float knockbackResistance;
	   private final Lazy<Ingredient> repairIngredientSupplier;

	   private AdabraniumArmorMaterials(String name, int[] baseDurability, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
	      this.name = name;
	      this.baseDurability = baseDurability;
	      this.durabilityMultiplier = durabilityMultiplier;
	      this.protectionAmounts = protectionAmounts;
	      this.enchantability = enchantability;
	      this.equipSound = equipSound;
	      this.toughness = toughness;
	      this.knockbackResistance = knockbackResistance;
	      this.repairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
	   }

	   public int getDurability(EquipmentSlot slot) {
	      return this.baseDurability[slot.getEntitySlotId()] * this.durabilityMultiplier;
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
	        return (Ingredient)this.repairIngredientSupplier.get();
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