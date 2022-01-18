package com.yannick.unbelievablemod.items;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class WoodenMilkBucketItem extends TieredItem {
    public WoodenMilkBucketItem(Tiers tier, Properties properties) {
        super(tier, properties);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide) livingEntity.curePotionEffects(itemStack);
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        ItemStack returnStack = new ItemStack(Registration.WOODEN_BUCKET.get());

        if (livingEntity instanceof Player player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.swingingArm));
            if (itemStack != ItemStack.EMPTY && !itemStack.is(Items.AIR)) {
                int remainDurability = itemStack.getDamageValue();
                returnStack.setDamageValue(remainDurability);
                itemStack.shrink(1);
            } else {
                return ItemStack.EMPTY;
            }
        }

        return itemStack.isEmpty() ? returnStack : itemStack;
    }

    public int getUseDuration(ItemStack itemStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return ItemUtils.startUsingInstantly(level, player, interactionHand);
    }

    public ItemStack getContainerItem(ItemStack itemStack) {
        if (!hasContainerItem(itemStack)) {
            return ItemStack.EMPTY;
        }
        int remainDurability = itemStack.getDamageValue();
        ItemStack returnStack = new ItemStack(Registration.WOODEN_BUCKET.get());
        returnStack.setDamageValue(remainDurability);
        return returnStack;
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @javax.annotation.Nullable net.minecraft.nbt.CompoundTag nbt) {
        return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
    }
}
