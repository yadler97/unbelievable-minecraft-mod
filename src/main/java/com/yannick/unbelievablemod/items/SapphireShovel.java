package com.yannick.unbelievablemod.items;

import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.Config;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;
import java.util.List;

public class SapphireShovel extends ShovelItem {

    public SapphireShovel(Properties properties) {
        super(Tiers.SAPPHIRE, 1.5F, -3.0F, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flags) {
        super.appendHoverText(stack, level, list, flags);
        int distance = stack.hasTag() ? stack.getTag().getInt("distance") : 0;
        list.add(new TranslatableComponent("message.sapphire_distance.tooltip", Integer.toString(distance)).withStyle(ChatFormatting.BLUE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int distance = stack.getOrCreateTag().getInt("distance");
        distance++;
        if (distance > Config.MAX_SAPPHIRE_DISTANCE.get()) {
            distance = 0;
        }
        stack.getTag().putInt("distance", distance);
        if (level.isClientSide()) {
            player.sendMessage(new TranslatableComponent("message.sapphire_distance.change", Integer.toString(distance)), Util.NIL_UUID);
        }
        return InteractionResultHolder.success(stack);
    }

    public int getDistance(ItemStack stack) {
        return stack.hasTag() ? stack.getTag().getInt("distance") : 0;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean result = super.mineBlock(stack, level, state, pos, entity);
        if (result) {
            int distance = getDistance(stack);
            if (distance > 0) {
                CompoundTag tag = stack.getOrCreateTag();
                boolean mining = tag.getBoolean("mining");
                if (!mining) {
                    BlockHitResult hit = trace(level, entity);
                    if (hit.getType() == HitResult.Type.BLOCK) {
                        tag.putBoolean("mining", true);
                        for (int i = 0; i < distance; i++) {
                            BlockPos relative = pos.relative(hit.getDirection().getOpposite(), i + 1);
                            if (!tryHarvest(stack, entity, relative)) {
                                tag.putBoolean("mining", false);
                                return result;
                            }
                        }
                        if (getDistance(stack) == Config.MAX_SAPPHIRE_DISTANCE.get() && entity instanceof ServerPlayer player) {
                            ModCriteriaTriggers.SAPPHIRE_MINE_MAX_DISTANCE.trigger(player, stack);
                        }
                        tag.putBoolean("mining", false);
                    }
                }
            }
        }
        return result;
    }

    private boolean tryHarvest(ItemStack stack, LivingEntity entityLiving, BlockPos pos) {
        BlockState state = entityLiving.level.getBlockState(pos);
        if (isCorrectToolForDrops(stack, state)) {
            if (entityLiving instanceof ServerPlayer player) {
                return player.gameMode.destroyBlock(pos);
            }
        }
        return false;
    }

    private BlockHitResult trace(Level level, LivingEntity player) {
        double reach = player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue();
        Vec3 eye = player.getEyePosition(1.0f);
        Vec3 view = player.getViewVector(1.0f);
        Vec3 withReach = eye.add(view.x * reach, view.y * reach, view.z * reach);
        return level.clip(new ClipContext(eye, withReach, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));
    }
}
