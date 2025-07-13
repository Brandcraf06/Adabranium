package com.brand.adabranium;

import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class AdabraniumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT_MIPPED, ModBlocks.HEART_SHAPED_PLANT);
    }
}
