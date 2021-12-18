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
                .add(Registration.GENERATOR.get())
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.RUBY_ORE.get())
                .add(Registration.DEEPSLATE_RUBY_ORE.get())
                .add(Registration.SAPPHIRE_BLOCK.get())
                .add(Registration.SAPPHIRE_ORE.get())
                .add(Registration.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(Registration.QUARTZ_WALL.get())
                .add(Registration.POLISHED_GRANITE_WALL.get())
                .add(Registration.POLISHED_DIORITE_WALL.get())
                .add(Registration.POLISHED_ANDESITE_WALL.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Registration.BAMBOO_BLOCK.get())
                .add(Registration.BAMBOO_BLOCK_SLAB.get())
                .add(Registration.BAMBOO_BLOCK_STAIRS.get())
                .add(Registration.BAMBOO_BLOCK_FENCE.get())
                .add(Registration.BAMBOO_BLOCK_FENCE_GATE.get())
                .add(Registration.BAMBOO_DOOR.get())
                .add(Registration.BAMBOO_TRAPDOOR.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.GENERATOR.get())
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.RUBY_ORE.get())
                .add(Registration.DEEPSLATE_RUBY_ORE.get())
                .add(Registration.SAPPHIRE_BLOCK.get())
                .add(Registration.SAPPHIRE_ORE.get())
                .add(Registration.DEEPSLATE_SAPPHIRE_ORE.get());
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
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.SAPPHIRE_BLOCK.get());
    }

    @Override
    public String getName() {
        return "UnbelievableMod Tag";
    }
}
