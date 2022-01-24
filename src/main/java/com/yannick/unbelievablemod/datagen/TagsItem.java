package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.ModTags;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
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

        tag(ModTags.Items.TABLES)
                .add(Registration.OAK_TABLE.get().asItem())
                .add(Registration.SPRUCE_TABLE.get().asItem())
                .add(Registration.BIRCH_TABLE.get().asItem())
                .add(Registration.JUNGLE_TABLE.get().asItem())
                .add(Registration.ACACIA_TABLE.get().asItem())
                .add(Registration.DARK_OAK_TABLE.get().asItem())
                .add(Registration.CRIMSON_TABLE.get().asItem())
                .add(Registration.WARPED_TABLE.get().asItem())
                .add(Registration.BAMBOO_TABLE.get().asItem());

        tag(ModTags.Items.CHAIRS)
                .add(Registration.OAK_CHAIR.get().asItem())
                .add(Registration.SPRUCE_CHAIR.get().asItem())
                .add(Registration.BIRCH_CHAIR.get().asItem())
                .add(Registration.JUNGLE_CHAIR.get().asItem())
                .add(Registration.ACACIA_CHAIR.get().asItem())
                .add(Registration.DARK_OAK_CHAIR.get().asItem())
                .add(Registration.CRIMSON_CHAIR.get().asItem())
                .add(Registration.WARPED_CHAIR.get().asItem())
                .add(Registration.BAMBOO_CHAIR.get().asItem());

        tag(ModTags.Items.SHELVES)
                .add(Registration.OAK_SHELF.get().asItem())
                .add(Registration.SPRUCE_SHELF.get().asItem())
                .add(Registration.BIRCH_SHELF.get().asItem())
                .add(Registration.JUNGLE_SHELF.get().asItem())
                .add(Registration.ACACIA_SHELF.get().asItem())
                .add(Registration.DARK_OAK_SHELF.get().asItem())
                .add(Registration.CRIMSON_SHELF.get().asItem())
                .add(Registration.WARPED_SHELF.get().asItem())
                .add(Registration.BAMBOO_SHELF.get().asItem());
    }
}
