package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdabraniumAdvancementProvider extends FabricAdvancementProvider {
    public final RegistryWrapper.WrapperLookup registryLookup;

    public AdabraniumAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
        this.registryLookup = registryLookup.join();
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = Advancement.Builder.create()
                .display(
                        ModItems.VIBRANIUM,
                        title("root"), description("root"), background("adv_background"),
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("netherite_pickaxe", InventoryChangedCriterion.Conditions.items(Items.NETHERITE_PICKAXE))
                .build(consumer, Adabranium.MOD_ID + "/root");

        AdvancementEntry vibraniumIngot = Advancement.Builder.create()
                .parent(root)
                .display(
                        ModItems.VIBRANIUM_INGOT,
                        title("wakanda_forever"), description("wakanda_forever"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("vibranium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_INGOT))
                .build(consumer, Adabranium.MOD_ID + "/wakanda_forever");

        AdvancementEntry vibraniumPickaxe = Advancement.Builder.create()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_STUFF.pickaxe,
                        title("vibranium_pickaxe"), description("vibranium_pickaxe"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("vibranium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_STUFF.pickaxe))
                .build(consumer, Adabranium.MOD_ID + "/vibranium_pickaxe");

        AdvancementEntry adamantiumIngot = Advancement.Builder.create()
                .parent(vibraniumIngot)
                .display(
                        ModItems.ADAMANTIUM_INGOT,
                        title("adamantium_ingot"), description("adamantium_ingot"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("adamantium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_INGOT))
                .build(consumer, Adabranium.MOD_ID + "/adamantium_ingot");

        AdvancementEntry vibraniumArmor = Advancement.Builder.create()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_STUFF.chestplate,
                        title("purple_panther"), description("purple_panther"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("vibranium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_STUFF.helmet))
                .criterion("vibranium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_STUFF.chestplate))
                .criterion("vibranium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_STUFF.leggings))
                .criterion("vibranium_boots", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_STUFF.boots))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)
                .build(consumer, Adabranium.MOD_ID + "/purple_panther");

        AdvancementEntry vibraniumSoup = Advancement.Builder.create()
                .parent(vibraniumIngot)
                .display(
                        ModItems.VIBRANIUM_SOUP,
                        title("panther_powers"), description("panther_powers"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("vibranium_soup", ConsumeItemCriterion.Conditions.item(ModItems.VIBRANIUM_SOUP))
                .build(consumer, Adabranium.MOD_ID + "/panther_powers");

        AdvancementEntry adamantiumPickaxe = Advancement.Builder.create()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.pickaxe,
                        title("adamantium_pickaxe"), description("adamantium_pickaxe"), null,
                        AdvancementFrame.TASK, true, true, false
                )
                .criterion("adamantium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.pickaxe))
                .build(consumer, Adabranium.MOD_ID + "/adamantium_pickaxe");

        AdvancementEntry adamantiumArmor = Advancement.Builder.create()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.chestplate,
                        title("adamantium_armor"), description("adamantium_armor"), null,
                        AdvancementFrame.CHALLENGE, true, true, false
                )
                .criterion("adamantium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.helmet))
                .criterion("adamantium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.chestplate))
                .criterion("adamantium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.leggings))
                .criterion("adamantium_boots", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.boots))
                .rewards(AdvancementRewards.Builder.experience(60))
                .build(consumer, Adabranium.MOD_ID + "/adamantium_armor");

        AdvancementEntry premiumHoe = Advancement.Builder.create()
                .parent(adamantiumIngot)
                .display(
                        ModItems.ADAMANTIUM_STUFF.hoe,
                        title("premium_hoe"), description("premium_hoe"), null,
                        AdvancementFrame.CHALLENGE, true, true, true
                )
                .criterion("adamantium_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ADAMANTIUM_STUFF.hoe))
                .rewards(AdvancementRewards.Builder.experience(15))
                .build(consumer, Adabranium.MOD_ID + "/premium_hoe");

    }

    private Identifier background(String name) {
        return Adabranium.id(name);
    }

    public Text title(String name) {
        return Text.translatable("advancements.adabranium." + name + ".title");
    }

    public Text description(String name) {
        return Text.translatable("advancements.adabranium." + name + ".description");
    }
}
