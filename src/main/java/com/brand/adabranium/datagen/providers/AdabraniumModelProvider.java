package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class AdabraniumModelProvider extends FabricModelProvider {

    public static final Identifier TRIM_TYPE = Adabranium.id("trim_type");

    public AdabraniumModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
        modelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_BLOCK);
        modelGenerator.registerSimpleCubeAll(ModBlocks.ADAMANTIUM_ORE);
        modelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ADAMANTIUM_ORE);
        modelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_ORE);
        modelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        modelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        this.registerHeartShapedPlant(modelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {
        modelGenerator.register(ModItems.ADAMANTIUM, Models.GENERATED);
        modelGenerator.register(ModItems.ADAMANTIUM_INGOT, Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM, Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_INGOT, Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_DUST, Models.GENERATED);
        modelGenerator.register(ModItems.HEART_SHAPED_HERB, Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_SOUP, Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        modelGenerator.register(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);


        for (FullStuffs fullStuffs : FullStuffs.values()) {
            modelGenerator.registerArmor((ArmorItem) fullStuffs.helmet);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.chestplate);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.leggings);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.boots);
            modelGenerator.register(fullStuffs.sword, Models.HANDHELD);
            modelGenerator.register(fullStuffs.pickaxe, Models.HANDHELD);
            modelGenerator.register(fullStuffs.axe, Models.HANDHELD);
            modelGenerator.register(fullStuffs.shovel, Models.HANDHELD);
            modelGenerator.register(fullStuffs.hoe, Models.HANDHELD);
        }
        modelGenerator.register(ModItems.ONESHOTIUM_SWORD, Models.HANDHELD);
    }

    private void registerHeartShapedPlant(BlockStateModelGenerator modelGenerator) {
        modelGenerator.registerItemModel(ModBlocks.HEART_SHAPED_PLANT, "_stage2");
        modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.HEART_SHAPED_PLANT).coordinate(BlockStateVariantMap.create(Properties.AGE_2).register((stage) -> BlockStateVariant.create().put(VariantSettings.MODEL, modelGenerator.createSubModel(ModBlocks.HEART_SHAPED_PLANT, "_stage" + stage, Models.CROSS, TextureMap::cross)))));
    }
}
