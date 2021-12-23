package com.yannick.unbelievablemod.world;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ConfiguredStructures {

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ABANDONED_LUMBERJACK_HOUSE = Structures.ABANDONED_LUMBERJACK_HOUSE.get().configured(NoneFeatureConfiguration.INSTANCE);
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_CASTLE_RUINS = Structures.CASTLE_RUINS.get().configured(NoneFeatureConfiguration.INSTANCE);

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_abandoned_lumberjack_house"), CONFIGURED_ABANDONED_LUMBERJACK_HOUSE);
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_ruined_castle"), CONFIGURED_CASTLE_RUINS);
    }
}
