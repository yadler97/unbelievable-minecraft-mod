package com.yannick.unbelievablemod;

import com.yannick.unbelievablemod.setup.ClientSetup;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnbelievableMod.MODID)
public class UnbelievableMod {
    public static final String MODID = "unbelievablemod";

    public UnbelievableMod() {
        Registration.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(ClientSetup::setup);
        bus.addListener(ClientSetup::setupCommon);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}
