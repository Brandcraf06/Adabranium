package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class AdabraniumModelProvider extends FabricModelProvider {

    public static final Identifier TRIM_TYPE = Adabranium.id("trim_type");

    public AdabraniumModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators modelGenerator) {
        modelGenerator.createTrivialCube(ModBlocks.ADAMANTIUM_BLOCK);
        modelGenerator.createTrivialCube(ModBlocks.ADAMANTIUM_ORE);
        modelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        modelGenerator.createTrivialCube(ModBlocks.VIBRANIUM_ORE);
        modelGenerator.createTrivialCube(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        modelGenerator.createTrivialCube(ModBlocks.VIBRANIUM_BLOCK);
        this.registerHeartShapedPlant(modelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerators modelGenerator) {
        modelGenerator.generateFlatItem(ModItems.ADAMANTIUM, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.ADAMANTIUM_INGOT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_DUST, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.HEART_SHAPED_HERB, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_SOUP, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);


        for (FullStuffs fullStuffs : FullStuffs.values()) {
            modelGenerator.generateTrimmableItem(fullStuffs.helmet, fullStuffs.equipmentKey, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
            modelGenerator.generateTrimmableItem(fullStuffs.chestplate, fullStuffs.equipmentKey, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
            modelGenerator.generateTrimmableItem(fullStuffs.leggings, fullStuffs.equipmentKey, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
            modelGenerator.generateTrimmableItem(fullStuffs.boots, fullStuffs.equipmentKey, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
            modelGenerator.generateFlatItem(fullStuffs.sword, ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGenerator.generateFlatItem(fullStuffs.pickaxe, ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGenerator.generateFlatItem(fullStuffs.axe, ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGenerator.generateFlatItem(fullStuffs.shovel, ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGenerator.generateFlatItem(fullStuffs.hoe, ModelTemplates.FLAT_HANDHELD_ITEM);
            modelGenerator.generateSpear(fullStuffs.spear);
        }
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.ADAMANTIUM_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.VIBRANIUM_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);
        modelGenerator.generateFlatItem(ModItems.ADAMANTIUM_NAUTILUS_ARMOR, ModelTemplates.FLAT_ITEM);

        modelGenerator.generateFlatItem(ModItems.ONESHOTIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    private void registerHeartShapedPlant(BlockModelGenerators modelGenerator) {
        modelGenerator.registerSimpleFlatItemModel(ModBlocks.HEART_SHAPED_PLANT, "_stage2");
        modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(ModBlocks.HEART_SHAPED_PLANT).with(PropertyDispatch.initial(BlockStateProperties.AGE_2).generate((stage) -> BlockModelGenerators.plainVariant(modelGenerator.createSuffixedVariant(ModBlocks.HEART_SHAPED_PLANT, "_stage" + stage, ModelTemplates.CROSS, TextureMapping::cross)))));
    }
}
