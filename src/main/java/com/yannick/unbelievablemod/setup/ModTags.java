package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> TABLES = createBlockTag("tables");
        public static final TagKey<Block> CHAIRS = createBlockTag("chairs");
        public static final TagKey<Block> SHELVES = createBlockTag("shelves");

        private static TagKey<Block> createBlockTag(String name) {
            return net.minecraft.tags.BlockTags.create(new ResourceLocation(UnbelievableMod.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TABLES = createItemTag("tables");
        public static final TagKey<Item> CHAIRS = createItemTag("chairs");
        public static final TagKey<Item> SHELVES = createItemTag("shelves");

        private static TagKey<Item> createItemTag(String name) {
            return net.minecraft.tags.ItemTags.create(new ResourceLocation(UnbelievableMod.MODID, name));
        }
    }
}
