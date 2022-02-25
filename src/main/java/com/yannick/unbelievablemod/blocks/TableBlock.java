package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.setup.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class TableBlock extends Block implements SimpleWaterloggedBlock {

    private final int fireSpreadSpeed;
    private final int flammability;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    public TableBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
        this.registerDefaultState(this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(NORTH, Boolean.FALSE)
                .setValue(EAST, Boolean.FALSE)
                .setValue(SOUTH, Boolean.FALSE)
                .setValue(WEST, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        FluidState fluidState = level.getFluidState(pos);

        if (Config.CONNECTING_TABLES.get()) {
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)
                    .setValue(NORTH, level.getBlockState(pos.north()).is(this))
                    .setValue(EAST, level.getBlockState(pos.east()).is(this))
                    .setValue(SOUTH, level.getBlockState(pos.south()).is(this))
                    .setValue(WEST, level.getBlockState(pos.west()).is(this));
        } else {
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState>  builder) {
        builder.add(WATERLOGGED, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        return Stream.of(
                !blockState.getValue(NORTH) && !blockState.getValue(EAST) ? Block.box(13, 0, 1, 15, 14, 3) : Block.box(0, 0, 0, 0, 0, 0),
                !blockState.getValue(EAST) && !blockState.getValue(SOUTH) ? Block.box(13, 0, 13, 15, 14, 15) : Block.box(0, 0, 0, 0, 0, 0),
                !blockState.getValue(SOUTH) && !blockState.getValue(WEST) ? Block.box(1, 0, 13, 3, 14, 15) : Block.box(0, 0, 0, 0, 0, 0),
                !blockState.getValue(WEST) && !blockState.getValue(NORTH) ? Block.box(1, 0, 1, 3, 14, 3) : Block.box(0, 0, 0, 0, 0, 0),
                Block.box(0, 14, 0, 16, 16, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return this.fireSpreadSpeed;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return this.flammability;
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos pos, BlockState blockState, FluidState fluidState) {
        return SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, pos, blockState, fluidState);
    }

    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos pos, BlockState blockState, Fluid fluid) {
        return SimpleWaterloggedBlock.super.canPlaceLiquid(blockGetter, pos, blockState, fluid);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState facingBlockState, LevelAccessor levelAccessor, BlockPos currentPos, BlockPos neighborPos) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        if (Config.CONNECTING_TABLES.get()) {
            return switch (direction) {
                case NORTH -> blockState.setValue(NORTH, facingBlockState.is(this));
                case EAST -> blockState.setValue(EAST, facingBlockState.is(this));
                case SOUTH -> blockState.setValue(SOUTH, facingBlockState.is(this));
                case WEST -> blockState.setValue(WEST, facingBlockState.is(this));
                default -> blockState;
            };
        } else {
            return switch (direction) {
                case NORTH -> blockState.setValue(NORTH, false);
                case EAST -> blockState.setValue(EAST, false);
                case SOUTH -> blockState.setValue(SOUTH, false);
                case WEST -> blockState.setValue(WEST, false);
                default -> blockState;
            };
        }
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos pos, PathComputationType pathComputationType) {
        if (pathComputationType == PathComputationType.WATER) {
            return blockGetter.getFluidState(pos).is(FluidTags.WATER);
        }

        return false;
    }
}
