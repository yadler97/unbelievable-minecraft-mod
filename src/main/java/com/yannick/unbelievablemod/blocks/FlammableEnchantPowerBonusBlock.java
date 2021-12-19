package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;

public class FlammableEnchantPowerBonusBlock extends FlammableBlock {

    public FlammableEnchantPowerBonusBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties, fireSpreadSpeed, flammability);
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1;
    }
}
