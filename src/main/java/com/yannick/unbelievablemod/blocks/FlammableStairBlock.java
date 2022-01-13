package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableStairBlock extends StairBlock {
    private final int fireSpreadSpeed;
    private final int flammability;

    public FlammableStairBlock(java.util.function.Supplier<BlockState> blockState, Properties properties, int fireSpreadSpeed, int flammability) {
        super(blockState, properties);
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
