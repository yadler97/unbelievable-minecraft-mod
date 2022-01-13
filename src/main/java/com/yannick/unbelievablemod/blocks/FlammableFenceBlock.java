package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableFenceBlock extends FenceBlock {
    private final int fireSpreadSpeed;
    private final int flammability;

    public FlammableFenceBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState blockState, BlockGetter world, BlockPos pos, Direction face) {
        return this.fireSpreadSpeed;
    }

    @Override
    public int getFlammability(BlockState blockState, BlockGetter world, BlockPos pos, Direction face) {
        return this.flammability;
    }
}
