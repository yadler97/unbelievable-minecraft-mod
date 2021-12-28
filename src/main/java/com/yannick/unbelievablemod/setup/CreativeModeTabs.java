package com.yannick.unbelievablemod.setup;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

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

            items.add(Registration.ROSEGOLD_HELMET.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_CHESTPLATE.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_LEGGINGS.get().getDefaultInstance());
            items.add(Registration.ROSEGOLD_BOOTS.get().getDefaultInstance());

            items.add(Registration.COPPER_WRENCH.get().getDefaultInstance());

            items.add(Items.BUNDLE.getDefaultInstance());

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
            items.add(Registration.BAMBOO_PRESSURE_PLATE.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BUTTON.get().asItem().getDefaultInstance());

            items.add(Registration.QUARTZ_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_GRANITE_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_DIORITE_WALL.get().asItem().getDefaultInstance());
            items.add(Registration.POLISHED_ANDESITE_WALL.get().asItem().getDefaultInstance());

            items.add(Registration.SPRUCE_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.BIRCH_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.JUNGLE_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.ACACIA_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.DARK_OAK_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.CRIMSON_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.WARPED_BOOKSHELF.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_BOOKSHELF.get().asItem().getDefaultInstance());

            items.add(Registration.OAK_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.SPRUCE_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.BIRCH_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.JUNGLE_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.ACACIA_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.DARK_OAK_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.CRIMSON_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.WARPED_TABLE.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_TABLE.get().asItem().getDefaultInstance());

            items.add(Registration.OAK_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.SPRUCE_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.BIRCH_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.JUNGLE_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.ACACIA_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.DARK_OAK_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.CRIMSON_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.WARPED_CHAIR.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_CHAIR.get().asItem().getDefaultInstance());

            items.add(Registration.OAK_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.SPRUCE_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.BIRCH_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.JUNGLE_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.ACACIA_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.DARK_OAK_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.CRIMSON_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.WARPED_SHELF.get().asItem().getDefaultInstance());
            items.add(Registration.BAMBOO_SHELF.get().asItem().getDefaultInstance());

            items.add(Registration.CUT_GOLD.get().asItem().getDefaultInstance());
            items.add(Registration.CUT_GOLD_SLAB.get().asItem().getDefaultInstance());
            items.add(Registration.CUT_GOLD_STAIRS.get().asItem().getDefaultInstance());
        }
    };
}
