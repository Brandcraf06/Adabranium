package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.brand.adabranium.registry.content.ModItems.*;

public class AdabraniumRecipesProvider extends FabricRecipeProvider {

    private static final ImmutableList<ItemConvertible> VIBRANIUM_ORES = ImmutableList.of(ModBlocks.VIBRANIUM_ORE, ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
    private static final ImmutableList<ItemConvertible> ADAMANTIUM_ORES = ImmutableList.of(ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

    public AdabraniumRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_HELMET, VIBRANIUM_STUFF.helmet);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_CHESTPLATE, VIBRANIUM_STUFF.chestplate);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_LEGGINGS, VIBRANIUM_STUFF.leggings);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_BOOTS, VIBRANIUM_STUFF.boots);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_SHOVEL, VIBRANIUM_STUFF.shovel);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_PICKAXE, VIBRANIUM_STUFF.pickaxe);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_AXE, VIBRANIUM_STUFF.axe);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_HOE, VIBRANIUM_STUFF.hoe);
        offerVibraniumStuffRecipe(exporter, Items.NETHERITE_SWORD, VIBRANIUM_STUFF.sword);

        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.helmet, ADAMANTIUM_STUFF.helmet);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.chestplate, ADAMANTIUM_STUFF.chestplate);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.leggings, ADAMANTIUM_STUFF.leggings);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.boots, ADAMANTIUM_STUFF.boots);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.shovel, ADAMANTIUM_STUFF.shovel);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.pickaxe, ADAMANTIUM_STUFF.pickaxe);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.axe, ADAMANTIUM_STUFF.axe);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.hoe, ADAMANTIUM_STUFF.hoe);
        offerAdamantiumStuffRecipe(exporter, VIBRANIUM_STUFF.sword, ADAMANTIUM_STUFF.sword);

        offerNetherStuffRecipe(exporter, Items.IRON_HELMET, NETHER_STUFF.helmet);
        offerNetherStuffRecipe(exporter, Items.IRON_CHESTPLATE, NETHER_STUFF.chestplate);
        offerNetherStuffRecipe(exporter, Items.IRON_LEGGINGS, NETHER_STUFF.leggings);
        offerNetherStuffRecipe(exporter, Items.IRON_BOOTS, NETHER_STUFF.boots);
        offerNetherStuffRecipe(exporter, Items.IRON_SHOVEL, NETHER_STUFF.shovel);
        offerNetherStuffRecipe(exporter, Items.IRON_PICKAXE, NETHER_STUFF.pickaxe);
        offerNetherStuffRecipe(exporter, Items.IRON_AXE, NETHER_STUFF.axe);
        offerNetherStuffRecipe(exporter, Items.IRON_HOE, NETHER_STUFF.hoe);
        offerNetherStuffRecipe(exporter, Items.IRON_SWORD, NETHER_STUFF.sword);

        offerSmelting(exporter, VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 200, "vibranium");
        offerBlasting(exporter, VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 100, "vibranium");
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(VIBRANIUM_INGOT), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 200).criterion(hasItem(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT)).offerTo(exporter, getItemPath(VIBRANIUM_DUST) + "_from_smelting");
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(VIBRANIUM_INGOT), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 100).criterion(hasItem(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT)).offerTo(exporter, getItemPath(VIBRANIUM_DUST) + "_from_blasting");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, VIBRANIUM_INGOT).input(VIBRANIUM, 4).input(Blocks.OBSIDIAN, 4).group("vibranium_ingot").criterion(hasItem(VIBRANIUM), conditionsFromItem(VIBRANIUM)).offerTo(exporter);
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, VIBRANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK, "vibranium_ingot_from_vibranium_block", "vibranium_ingot");

        offerSmelting(exporter, ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 200, "adamantium");
        offerBlasting(exporter, ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 100, "adamantium");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ADAMANTIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_BLOCK, "adamantium_ingot_from_adamantium_block", "adamantium_ingot");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ADAMANTIUM_INGOT).input(ADAMANTIUM, 4).input(Blocks.OBSIDIAN, 4).group("adamantium_ingot").criterion(hasItem(ADAMANTIUM), conditionsFromItem(ADAMANTIUM)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, VIBRANIUM_SOUP).input('A', HEART_SHAPED_HERB).input('B', VIBRANIUM_DUST).input('C', Items.BOWL).pattern("ABA").pattern("AAA").pattern(" C ").criterion(hasItem(HEART_SHAPED_HERB), conditionsFromItem(HEART_SHAPED_HERB)).offerTo(exporter);

        offerSmithingTemplateCopyingRecipe(exporter, VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.AMETHYST_BLOCK);
        offerSmithingTemplateCopyingRecipe(exporter, ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.SCULK);
    }

    public static void offerStuffRecipes(RecipeExporter exporter, ItemConvertible material, ItemConvertible rod, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ItemConvertible shovel, ItemConvertible pickaxe, ItemConvertible axe, ItemConvertible hoe, ItemConvertible sword) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, helmet).input('X', material).pattern("XXX").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, chestplate).input('X', material).pattern("X X").pattern("XXX").pattern("XXX").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, leggings).input('X', material).pattern("XXX").pattern("X X").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, boots).input('X', material).pattern("X X").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, shovel).input('#', rod).input('X', material).pattern("X").pattern("#").pattern("#").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, pickaxe).input('#', rod).input('X', material).pattern("XXX").pattern(" # ").pattern(" # ").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, axe).input('#', rod).input('X', material).pattern("XX").pattern("X#").pattern(" #").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, hoe).input('#', rod).input('X', material).pattern("XX").pattern(" #").pattern(" #").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, sword).input('#', rod).input('X', material).pattern("X").pattern("X").pattern("#").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
    }

    public void createUpgradeRecipe(RecipeExporter exporter, Item input, Ingredient material, AdvancementCriterion<?> condition, Item result, Item template, String name) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(template), Ingredient.ofItems(input), material, RecipeCategory.TOOLS, result).criterion("has_" + name, condition).offerTo(exporter, getItemPath(result) + "_smithing");
    }

    public void offerVibraniumStuffRecipe(RecipeExporter exporter, Item input, Item result) {
        createUpgradeRecipe(exporter, input, Ingredient.ofItems(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT), result, ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, "vibranium_ingot");
    }

    public void offerAdamantiumStuffRecipe(RecipeExporter exporter, Item input, Item result) {
        createUpgradeRecipe(exporter,input, Ingredient.ofItems(ADAMANTIUM_INGOT), conditionsFromItem(ADAMANTIUM_INGOT), result, ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, "adamantium_ingot");
    }

    public static void offerNetherStuffRecipe(RecipeExporter exporter, Item input, Item result) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(Items.NETHER_BRICK), Ingredient.ofItems(input), Ingredient.ofItems(Items.NETHER_BRICK), RecipeCategory.TOOLS, result).criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK)).offerTo(exporter, getItemPath(result));
    }

    @Override
    public String getName() {
        return "Adabranium Recipes";
    }
}