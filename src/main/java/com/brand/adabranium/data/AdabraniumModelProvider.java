package com.brand.adabranium.data;

import com.brand.adabranium.content.ModItems;
import com.brand.adabranium.content.stuff.full.FullStuffs;
import com.brand.adabranium.content.stuff.materials.AdabraniumArmorMaterials;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class AdabraniumModelProvider extends FabricModelProvider {

    public static final Identifier TRIM_TYPE = new Identifier("trim_type");

    public AdabraniumModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator modelGenerator) {

        for (FullStuffs fullStuffs : FullStuffs.values()) {
            modelGenerator.registerArmor((ArmorItem) fullStuffs.helmet);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.chestplate);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.leggings);
            modelGenerator.registerArmor((ArmorItem) fullStuffs.boots);
        }
    }
}
