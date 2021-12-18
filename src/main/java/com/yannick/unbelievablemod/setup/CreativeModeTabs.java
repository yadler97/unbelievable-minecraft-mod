package com.yannick.unbelievablemod.setup;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModeTabs {
    public static final CreativeModeTab UNBELIEVABLE_TAB = new CreativeModeTab("unbelievablemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.SAPPHIRE.get());
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> items) {
            items.add(Registration.RUBY.get().getDefaultInstance());
            items.add(Registration.SAPPHIRE.get().getDefaultInstance());

            items.add(Registration.SAPPHIRE_PICKAXE.get().getDefaultInstance());
            items.add(Registration.SAPPHIRE_AXE.get().getDefaultInstance());
            items.add(Registration.SAPPHIRE_SHOVEL.get().getDefaultInstance());
            items.add(Registration.SAPPHIRE_HOE.get().getDefaultInstance());
            items.add(Registration.SAPPHIRE_SWORD.get().getDefaultInstance());

            items.add(Registration.ROSEGOLD_PICKAXE.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_AXE.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_SHOVEL.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_HOE.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_SWORD.get().getDefaultInstance());

            items.add(Registration.COPPER_WRENCH.get().getDefaultInstance());

            items.add(Registration.FRIED_EGG.get().getDefaultInstance());

            items.add(Registration.RUBY_BLOCK.get().asItem().getDefaultInstance());
            items.add(Registration.SAPPHIRE_BLOCK.get().asItem().getDefaultInstance());
            items.add(Registration.RUBY_ORE.get().asItem().getDefaultInstance());
            items.add(Registration.SAPPHIRE_ORE.get().asItem().getDefaultInstance());
            items.add(Registration.DEEPSLATE_RUBY_ORE.get().asItem().getDefaultInstance());
            items.add(Registration.DEEPSLATE_SAPPHIRE_ORE.get().asItem().getDefaultInstance());

            items.add(Registration.BAMBOO_BLOCK.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BLOCK_SLAB.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BLOCK_STAIRS.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BLOCK_FENCE.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BLOCK_FENCE_GATE.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_DOOR_ITEM.get().getDefaultInstance());
            items.add(Registration.BAMBOO_TRAPDOOR.get().asItem().getDefaultInstance());

            items.add(Registration.QUARTZ_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_GRANITE_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_DIORITE_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_ANDESITE_WALL.get().asItem().getDefaultInstance());
        }
    };
}
