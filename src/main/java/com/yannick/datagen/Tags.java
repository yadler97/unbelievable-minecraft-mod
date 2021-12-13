package com.yannick.datagen;

import com.yannick.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Tags extends BlockTagsProvider {

    public Tags(DataGenerator generator, ExistingFileHelper existingFileHelper) {
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
                .add(Registration.QUARTZ_WALL.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Registration.BAMBOO_BLOCK.get())
                .add(Registration.BAMBOO_BLOCK_SLAB.get())
                .add(Registration.BAMBOO_BLOCK_STAIRS.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.GENERATOR.get())
                .add(Registration.RUBY_BLOCK.get())
                .add(Registration.RUBY_ORE.get())
                .add(Registration.DEEPSLATE_RUBY_ORE.get())
                .add(Registration.SAPPHIRE_BLOCK.get())
                .add(Registration.SAPPHIRE_ORE.get())
                .add(Registration.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(BlockTags.WALLS)
                .add(Registration.QUARTZ_WALL.get());
        tag(BlockTags.SLABS)
                .add(Registration.BAMBOO_BLOCK_SLAB.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(Registration.BAMBOO_BLOCK_SLAB.get());
        tag(BlockTags.STAIRS)
                .add(Registration.BAMBOO_BLOCK_STAIRS.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(Registration.BAMBOO_BLOCK_STAIRS.get());
    }

    @Override
    public String getName() {
        return "UnbelievableMod Tag";
    }
}
