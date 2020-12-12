package com.brand.adabraniummod.content.stuff.materials;

import com.brand.adabraniummod.Adabranium;
import com.brand.adabraniummod.content.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum AdabraniumToolMaterials implements ToolMaterial {
    VIBRANIUM(4, Adabranium.CONFIG.vibraniumToolDurability, Adabranium.CONFIG.vibraniumToolMiningSpeed, Adabranium.CONFIG.vibraniumToolAttackDamage, Adabranium.CONFIG.vibraniumToolEnchantability, () -> {
        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
    }),
    ADAMANTIUM(4, Adabranium.CONFIG.adamantiumToolDurability, Adabranium.CONFIG.adamantiumToolMiningSpeed, Adabranium.CONFIG.adamantiumToolAttackDamage, Adabranium.CONFIG.adamantiumToolEnchantability, () -> {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }),
    NETHER_BRICK(2, Adabranium.CONFIG.netherToolDurability, Adabranium.CONFIG.netherToolMiningSpeed, Adabranium.CONFIG.netherToolAttackDamage, Adabranium.CONFIG.netherToolEnchantability, () -> {
        return Ingredient.ofItems(Items.NETHER_BRICK);
    }),
    ONESHOTIUM(3, 1000000, 23.0F, 999999.0F, 100, () -> {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    });
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    AdabraniumToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

