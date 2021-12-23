package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableTableBlock extends TableBlock {
    private final int fireSpreadSpeed;
    private final int flammability;

    public FlammableTableBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return this.fireSpreadSpeed;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return this.flammability;
    }
}
