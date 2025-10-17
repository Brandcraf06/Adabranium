package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.registry.content.ModItems;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.Objects;
import java.util.function.Supplier;

public enum AdabraniumToolMaterials implements ToolMaterial {
    VIBRANIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2701, 11.0F, 6.0F, 12, () -> Ingredient.ofItems(ModItems.VIBRANIUM_INGOT)),
    ADAMANTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3346, 14.0F, 8.0F, 10, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT)),
    NETHER_BRICK(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 9.0F, 2.0F, 15, () -> Ingredient.ofItems(Items.NETHER_BRICK)),
    ONESHOTIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000000, 23.0F, 999999.0F, 100, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    AdabraniumToolMaterials(final TagKey<Block> inverseTag, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantability, final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        Objects.requireNonNull(repairIngredient);
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
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

    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}

