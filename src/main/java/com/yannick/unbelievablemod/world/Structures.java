package com.yannick.unbelievablemod.world;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.world.structures.AbandonedLumberjackHouseStructure;
import com.yannick.unbelievablemod.world.structures.CastleRuinsStructure;
import com.yannick.unbelievablemod.world.structures.UndergroundCabinStructure;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class Structures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, UnbelievableMod.MODID);

    // Structures
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> ABANDONED_LUMBERJACK_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("abandoned_lumberjack_house", () -> (new AbandonedLumberjackHouseStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> CASTLE_RUINS = DEFERRED_REGISTRY_STRUCTURE.register("castle_ruins", () -> (new CastleRuinsStructure(JigsawConfiguration.CODEC)));
    public static final RegistryObject<StructureFeature<JigsawConfiguration>> UNDERGROUND_CABIN = DEFERRED_REGISTRY_STRUCTURE.register("underground_cabin", () -> (new UndergroundCabinStructure(JigsawConfiguration.CODEC)));

    public static void setupStructures() {
        setupMapSpacingAndLand(
                ABANDONED_LUMBERJACK_HOUSE.get(),
                new StructureFeatureConfiguration(100,
                        50,
                        987654321),
                true);

        setupMapSpacingAndLand(
                CASTLE_RUINS.get(),
                new StructureFeatureConfiguration(100,
                        50,
                        876543219),
                true);

        setupMapSpacingAndLand(
                UNDERGROUND_CABIN.get(),
                new StructureFeatureConfiguration(50,
                        20,
                        765432198),
                true);
    }

    public static <F extends StructureFeature<?>> void setupMapSpacingAndLand(F structure, StructureFeatureConfiguration StructureFeatureConfiguration, boolean transformSurroundingLand) {

        StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            StructureFeature.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<StructureFeature<?>>builder()
                            .addAll(StructureFeature.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }

        StructureSettings.DEFAULTS =
                ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
                        .putAll(StructureSettings.DEFAULTS)
                        .put(structure, StructureFeatureConfiguration)
                        .build();

        BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = settings.getValue().structureSettings().structureConfig();

            if (structureMap instanceof ImmutableMap) {
                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, StructureFeatureConfiguration);
                settings.getValue().structureSettings().structureConfig = tempMap;
            } else {
                structureMap.put(structure, StructureFeatureConfiguration);
            }
        });
    }
}
