package com.brand.adabranium.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.content.base.HeartShapedHerbItem;
import com.brand.adabranium.content.stuff.base.BaseSword;
import com.brand.adabranium.content.stuff.full.FullStuffs;
import com.brand.adabranium.content.stuff.materials.AdabraniumArmorMaterials;
import com.brand.adabranium.content.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // materials
    public static final Item VIBRANIUM = register("vibranium", new Item(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item(new Item.Settings().maxCount(64)));
    public static final Item ADAMANTIUM = register("adamantium", new Item(new Item.Settings().maxCount(64)));
    public static final Item ADAMANTIUM_INGOT = register("adamantium_ingot", new Item(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_DUST = register("vibranium_dust", new Item(new Item.Settings().maxCount(64)));

    // stuffs
    public static final FullStuffs VIBRANIUM_STUFF = new FullStuffs("vibranium",
            AdabraniumArmorMaterials.VIBRANIUM, AdabraniumToolMaterials.VIBRANIUM,
            5.0F, -3.0F,
            -6, -0.0F,
            false);

    public static final FullStuffs ADAMANTIUM_STUFF = new FullStuffs("adamantium",
            AdabraniumArmorMaterials.ADAMANTIUM, AdabraniumToolMaterials.ADAMANTIUM,
            5.0F, -3.0F,
            -9, -0.0F,
            false);

    public static final FullStuffs NETHER_STUFF = new FullStuffs("nether",
            AdabraniumArmorMaterials.NETHER_BRICK, AdabraniumToolMaterials.NETHER_BRICK,
            6.0F, -3.1F,
            -2, -1.0F,
            true);

    public static final Item ONESHOTIUM_SWORD = register("oneshotium_sword", new BaseSword(AdabraniumToolMaterials.ONESHOTIUM, 0, 0.0f, new Item.Settings()));


    // rods
    public static final Item OBSIDIAN_ROD = register("obsidian_rod", new Item(new Item.Settings().maxCount(64)));
    public static final Item ADAMANTIUM_ROD = register("adamantium_rod", new Item(new Item.Settings().maxCount(64)));

    // potions
    public static final Potion TOUGHNESS = register("toughness", new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0)));
    public static final Potion LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0)));
    public static final Potion STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1)));

    // other
    public static final Item HEART_SHAPED_HERB = register("heart_shaped_herb", new HeartShapedHerbItem(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_SOUP = register("vibranium_soup", new StewItem(new Item.Settings().maxCount(1).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.6F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 1, true, false, true), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3000, 1, true, false, true), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 1, true, false, true), 1.0F).alwaysEdible().build())));


    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Adabranium.MOD_ID, id), item);
    }

    private static Potion register(String id, Potion potion) {
        return Registry.register(Registries.POTION, id, potion);
    }
}
