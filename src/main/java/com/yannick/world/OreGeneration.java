package com.yannick.world;

import com.yannick.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {

    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> JUNGLE_DESERT_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> NETHER_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> END_ORES = new ArrayList<>();

    public static void registerOres() {
        ConfiguredFeature<?, ?> sapphire_ore = Feature.ORE.configured(new OreConfiguration(List.of(
                OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                        Registration.SAPPHIRE_ORE.get().defaultBlockState())), 1))
                .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(20))
                .squared().count(2);
        ConfiguredFeature<?, ?> deepslate_sapphire_ore = Feature.ORE.configured(new OreConfiguration(List.of(
                        OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                                Registration.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())), 3))
                .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(20))
                .squared().count(4);

        ConfiguredFeature<?, ?> sapphire_ore_jungle_desert = Feature.ORE.configured(new OreConfiguration(List.of(
                        OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                                Registration.SAPPHIRE_ORE.get().defaultBlockState())), 4))
                .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(40))
                .squared().count(3);
        ConfiguredFeature<?, ?> deepslate_sapphire_ore_jungle_desert = Feature.ORE.configured(new OreConfiguration(List.of(
                        OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                                Registration.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())), 12))
                .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(40))
                .squared().count(6);


        OVERWORLD_ORES.add(register("sapphire_ore", sapphire_ore));
        OVERWORLD_ORES.add(register("deepslate_sapphire_ore", deepslate_sapphire_ore));
        JUNGLE_DESERT_ORES.add(register("sapphire_ore_jungle_desert", sapphire_ore_jungle_desert));
        JUNGLE_DESERT_ORES.add(register("deepslate_sapphire_ore_jungle_desert", deepslate_sapphire_ore_jungle_desert));
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name, ConfiguredFeature<Config, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(UnbelievableMod.MODID, name), configuredFeature);
    }

    @Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {

        @SubscribeEvent
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            switch (event.getCategory()) {
                case NETHER -> OreGeneration.NETHER_ORES.forEach(ore -> features.add(() -> ore));
                case THEEND -> OreGeneration.END_ORES.forEach(ore -> features.add(() -> ore));
                case JUNGLE, DESERT -> OreGeneration.JUNGLE_DESERT_ORES.forEach(ore -> features.add(() -> ore));
                default -> OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }
}
