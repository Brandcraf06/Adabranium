package com.brand.adabranium.data;

import com.brand.adabranium.content.ModBlocks;
import com.brand.adabranium.content.ModItems;
import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class AdabraniumRecipesGenerator extends FabricRecipeProvider {

    private static final ImmutableList<ItemConvertible> VIBRANIUM_ORES;
    private static final ImmutableList<ItemConvertible> ADAMANTINE_ORES;

    public AdabraniumRecipesGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {


        offerStuffRecipes(exporter, ModItems.VIBRANIUM_INGOT, ModItems.OBSIDIAN_ROD,
                ModItems.VIBRANIUM_STUFF.helmet,
                ModItems.VIBRANIUM_STUFF.chestplate,
                ModItems.VIBRANIUM_STUFF.leggings,
                ModItems.VIBRANIUM_STUFF.boots,
                ModItems.VIBRANIUM_STUFF.shovel,
                ModItems.VIBRANIUM_STUFF.pickaxe,
                ModItems.VIBRANIUM_STUFF.axe,
                ModItems.VIBRANIUM_STUFF.hoe,
                ModItems.VIBRANIUM_STUFF.sword);

        offerStuffRecipes(exporter, ModItems.ADAMANTIUM_INGOT, ModItems.ADAMANTIUM_ROD,
                ModItems.ADAMANTIUM_STUFF.helmet,
                ModItems.ADAMANTIUM_STUFF.chestplate,
                ModItems.ADAMANTIUM_STUFF.leggings,
                ModItems.ADAMANTIUM_STUFF.boots,
                ModItems.ADAMANTIUM_STUFF.shovel,
                ModItems.ADAMANTIUM_STUFF.pickaxe,
                ModItems.ADAMANTIUM_STUFF.axe,
                ModItems.ADAMANTIUM_STUFF.hoe,
                ModItems.ADAMANTIUM_STUFF.sword);

        offerSmelting(exporter, VIBRANIUM_ORES, RecipeCategory.MISC, ModItems.VIBRANIUM, 1.0F, 200, "vibranium");
        offerSmelting(exporter, ADAMANTINE_ORES, RecipeCategory.MISC, ModItems.ADAMANTINE, 1.0F, 200, "adamantine");
        offerBlasting(exporter, VIBRANIUM_ORES, RecipeCategory.MISC, ModItems.VIBRANIUM, 1.0F, 100, "vibranium");
        offerBlasting(exporter, ADAMANTINE_ORES, RecipeCategory.MISC, ModItems.ADAMANTINE, 1.0F, 100, "adamantine");
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(ModItems.VIBRANIUM_INGOT), RecipeCategory.MISC, ModItems.VIBRANIUM_DUST, 0.5F, 200).criterion(hasItem(ModItems.VIBRANIUM_INGOT), conditionsFromItem(ModItems.VIBRANIUM_INGOT)).offerTo(exporter);


        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK, "vibranium_ingot_from_vibranium_block", "vibranium_ingot");
        offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter, RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ADAMANTIUM_BLOCK, "adamantium_ingot_from_adamantium_block", "adamantium_ingot");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT).input('A', ModItems.VIBRANIUM).input('B', Blocks.OBSIDIAN).pattern(" A ").pattern("ABA").pattern(" A ").criterion(hasItem(ModItems.VIBRANIUM), conditionsFromItem(ModItems.VIBRANIUM)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT).input('A', ModItems.ADAMANTINE).input('B', ModItems.VIBRANIUM).input('C', Blocks.OBSIDIAN).pattern("BAB").pattern("ACA").pattern("BAB").criterion(hasItem(ModItems.ADAMANTINE), conditionsFromItem(ModItems.ADAMANTINE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_INGOT).input('A', ModItems.ADAMANTINE).input('B', ModItems.VIBRANIUM_INGOT).pattern(" A ").pattern("ABA").pattern(" A ").criterion(hasItem(ModItems.ADAMANTINE), conditionsFromItem(ModItems.ADAMANTINE)).offerTo(exporter, getRecipeName(ModItems.ADAMANTIUM_INGOT) + "_from_" + (ModItems.VIBRANIUM_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OBSIDIAN_ROD, 4).input('#', Blocks.OBSIDIAN).pattern("#").pattern("#").criterion(hasItem(Blocks.OBSIDIAN), conditionsFromItem(Blocks.OBSIDIAN)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADAMANTIUM_ROD, 2).input('A', ModItems.ADAMANTINE).input('B', ModItems.VIBRANIUM).input('C', ModItems.OBSIDIAN_ROD).pattern("A").pattern("B").pattern("C").criterion(hasItem(ModItems.ADAMANTINE), conditionsFromItem(ModItems.ADAMANTINE)).offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VIBRANIUM_SOUP).input('A', ModItems.HEART_SHAPED_HERB).input('B', ModItems.VIBRANIUM_DUST).input('C', Items.BOWL).pattern("ABA").pattern("AAA").pattern(" C ").criterion(hasItem(ModItems.HEART_SHAPED_HERB), conditionsFromItem(ModItems.HEART_SHAPED_HERB)).offerTo(exporter);


    }

    public static void offerStuffRecipes(Consumer<RecipeJsonProvider> exporter, ItemConvertible material, ItemConvertible rod, ItemConvertible helmet, ItemConvertible chestplate, ItemConvertible leggings, ItemConvertible boots, ItemConvertible shovel, ItemConvertible pickaxe, ItemConvertible axe, ItemConvertible hoe, ItemConvertible sword) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, helmet).input('X', material).pattern("XXX").pattern("X X").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, chestplate).input('X', material).pattern("X X").pattern("XXX").pattern("XXX").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, leggings).input('X', material).pattern("XXX").pattern("X X").pattern("X X").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, boots).input('X', material).pattern("X X").pattern("X X").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, shovel).input('#', rod).input('X', material).pattern("X").pattern("#").pattern("#").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, pickaxe).input('#', rod).input('X', material).pattern("XXX").pattern(" # ").pattern(" # ").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, axe).input('#', rod).input('X', material).pattern("XX").pattern("X#").pattern(" #").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, hoe).input('#', rod).input('X', material).pattern("XX").pattern(" #").pattern(" #").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, sword).input('#', rod).input('X', material).pattern("X").pattern("X").pattern("#").criterion("has_diamond", conditionsFromItem(material)).offerTo(exporter);
    }

    static {
        VIBRANIUM_ORES = ImmutableList.of(ModBlocks.VIBRANIUM_ORE, ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        ADAMANTINE_ORES = ImmutableList.of(ModBlocks.ADAMANTINE_ORE, ModBlocks.DEEPSLATE_ADAMANTINE_ORE);
    }
}
