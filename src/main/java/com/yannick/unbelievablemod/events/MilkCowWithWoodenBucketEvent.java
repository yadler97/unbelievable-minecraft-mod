package com.yannick.unbelievablemod.events;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MilkCowWithWoodenBucketEvent {

    @SubscribeEvent
    public static void onMilkCowWithWoodenBucket(PlayerInteractEvent.EntityInteract event) {
        Entity target = event.getTarget();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();

        if (target instanceof Cow && !((Cow) target).isBaby() && itemStack.is(Registration.WOODEN_BUCKET.get())) {
            itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.swingingArm));
            if (itemStack != ItemStack.EMPTY && !itemStack.is(Items.AIR)) {
                int remainDurability = itemStack.getDamageValue();
                player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
                ItemStack returnStack = new ItemStack(Registration.WOODEN_MILK_BUCKET.get());
                returnStack.setDamageValue(remainDurability);

                if (player.getAbilities().instabuild) {
                    if (!player.getInventory().contains(returnStack)) {
                        player.addItem(returnStack);
                    }
                } else {
                    player.setItemInHand(InteractionHand.MAIN_HAND, returnStack);
                }
            }
        }
    }
}
