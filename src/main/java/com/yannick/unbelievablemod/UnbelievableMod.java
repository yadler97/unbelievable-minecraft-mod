package com.yannick.unbelievablemod;

import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.*;
import com.yannick.unbelievablemod.world.OreGeneration;
import com.yannick.unbelievablemod.world.Structures;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UnbelievableMod.MODID)
public class UnbelievableMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "unbelievablemod";

    public UnbelievableMod() {
        Registration.init();
        Config.init();
        ModCriteriaTriggers.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Structures.DEFERRED_REGISTRY_STRUCTURE.register(bus);
        bus.addListener(this::setup);
        bus.addListener(ClientSetup::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGeneration.registerOres();
            ModStats.init();
            RecipeTypes.init();
        });
    }
}
