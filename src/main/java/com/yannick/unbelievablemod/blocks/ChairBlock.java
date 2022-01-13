package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.entities.ChairEntity;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ChairBlock extends Block implements SimpleWaterloggedBlock {

    private final int fireSpreadSpeed;
    private final int flammability;
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

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

    public ChairBlock(Properties properties, int fireSpreadSpeed, int flammability) {
        super(properties);
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.flammability = flammability;
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            ChairEntity entity = new ChairEntity(level, pos);
            level.addFreshEntity(entity);
            player.startRiding(entity);

            return InteractionResult.CONSUME;
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
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
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
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

        return super.updateShape(blockState, direction, facingBlockState, levelAccessor, currentPos, neighborPos);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos pos, PathComputationType pathComputationType) {
        if (pathComputationType == PathComputationType.WATER) {
            return blockGetter.getFluidState(pos).is(FluidTags.WATER);
        }
        return false;
    }
}
