package com.brand.adabranium.registry.stuff.equipment;

import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class AdaEquipmentAssetKeys {
    public static final RegistryKey<EquipmentAsset> VIBRANIUM = register("vibranium");
    public static final RegistryKey<EquipmentAsset> ADAMANTIUM = register("adamantium");
    public static final RegistryKey<EquipmentAsset> NETHER_BRICK = register("nether");

    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.ofVanilla(name));
    }
}
