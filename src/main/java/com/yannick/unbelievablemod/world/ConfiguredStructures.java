package com.yannick.unbelievablemod.world;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;

public class ConfiguredStructures {

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_ABANDONED_LUMBERJACK_HOUSE = Structures.ABANDONED_LUMBERJACK_HOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_CASTLE_RUINS = Structures.CASTLE_RUINS.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_UNDERGROUND_CABIN = Structures.UNDERGROUND_CABIN.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_MOUNTAIN_FORTRESS = Structures.MOUNTAIN_FORTRESS.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_abandoned_lumberjack_house"), CONFIGURED_ABANDONED_LUMBERJACK_HOUSE);
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_ruined_castle"), CONFIGURED_CASTLE_RUINS);
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_underground_cabin"), CONFIGURED_UNDERGROUND_CABIN);
        Registry.register(registry, new ResourceLocation(UnbelievableMod.MODID, "configured_mountain_fortress"), CONFIGURED_MOUNTAIN_FORTRESS);
    }
}
