package com.yannick.setup;

import com.yannick.blocks.GeneratorScreen;
import com.yannick.world.OreGeneration;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientSetup {

    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), GeneratorScreen::new);
        });
    }

    public static void setupCommon(FMLCommonSetupEvent event) {
        event.enqueueWork(OreGeneration::registerOres);
    }
}
