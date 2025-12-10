package com.brand.adabranium.datagen;

import com.brand.adabranium.datagen.providers.*;
import com.brand.adabranium.worldgen.AdabraniumWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class AdabraniumDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(AdabraniumRecipesProvider::new);
        pack.addProvider(AdabraniumWorldgenProvider::new);
        pack.addProvider(AdabraniumLangEnProvider::new);
        pack.addProvider(AdabraniumModelProvider::new);
        pack.addProvider(AdabraniumBlockLootTableProvider::new);
        AdabraniumBlockTagProvider blockTags = pack.addProvider(AdabraniumBlockTagProvider::new);
        pack.addProvider((output, registries) -> new AdabraniumItemTagProvider(output, registries, blockTags));
        pack.addProvider(AdabraniumAdvancementProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, AdabraniumWorldgenProvider::bootstrapConfiguredFeatures);
        registryBuilder.add(Registries.PLACED_FEATURE, AdabraniumWorldgenProvider::bootstrapPlacedFeatures);
    }

    public static ResourceCondition getLoadCondition(String... modIds) {
        return ResourceConditions.allModsLoaded(modIds);
    }
}
