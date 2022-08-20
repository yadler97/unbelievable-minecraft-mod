package com.yannick.unbelievablemod.world.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BiomeModifiers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, UnbelievableMod.MODID);

    public static RegistryObject<Codec<OreBiomeModifier>> ORE_MODIFIER = BIOME_MODIFIERS.register("ores", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(OreBiomeModifier::biomes),
                    PlacedFeature.CODEC.fieldOf("feature").forGetter(OreBiomeModifier::feature)
            ).apply(builder, OreBiomeModifier::new)));

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIERS.register(eventBus);
    }
}
