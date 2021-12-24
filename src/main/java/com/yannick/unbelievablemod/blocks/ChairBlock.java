package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ChairBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(4, 0, 4, 6, 6, 6),
            Block.box(4, 0, 10, 6, 6, 12),
            Block.box(10, 0, 10, 12, 6, 12),
            Block.box(10, 0, 4, 12, 6, 6),
            Block.box(3, 6, 3, 13, 8, 11),
            Block.box(3, 6, 11, 13, 19, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(10, 0, 4, 12, 6, 6),
            Block.box(10, 0, 10, 12, 6, 12),
            Block.box(4, 0, 4, 6, 6, 6),
            Block.box(4, 0, 10, 6, 6, 12),
            Block.box(5, 6, 3, 13, 8, 13),
            Block.box(3, 6, 3, 5, 19, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(10, 0, 10, 12, 6, 12),
            Block.box(4, 0, 10, 6, 6, 12),
            Block.box(10, 0, 4, 12, 6, 6),
            Block.box(4, 0, 4, 6, 6, 6),
            Block.box(3, 6, 5, 13, 8, 13),
            Block.box(3, 6, 3, 13, 19, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(4, 0, 10, 6, 6, 12),
            Block.box(4, 0, 4, 6, 6, 6),
            Block.box(10, 0, 10, 12, 6, 12),
            Block.box(10, 0, 4, 12, 6, 6),
            Block.box(3, 6, 3, 11, 8, 13),
            Block.box(11, 6, 3, 13, 19, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ChairBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState>  builder) {
        builder.add(FACING);
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return switch (blockState.getValue(FACING)) {
            case SOUTH -> SHAPE_S;
            case EAST -> SHAPE_E;
            case WEST -> SHAPE_W;
            default -> SHAPE_N;
        };
    }
}
