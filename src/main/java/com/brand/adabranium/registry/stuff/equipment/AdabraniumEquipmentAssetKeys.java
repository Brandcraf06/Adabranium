package com.brand.adabranium.registry.stuff.equipment;

import com.brand.adabranium.Adabranium;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;

public class AdabraniumEquipmentAssetKeys {
    public static final RegistryKey<EquipmentAsset> VIBRANIUM = register("vibranium");
    public static final RegistryKey<EquipmentAsset> ADAMANTIUM = register("adamantium");
    public static final RegistryKey<EquipmentAsset> NETHER_BRICK = register("nether");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Adabranium.id(name));
    }
}
