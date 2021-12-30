package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static net.minecraft.core.Direction.*;

public class ShelfBlock extends Block implements SimpleWaterloggedBlock {

    private final int fireSpreadSpeed;
    private final int flammability;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(1, 7, 8, 15, 9, 16),
            Block.box(0, 0, 8, 16, 1, 16),
            Block.box(0, 15, 8, 16, 16, 16),
            Block.box(15, 1, 8, 16, 15, 16),
            Block.box(0, 1, 8, 1, 15, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 7, 1, 8, 9, 15),
            Block.box(0, 0, 0, 8, 1, 16),
            Block.box(0, 15, 0, 8, 16, 16),
            Block.box(0, 1, 15, 8, 15, 16),
            Block.box(0, 1, 0, 8, 15, 1)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(1, 7, 0, 15, 9, 8),
            Block.box(0, 0, 0, 16, 1, 8),
            Block.box(0, 15, 0, 16, 16, 8),
            Block.box(0, 1, 0, 1, 15, 8),
            Block.box(15, 1, 0, 16, 15, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(8, 7, 1, 16, 9, 15),
            Block.box(8, 0, 0, 16, 1, 16),
            Block.box(8, 15, 0, 16, 16, 16),
            Block.box(8, 1, 0, 16, 15, 1),
            Block.box(8, 1, 15, 16, 15, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public ShelfBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            int clickedSlot = getClickedSlot(blockState, blockHitResult);
            UnbelievableMod.LOGGER.log(org.apache.logging.log4j.Level.INFO, "Clicked Slot: " + clickedSlot);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState>  builder) {
        builder.add(FACING, WATERLOGGED);
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

    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        return SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, blockState, fluidState);
    }

    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, Fluid fluid) {
        return SimpleWaterloggedBlock.super.canPlaceLiquid(blockGetter, blockPos, blockState, fluid);
    }

    public BlockState updateShape(BlockState p_56381_, Direction direction, BlockState blockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        if (p_56381_.getValue(WATERLOGGED)) {
            levelAccessor.getLiquidTicks().scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(p_56381_, direction, blockState, levelAccessor, blockPos, blockPos1);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        if (pathComputationType == PathComputationType.WATER) {
            return blockGetter.getFluidState(blockPos).is(FluidTags.WATER);
        }
        return false;
    }

    private int getClickedSlot(BlockState blockState, BlockHitResult blockHitResult) {
        Vec3 vec = blockHitResult.getLocation();
        double xd = Math.abs(vec.x % 1);
        double yd = Math.abs(vec.y % 1);
        double zd = Math.abs(vec.z % 1);

        switch (blockState.getValue(FACING)) {
            case SOUTH, NORTH -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == EAST || dir == WEST) && xd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (xd < 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (xd >= 0.5 && yd < 0.5) {
                        return 2;
                    }
                    if (xd < 0.5 && yd >= 0.5) {
                        return 3;
                    }
                    if (xd >= 0.5 && yd >= 0.5) {
                        return 4;
                    }
                }
            }
            case EAST, WEST -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == NORTH || dir == SOUTH) && zd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (zd < 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (zd >= 0.5 && yd < 0.5) {
                        return 2;
                    }
                    if (zd < 0.5 && yd >= 0.5) {
                        return 3;
                    }
                    if (zd >= 0.5 && yd >= 0.5) {
                        return 4;
                    }
                }
            }
        }

        return 0;
    }
}
