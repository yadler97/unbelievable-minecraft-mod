package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;

import static net.minecraft.stats.Stats.CUSTOM;

public class ModStats {

    public static final ResourceLocation INTERACT_WITH_SAWMILL = makeCustomStat("interact_with_sawmill");
    public static final ResourceLocation ADD_ITEM_TO_SHELF = makeCustomStat("add_item_to_shelf");
    public static final ResourceLocation SIT_ON_CHAIR = makeCustomStat("sit_on_chair");

    public static void init() {}

    private static ResourceLocation makeCustomStat(String key) {
        ResourceLocation resourcelocation = new ResourceLocation(UnbelievableMod.MODID, key);
        Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
        CUSTOM.get(resourcelocation, StatFormatter.DEFAULT);
        return resourcelocation;
    }
}
