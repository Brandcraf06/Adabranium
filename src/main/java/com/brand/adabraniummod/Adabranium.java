package com.brand.adabraniummod;

import com.brand.adabraniummod.config.AdabraniumConfig;
import com.brand.adabraniummod.content.ModBlocks;
import com.brand.adabraniummod.content.ModItems;
import com.brand.adabraniummod.content.ModPotions;
import com.brand.adabraniummod.content.potions.PotionsRecipes;
import com.brand.adabraniummod.content.stuff.armor.RegisterArmors;
import com.brand.adabraniummod.content.stuff.tools.*;
import com.brand.adabraniummod.world.AdabraniumConfiguredFeatures;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("deprecation")
public class Adabranium implements ModInitializer {

    public static final String MOD_ID = "adabraniummod";
    public static AdabraniumConfig CONFIG = AutoConfig.register(AdabraniumConfig.class, GsonConfigSerializer::new).getConfig();
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup ADABRANIUM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "adabranium_group"), () -> new ItemStack(ModItems.VIBRANIUM_INGOT));

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {

        new ModBlocks();
        new ModItems();
        new ModPotions();
        new AdabraniumPickaxes();
        new AdabraniumAxes();
        new AdabraniumHoes();
        new AdabraniumShovels();
        new AdabraniumSwords();
        RegisterArmors.register();
        PotionsRecipes.registerRecipes();

        BiomeModifications.create(new Identifier(MOD_ID, "world_features"))
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld(),
                        context -> {
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, AdabraniumConfiguredFeatures.VIBRANIUM_ORE);
                            context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, AdabraniumConfiguredFeatures.ADAMANTINE_ORE);
                        })
                .add(ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld().and(BiomeSelectors.categories(Biome.Category.JUNGLE)),
                        context -> context.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.VEGETAL_DECORATION, AdabraniumConfiguredFeatures.HEART_SHAPED_PLANT));

    }
}
