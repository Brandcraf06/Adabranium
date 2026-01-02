package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.ConsumeItemTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdabraniumAdvancementProvider extends FabricAdvancementProvider {
    public final HolderLookup.Provider registryLookup;

    public AdabraniumAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        ModItems.VIBRANIUM,
                        title("root"), description("root"), background("adv_background"),
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("netherite_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_PICKAXE))
                .save(consumer, Adabranium.MOD_ID + "/root");

        AdvancementHolder vibraniumIngot = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModItems.VIBRANIUM_INGOT,
                        title("wakanda_forever"), description("wakanda_forever"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("vibranium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_INGOT))
                .save(consumer, Adabranium.MOD_ID + "/wakanda_forever");

        AdvancementHolder vibraniumPickaxe = Advancement.Builder.advancement()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_STUFF.pickaxe(),
                        title("vibranium_pickaxe"), description("vibranium_pickaxe"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("vibranium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_STUFF.pickaxe()))
                .save(consumer, Adabranium.MOD_ID + "/vibranium_pickaxe");

        AdvancementHolder adamantiumIngot = Advancement.Builder.advancement()
                .parent(vibraniumIngot)
                .display(
                        ModItems.ADAMANTIUM_INGOT,
                        title("adamantium_ingot"), description("adamantium_ingot"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("adamantium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_INGOT))
                .save(consumer, Adabranium.MOD_ID + "/adamantium_ingot");

        AdvancementHolder vibraniumArmor = Advancement.Builder.advancement()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_STUFF.chestplate(),
                        title("purple_panther"), description("purple_panther"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("vibranium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_STUFF.helmet()))
                .addCriterion("vibranium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_STUFF.chestplate()))
                .addCriterion("vibranium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_STUFF.leggings()))
                .addCriterion("vibranium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_STUFF.boots()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(consumer, Adabranium.MOD_ID + "/purple_panther");

        AdvancementHolder vibraniumSoup = Advancement.Builder.advancement()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_SOUP,
                        title("panther_powers"), description("panther_powers"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("vibranium_soup", ConsumeItemTrigger.TriggerInstance.usedItem(BuiltInRegistries.ITEM, ModItems.VIBRANIUM_SOUP))
                .save(consumer, Adabranium.MOD_ID + "/panther_powers");

        AdvancementHolder adamantiumPickaxe = Advancement.Builder.advancement()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.pickaxe(),
                        title("adamantium_pickaxe"), description("adamantium_pickaxe"), null,
                        AdvancementType.TASK, true, true, false
                )
                .addCriterion("adamantium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.pickaxe()))
                .save(consumer, Adabranium.MOD_ID + "/adamantium_pickaxe");

        AdvancementHolder adamantiumArmor = Advancement.Builder.advancement()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.chestplate(),
                        title("adamantium_armor"), description("adamantium_armor"), null,
                        AdvancementType.CHALLENGE, true, true, false
                )
                .addCriterion("adamantium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.helmet()))
                .addCriterion("adamantium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.chestplate()))
                .addCriterion("adamantium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.leggings()))
                .addCriterion("adamantium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.boots()))
                .rewards(AdvancementRewards.Builder.experience(60))
                .save(consumer, Adabranium.MOD_ID + "/adamantium_armor");

        AdvancementHolder premiumHoe = Advancement.Builder.advancement()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.hoe(),
                        title("premium_hoe"), description("premium_hoe"), null,
                        AdvancementType.CHALLENGE, true, true, true
                )
                .addCriterion("adamantium_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ADAMANTIUM_STUFF.hoe()))
                .rewards(AdvancementRewards.Builder.experience(15))
                .save(consumer, Adabranium.MOD_ID + "/premium_hoe");

    }

    private Identifier background(String name) {
        return Adabranium.id(name);
    }

    public Component title(String name) {
        return Component.translatable("advancements.adabranium." + name + ".title");
    }

    public Component description(String name) {
        return Component.translatable("advancements.adabranium." + name + ".description");
    }
}
