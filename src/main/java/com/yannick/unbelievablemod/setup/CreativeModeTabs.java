package com.yannick.unbelievablemod.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabs {
    public static final CreativeModeTab UNBELIEVABLE_TAB = new CreativeModeTab("unbelievablemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.SAPPHIRE.get());
        }
    };
}
