package com.brand.adabranium;

import com.brand.adabranium.itemgroups.AdabraniumGroup;
import com.brand.adabranium.registry.content.ModBlocks;
import com.brand.adabranium.registry.content.ModItems;
import com.brand.adabranium.registry.stuff.potions.PotionsRecipes;
import com.brand.adabranium.worldgen.AdabraniumWorldgenFeatures;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
public class Adabranium implements ModInitializer {

    public static final String MOD_ID = "adabranium";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {

        new ModBlocks();
        new ModItems();

        AdabraniumGroup.init();

        PotionsRecipes.registerRecipes();
        AdabraniumWorldgenFeatures.registerConfiguredFeature();

    }

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}


