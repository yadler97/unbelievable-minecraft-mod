package com.yannick.unbelievablemod.items;

import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class FuelDoubleHighBlockItem extends DoubleHighBlockItem {
    private final int burnTime;

    public FuelDoubleHighBlockItem(Block block, Properties properties, int burnTime) {
        super(block, properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
