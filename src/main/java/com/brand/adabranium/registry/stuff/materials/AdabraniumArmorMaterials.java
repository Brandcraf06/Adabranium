package com.brand.adabranium.registry.stuff.materials;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class AdabraniumArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> VIBRANIUM;
    public static final RegistryEntry<ArmorMaterial> ADAMANTIUM;
    public static final RegistryEntry<ArmorMaterial> NETHER_BRICK;

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Adabranium.id(id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(String id, EnumMap<ArmorItem.Type, Integer> defense, int enchantability, RegistryEntry<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for(ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }

        return Registry.registerReference(Registries.ARMOR_MATERIAL, Adabranium.id(id), new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance));
    }

    static {
        VIBRANIUM = register("vibranium", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 5);
            map.put(ArmorItem.Type.LEGGINGS, 8);
            map.put(ArmorItem.Type.CHESTPLATE, 10);
            map.put(ArmorItem.Type.HELMET, 5);
            map.put(ArmorItem.Type.BODY, 11);
        }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(ModItems.VIBRANIUM_INGOT));
        ADAMANTIUM = register("adamantium", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 6);
            map.put(ArmorItem.Type.LEGGINGS, 10);
            map.put(ArmorItem.Type.CHESTPLATE, 12);
            map.put(ArmorItem.Type.HELMET, 6);
            map.put(ArmorItem.Type.BODY, 11);
        }), 12, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT));
        NETHER_BRICK = register("nether", Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            map.put(ArmorItem.Type.BOOTS, 2);
            map.put(ArmorItem.Type.LEGGINGS, 5);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.BODY, 5);
        }), 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.NETHER_BRICK));
    }
}