package com.brand.adabraniummod.content;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class ModPotions {

    public static final Potion TOUGHNESS = register("toughness", new Potion(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0)));
    public static final Potion LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0)));
    public static final Potion STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1)));

    private static Potion register(String id, Potion potion) {
        return Registry.register(Registry.POTION, id, potion);
    }
}

