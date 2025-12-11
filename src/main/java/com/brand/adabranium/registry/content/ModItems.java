package com.brand.adabranium.registry.content;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.items.HeartShapedHerbItem;
import com.brand.adabranium.registry.stuff.equipment.AdabraniumEquipmentAssetKeys;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import com.brand.adabranium.registry.stuff.materials.AdabraniumArmorMaterials;
import com.brand.adabranium.registry.stuff.materials.AdabraniumToolMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;
import java.util.function.Function;

public class ModItems {

    public static final Component VIBRANIUM_UPGRADE_APPLIES_TO_TEXT = templateText("vibranium_upgrade", "applies_to", ChatFormatting.BLUE);
    public static final Component VIBRANIUM_UPGRADE_INGREDIENTS_TEXT = templateText("vibranium_upgrade", "ingredients", ChatFormatting.BLUE);
    public static final Component VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = templateText("vibranium_upgrade", "base_slot_description");
    public static final Component VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = templateText("vibranium_upgrade", "additions_slot_description");
    public static final Component ADAMANTIUM_UPGRADE_APPLIES_TO_TEXT = templateText("adamantium_upgrade", "applies_to", ChatFormatting.BLUE);
    public static final Component ADAMANTIUM_UPGRADE_INGREDIENTS_TEXT = templateText("adamantium_upgrade", "ingredients", ChatFormatting.BLUE);
    public static final Component ADAMANTIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = templateText("adamantium_upgrade", "base_slot_description");
    public static final Component ADAMANTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = templateText("adamantium_upgrade", "additions_slot_description");
    public static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.withDefaultNamespace("container/slot/helmet");
    public static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.withDefaultNamespace("container/slot/chestplate");
    public static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.withDefaultNamespace("container/slot/leggings");
    public static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.withDefaultNamespace("container/slot/boots");
    public static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.withDefaultNamespace("container/slot/hoe");
    public static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.withDefaultNamespace("container/slot/axe");
    public static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.withDefaultNamespace("container/slot/sword");
    public static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.withDefaultNamespace("container/slot/shovel");
    public static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.withDefaultNamespace("container/slot/pickaxe");
    public static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.withDefaultNamespace("container/slot/ingot");

    // materials
    public static final Item VIBRANIUM = register("vibranium", new Item.Properties().stacksTo(64));
    public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item.Properties().stacksTo(64));
    public static final Item ADAMANTIUM = register("adamantium", new Item.Properties().stacksTo(64));
    public static final Item ADAMANTIUM_INGOT = register("adamantium_ingot", new Item.Properties().stacksTo(64));
    public static final Item VIBRANIUM_DUST = register("vibranium_dust", new Item.Properties().stacksTo(64));

    // stuffs
    public static final FullStuffs VIBRANIUM_STUFF = new FullStuffs("vibranium",
            AdabraniumArmorMaterials.ArmorMaterials.VIBRANIUM, AdabraniumToolMaterials.VIBRANIUM,
            5.0F, -3.0F,
            -6.0F, -0.0F,
            1.25F, 1.325F, 0.4F, 2.0F, 6.5F, 5.0F, 7.5F,
            true, AdabraniumEquipmentAssetKeys.VIBRANIUM);

    public static final FullStuffs ADAMANTIUM_STUFF = new FullStuffs("adamantium",
            AdabraniumArmorMaterials.ArmorMaterials.ADAMANTIUM, AdabraniumToolMaterials.ADAMANTIUM,
            5.0F, -3.0F,
            -8.0F, -0.0F,
            1.35F, 1.45F, 0.3F, 2.0F, 6.25F, 4.85F, 6.25F,
            true, AdabraniumEquipmentAssetKeys.ADAMANTIUM);

    public static final FullStuffs NETHER_STUFF = new FullStuffs("nether",
            AdabraniumArmorMaterials.ArmorMaterials.NETHER_BRICK, AdabraniumToolMaterials.NETHER_BRICK,
            6.0F, -3.1F,
            -2.0F, -1.0F,
            0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 11.25F,
            true, AdabraniumEquipmentAssetKeys.NETHER_BRICK);

    public static final Item ONESHOTIUM_SWORD = register("oneshotium_sword", (new Item.Properties()).sword(AdabraniumToolMaterials.ONESHOTIUM, 0, 0.0F));

    // templates
    public static final Item VIBRANIUM_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate("vibranium_upgrade_smithing_template", VIBRANIUM_UPGRADE_APPLIES_TO_TEXT, VIBRANIUM_UPGRADE_INGREDIENTS_TEXT, VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT);
    public static final Item ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE = registerSmithingTemplate("adamantium_upgrade_smithing_template", ADAMANTIUM_UPGRADE_APPLIES_TO_TEXT, ADAMANTIUM_UPGRADE_INGREDIENTS_TEXT, ADAMANTIUM_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, ADAMANTIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT);

    // potions
    public static final Holder<Potion> TOUGHNESS = register("toughness", new Potion("toughness", new MobEffectInstance(MobEffects.RESISTANCE, 1200, 0)));
    public static final Holder<Potion> LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new MobEffectInstance(MobEffects.RESISTANCE, 1800, 0)));
    public static final Holder<Potion> STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new MobEffectInstance(MobEffects.RESISTANCE, 600, 1)));

    // other
    public static final Item HEART_SHAPED_HERB = register("heart_shaped_herb", HeartShapedHerbItem::new, new Item.Properties().stacksTo(64));
    public static final Item VIBRANIUM_SOUP = register("vibranium_soup", new Item.Properties().stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).alwaysEdible().build(), Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                    new MobEffectInstance(MobEffects.RESISTANCE, 1800, 1),
                    new MobEffectInstance(MobEffects.SPEED, 3000, 1),
                    new MobEffectInstance(MobEffects.STRENGTH, 1200, 1)))).build()).usingConvertsTo(Items.BOWL));

    public static Item register(String id, Function<Item.Properties, Item> factory, Item.Properties settings) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Adabranium.id(id));
        Item item = factory.apply(settings.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static Item register(String id, Item.Properties settings) {
        return register(id, Item::new, settings);
    }

    public static Holder<Potion> register(String id, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, Adabranium.id(id), potion);
    }

    public static Component templateText(String templateName, String suffix, ChatFormatting formatting) {
        return Component.translatable(Util.makeDescriptionId("item", Adabranium.id("smithing_template." + templateName + "." + suffix))).withStyle(formatting);
    }

    public static Component templateText(String templateName, String suffix) {
        return Component.translatable(Util.makeDescriptionId("item", Adabranium.id("smithing_template." + templateName + "." + suffix)));
    }

    public static List<Identifier> getNetheriteUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    public static List<Identifier> getNetheriteUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public static Item registerSmithingTemplate(String id, Component appliesToText, Component ingredientsText, Component baseSlotDescriptionText, Component additionsSlotDescriptionText) {
        return register(id, settings -> new SmithingTemplateItem(appliesToText, ingredientsText, baseSlotDescriptionText, additionsSlotDescriptionText, getNetheriteUpgradeEmptyBaseSlotTextures(), getNetheriteUpgradeEmptyAdditionsSlotTextures(), settings), new Item.Properties().rarity(Rarity.UNCOMMON)
        );
    }
}
