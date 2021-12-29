package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.fmllegacy.RegistryObject;

public class BlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {
        this.add(Registration.RUBY_ORE.get(), (block) -> createOreDrop(Registration.RUBY_ORE.get(), Registration.RUBY.get()));
        this.add(Registration.DEEPSLATE_RUBY_ORE.get(), (block) -> createOreDrop(Registration.DEEPSLATE_RUBY_ORE.get(), Registration.RUBY.get()));
        this.dropSelf(Registration.RUBY_BLOCK.get());

        this.add(Registration.SAPPHIRE_ORE.get(), (block) -> createOreDrop(Registration.SAPPHIRE_ORE.get(), Registration.SAPPHIRE.get()));
        this.add(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), (block) -> createOreDrop(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), Registration.SAPPHIRE.get()));
        this.dropSelf(Registration.SAPPHIRE_BLOCK.get());


        this.dropSelf(Registration.BAMBOO_BLOCK.get());
        this.add(Registration.BAMBOO_BLOCK_SLAB.get(), (block) -> createSlabItemTable(Registration.BAMBOO_BLOCK_SLAB.get()));
        this.dropSelf(Registration.BAMBOO_BLOCK_STAIRS.get());
        this.dropSelf(Registration.BAMBOO_BLOCK_FENCE.get());
        this.dropSelf(Registration.BAMBOO_BLOCK_FENCE_GATE.get());
        this.add(Registration.BAMBOO_DOOR.get(), (block -> createDoorTable(Registration.BAMBOO_DOOR.get())));
        this.dropSelf(Registration.BAMBOO_TRAPDOOR.get());
        this.dropSelf(Registration.BAMBOO_PRESSURE_PLATE.get());
        this.dropSelf(Registration.BAMBOO_BUTTON.get());


        this.dropSelf(Registration.QUARTZ_WALL.get());
        this.dropSelf(Registration.POLISHED_GRANITE_WALL.get());
        this.dropSelf(Registration.POLISHED_DIORITE_WALL.get());
        this.dropSelf(Registration.POLISHED_ANDESITE_WALL.get());


        this.add(Registration.SPRUCE_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.SPRUCE_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.BIRCH_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.BIRCH_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.JUNGLE_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.JUNGLE_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.ACACIA_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.ACACIA_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.DARK_OAK_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.DARK_OAK_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.CRIMSON_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.CRIMSON_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.WARPED_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.WARPED_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));
        this.add(Registration.BAMBOO_BOOKSHELF.get(), (block) -> createSingleItemTableWithSilkTouch(Registration.BAMBOO_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3)));

        this.dropSelf(Registration.OAK_TABLE.get());
        this.dropSelf(Registration.SPRUCE_TABLE.get());
        this.dropSelf(Registration.BIRCH_TABLE.get());
        this.dropSelf(Registration.JUNGLE_TABLE.get());
        this.dropSelf(Registration.ACACIA_TABLE.get());
        this.dropSelf(Registration.DARK_OAK_TABLE.get());
        this.dropSelf(Registration.CRIMSON_TABLE.get());
        this.dropSelf(Registration.WARPED_TABLE.get());
        this.dropSelf(Registration.BAMBOO_TABLE.get());

        this.dropSelf(Registration.OAK_CHAIR.get());
        this.dropSelf(Registration.SPRUCE_CHAIR.get());
        this.dropSelf(Registration.BIRCH_CHAIR.get());
        this.dropSelf(Registration.JUNGLE_CHAIR.get());
        this.dropSelf(Registration.ACACIA_CHAIR.get());
        this.dropSelf(Registration.DARK_OAK_CHAIR.get());
        this.dropSelf(Registration.CRIMSON_CHAIR.get());
        this.dropSelf(Registration.WARPED_CHAIR.get());
        this.dropSelf(Registration.BAMBOO_CHAIR.get());

        this.dropSelf(Registration.OAK_SHELF.get());
        this.dropSelf(Registration.SPRUCE_SHELF.get());
        this.dropSelf(Registration.BIRCH_SHELF.get());
        this.dropSelf(Registration.JUNGLE_SHELF.get());
        this.dropSelf(Registration.ACACIA_SHELF.get());
        this.dropSelf(Registration.DARK_OAK_SHELF.get());
        this.dropSelf(Registration.CRIMSON_SHELF.get());
        this.dropSelf(Registration.WARPED_SHELF.get());
        this.dropSelf(Registration.BAMBOO_SHELF.get());

        this.dropSelf(Registration.CUT_GOLD.get());
        this.add(Registration.CUT_GOLD_SLAB.get(), (block) -> createSlabItemTable(Registration.CUT_GOLD_SLAB.get()));
        this.dropSelf(Registration.CUT_GOLD_STAIRS.get());

        this.dropSelf(Registration.SAWMILL.get());


        this.add(Registration.GENERATOR.get(), (block) -> createStandardTable("generator", Registration.GENERATOR.get()).setParamSet(LootContextParamSets.BLOCK));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createStandardTable(String name, Block block) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block)
                        .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
                        .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
                                .copy("inv", "BlockEntityTag.inv", CopyNbtFunction.MergeStrategy.REPLACE)
                                .copy("energy", "BlockEntityTag.energy", CopyNbtFunction.MergeStrategy.REPLACE))
                        .apply(SetContainerContents.setContents().withEntry(DynamicLoot.dynamicEntry(new ResourceLocation("minecraft", "contents"))))
                );
        return LootTable.lootTable().withPool(builder);
    }
}
