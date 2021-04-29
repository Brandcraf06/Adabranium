package com.brand.adabraniummod.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "adabranium")
public class AdabraniumConfig implements ConfigData {
    
    // Nether
    @ConfigEntry.Category("nether")
    public float netherToolAttackDamage = 2.0f;

    @ConfigEntry.Category("nether")
    public float netherToolMiningSpeed = 8.0f;

    @ConfigEntry.Category("nether")
    public int netherToolDurability = 381;

    @ConfigEntry.Category("nether")
    public int netherToolEnchantability = 15;

    @ConfigEntry.Category("nether")
    public int netherArmorDurabilityMultiplier = 20;

    // Vibranium

    @ConfigEntry.Category("vibranium")
    public float vibraniumBaseAttackDamage = 6.0f;

    @ConfigEntry.Category("vibranium")
    public float vibraniumToolMiningSpeed = 17.0f;

    @ConfigEntry.Category("vibranium")
    public int vibraniumToolDurability = 2990;

    @ConfigEntry.Category("vibranium")
    public int vibraniumToolEnchantability = 12;

    @ConfigEntry.Category("vibranium")
    public int vibraniumArmorDurabilityMultiplier = 165;

    // Adamantium

    @ConfigEntry.Category("adamantium")
    public float adamantiumBaseAttackDamage = 9.0f;

    @ConfigEntry.Category("adamantium")
    public float adamantiumToolMiningSpeed = 25.0f;

    @ConfigEntry.Category("adamantium")
    public int adamantiumToolDurability = 4280;

    @ConfigEntry.Category("adamantium")
    public int adamantiumToolEnchantability = 10;

    @ConfigEntry.Category("adamantium")
    public int adamantiumArmorDurabilityMultiplier = 220;

}