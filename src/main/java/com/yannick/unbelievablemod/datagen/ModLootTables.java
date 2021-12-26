package com.yannick.unbelievablemod.datagen;

import com.google.common.collect.Sets;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class ModLootTables {
    private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
    private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceLocation CASTLE_RUINS = register("chests/castle_ruins");
    public static final ResourceLocation CASTLE_RUINS_BASEMENT = register("chests/castle_ruins_basement");
    public static final ResourceLocation ABANDONED_LUMBERJACK_HOUSE = register("chests/abandoned_lumberjack_house");

    private static ResourceLocation register(String path) {
        return register(new ResourceLocation(UnbelievableMod.MODID, path));
    }

    private static ResourceLocation register(ResourceLocation path) {
        if (LOCATIONS.add(path)) {
            return path;
        } else {
            throw new IllegalArgumentException(path + " is already a registered built-in loot table");
        }
    }

    public static Set<ResourceLocation> all() {
        return IMMUTABLE_LOCATIONS;
    }
}
