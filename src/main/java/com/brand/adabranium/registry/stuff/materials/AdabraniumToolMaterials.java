package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.component.type.WeaponComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public record AdabraniumToolMaterials(TagKey<Block> incorrectBlocksForDrops, int durability, float speed,
                                      float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
    public static final ToolMaterial VIBRANIUM;
    public static final ToolMaterial ADAMANTIUM;
    public static final ToolMaterial NETHER_BRICK;
    public static final ToolMaterial ONESHOTIUM;

    public AdabraniumToolMaterials(TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairItems = repairItems;
    }

    private Item.Settings applyBaseSettings(Item.Settings settings) {
        return settings.maxDamage(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Settings applyToolSettings(Item.Settings settings, TagKey<Block> effectiveBlocks, float attackDamage, float attackSpeed, float disableBlockingForSeconds) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return this.applyBaseSettings(settings).component(DataComponentTypes.TOOL, new ToolComponent(List.of(ToolComponent.Rule.ofNeverDropping(registryEntryLookup.getOrThrow(this.incorrectBlocksForDrops)), ToolComponent.Rule.ofAlwaysDropping(registryEntryLookup.getOrThrow(effectiveBlocks), this.speed)), 1.0F, 1, true)).attributeModifiers(this.createToolAttributeModifiers(attackDamage, attackSpeed)).component(DataComponentTypes.WEAPON, new WeaponComponent(2, disableBlockingForSeconds));
    }

    private AttributeModifiersComponent createToolAttributeModifiers(float attackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, attackDamage + this.attackDamageBonus, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public Item.Settings applySwordSettings(Item.Settings settings, float attackDamage, float attackSpeed) {
        RegistryEntryLookup<Block> registryEntryLookup = Registries.createEntryLookup(Registries.BLOCK);
        return this.applyBaseSettings(settings).component(DataComponentTypes.TOOL, new ToolComponent(List.of(ToolComponent.Rule.ofAlwaysDropping(RegistryEntryList.of(Blocks.COBWEB.getRegistryEntry()), 15.0F), ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_INSTANTLY_MINES), Float.MAX_VALUE), ToolComponent.Rule.of(registryEntryLookup.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)), 1.0F, 2, false)).attributeModifiers(this.createSwordAttributeModifiers(attackDamage, attackSpeed)).component(DataComponentTypes.WEAPON, new WeaponComponent(1));
    }

    private AttributeModifiersComponent createSwordAttributeModifiers(float attackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder().add(EntityAttributes.ATTACK_DAMAGE, new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, attackDamage + this.attackDamageBonus, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.ATTACK_SPEED, new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }

    public TagKey<Block> incorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int durability() {
        return this.durability;
    }

    public float speed() {
        return this.speed;
    }

    public float attackDamageBonus() {
        return this.attackDamageBonus;
    }

    public int enchantmentValue() {
        return this.enchantmentValue;
    }

    public TagKey<Item> repairItems() {
        return this.repairItems;
    }

    static {
        VIBRANIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2701, 11.0F, 6.0F, 12, AdabraniumItemTags.VIBRANIUM_MATERIALS);
        ADAMANTIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3046, 14.0F, 8.0F, 10, AdabraniumItemTags.ADAMANTIUM_MATERIALS);
        NETHER_BRICK = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 381, 9.0F, 2.0F, 15, AdabraniumItemTags.NETHER_BRICK_MATERIALS);
        ONESHOTIUM = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000000, 23.0F, 999999.0F, 100, AdabraniumItemTags.ADAMANTIUM_MATERIALS);
    }
}

