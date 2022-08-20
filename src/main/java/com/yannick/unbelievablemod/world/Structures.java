package com.yannick.unbelievablemod.world;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.world.structures.MountainFortressStructure;
import com.yannick.unbelievablemod.world.structures.UndergroundCabinStructure;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Structures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, UnbelievableMod.MODID);

    // Structures
    public static final RegistryObject<StructureType<UndergroundCabinStructure>> UNDERGROUND_CABIN = DEFERRED_REGISTRY_STRUCTURE.register("underground_cabin", () -> () -> UndergroundCabinStructure.CODEC);
    public static final RegistryObject<StructureType<MountainFortressStructure>> MOUNTAIN_FORTRESS = DEFERRED_REGISTRY_STRUCTURE.register("mountain_fortress",  () -> () -> MountainFortressStructure.CODEC);
}
