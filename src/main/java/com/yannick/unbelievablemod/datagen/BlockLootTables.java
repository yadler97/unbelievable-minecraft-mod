package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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
        this.add(Registration.RUBY_ORE.get(), (block) -> {
            return createOreDrop(Registration.RUBY_ORE.get(), Registration.RUBY.get());
        });
        this.add(Registration.DEEPSLATE_RUBY_ORE.get(), (block) -> {
            return createOreDrop(Registration.DEEPSLATE_RUBY_ORE.get(), Registration.RUBY.get());
        });
        this.dropSelf(Registration.RUBY_BLOCK.get());


        this.add(Registration.SAPPHIRE_ORE.get(), (block) -> {
            return createOreDrop(Registration.SAPPHIRE_ORE.get(), Registration.SAPPHIRE.get());
        });
        this.add(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), (block) -> {
            return createOreDrop(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), Registration.SAPPHIRE.get());
        });
        this.dropSelf(Registration.SAPPHIRE_BLOCK.get());


        this.dropSelf(Registration.BAMBOO_BLOCK.get());
        this.add(Registration.BAMBOO_BLOCK_SLAB.get(), (block) -> {
            return createSlabItemTable(Registration.BAMBOO_BLOCK_SLAB.get());
        });
        this.dropSelf(Registration.BAMBOO_BLOCK_STAIRS.get());
        this.dropSelf(Registration.BAMBOO_BLOCK_FENCE.get());
        this.dropSelf(Registration.BAMBOO_BLOCK_FENCE_GATE.get());
        this.add(Registration.BAMBOO_DOOR.get(), (block -> {
            return createDoorTable(Registration.BAMBOO_DOOR.get());
        }));
        this.dropSelf(Registration.BAMBOO_TRAPDOOR.get());


        this.dropSelf(Registration.QUARTZ_WALL.get());
        this.dropSelf(Registration.POLISHED_GRANITE_WALL.get());
        this.dropSelf(Registration.POLISHED_DIORITE_WALL.get());
        this.dropSelf(Registration.POLISHED_ANDESITE_WALL.get());

        this.add(Registration.GENERATOR.get(), (block) -> {
            return createStandardTable("generator", Registration.GENERATOR.get()).setParamSet(LootContextParamSets.BLOCK);
        });
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
