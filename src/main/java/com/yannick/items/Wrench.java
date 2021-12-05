package com.yannick.items;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Wrench extends TieredItem implements Vanishable {
    public Wrench(Item.Properties properties) {
        super(Tiers.COPPER, properties);
    }

    public boolean canAttackBlock(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if (!level.isClientSide) {
            this.handleInteraction(player, blockState, level, blockPos, false, player.getItemInHand(InteractionHand.MAIN_HAND));
        }

        return false;
    }

    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        if (!level.isClientSide && player != null) {
            BlockPos blockpos = context.getClickedPos();
            if (!this.handleInteraction(player, level.getBlockState(blockpos), level, blockpos, true, context.getItemInHand())) {
                return InteractionResult.FAIL;
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private boolean handleInteraction(Player player, BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, boolean isRightClick, ItemStack itemStack) {
        Block block = blockState.getBlock();
        if (block.getTags().contains(BlockTags.BEDS.getName()) || block.getTags().contains(BlockTags.BUTTONS.getName()) ||
                block.getTags().contains(BlockTags.FENCE_GATES.getName()) || block.getTags().contains(BlockTags.WALL_SIGNS.getName()) ||
                block == Blocks.LEVER || block == Blocks.TRIPWIRE_HOOK || block == Blocks.LADDER || block == Blocks.BELL || block == Blocks.WALL_TORCH ||
                block == Blocks.SOUL_WALL_TORCH || block == Blocks.REDSTONE_WALL_TORCH || block == Blocks.PISTON_HEAD || block == Blocks.MOVING_PISTON) {
            return false;
        }
        if (block == Blocks.STICKY_PISTON || block == Blocks.PISTON) {
            if (Objects.equals(blockState.getValues().get(BlockStateProperties.EXTENDED), true)) {
                return false;
            }
        }
        if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
            if (!(Objects.equals(blockState.getValues().get(BlockStateProperties.CHEST_TYPE), ChestType.SINGLE))) {
                return false;
            }
        }
        StateDefinition<Block, BlockState> stateDefinition = block.getStateDefinition();
        Collection<Property<?>> collection = new ArrayList<>(Collections.emptyList());
        stateDefinition.getProperties().forEach(p -> {
            if (p instanceof DirectionProperty || (p instanceof EnumProperty && p.getName().equals("axis"))) {
                collection.add(p);
            }
        });
        String s = Registry.BLOCK.getKey(block).toString();
        if (collection.isEmpty()) {
            return false;
        } else {
            CompoundTag compoundtag = itemStack.getOrCreateTagElement("WrenchProperty");
            String s1 = compoundtag.getString(s);
            Property<?> property = stateDefinition.getProperty(s1);
            if (isRightClick) {
                if (property == null) {
                    property = collection.iterator().next();
                }

                BlockState blockstate = cycleState(blockState, property, player.isSecondaryUseActive());
                levelAccessor.setBlock(blockPos, blockstate, 18);
                itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.swingingArm));
            } else {
                property = getRelative(collection, property, player.isSecondaryUseActive());
                String s2 = property.getName();
                compoundtag.putString(s, s2);
            }

            return true;
        }
    }

    private static <T extends Comparable<T>> BlockState cycleState(BlockState blockState, Property<T> property, boolean isSecondaryUseActive) {
        return blockState.setValue(property, getRelative(property.getPossibleValues(), blockState.getValue(property), isSecondaryUseActive));
    }

    private static <T> T getRelative(Iterable<T> collection, @Nullable T property, boolean isSecondaryHandActive) {
        return (T)(isSecondaryHandActive ? Util.findPreviousInIterable(collection, property) : Util.findNextInIterable(collection, property));
    }
}
