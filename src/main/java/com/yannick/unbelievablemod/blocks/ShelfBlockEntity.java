package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class ShelfBlockEntity extends BlockEntity {

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

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Override
    public void load(CompoundTag tag) {
        itemHandler.deserializeNBT(tag.getCompound("inv"));

        super.load(tag);
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.put("inv", itemHandler.serializeNBT());

        return super.save(tag);
    }

    public void addItemToShelf(int slot) {
        itemHandler.insertItem(slot, new ItemStack(Items.PAPER), false);
    }
}
