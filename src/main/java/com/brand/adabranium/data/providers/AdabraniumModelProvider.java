package com.brand.adabranium.data.providers;

import com.brand.adabranium.content.stuff.full.FullStuffs;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

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
