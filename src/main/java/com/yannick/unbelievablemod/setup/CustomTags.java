package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class CustomTags {

    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> TABLES = createBlockTag("tables");
        public static final Tags.IOptionalNamedTag<Block> CHAIRS = createBlockTag("chairs");
        public static final Tags.IOptionalNamedTag<Block> SHELVES = createBlockTag("shelves");

        private static Tags.IOptionalNamedTag<Block> createBlockTag(String name) {
            return net.minecraft.tags.BlockTags.createOptional(new ResourceLocation(UnbelievableMod.MODID, name));
        }
    }

    public static class Items {
        public static final Tags.IOptionalNamedTag<Item> TABLES = createItemTag("tables");
        public static final Tags.IOptionalNamedTag<Item> CHAIRS = createItemTag("chairs");
        public static final Tags.IOptionalNamedTag<Item> SHELVES = createItemTag("shelves");

        private static Tags.IOptionalNamedTag<Item> createItemTag(String name) {
            return net.minecraft.tags.ItemTags.createOptional(new ResourceLocation(UnbelievableMod.MODID, name));
        }
    }
}
