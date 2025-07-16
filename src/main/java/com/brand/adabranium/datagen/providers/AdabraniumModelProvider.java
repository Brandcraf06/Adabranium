package com.brand.adabranium.datagen.providers;

import com.brand.adabranium.Adabranium;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
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
        modelGenerator.register(ModItems.ADAMANTIUM.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.ADAMANTIUM_INGOT.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_INGOT.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_DUST.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.HEART_SHAPED_HERB.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_SOUP.asItem(), Models.GENERATED);
        modelGenerator.register(ModItems.VIBRANIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        modelGenerator.register(ModItems.ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);


        for (FullStuffs fullStuffs : FullStuffs.values()) {
            modelGenerator.registerArmor(fullStuffs.helmet.asItem(), fullStuffs.equipmentKey, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
            modelGenerator.registerArmor(fullStuffs.chestplate.asItem(), fullStuffs.equipmentKey, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
            modelGenerator.registerArmor(fullStuffs.leggings.asItem(), fullStuffs.equipmentKey, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
            modelGenerator.registerArmor(fullStuffs.boots.asItem(), fullStuffs.equipmentKey, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
            modelGenerator.register(fullStuffs.sword.asItem(), Models.HANDHELD);
            modelGenerator.register(fullStuffs.pickaxe.asItem(), Models.HANDHELD);
            modelGenerator.register(fullStuffs.axe.asItem(), Models.HANDHELD);
            modelGenerator.register(fullStuffs.shovel.asItem(), Models.HANDHELD);
            modelGenerator.register(fullStuffs.hoe.asItem(), Models.HANDHELD);
        }
        modelGenerator.register(ModItems.ONESHOTIUM_SWORD, Models.HANDHELD);
    }

    private void registerHeartShapedPlant(BlockStateModelGenerator modelGenerator) {
        modelGenerator.registerItemModel(ModBlocks.HEART_SHAPED_PLANT, "_stage2");
        modelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModBlocks.HEART_SHAPED_PLANT).with(BlockStateVariantMap.models(Properties.AGE_2).generate((stage) -> BlockStateModelGenerator.createWeightedVariant(modelGenerator.createSubModel(ModBlocks.HEART_SHAPED_PLANT, "_stage" + stage, Models.CROSS, TextureMap::cross)))));
    }
}
