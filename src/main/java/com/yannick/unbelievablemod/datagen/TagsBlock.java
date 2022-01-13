package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TagsBlock extends BlockTagsProvider {

    public TagsBlock(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UnbelievableMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.RUBY_ORE.get())
                .add(Registration.DEEPSLATE_RUBY_ORE.get())
                .add(Registration.SAPPHIRE_BLOCK.get())
                .add(Registration.SAPPHIRE_ORE.get())
                .add(Registration.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(Registration.QUARTZ_WALL.get())
                .add(Registration.POLISHED_GRANITE_WALL.get())
                .add(Registration.POLISHED_DIORITE_WALL.get())
                .add(Registration.POLISHED_ANDESITE_WALL.get())
                .add(Registration.CUT_GOLD.get())
                .add(Registration.CUT_GOLD_SLAB.get())
                .add(Registration.CUT_GOLD_STAIRS.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Registration.BAMBOO_BLOCK.get())
                .add(Registration.BAMBOO_BLOCK_SLAB.get())
                .add(Registration.BAMBOO_BLOCK_STAIRS.get())
                .add(Registration.BAMBOO_BLOCK_FENCE.get())
                .add(Registration.BAMBOO_BLOCK_FENCE_GATE.get())
                .add(Registration.BAMBOO_DOOR.get())
                .add(Registration.BAMBOO_TRAPDOOR.get())
                .add(Registration.SPRUCE_BOOKSHELF.get())
                .add(Registration.BIRCH_BOOKSHELF.get())
                .add(Registration.JUNGLE_BOOKSHELF.get())
                .add(Registration.ACACIA_BOOKSHELF.get())
                .add(Registration.DARK_OAK_BOOKSHELF.get())
                .add(Registration.CRIMSON_BOOKSHELF.get())
                .add(Registration.WARPED_BOOKSHELF.get())
                .add(Registration.BAMBOO_BOOKSHELF.get())
                .add(Registration.OAK_TABLE.get())
                .add(Registration.SPRUCE_TABLE.get())
                .add(Registration.BIRCH_TABLE.get())
                .add(Registration.JUNGLE_TABLE.get())
                .add(Registration.ACACIA_TABLE.get())
                .add(Registration.DARK_OAK_TABLE.get())
                .add(Registration.CRIMSON_TABLE.get())
                .add(Registration.WARPED_TABLE.get())
                .add(Registration.BAMBOO_TABLE.get())
                .add(Registration.OAK_CHAIR.get())
                .add(Registration.SPRUCE_CHAIR.get())
                .add(Registration.BIRCH_CHAIR.get())
                .add(Registration.JUNGLE_CHAIR.get())
                .add(Registration.ACACIA_CHAIR.get())
                .add(Registration.DARK_OAK_CHAIR.get())
                .add(Registration.CRIMSON_CHAIR.get())
                .add(Registration.WARPED_CHAIR.get())
                .add(Registration.BAMBOO_CHAIR.get())
                .add(Registration.OAK_SHELF.get())
                .add(Registration.SPRUCE_SHELF.get())
                .add(Registration.BIRCH_SHELF.get())
                .add(Registration.JUNGLE_SHELF.get())
                .add(Registration.ACACIA_SHELF.get())
                .add(Registration.DARK_OAK_SHELF.get())
                .add(Registration.CRIMSON_SHELF.get())
                .add(Registration.WARPED_SHELF.get())
                .add(Registration.BAMBOO_SHELF.get())
                .add(Registration.SAWMILL.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.RUBY_ORE.get())
                .add(Registration.DEEPSLATE_RUBY_ORE.get())
                .add(Registration.SAPPHIRE_BLOCK.get())
                .add(Registration.SAPPHIRE_ORE.get())
                .add(Registration.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(Registration.CUT_GOLD.get())
                .add(Registration.CUT_GOLD_SLAB.get())
                .add(Registration.CUT_GOLD_STAIRS.get());

        tag(BlockTags.WALLS)
                .add(Registration.QUARTZ_WALL.get())
                .add(Registration.POLISHED_GRANITE_WALL.get())
                .add(Registration.POLISHED_DIORITE_WALL.get())
                .add(Registration.POLISHED_ANDESITE_WALL.get());

        tag(BlockTags.SLABS)
                .add(Registration.BAMBOO_BLOCK_SLAB.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(Registration.BAMBOO_BLOCK_SLAB.get());

        tag(BlockTags.STAIRS)
                .add(Registration.BAMBOO_BLOCK_STAIRS.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(Registration.BAMBOO_BLOCK_STAIRS.get());

        tag(BlockTags.FENCES)
                .add(Registration.BAMBOO_BLOCK_FENCE.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(Registration.BAMBOO_BLOCK_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(Registration.BAMBOO_BLOCK_FENCE_GATE.get());

        tag(BlockTags.DOORS)
                .add(Registration.BAMBOO_DOOR.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(Registration.BAMBOO_DOOR.get());

        tag(BlockTags.TRAPDOORS)
                .add(Registration.BAMBOO_TRAPDOOR.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(Registration.BAMBOO_TRAPDOOR.get());

        tag(BlockTags.PRESSURE_PLATES)
                .add(Registration.BAMBOO_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(Registration.BAMBOO_PRESSURE_PLATE.get());

        tag(BlockTags.BUTTONS)
                .add(Registration.BAMBOO_BUTTON.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(Registration.BAMBOO_BUTTON.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.SAPPHIRE_BLOCK.get());

        tag(BlockTags.GUARDED_BY_PIGLINS)
                .add(Registration.CUT_GOLD.get())
                .add(Registration.CUT_GOLD_SLAB.get())
                .add(Registration.CUT_GOLD_STAIRS.get());
    }
}
