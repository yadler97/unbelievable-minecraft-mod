package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.client.ChairRenderer;
import com.yannick.unbelievablemod.client.ShelfRenderer;
import com.yannick.unbelievablemod.gui.SawmillScreen;
import com.yannick.unbelievablemod.items.DepthMeter;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static final ResourceLocation DEPTH_PROPERTY = new ResourceLocation(UnbelievableMod.MODID, "depth");

    public static void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(Registration.SAWMILL_MENU.get(), SawmillScreen::new);
            BlockEntityRenderers.register(Registration.SHELF_BE.get(), ShelfRenderer::new);
            EntityRenderers.register(Registration.CHAIR_ENTITY.get(), ChairRenderer::new);
            initDepthMeterOverrides();
        });

        ItemBlockRenderTypes.setRenderLayer(Registration.BAMBOO_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Registration.BAMBOO_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Registration.SAWMILL.get(), RenderType.cutout());
    }

    public static void initDepthMeterOverrides() {
        DepthMeter item = Registration.DEPTH_METER.get();
        ItemProperties.register(item, DEPTH_PROPERTY,
                (stack, level, entity, damage) -> item.getVisualDepthLevel(stack));
    }
}
