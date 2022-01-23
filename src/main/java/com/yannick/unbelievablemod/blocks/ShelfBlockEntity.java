package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.yannick.unbelievablemod.blocks.ShelfBlock.LIGHT_LEVEL;
import static com.yannick.unbelievablemod.blocks.ShelfBlock.LIT;

public class ShelfBlockEntity extends BlockEntity {

    private final NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);

    private final ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public ShelfBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Registration.SHELF_BE.get(), blockPos, blockState);
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        handler.invalidate();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(4) {

            @Override
            protected void onContentsChanged(int slot) {
                // To make sure the TE persists when the chunk is saved later we need to
                // mark it dirty every time the item handler changes
                setChanged();
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                ItemStack existingStack = this.getStackInSlot(slot);
                if (existingStack == ItemStack.EMPTY) {
                    return super.insertItem(slot, stack, simulate);
                }
                return super.extractItem(slot, 1, simulate);
            }
        };
    }

    @Override
    public void load(CompoundTag tag) {
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items);
        itemHandler.insertItem(0, items.get(0), false);
        itemHandler.insertItem(1, items.get(1), false);
        itemHandler.insertItem(2, items.get(2), false);
        itemHandler.insertItem(3, items.get(3), false);

        super.load(tag);
    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items, true);
    }

    public ItemStack addItemToShelf(Player player, int slot, ItemStack itemStack) {
        ItemStack returnStack = itemHandler.insertItem(slot, itemStack, false);
        if (returnStack == ItemStack.EMPTY) {
            this.items.set(slot, itemStack);
            ModCriteriaTriggers.ADD_ITEM_TO_SHELF.trigger((ServerPlayer) player, this.items);
        } else {
            this.items.set(slot, ItemStack.EMPTY);
        }
        markUpdated();
        return returnStack;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        ContainerHelper.saveAllItems(compoundtag, this.items, true);
        return compoundtag;
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    private void markUpdated() {
        this.setChanged();
        this.getLightEmission();
        if (this.getLevel() != null) {
            this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        if (tag != null) {
            loadClientData(tag);
        }
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket dataPacket) {
        CompoundTag tag = dataPacket.getTag();
        handleUpdateTag(tag);
    }

    private void loadClientData(CompoundTag tag) {
        this.items.clear();
        ContainerHelper.loadAllItems(tag, this.items);
    }

    public void getLightEmission() {
        int highestLightLevel = 0;
        for (ItemStack itemStack : items) {
            if (itemStack.getItem() instanceof BlockItem blockItem) {
                if (!(blockItem.getBlock() instanceof ShelfBlock)) {
                    int lightLevel = blockItem.getBlock().getLightEmission(blockItem.getBlock().defaultBlockState(), getLevel(), getBlockPos());
                    if (lightLevel != 0 && highestLightLevel < lightLevel) {
                        highestLightLevel = lightLevel;
                    }
                }
            }
        }

        if (level != null) {
            BlockState blockState = level.getBlockState(worldPosition);

            if (highestLightLevel == 0) {
                level.setBlock(worldPosition, blockState.setValue(LIT, Boolean.FALSE).setValue(LIGHT_LEVEL, 0), Block.UPDATE_ALL);
            } else {
                level.setBlock(worldPosition, blockState.setValue(LIT, Boolean.TRUE).setValue(LIGHT_LEVEL, highestLightLevel), Block.UPDATE_ALL);
            }
        }
    }
}
