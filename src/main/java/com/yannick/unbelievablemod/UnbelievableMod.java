package com.yannick.unbelievablemod;

import com.mojang.serialization.Codec;
import com.yannick.unbelievablemod.setup.ClientSetup;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.world.OreGeneration;
import com.yannick.unbelievablemod.world.ConfiguredStructures;
import com.yannick.unbelievablemod.world.Structures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
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

import static net.minecraft.world.level.biome.Biome.BiomeCategory.EXTREME_HILLS;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnbelievableMod.MODID)
public class UnbelievableMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "unbelievablemod";

    public UnbelievableMod() {
        Registration.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Structures.DEFERRED_REGISTRY_STRUCTURE.register(bus);
        bus.addListener(this::setup);
        bus.addListener(ClientSetup::setup);

        // Register ourselves for server and other game events we are interested in
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGeneration.registerOres();
            Structures.setupStructures();
            ConfiguredStructures.registerConfiguredStructures();
        });
    }

    public void biomeModification(final BiomeLoadingEvent event) {
        if (event.getCategory().equals(EXTREME_HILLS)) {
            event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_ABANDONED_LUMBERJACK_HOUSE);
        }
        event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_CASTLE_RUINS);
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerLevel serverWorld) {

            try {
                if (GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if (cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            } catch (Exception e) {
                UnbelievableMod.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            if (serverWorld.getChunkSource().getGenerator() instanceof FlatLevelSource && serverWorld.dimension().equals(Level.OVERWORLD)) {
                return;
            }

            Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(Structures.ABANDONED_LUMBERJACK_HOUSE.get(), StructureSettings.DEFAULTS.get(Structures.ABANDONED_LUMBERJACK_HOUSE.get()));
            tempMap.putIfAbsent(Structures.CASTLE_RUINS.get(), StructureSettings.DEFAULTS.get(Structures.CASTLE_RUINS.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }
}
