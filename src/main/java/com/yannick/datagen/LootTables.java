package com.yannick.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yannick.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.LootTableProvider;
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

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LootTables extends LootTableProvider {

    private final DataGenerator generator;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public LootTables(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }

    @Override
    public void run(HashCache cache) {
        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        tables.put(Registration.GENERATOR.get().getLootTable(), createStandardTable("generator", Registration.GENERATOR.get()).setParamSet(LootContextParamSets.BLOCK).build());
        tables.put(Registration.SAPPHIRE_BLOCK.get().getLootTable(), createStandardTable("sapphire_block", Registration.SAPPHIRE_BLOCK.get()).setParamSet(LootContextParamSets.BLOCK).build());
        tables.put(Registration.QUARTZ_WALL.get().getLootTable(), createStandardTable("quartz_wall", Registration.QUARTZ_WALL.get()).setParamSet(LootContextParamSets.BLOCK).build());
        writeTables(cache, tables);
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

    private void writeTables(HashCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                DataProvider.save(GSON, cache, net.minecraft.world.level.storage.loot.LootTables.serialize(lootTable), path);
            } catch (IOException e) {
                UnbelievableMod.LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }
}
