package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        if (event.includeServer()) {
            generator.addProvider(true, new Recipes(generator));
            generator.addProvider(true, new Advancements(generator));
            generator.addProvider(true, new LootTables(generator));

            BlockTagsProvider blockTagProvider = new TagsBlock(generator, event.getExistingFileHelper());
            generator.addProvider(true, blockTagProvider);
            generator.addProvider(true, new TagsItem(generator, blockTagProvider, event.getExistingFileHelper()));
        }

        if (event.includeClient()) {
            generator.addProvider(true, new BlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new Items(generator, event.getExistingFileHelper()));
        }
    }
}
