package com.yannick.unbelievablemod.world;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.world.structures.MountainFortressStructure;
import com.yannick.unbelievablemod.world.structures.UndergroundCabinStructure;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Structures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, UnbelievableMod.MODID);

    // Structures
    public static final RegistryObject<StructureFeature<?>> UNDERGROUND_CABIN = DEFERRED_REGISTRY_STRUCTURE.register("underground_cabin", UndergroundCabinStructure::new);
    public static final RegistryObject<StructureFeature<?>> MOUNTAIN_FORTRESS = DEFERRED_REGISTRY_STRUCTURE.register("mountain_fortress", MountainFortressStructure::new);
}
