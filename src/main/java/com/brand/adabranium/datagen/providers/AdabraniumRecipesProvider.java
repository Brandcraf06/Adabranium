package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.tag.AdabraniumItemTags;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static com.brand.adabranium.registry.content.ModItems.*;

public class AdabraniumRecipesProvider extends FabricRecipeProvider {


    public AdabraniumRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            private static final ImmutableList<ItemConvertible> VIBRANIUM_ORES = ImmutableList.of(ModBlocks.VIBRANIUM_ORE, ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
            private static final ImmutableList<ItemConvertible> ADAMANTIUM_ORES = ImmutableList.of(ModBlocks.ADAMANTIUM_ORE, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);

            @Override
            public void generate() {

                offerVibraniumStuffRecipe(Items.NETHERITE_HELMET, VIBRANIUM_STUFF.helmet);
                offerVibraniumStuffRecipe(Items.NETHERITE_CHESTPLATE, VIBRANIUM_STUFF.chestplate);
                offerVibraniumStuffRecipe(Items.NETHERITE_LEGGINGS, VIBRANIUM_STUFF.leggings);
                offerVibraniumStuffRecipe(Items.NETHERITE_BOOTS, VIBRANIUM_STUFF.boots);
                offerVibraniumStuffRecipe(Items.NETHERITE_SHOVEL, VIBRANIUM_STUFF.shovel);
                offerVibraniumStuffRecipe(Items.NETHERITE_PICKAXE, VIBRANIUM_STUFF.pickaxe);
                offerVibraniumStuffRecipe(Items.NETHERITE_AXE, VIBRANIUM_STUFF.axe);
                offerVibraniumStuffRecipe(Items.NETHERITE_HOE, VIBRANIUM_STUFF.hoe);
                offerVibraniumStuffRecipe(Items.NETHERITE_SWORD, VIBRANIUM_STUFF.sword);

                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.helmet, ADAMANTIUM_STUFF.helmet);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.chestplate, ADAMANTIUM_STUFF.chestplate);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.leggings, ADAMANTIUM_STUFF.leggings);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.boots, ADAMANTIUM_STUFF.boots);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.shovel, ADAMANTIUM_STUFF.shovel);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.pickaxe, ADAMANTIUM_STUFF.pickaxe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.axe, ADAMANTIUM_STUFF.axe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.hoe, ADAMANTIUM_STUFF.hoe);
                offerAdamantiumStuffRecipe(VIBRANIUM_STUFF.sword, ADAMANTIUM_STUFF.sword);

                offerNetherStuffRecipe(Items.IRON_HELMET, NETHER_STUFF.helmet);
                offerNetherStuffRecipe(Items.IRON_CHESTPLATE, NETHER_STUFF.chestplate);
                offerNetherStuffRecipe(Items.IRON_LEGGINGS, NETHER_STUFF.leggings);
                offerNetherStuffRecipe(Items.IRON_BOOTS, NETHER_STUFF.boots);
                offerNetherStuffRecipe(Items.IRON_SHOVEL, NETHER_STUFF.shovel);
                offerNetherStuffRecipe(Items.IRON_PICKAXE, NETHER_STUFF.pickaxe);
                offerNetherStuffRecipe(Items.IRON_AXE, NETHER_STUFF.axe);
                offerNetherStuffRecipe(Items.IRON_HOE, NETHER_STUFF.hoe);
                offerNetherStuffRecipe(Items.IRON_SWORD, NETHER_STUFF.sword);

                offerSmelting(VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 200, "vibranium");
                offerBlasting(VIBRANIUM_ORES, RecipeCategory.MISC, VIBRANIUM, 1.0F, 100, "vibranium");
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(VIBRANIUM_INGOT), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 200).criterion(hasItem(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT)).offerTo(exporter, getItemPath(VIBRANIUM_DUST) + "_from_smelting");
                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(VIBRANIUM_INGOT), RecipeCategory.MISC, VIBRANIUM_DUST, 0.7F, 100).criterion(hasItem(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT)).offerTo(exporter, getItemPath(VIBRANIUM_DUST) + "_from_blasting");
                createShapeless(RecipeCategory.MISC, VIBRANIUM_INGOT).input(VIBRANIUM, 4).input(Blocks.OBSIDIAN, 4).group("vibranium_ingot").criterion(hasItem(VIBRANIUM), conditionsFromItem(VIBRANIUM)).offerTo(exporter);
                offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeCategory.MISC, VIBRANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK, "vibranium_ingot_from_vibranium_block", "vibranium_ingot");

                offerSmelting(ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 200, "adamantium");
                offerBlasting(ADAMANTIUM_ORES, RecipeCategory.MISC, ADAMANTIUM, 1.0F, 100, "adamantium");
                offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeCategory.MISC, ADAMANTIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_BLOCK, "adamantium_ingot_from_adamantium_block", "adamantium_ingot");
                createShapeless(RecipeCategory.MISC, ADAMANTIUM_INGOT).input(ADAMANTIUM, 4).input(VIBRANIUM_INGOT, 4).group("adamantium_ingot").criterion(hasItem(ADAMANTIUM), conditionsFromItem(ADAMANTIUM)).offerTo(exporter);

                createShaped(RecipeCategory.MISC, VIBRANIUM_SOUP).input('A', HEART_SHAPED_HERB).input('B', VIBRANIUM_DUST).input('C', Items.BOWL).pattern("ABA").pattern("AAA").pattern(" C ").criterion(hasItem(HEART_SHAPED_HERB), conditionsFromItem(HEART_SHAPED_HERB)).offerTo(exporter);

                this.offerSmithingTemplateCopyingRecipe(VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.AMETHYST_BLOCK);
                this.offerSmithingTemplateCopyingRecipe(ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Blocks.SCULK);
            }

            public void offerStuffRecipes(ItemConvertible material, ItemConvertible rod, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ItemConvertible shovel, ItemConvertible pickaxe, ItemConvertible axe, ItemConvertible hoe, ItemConvertible sword) {
                createShaped(RecipeCategory.COMBAT, helmet).input('X', material).pattern("XXX").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, chestplate).input('X', material).pattern("X X").pattern("XXX").pattern("XXX").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, leggings).input('X', material).pattern("XXX").pattern("X X").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, boots).input('X', material).pattern("X X").pattern("X X").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, shovel).input('#', rod).input('X', material).pattern("X").pattern("#").pattern("#").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, pickaxe).input('#', rod).input('X', material).pattern("XXX").pattern(" # ").pattern(" # ").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, axe).input('#', rod).input('X', material).pattern("XX").pattern("X#").pattern(" #").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.TOOLS, hoe).input('#', rod).input('X', material).pattern("XX").pattern(" #").pattern(" #").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, sword).input('#', rod).input('X', material).pattern("X").pattern("X").pattern("#").criterion(hasItem(material), conditionsFromItem(material)).offerTo(exporter);
            }

            public void createUpgradeRecipe(Item input, Ingredient material, AdvancementCriterion<?> condition, Item result, Item template, String name) {
                SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItem(template), Ingredient.ofItem(input), material, RecipeCategory.TOOLS, result).criterion("has_" + name, condition).offerTo(exporter, this.getItemPath(result) + "_smithing");
            }

            public void offerVibraniumStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, Ingredient.ofItem(VIBRANIUM_INGOT), conditionsFromItem(VIBRANIUM_INGOT), result, ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, "vibranium_ingot");
            }

            public void offerAdamantiumStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, Ingredient.ofItem(ADAMANTIUM_INGOT), conditionsFromItem(ADAMANTIUM_INGOT), result, ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, "adamantium_ingot");
            }

            public void offerNetherStuffRecipe(Item input, Item result) {
                createUpgradeRecipe(input, this.ingredientFromTag(AdabraniumItemTags.NETHER_BRICK_MATERIALS), this.conditionsFromTag(AdabraniumItemTags.NETHER_BRICK_MATERIALS), result, Items.NETHER_BRICK, "nether_brick");
            }
        };
    }

    @Override
    public String getName() {
        return "Adabranium Recipes";
    }
}