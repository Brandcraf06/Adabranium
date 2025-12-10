package com.brand.adabranium.registry.stuff.equipment;

import com.brand.adabranium.Adabranium;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class AdabraniumEquipmentAssetKeys {
    public static final ResourceKey<EquipmentAsset> VIBRANIUM = register("vibranium");
    public static final ResourceKey<EquipmentAsset> ADAMANTIUM = register("adamantium");
    public static final ResourceKey<EquipmentAsset> NETHER_BRICK = register("nether");

    static ResourceKey<EquipmentAsset> register(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Adabranium.id(name));
    }
}
