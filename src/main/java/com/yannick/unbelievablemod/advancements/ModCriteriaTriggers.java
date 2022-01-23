package com.yannick.unbelievablemod.advancements;

import com.yannick.unbelievablemod.advancements.criteron.AddItemToShelfTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class ModCriteriaTriggers extends CriteriaTriggers {
    public static AddItemToShelfTrigger ADD_ITEM_TO_SHELF = register(new AddItemToShelfTrigger());

    public static void init() {
    }
}
