package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
                if (existingStack.getItem() == Items.AIR) {
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

    @Override
    public CompoundTag save(CompoundTag tag) {
        this.saveMetadataAndItems(tag);

        return super.save(tag);
    }

    public ItemStack addItemToShelf(int slot, ItemStack itemStack) {
        ItemStack returnStack = itemHandler.insertItem(slot, itemStack, false);
        if (returnStack.getItem() == Items.AIR) {
            this.items.set(slot, itemStack);
        } else {
            this.items.set(slot, new ItemStack(Items.AIR));
        }
        markUpdated();
        return returnStack;
    }

    private CompoundTag saveMetadataAndItems(CompoundTag tag) {
        super.save(tag);
        ContainerHelper.saveAllItems(tag, this.items, true);
        return tag;
    }

    @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return new ClientboundBlockEntityDataPacket(this.worldPosition, 100, this.getUpdateTag());
    }

    public CompoundTag getUpdateTag() {
        return this.saveMetadataAndItems(new CompoundTag());
    }

    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    private void markUpdated() {
        this.setChanged();
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
}
