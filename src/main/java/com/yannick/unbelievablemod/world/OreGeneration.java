package com.yannick.unbelievablemod.world;

import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

public class OreGeneration {

    public static final List<Holder<PlacedFeature>> OVERWORLD_ORES = new ArrayList<>();
    public static final List<Holder<PlacedFeature>> SAVANNA_DESERT_ORES = new ArrayList<>();
    public static final List<Holder<PlacedFeature>> JUNGLE_ORES = new ArrayList<>();
    public static final List<Holder<PlacedFeature>> NETHER_ORES = new ArrayList<>();
    public static final List<Holder<PlacedFeature>> END_ORES = new ArrayList<>();

    public static final List<OreConfiguration.TargetBlockState> ORE_SAPPHIRE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Registration.SAPPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Registration.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Registration.RUBY_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Registration.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_SMALL = FeatureUtils.register("ore_sapphire_small", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 4, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_LARGE = FeatureUtils.register("ore_sapphire_large", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 12, 0.7F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SAPPHIRE_BURIED = FeatureUtils.register("ore_sapphire_buried", Feature.ORE, new OreConfiguration(ORE_SAPPHIRE_TARGET_LIST, 8, 1.0F));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_SMALL = FeatureUtils.register("ore_ruby_small", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 4, 0.5F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_LARGE = FeatureUtils.register("ore_ruby_large", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 12, 0.7F));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY_BURIED = FeatureUtils.register("ore_ruby_buried", Feature.ORE, new OreConfiguration(ORE_RUBY_TARGET_LIST, 8, 1.0F));

    public static final Holder<PlacedFeature> ORE_SAPPHIRE_SMALL_PLACED = PlacementUtils.register("ore_sapphire_small_placed", ORE_SAPPHIRE_SMALL, commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_LARGE_PLACED = PlacementUtils.register("ore_sapphire_large_placed", ORE_SAPPHIRE_LARGE, rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_BURIED_PLACED = PlacementUtils.register("ore_sapphire_buried_placed", ORE_SAPPHIRE_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> ORE_RUBY_SMALL_PLACED = PlacementUtils.register("ore_ruby_small_placed", ORE_RUBY_SMALL, commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_RUBY_LARGE_PLACED = PlacementUtils.register("ore_ruby_large_placed", ORE_RUBY_LARGE, rareOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
    public static final Holder<PlacedFeature> ORE_RUBY_BURIED_PLACED = PlacementUtils.register("ore_ruby_buried_placed", ORE_RUBY_BURIED, commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> ORE_SAPPHIRE_SMALL_PLACED_SAVANNA_DESERT = PlacementUtils.register("ore_sapphire_small_placed_savanna_desert", ORE_SAPPHIRE_SMALL, commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_LARGE_PLACED_SAVANNA_DESERT = PlacementUtils.register("ore_sapphire_large_placed_savanna_desert", ORE_SAPPHIRE_LARGE, rareOrePlacement(18, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));
    public static final Holder<PlacedFeature> ORE_SAPPHIRE_BURIED_PLACED_SAVANNA_DESERT = PlacementUtils.register("ore_sapphire_buried_placed_savanna_desert", ORE_SAPPHIRE_BURIED, commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));

    public static final Holder<PlacedFeature> ORE_RUBY_SMALL_PLACED_JUNGLE = PlacementUtils.register("ore_ruby_small_placed_jungle", ORE_RUBY_SMALL, commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));
    public static final Holder<PlacedFeature> ORE_RUBY_LARGE_PLACED_JUNGLE = PlacementUtils.register("ore_ruby_large_placed_jungle", ORE_RUBY_LARGE, rareOrePlacement(18, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));
    public static final Holder<PlacedFeature> ORE_RUBY_BURIED_PLACED_JUNGLE = PlacementUtils.register("ore_ruby_buried_placed_jungle", ORE_RUBY_BURIED, commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-120), VerticalAnchor.aboveBottom(120))));

    public static void registerOres() {

        OVERWORLD_ORES.add(ORE_SAPPHIRE_SMALL_PLACED);
        OVERWORLD_ORES.add(ORE_SAPPHIRE_LARGE_PLACED);
        OVERWORLD_ORES.add(ORE_SAPPHIRE_BURIED_PLACED);

        OVERWORLD_ORES.add(ORE_RUBY_SMALL_PLACED);
        OVERWORLD_ORES.add(ORE_RUBY_LARGE_PLACED);
        OVERWORLD_ORES.add(ORE_RUBY_BURIED_PLACED);

        SAVANNA_DESERT_ORES.add(ORE_SAPPHIRE_SMALL_PLACED_SAVANNA_DESERT);
        SAVANNA_DESERT_ORES.add(ORE_SAPPHIRE_LARGE_PLACED_SAVANNA_DESERT);
        SAVANNA_DESERT_ORES.add(ORE_SAPPHIRE_BURIED_PLACED_SAVANNA_DESERT);

        JUNGLE_ORES.add(ORE_RUBY_SMALL_PLACED_JUNGLE);
        JUNGLE_ORES.add(ORE_RUBY_LARGE_PLACED_JUNGLE);
        JUNGLE_ORES.add(ORE_RUBY_BURIED_PLACED_JUNGLE);
    }

    @Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubscriber {

        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void biomeLoading(BiomeLoadingEvent event) {
            List<Holder<PlacedFeature>> features = event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES);
            switch (event.getCategory()) {
                case NETHER -> features.addAll(OreGeneration.NETHER_ORES);
                case THEEND -> features.addAll(OreGeneration.END_ORES);
                case SAVANNA, DESERT -> features.addAll(OreGeneration.SAVANNA_DESERT_ORES);
                case JUNGLE -> features.addAll(OreGeneration.JUNGLE_ORES);
                default -> features.addAll(OreGeneration.OVERWORLD_ORES);
            }
        }
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier amountModifier, PlacementModifier heightModifier) {
        return List.of(amountModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightModifier) {
        return orePlacement(CountPlacement.of(count), heightModifier);
    }

    private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightModifier);
    }
}
