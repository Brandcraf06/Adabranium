package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

import static com.brand.adabranium.registry.content.ModItems.*;

public class AdabraniumRecipesProvider extends FabricRecipeProvider {


    public AdabraniumRecipesProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            private static final ImmutableList<ItemLike> VIBRANIUM_ORES = ImmutableList.of(ModBlocks.VIBRANIUM_ORE, ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
            private static final ImmutableList<ItemLike> ADAMANTIUM_ORES = ImmutableList.of(ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

            @Override
            public void buildRecipes() {

                offerVibraniumStuffRecipe(Items.NETHERITE_HELMET, VIBRANIUM_STUFF.helmet);
                offerVibraniumStuffRecipe(Items.NETHERITE_CHESTPLATE, VIBRANIUM_STUFF.chestplate);
                offerVibraniumStuffRecipe(Items.NETHERITE_LEGGINGS, VIBRANIUM_STUFF.leggings);
                offerVibraniumStuffRecipe(Items.NETHERITE_BOOTS, VIBRANIUM_STUFF.boots);
                offerVibraniumStuffRecipe(Items.NETHERITE_SHOVEL, VIBRANIUM_STUFF.shovel);
                offerVibraniumStuffRecipe(Items.NETHERITE_PICKAXE, VIBRANIUM_STUFF.pickaxe);
                offerVibraniumStuffRecipe(Items.NETHERITE_AXE, VIBRANIUM_STUFF.axe);
                offerVibraniumStuffRecipe(Items.NETHERITE_HOE, VIBRANIUM_STUFF.hoe);
                offerVibraniumStuffRecipe(Items.NETHERITE_SWORD, VIBRANIUM_STUFF.sword);
                offerVibraniumStuffRecipe(Items.NETHERITE_SPEAR, VIBRANIUM_STUFF.spear);

                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.helmet, ADAMANTIUM_STUFF.helmet);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.chestplate, ADAMANTIUM_STUFF.chestplate);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.leggings, ADAMANTIUM_STUFF.leggings);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.boots, ADAMANTIUM_STUFF.boots);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.shovel, ADAMANTIUM_STUFF.shovel);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.pickaxe, ADAMANTIUM_STUFF.pickaxe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.axe, ADAMANTIUM_STUFF.axe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.hoe, ADAMANTIUM_STUFF.hoe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.sword, ADAMANTIUM_STUFF.sword);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.spear, ADAMANTIUM_STUFF.spear);

                offerNetherStuffRecipe(Items.IRON_HELMET, NETHER_STUFF.helmet);
                offerNetherStuffRecipe(Items.IRON_CHESTPLATE, NETHER_STUFF.chestplate);
                offerNetherStuffRecipe(Items.IRON_LEGGINGS, NETHER_STUFF.leggings);
                offerNetherStuffRecipe(Items.IRON_BOOTS, NETHER_STUFF.boots);
                offerNetherStuffRecipe(Items.IRON_SHOVEL, NETHER_STUFF.shovel);
                offerNetherStuffRecipe(Items.IRON_PICKAXE, NETHER_STUFF.pickaxe);
                offerNetherStuffRecipe(Items.IRON_AXE, NETHER_STUFF.axe);
                offerNetherStuffRecipe(Items.IRON_HOE, NETHER_STUFF.hoe);
                offerNetherStuffRecipe(Items.IRON_SWORD, NETHER_STUFF.sword);
                offerNetherStuffRecipe(Items.IRON_SPEAR, NETHER_STUFF.spear);

                oreSmelting(VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 200, "vibranium");
                oreBlasting(VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 100, "vibranium");
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(VIBRANIUM), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 200).unlockedBy(getHasName(VIBRANIUM_INGOT), has(VIBRANIUM_INGOT)).save(output, getItemName(VIBRANIUM_DUST) + "_from_smelting");
                SimpleCookingRecipeBuilder.blasting(Ingredient.of(VIBRANIUM), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 100).unlockedBy(getHasName(VIBRANIUM_INGOT), has(VIBRANIUM_INGOT)).save(output, getItemName(VIBRANIUM_DUST) + "_from_blasting");
                shapeless(RecipeCategory.MISC, VIBRANIUM_INGOT).requires(VIBRANIUM, 4).requires(Blocks.OBSIDIAN, 4).group("vibranium_ingot").unlockedBy(getHasName(VIBRANIUM), has(VIBRANIUM)).save(output);
                nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, VIBRANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK, "vibranium_ingot_from_vibranium_block", "vibranium_ingot");

                oreSmelting(ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 200, "adamantium");
                oreBlasting(ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 100, "adamantium");
                nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.MISC, ADAMANTIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_BLOCK, "adamantium_ingot_from_adamantium_block", "adamantium_ingot");
                shapeless(RecipeCategory.MISC, ADAMANTIUM_INGOT).requires(ADAMANTIUM, 4).requires(VIBRANIUM_INGOT, 4).group("adamantium_ingot").unlockedBy(getHasName(ADAMANTIUM), has(ADAMANTIUM)).save(output);

                shaped(RecipeCategory.MISC, VIBRANIUM_SOUP).define('A', HEART_SHAPED_HERB).define('B', VIBRANIUM_DUST).define('C', Items.BOWL).pattern("ABA").pattern("AAA").pattern(" C ").unlockedBy(getHasName(HEART_SHAPED_HERB), has(HEART_SHAPED_HERB)).save(output);

                this.copySmithingTemplate(VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.AMETHYST_BLOCK);
                this.copySmithingTemplate(ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.SCULK);
            }

            public void createUpgradeRecipe(Item input, Ingredient material, Criterion<?> condition, Item result, Item template, String name) {
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(input), material, RecipeCategory.TOOLS, result).unlocks("has_" + name, condition).save(output, this.getItemName(result) + "_smithing");
            }

            public void offerVibraniumStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, Ingredient.of(VIBRANIUM_INGOT), has(VIBRANIUM_INGOT), result, ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, "vibranium_ingot");
            }

            public void offerAdamantiumStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, Ingredient.of(ADAMANTIUM_INGOT), has(ADAMANTIUM_INGOT), result, ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, "adamantium_ingot");
            }

            public void offerNetherStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, this.tag(AdabraniumItemTags.NETHER_BRICK_MATERIALS), this.has(AdabraniumItemTags.NETHER_BRICK_MATERIALS), result, Items.NETHER_BRICK, "nether_brick");
            }
        };
    }

    @Override
    public String getName() {
        return "Adabranium Recipes";
    }
}