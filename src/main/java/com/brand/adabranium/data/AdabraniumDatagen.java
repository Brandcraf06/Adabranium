package com.brand.adabranium.data;

import com.brand.adabranium.data.providers.AdabraniumBlockTagProvider;
import com.brand.adabranium.data.providers.AdabraniumItemTagProvider;
import com.brand.adabranium.data.providers.AdabraniumModelProvider;
import com.brand.adabranium.data.providers.AdabraniumRecipesProvider;
import com.brand.adabranium.worldgen.AdabraniumWorldgenProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;

public class AdabraniumDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(AdabraniumRecipesProvider::new);
        pack.addProvider(AdabraniumWorldgenProvider::new);
        pack.addProvider(AdabraniumModelProvider::new);
        AdabraniumBlockTagProvider blockTags = pack.addProvider(AdabraniumBlockTagProvider::new);
        pack.addProvider((output, registries) -> new AdabraniumItemTagProvider(output, registries, blockTags));

    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
