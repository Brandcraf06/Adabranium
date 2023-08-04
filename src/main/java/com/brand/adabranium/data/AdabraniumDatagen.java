package com.brand.adabranium.data;

import com.brand.adabranium.worldgen.AdabraniumWorldgenProvider;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class AdabraniumDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {

        final FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(AdabraniumRecipesProvider::new);
        pack.addProvider(AdabraniumWorldgenProvider::new);
        pack.addProvider(AdabraniumModelProvider::new);

    }

    public static ConditionJsonProvider getLoadCondition(String... modIds) {
        return DefaultResourceConditions.allModsLoaded(modIds);
    }
}
