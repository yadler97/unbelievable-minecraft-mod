package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.gui.GeneratorScreen;
import com.yannick.unbelievablemod.gui.SawmillScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(Registration.GENERATOR_CONTAINER.get(), GeneratorScreen::new);
            MenuScreens.register(Registration.SAWMILL_MENU.get(), SawmillScreen::new);
        });

        ItemBlockRenderTypes.setRenderLayer(Registration.BAMBOO_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Registration.BAMBOO_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Registration.SAWMILL.get(), RenderType.cutout());
    }
}
