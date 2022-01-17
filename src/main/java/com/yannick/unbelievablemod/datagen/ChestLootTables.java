package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.ModLootTables;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.loot.ChestLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ChestLootTables extends ChestLoot {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer) {
        resourceLocationBuilderBiConsumer.accept(ModLootTables.CASTLE_RUINS, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(20))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT))
                        .add(LootItem.lootTableItem(Items.IRON_SWORD).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SHIELD).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_HELMET).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_BOOTS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_HORSE_ARMOR).setWeight(5))
                        .add(LootItem.lootTableItem(Items.BOW).setWeight(10))
                        .add(EmptyLootItem.emptyItem().setWeight(10)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.APPLE).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.BEEF).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.PAPER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Blocks.TORCH).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))));


        resourceLocationBuilderBiConsumer.accept(ModLootTables.CASTLE_RUINS_BASEMENT, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.DIAMOND))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(2))
                        .add(LootItem.lootTableItem(Registration.SAPPHIRE.get()))
                        .add(LootItem.lootTableItem(Registration.RUBY.get()))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(5).apply(EnchantRandomlyFunction.randomApplicableEnchantment()))
                        .add(LootItem.lootTableItem(Items.IRON_HELMET).setWeight(3))
                        .add(LootItem.lootTableItem(Items.IRON_CHESTPLATE).setWeight(3))
                        .add(LootItem.lootTableItem(Items.IRON_LEGGINGS).setWeight(3))
                        .add(LootItem.lootTableItem(Items.IRON_BOOTS).setWeight(3))
                        .add(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(3))
                        .add(EmptyLootItem.emptyItem().setWeight(5)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                        .add(LootItem.lootTableItem(Items.GOLD_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                        .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.LANTERN).setWeight(5).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));


        resourceLocationBuilderBiConsumer.accept(ModLootTables.ABANDONED_LUMBERJACK_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.LEATHER_HELMET).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_CHESTPLATE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_LEGGINGS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.LEATHER_BOOTS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.IRON_AXE).setWeight(5))
                        .add(EmptyLootItem.emptyItem().setWeight(10)))
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3.0F, 5.0F))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.BREAD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.SWEET_BERRIES).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.BOWL).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Blocks.TORCH).setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))));

        resourceLocationBuilderBiConsumer.accept(ModLootTables.UNDERGROUND_CABIN, LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BOOK).setWeight(20).apply((new EnchantRandomlyFunction.Builder()).withEnchantment(Registration.SMELTING.get())))
                        .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Registration.RUBY.get()).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Registration.SAPPHIRE.get()).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))))
                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(3.0F, 5.0F))
                        .add(LootItem.lootTableItem(Items.RAW_GOLD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                        .add(LootItem.lootTableItem(Items.RAW_IRON).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 6.0F))))
                        .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 8.0F))))
                        .add(LootItem.lootTableItem(Items.LANTERN).setWeight(5).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
    }
}
