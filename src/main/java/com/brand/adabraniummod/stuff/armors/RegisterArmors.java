package com.brand.adabraniummod.stuff.armors;

import com.brand.adabraniummod.AdabraniumMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterArmors {
    // vibranium
    public static final Item VIBRANIUM_HELMET = new ArmorItem(AdabraniumArmorMaterials.VIBRANIUM, EquipmentSlot.HEAD, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item VIBRANIUM_CHESTPLATE = new ArmorItem(AdabraniumArmorMaterials.VIBRANIUM, EquipmentSlot.CHEST, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item VIBRANIUM_LEGGINGS = new ArmorItem(AdabraniumArmorMaterials.VIBRANIUM, EquipmentSlot.LEGS, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item VIBRANIUM_BOOTS = new ArmorItem(AdabraniumArmorMaterials.VIBRANIUM, EquipmentSlot.FEET, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));

    // adamantium
    public static final Item ADAMANTIUM_HELMET = new ArmorItem(AdabraniumArmorMaterials.ADAMANTIUM, EquipmentSlot.HEAD, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item ADAMANTIUM_CHESTPLATE = new ArmorItem(AdabraniumArmorMaterials.ADAMANTIUM, EquipmentSlot.CHEST, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item ADAMANTIUM_LEGGINGS = new ArmorItem(AdabraniumArmorMaterials.ADAMANTIUM, EquipmentSlot.LEGS, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));
    public static final Item ADAMANTIUM_BOOTS = new ArmorItem(AdabraniumArmorMaterials.ADAMANTIUM, EquipmentSlot.FEET, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP)));

    // nether
    public static final Item NETHER_HELMET = new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.HEAD, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
    public static final Item NETHER_CHESTPLATE = new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.CHEST, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
    public static final Item NETHER_LEGGINGS = new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.LEGS, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));
    public static final Item NETHER_BOOTS = new ArmorItem(AdabraniumArmorMaterials.NETHER_BRICK, EquipmentSlot.FEET, (new Item.Settings().group(AdabraniumMod.ADABRANIUM_GROUP).fireproof()));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "vibranium_helmet"), VIBRANIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "vibranium_chestplate"), VIBRANIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "vibranium_leggings"), VIBRANIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "vibranium_boots"), VIBRANIUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "adamantium_helmet"), ADAMANTIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "adamantium_chestplate"), ADAMANTIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "adamantium_leggings"), ADAMANTIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "adamantium_boots"), ADAMANTIUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "nether_helmet"), NETHER_HELMET);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "nether_chestplate"), NETHER_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "nether_leggings"), NETHER_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("adabraniummod", "nether_boots"), NETHER_BOOTS);

    }
}
