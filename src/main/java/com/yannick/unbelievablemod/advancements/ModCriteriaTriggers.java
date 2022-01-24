package com.yannick.unbelievablemod.advancements;

import com.yannick.unbelievablemod.advancements.criteron.AddCushionToChairTrigger;
import com.yannick.unbelievablemod.advancements.criteron.AddItemToShelfTrigger;
import com.yannick.unbelievablemod.advancements.criteron.SapphireMineMaxDistanceTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class ModCriteriaTriggers extends CriteriaTriggers {
    public static AddItemToShelfTrigger ADD_ITEM_TO_SHELF = register(new AddItemToShelfTrigger());
    public static SapphireMineMaxDistanceTrigger SAPPHIRE_MINE_MAX_DISTANCE = register(new SapphireMineMaxDistanceTrigger());
    public static AddCushionToChairTrigger ADD_CUSHION_TO_CHAIR = register(new AddCushionToChairTrigger());

    public static void init() {
    }
}
