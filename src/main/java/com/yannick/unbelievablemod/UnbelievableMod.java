package com.yannick.unbelievablemod;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.mojang.serialization.Codec;
import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.ClientSetup;
import com.yannick.unbelievablemod.setup.Config;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.world.OreGeneration;
import com.yannick.unbelievablemod.world.ConfiguredStructures;
import com.yannick.unbelievablemod.world.Structures;
import com.yannick.unbelievablemod.world.structures.AbandonedLumberjackHouseStructure;
import com.yannick.unbelievablemod.world.structures.CastleRuinsStructure;
import com.yannick.unbelievablemod.world.structures.MountainFortressStructure;
import com.yannick.unbelievablemod.world.structures.UndergroundCabinStructure;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnbelievableMod.MODID)
public class UnbelievableMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "unbelievablemod";

    public UnbelievableMod() {
        Registration.init();
        Config.init();
        ModCriteriaTriggers.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Structures.DEFERRED_REGISTRY_STRUCTURE.register(bus);
        bus.addListener(this::setup);
        bus.addListener(ClientSetup::setup);

        // Register ourselves for server and other game events we are interested in
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.NORMAL, CastleRuinsStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, AbandonedLumberjackHouseStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, UndergroundCabinStructure::setupStructureSpawns);
        forgeBus.addListener(EventPriority.NORMAL, MountainFortressStructure::setupStructureSpawns);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGeneration.registerOres();
            Structures.setupStructures();
            ConfiguredStructures.registerConfiguredStructures();
        });
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerLevel serverLevel){
            ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();

            if (chunkGenerator instanceof FlatLevelSource && serverLevel.dimension().equals(Level.OVERWORLD)) {
                return;
            }

            StructureSettings worldStructureConfig = chunkGenerator.getSettings();

            HashMap<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap = new HashMap<>();

            for (Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet()) {
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if (biomeCategory != Biome.BiomeCategory.OCEAN && biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE) {
                    associateBiomeToConfiguredStructure(STStructureToMultiMap, ConfiguredStructures.CONFIGURED_CASTLE_RUINS, biomeEntry.getKey());
                    associateBiomeToConfiguredStructure(STStructureToMultiMap, ConfiguredStructures.CONFIGURED_UNDERGROUND_CABIN, biomeEntry.getKey());
                }
                if (biomeCategory == Biome.BiomeCategory.EXTREME_HILLS) {
                    associateBiomeToConfiguredStructure(STStructureToMultiMap, ConfiguredStructures.CONFIGURED_ABANDONED_LUMBERJACK_HOUSE, biomeEntry.getKey());
                }
                if (biomeCategory == Biome.BiomeCategory.MOUNTAIN) {
                    associateBiomeToConfiguredStructure(STStructureToMultiMap, ConfiguredStructures.CONFIGURED_MOUNTAIN_FORTRESS, biomeEntry.getKey());
                }
            }

            ImmutableMap.Builder<StructureFeature<?>, ImmutableMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> tempStructureToMultiMap = ImmutableMap.builder();
            worldStructureConfig.configuredStructures.entrySet().stream().filter(entry -> !STStructureToMultiMap.containsKey(entry.getKey())).forEach(tempStructureToMultiMap::put);

            STStructureToMultiMap.forEach((key, value) -> tempStructureToMultiMap.put(key, ImmutableMultimap.copyOf(value)));

            worldStructureConfig.configuredStructures = tempStructureToMultiMap.build();


            try {
                if (GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(chunkGenerator));
                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            } catch(Exception e) {
                UnbelievableMod.LOGGER.error("Was unable to check if " + serverLevel.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(worldStructureConfig.structureConfig());
            tempMap.putIfAbsent(Structures.CASTLE_RUINS.get(), StructureSettings.DEFAULTS.get(Structures.CASTLE_RUINS.get()));
            tempMap.putIfAbsent(Structures.ABANDONED_LUMBERJACK_HOUSE.get(), StructureSettings.DEFAULTS.get(Structures.ABANDONED_LUMBERJACK_HOUSE.get()));
            tempMap.putIfAbsent(Structures.UNDERGROUND_CABIN.get(), StructureSettings.DEFAULTS.get(Structures.UNDERGROUND_CABIN.get()));
            tempMap.putIfAbsent(Structures.MOUNTAIN_FORTRESS.get(), StructureSettings.DEFAULTS.get(Structures.MOUNTAIN_FORTRESS.get()));
            worldStructureConfig.structureConfig = tempMap;
        }
    }

    private static void associateBiomeToConfiguredStructure(Map<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap, ConfiguredStructureFeature<?, ?> configuredStructureFeature, ResourceKey<Biome> biomeRegistryKey) {
        STStructureToMultiMap.putIfAbsent(configuredStructureFeature.feature, HashMultimap.create());
        HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>> configuredStructureToBiomeMultiMap = STStructureToMultiMap.get(configuredStructureFeature.feature);
        if (configuredStructureToBiomeMultiMap.containsValue(biomeRegistryKey)) {
            UnbelievableMod.LOGGER.error("""
                    Detected 2 ConfiguredStructureFeatures that share the same base StructureFeature trying to be added to same biome. One will be prevented from spawning.
                    This issue happens with vanilla too and is why a Snowy Village and Plains Village cannot spawn in the same biome because they both use the Village base structure.
                    The two conflicting ConfiguredStructures are: {}, {}
                    The biome that is attempting to be shared: {}
                """,
                    BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureFeature),
                    BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(configuredStructureToBiomeMultiMap.entries().stream().filter(e -> e.getValue() == biomeRegistryKey).findFirst().get().getKey()),
                    biomeRegistryKey
            );
        } else {
            configuredStructureToBiomeMultiMap.put(configuredStructureFeature, biomeRegistryKey);
        }
    }
}
