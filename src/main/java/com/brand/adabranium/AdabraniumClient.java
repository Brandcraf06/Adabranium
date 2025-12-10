package com.brand.adabranium;

import com.brand.adabranium.registry.content.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class AdabraniumClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, ModBlocks.HEART_SHAPED_PLANT);
    }
}
