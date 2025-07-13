package com.brand.adabranium.registry.tag;

import com.brand.adabranium.Adabranium;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class AdabraniumItemTags {

    public static final TagKey<Item> VIBRANIUM_MATERIALS = register("vibranium_materials");
    public static final TagKey<Item> ADAMANTIUM_MATERIALS = register("adamantium_materials");
    public static final TagKey<Item> NETHER_BRICK_MATERIALS = register("nether_brick_materials");

    private AdabraniumItemTags() {
    }

    private static TagKey<Item> register(String id) {
        return TagKey.of(RegistryKeys.ITEM, Adabranium.id(id));
    }
}
