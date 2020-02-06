package com.brand.adabraniummod.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class ModPotions {
	   public static final Potion TOUGHNESS;
	   public static final Potion LONG_TOUGHNESS;
	   public static final Potion STRONG_TOUGHNESS;

	   private static Potion register(String string_1, Potion potion_1) {
	      return (Potion)Registry.register(Registry.POTION, (String)string_1, potion_1);
	   }

	   static {
	      TOUGHNESS = register("toughness", new Potion(new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0)}));
	      LONG_TOUGHNESS = register("long_toughness", new Potion("toughness", new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.RESISTANCE, 1800, 0)}));
	      STRONG_TOUGHNESS = register("strong_toughness", new Potion("toughness", new StatusEffectInstance[]{new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1)}));
	   }
	}

