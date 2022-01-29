package com.yannick.unbelievablemod.advancements;

import com.yannick.unbelievablemod.advancements.criteron.*;
import net.minecraft.advancements.CriteriaTriggers;

public class ModCriteriaTriggers extends CriteriaTriggers {

    public static AddItemToShelfTrigger ADD_ITEM_TO_SHELF = register(new AddItemToShelfTrigger());
    public static SapphireMineMaxDistanceTrigger SAPPHIRE_MINE_MAX_DISTANCE = register(new SapphireMineMaxDistanceTrigger());
    public static AddCushionToChairTrigger ADD_CUSHION_TO_CHAIR = register(new AddCushionToChairTrigger());
    public static MineWithSmeltingTrigger MINE_WITH_SMELTING = register(new MineWithSmeltingTrigger());
    public static UseItemAtHeightTrigger USE_ITEM_AT_HEIGHT = register(new UseItemAtHeightTrigger());

    public static void init() {}
}
