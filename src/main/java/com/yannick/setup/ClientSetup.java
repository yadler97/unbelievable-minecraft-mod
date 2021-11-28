package com.yannick.setup;

import com.yannick.blocks.GeneratorScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), GeneratorScreen::new);
        });
    }
}
