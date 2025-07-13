package com.brand.adabranium.registry.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.items.HeartShapedHerbItem;
import com.brand.adabranium.registry.stuff.equipment.AdaEquipmentAssetKeys;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import com.brand.adabranium.registry.stuff.materials.AdabraniumArmorMaterials;
import com.brand.adabranium.registry.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {

    // materials
    public static final Item VIBRANIUM = register("vibranium", new Item.Settings().maxCount(64));
    public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item.Settings().maxCount(64));
    public static final Item ADAMANTIUM = register("adamantium", new Item.Settings().maxCount(64));
    public static final Item ADAMANTIUM_INGOT = register("adamantium_ingot", new Item.Settings().maxCount(64));
    public static final Item VIBRANIUM_DUST = register("vibranium_dust", new Item.Settings().maxCount(64));

    // stuffs
    public static final FullStuffs VIBRANIUM_STUFF = new FullStuffs("vibranium",
            AdabraniumArmorMaterials.ArmorMaterials.VIBRANIUM, AdabraniumToolMaterials.VIBRANIUM,
            5.0F, -3.0F,
            -6, -0.0F,
            true, AdaEquipmentAssetKeys.VIBRANIUM);

    public static final FullStuffs ADAMANTIUM_STUFF = new FullStuffs("adamantium",
            AdabraniumArmorMaterials.ArmorMaterials.ADAMANTIUM, AdabraniumToolMaterials.ADAMANTIUM,
            5.0F, -3.0F,
            -8, -0.0F,
            true, AdaEquipmentAssetKeys.ADAMANTIUM);

    public static final FullStuffs NETHER_STUFF = new FullStuffs("nether",
            AdabraniumArmorMaterials.ArmorMaterials.NETHER_BRICK, AdabraniumToolMaterials.NETHER_BRICK,
            6.0F, -3.1F,
            -2, -1.0F,
            true, AdaEquipmentAssetKeys.NETHER_BRICK);

    public static final Item ONESHOTIUM_SWORD = register("oneshotium_sword", (new Item.Settings()).sword(AdabraniumToolMaterials.ONESHOTIUM, 0, 0.0F));

    // rods
    public static final Item OBSIDIAN_ROD = register("obsidian_rod", new Item.Settings().maxCount(64));

    // potions
    public static final RegistryEntry<Potion> TOUGHNESS = register("toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0)));
    public static final RegistryEntry<Potion> LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0)));
    public static final RegistryEntry<Potion> STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1)));

    // other
    public static final Item HEART_SHAPED_HERB = register("heart_shaped_herb", HeartShapedHerbItem::new, new Item.Settings().maxCount(64));
    public static final Item VIBRANIUM_SOUP = register("vibranium_soup", new Item.Settings().maxCount(1).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).alwaysEdible().build(), ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                    new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 1),
                    new StatusEffectInstance(StatusEffects.SPEED, 3000, 1),
                    new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 1)))).build()).useRemainder(Items.BOWL));

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Adabranium.id(id));
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static Item register(String id, Item.Settings settings) {
        return register(id, Item::new, settings);
    }

    public static RegistryEntry<Potion> register(String id, Potion potion) {
        return Registry.registerReference(Registries.POTION, Adabranium.id(id), potion);
    }
}
