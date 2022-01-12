package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TagsItem extends ItemTagsProvider {

    public TagsItem(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, UnbelievableMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(Registration.RUBY.get())
                .add(Registration.SAPPHIRE.get());

        tag(ItemTags.PIGLIN_LOVED)
                .add(Registration.CUT_GOLD.get().asItem())
                .add(Registration.CUT_GOLD_SLAB.get().asItem())
                .add(Registration.CUT_GOLD_STAIRS.get().asItem());

        tag(ItemTags.DOORS)
                .add(Registration.BAMBOO_DOOR_ITEM.get());

        tag(ItemTags.BUTTONS)
                .add(Registration.BAMBOO_BUTTON.get().asItem());
    }
}
