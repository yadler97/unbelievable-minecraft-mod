package com.yannick.unbelievablemod.events;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UseDepthMeterEvent {

    @SubscribeEvent
    public static void onUsingDepthMeter(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntity() instanceof Player player && !player.getLevel().isClientSide) {
            if (player.getMainHandItem().is(Registration.DEPTH_METER.get())) {
                ModCriteriaTriggers.USE_ITEM_AT_HEIGHT.trigger((ServerPlayer) player, player.getMainHandItem(), player.getBlockY());
            } else if (player.getOffhandItem().is(Registration.DEPTH_METER.get())) {
                ModCriteriaTriggers.USE_ITEM_AT_HEIGHT.trigger((ServerPlayer) player, player.getOffhandItem(), player.getBlockY());
            }
        }
    }
}
