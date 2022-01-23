package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BlockLootTables extends BlockLoot {

    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_SMELTING = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Registration.SMELTING.get(), MinMaxBounds.Ints.atLeast(1))));

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

        this.dropSelf(Registration.GRANITE_BRICKS.get());
        this.dropSelf(Registration.DIORITE_BRICKS.get());
        this.dropSelf(Registration.ANDESITE_BRICKS.get());
        this.add(Registration.GRANITE_BRICK_SLAB.get(), (block) -> createSlabItemTable(Registration.GRANITE_BRICK_SLAB.get()));
        this.add(Registration.DIORITE_BRICK_SLAB.get(), (block) -> createSlabItemTable(Registration.DIORITE_BRICK_SLAB.get()));
        this.add(Registration.ANDESITE_BRICK_SLAB.get(), (block) -> createSlabItemTable(Registration.ANDESITE_BRICK_SLAB.get()));
        this.dropSelf(Registration.GRANITE_BRICK_STAIRS.get());
        this.dropSelf(Registration.DIORITE_BRICK_STAIRS.get());
        this.dropSelf(Registration.ANDESITE_BRICK_STAIRS.get());
        this.dropSelf(Registration.GRANITE_PILLAR.get());
        this.dropSelf(Registration.DIORITE_PILLAR.get());
        this.dropSelf(Registration.ANDESITE_PILLAR.get());


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

        this.add(Blocks.IRON_ORE, (block) -> createSingleItemWithSmeltingAndSilkTouch(Blocks.IRON_ORE, Items.IRON_INGOT, Items.RAW_IRON));
        this.add(Blocks.DEEPSLATE_IRON_ORE, (block) -> createSingleItemWithSmeltingAndSilkTouch(Blocks.DEEPSLATE_IRON_ORE, Items.IRON_INGOT, Items.RAW_IRON));
        this.add(Blocks.COPPER_ORE, (block) -> createCopperOreDropWithSmelting(Blocks.COPPER_ORE, Items.COPPER_INGOT, Items.RAW_COPPER));
        this.add(Blocks.DEEPSLATE_COPPER_ORE, (block) -> createCopperOreDropWithSmelting(Blocks.DEEPSLATE_COPPER_ORE, Items.COPPER_INGOT, Items.RAW_COPPER));
        this.add(Blocks.GOLD_ORE, (block) -> createSingleItemWithSmeltingAndSilkTouch(Blocks.GOLD_ORE, Items.GOLD_INGOT, Items.RAW_GOLD));
        this.add(Blocks.DEEPSLATE_GOLD_ORE, (block) -> createSingleItemWithSmeltingAndSilkTouch(Blocks.DEEPSLATE_GOLD_ORE, Items.GOLD_INGOT, Items.RAW_GOLD));

        this.add(Blocks.ANCIENT_DEBRIS, (block) -> createSingleItemWithSmelting(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP));
        this.add(Blocks.SAND, (block) -> createSingleItemWithSmelting(Blocks.SAND, Items.GLASS));
        this.add(Blocks.RED_SAND, (block) -> createSingleItemWithSmelting(Blocks.RED_SAND, Items.GLASS));
        this.add(Blocks.SANDSTONE, (block) -> createSingleItemWithSmelting(Blocks.SANDSTONE, Items.SMOOTH_SANDSTONE));
        this.add(Blocks.RED_SANDSTONE, (block) -> createSingleItemWithSmelting(Blocks.RED_SANDSTONE, Items.SMOOTH_RED_SANDSTONE));
        this.add(Blocks.NETHERRACK, (block) -> createSingleItemWithSmelting(Blocks.NETHERRACK, Items.NETHER_BRICK));
        this.add(Blocks.COBBLESTONE, (block) -> createSingleItemWithSmelting(Blocks.COBBLESTONE, Items.STONE));
        this.add(Blocks.COBBLED_DEEPSLATE, (block) -> createSingleItemWithSmelting(Blocks.COBBLED_DEEPSLATE, Items.DEEPSLATE));
        this.add(Blocks.QUARTZ_BLOCK, (block) -> createSingleItemWithSmelting(Blocks.QUARTZ_BLOCK, Items.SMOOTH_QUARTZ));
        this.add(Blocks.BASALT, (block) -> createSingleItemWithSmelting(Blocks.BASALT, Items.SMOOTH_BASALT));
        this.add(Blocks.CLAY, (block) -> createClayDrop(Blocks.CLAY, Items.TERRACOTTA, Items.CLAY_BALL));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        Collection<Block> blocks = new ArrayList<>(Collections.emptyList());
        Collection<RegistryObject<Block>> modBlocks = Registration.BLOCKS.getEntries();
        modBlocks.forEach((block) -> blocks.add(block.get()));
        blocks.add(Blocks.IRON_ORE);
        blocks.add(Blocks.DEEPSLATE_IRON_ORE);
        blocks.add(Blocks.COPPER_ORE);
        blocks.add(Blocks.DEEPSLATE_COPPER_ORE);
        blocks.add(Blocks.GOLD_ORE);
        blocks.add(Blocks.DEEPSLATE_GOLD_ORE);
        blocks.add(Blocks.ANCIENT_DEBRIS);
        blocks.add(Blocks.SAND);
        blocks.add(Blocks.RED_SAND);
        blocks.add(Blocks.SANDSTONE);
        blocks.add(Blocks.RED_SANDSTONE);
        blocks.add(Blocks.NETHERRACK);
        blocks.add(Blocks.COBBLESTONE);
        blocks.add(Blocks.COBBLED_DEEPSLATE);
        blocks.add(Blocks.QUARTZ_BLOCK);
        blocks.add(Blocks.BASALT);
        blocks.add(Blocks.CLAY);
        return blocks.stream()::iterator;
    }

    private LootTable.Builder createSingleItemWithSmeltingAndSilkTouch(Block silkTouchBlock, ItemLike smeltingItemLike, ItemLike noSilkTouchOrSmeltingItemLike) {
        LootPoolEntryContainer.Builder<?> alternativeEntryBuilder = applyExplosionDecay(silkTouchBlock, LootItem.lootTableItem(noSilkTouchOrSmeltingItemLike).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
        LootPoolEntryContainer.Builder<?> smeltingEntryBuilder = LootItem.lootTableItem(smeltingItemLike).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(HAS_SMELTING);
        return createSingleItemWithSmeltingAndSilkTouch(silkTouchBlock, smeltingEntryBuilder, alternativeEntryBuilder);
    }

    private LootTable.Builder createCopperOreDropWithSmelting(Block silkTouchBlock, ItemLike smeltingItemLike, ItemLike noSilkTouchOrSmeltingItemLike) {
        LootPoolEntryContainer.Builder<?> alternativeEntryBuilder = applyExplosionDecay(silkTouchBlock, LootItem.lootTableItem(noSilkTouchOrSmeltingItemLike).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))));
        LootPoolEntryContainer.Builder<?> smeltingEntryBuilder = LootItem.lootTableItem(smeltingItemLike).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).when(HAS_SMELTING);
        return createSingleItemWithSmeltingAndSilkTouch(silkTouchBlock, smeltingEntryBuilder, alternativeEntryBuilder);
    }

    private LootTable.Builder createClayDrop(Block silkTouchBlock, ItemLike smeltingItemLike, ItemLike noSilkTouchOrSmeltingItemLike) {
        LootPoolEntryContainer.Builder<?> alternativeEntryBuilder = applyExplosionDecay(silkTouchBlock, LootItem.lootTableItem(noSilkTouchOrSmeltingItemLike).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))));
        LootPoolEntryContainer.Builder<?> smeltingEntryBuilder = LootItem.lootTableItem(smeltingItemLike).when(HAS_SMELTING);
        return createSingleItemWithSmeltingAndSilkTouch(silkTouchBlock, smeltingEntryBuilder, alternativeEntryBuilder);
    }

    private LootTable.Builder createSingleItemWithSmeltingAndSilkTouch(Block silkTouchBlock, LootPoolEntryContainer.Builder<?> smeltingEntryBuilder, LootPoolEntryContainer.Builder<?> alternativeEntryBuilder) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(silkTouchBlock).when(HAS_SILK_TOUCH).otherwise(smeltingEntryBuilder.otherwise(alternativeEntryBuilder))));
    }

    private LootTable.Builder createSingleItemWithSmelting(Block block, ItemLike smeltingItemLike) {
        LootPoolEntryContainer.Builder<?> alternativeEntryBuilder = applyExplosionCondition(block, LootItem.lootTableItem(block));
        LootPoolEntryContainer.Builder<?> smeltingEntryBuilder = LootItem.lootTableItem(smeltingItemLike).when(HAS_SMELTING);
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(smeltingEntryBuilder.otherwise(alternativeEntryBuilder)));
    }
}
