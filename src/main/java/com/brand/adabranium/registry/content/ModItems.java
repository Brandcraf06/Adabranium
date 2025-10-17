package com.brand.adabranium.registry.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.items.HeartShapedHerbItem;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import com.brand.adabranium.registry.stuff.materials.AdabraniumArmorMaterials;
import com.brand.adabranium.registry.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModItems {

    public static final Text VIBRANIUM_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Adabranium.id("vibranium_upgrade"))).formatted(Formatting.GRAY);
    public static final Text VIBRANIUM_UPGRADE_APPLIES_TO_TEXT = templateText("vibranium_upgrade", "applies_to", Formatting.BLUE);
    public static final Text VIBRANIUM_UPGRADE_INGREDIENTS_TEXT = templateText("vibranium_upgrade", "ingredients", Formatting.BLUE);
    public static final Text VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = templateText("vibranium_upgrade", "base_slot_description");
    public static final Text VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = templateText("vibranium_upgrade", "additions_slot_description");
    public static final Text ADAMANTIUM_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Adabranium.id("adamantium_upgrade"))).formatted(Formatting.GRAY);
    public static final Text ADAMANTIUM_UPGRADE_APPLIES_TO_TEXT = templateText("adamantium_upgrade", "applies_to", Formatting.BLUE);
    public static final Text ADAMANTIUM_UPGRADE_INGREDIENTS_TEXT = templateText("adamantium_upgrade", "ingredients", Formatting.BLUE);
    public static final Text ADAMANTIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = templateText("adamantium_upgrade", "base_slot_description");
    public static final Text ADAMANTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = templateText("adamantium_upgrade", "additions_slot_description");
    public static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_helmet");
    public static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
    public static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_leggings");
    public static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_boots");
    public static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("item/empty_slot_hoe");
    public static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_axe");
    public static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("item/empty_slot_sword");
    public static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("item/empty_slot_shovel");
    public static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_pickaxe");
    public static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("item/empty_slot_ingot");

    // materials
    public static final Item VIBRANIUM = register("vibranium", new Item(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item(new Item.Settings().maxCount(64)));
    public static final Item ADAMANTIUM = register("adamantium", new Item(new Item.Settings().maxCount(64)));
    public static final Item ADAMANTIUM_INGOT = register("adamantium_ingot", new Item(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_DUST = register("vibranium_dust", new Item(new Item.Settings().maxCount(64)));

    // stuffs
    public static final FullStuffs VIBRANIUM_STUFF = new FullStuffs("vibranium",
            49, AdabraniumArmorMaterials.VIBRANIUM, AdabraniumToolMaterials.VIBRANIUM,
            5.0F, -3.0F,
            -6, -0.0F,
            false);

    public static final FullStuffs ADAMANTIUM_STUFF = new FullStuffs("adamantium",
            56, AdabraniumArmorMaterials.ADAMANTIUM, AdabraniumToolMaterials.ADAMANTIUM,
            5.0F, -3.0F,
            -8, -0.0F,
            false);

    public static final FullStuffs NETHER_STUFF = new FullStuffs("nether",
            22, AdabraniumArmorMaterials.NETHER_BRICK, AdabraniumToolMaterials.NETHER_BRICK,
            6.0F, -3.1F,
            -2, -1.0F,
            true);

    public static final Item ONESHOTIUM_SWORD = register("oneshotium_sword", new SwordItem(AdabraniumToolMaterials.ONESHOTIUM, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(AdabraniumToolMaterials.ONESHOTIUM, 0, 0.0F))));

    // templates
    public static final Item VIBRANIUM_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate("vibranium_upgrade_smithing_template", VIBRANIUM_UPGRADE_APPLIES_TO_TEXT, VIBRANIUM_UPGRADE_INGREDIENTS_TEXT, VIBRANIUM_UPGRADE_TEXT, VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT);
    public static final Item ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate("adamantium_upgrade_smithing_template", ADAMANTIUM_UPGRADE_APPLIES_TO_TEXT, ADAMANTIUM_UPGRADE_INGREDIENTS_TEXT, ADAMANTIUM_UPGRADE_TEXT, ADAMANTIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, ADAMANTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT);

    // potions
    public static final RegistryEntry<Potion> TOUGHNESS = register("toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0)));
    public static final RegistryEntry<Potion> LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0)));
    public static final RegistryEntry<Potion> STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1)));

    // other
    public static final Item HEART_SHAPED_HERB = register("heart_shaped_herb", new HeartShapedHerbItem(new Item.Settings().maxCount(64)));
    public static final Item VIBRANIUM_SOUP = register("vibranium_soup", new Item(new Item.Settings().maxCount(1).food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.6F).usingConvertsTo(Items.BOWL)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 1), 1.0F).alwaysEdible().build())));

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Adabranium.MOD_ID, id), item);
    }

    public static RegistryEntry<Potion> register(String id, Potion potion) {
        return Registry.registerReference(Registries.POTION, Adabranium.id(id), potion);
    }

    public static Text templateText(String templateName, String suffix, Formatting formatting) {
        return Text.translatable(Util.createTranslationKey("item", Adabranium.id("smithing_template." + templateName + "." + suffix))).formatted(formatting);
    }

    public static Text templateText(String templateName, String suffix) {
        return Text.translatable(Util.createTranslationKey("item", Adabranium.id("smithing_template." + templateName + "." + suffix)));
    }

    public static List<Identifier> getNetheriteUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    public static List<Identifier> getNetheriteUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public static Item registerSmithingTemplate(String id, Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText) {
        return register(id, new SmithingTemplateItem(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, getNetheriteUpgradeEmptyBaseSlotTextures(), getNetheriteUpgradeEmptyAdditionsSlotTextures()));
    }
}
