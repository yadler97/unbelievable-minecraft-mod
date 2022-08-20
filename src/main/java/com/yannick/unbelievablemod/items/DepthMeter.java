package com.yannick.unbelievablemod.items;

import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class DepthMeter extends Item {

    public DepthMeter(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        super.appendHoverText(itemStack, level, list, flags);
        int depth = getCurrentDepth(itemStack);
        list.add(Component.translatable("message.depth.tooltip", Integer.toString(depth)).withStyle(ChatFormatting.BLUE));
    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int itemSlot, boolean isSelected) {
        if (level.isClientSide) {
            itemStack.getOrCreateTag().putInt("depth", entity.getBlockY());
        } else {
            if (entity instanceof Player player) {
                if (player.getMainHandItem().is(itemStack.getItem())) {
                    ModCriteriaTriggers.USE_ITEM_AT_HEIGHT.trigger((ServerPlayer) player, player.getMainHandItem(), player.getBlockY());
                } else if (player.getOffhandItem().is(itemStack.getItem())) {
                    ModCriteriaTriggers.USE_ITEM_AT_HEIGHT.trigger((ServerPlayer) player, player.getOffhandItem(), player.getBlockY());
                }
            }
        }
    }

    public int getCurrentDepth(ItemStack stack) {
        return stack.hasTag() ? stack.getTag().getInt("depth") : 64;
    }

    public int getVisualDepthLevel(ItemStack stack) {
        int depth = getCurrentDepth(stack);
        if (depth < -48) {
            return 1;
        } else if (depth < -32) {
            return 2;
        } else if (depth < -16) {
            return 3;
        } else if (depth < 0) {
            return 4;
        } else if (depth < 16) {
            return 5;
        } else if (depth < 32) {
            return 6;
        } else if (depth < 48) {
            return 7;
        } else if (depth < 64) {
            return 8;
        } else if (depth < 80) {
            return 9;
        } else if (depth < 96) {
            return 10;
        } else {
            return 11;
        }
    }
}
