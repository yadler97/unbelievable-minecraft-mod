package com.yannick.unbelievablemod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
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
import java.util.Collections;
import java.util.stream.Stream;

import static net.minecraft.core.Direction.*;

public class ShelfBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {

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
            if (clickedSlot != -1) {
                ShelfBlockEntity blockEntity = (ShelfBlockEntity) level.getBlockEntity(blockPos);
                ItemStack stack = player.getItemInHand(interactionHand);
                if (blockEntity != null) {
                    ItemStack inputStack = stack.copy();
                    inputStack.setCount(1);
                    ItemStack returnStack = blockEntity.addItemToShelf(clickedSlot, inputStack);
                    if (returnStack != ItemStack.EMPTY) {
                        Direction direction = blockHitResult.getDirection();
                        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
                        ItemEntity itementity = new ItemEntity(level, (double)blockPos.getX() + 0.5D + (double)direction1.getStepX() * 0.65D, (double)blockPos.getY() + 0.1D, (double)blockPos.getZ() + 0.5D + (double)direction1.getStepZ() * 0.65D, returnStack);
                        itementity.setDeltaMovement(0.05D * (double)direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction1.getStepZ() + level.random.nextDouble() * 0.02D);
                        level.addFreshEntity(itementity);
                    } else {
                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    }
                }
            }

            return InteractionResult.CONSUME;
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
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(p_56381_, direction, blockState, levelAccessor, blockPos, blockPos1);
    }

    public boolean isPathfindable(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, PathComputationType pathComputationType) {
        if (pathComputationType == PathComputationType.WATER) {
            return blockGetter.getFluidState(blockPos).is(FluidTags.WATER);
        }
        return false;
    }

    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState replacingBlockState, boolean p_51542_) {
        if (!blockState.is(replacingBlockState.getBlock())) {
            ShelfBlockEntity blockEntity = (ShelfBlockEntity) level.getBlockEntity(blockPos);
            if (blockEntity != null) {
                NonNullList<ItemStack> items = blockEntity.getItems();
                for (ItemStack itemStack : items) {
                    Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemStack);
                }
            }

            super.onRemove(blockState, level, blockPos, replacingBlockState, p_51542_);
        }
    }

    private int getClickedSlot(BlockState blockState, BlockHitResult blockHitResult) {
        Vec3 vec = blockHitResult.getLocation();
        double xd = Math.abs(vec.x % 1);
        double yd = Math.abs(vec.y % 1);
        double zd = Math.abs(vec.z % 1);

        switch (blockState.getValue(FACING)) {
            case NORTH -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == EAST || dir == WEST) && xd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (xd < 0.5 && yd < 0.5) {
                        return 0;
                    }
                    if (xd >= 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (xd < 0.5 && yd >= 0.5) {
                        return 2;
                    }
                    if (xd >= 0.5 && yd >= 0.5) {
                        return 3;
                    }
                }
            }
            case SOUTH -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == EAST || dir == WEST) && xd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (xd >= 0.5 && yd < 0.5) {
                        return 0;
                    }
                    if (xd < 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (xd >= 0.5 && yd >= 0.5) {
                        return 2;
                    }
                    if (xd < 0.5 && yd >= 0.5) {
                        return 3;
                    }

                }
            }
            case WEST -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == NORTH || dir == SOUTH) && zd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (zd < 0.5 && yd < 0.5) {
                        return 0;
                    }
                    if (zd >= 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (zd < 0.5 && yd >= 0.5) {
                        return 2;
                    }
                    if (zd >= 0.5 && yd >= 0.5) {
                        return 3;
                    }
                }
            }
            case EAST -> {
                Direction dir = blockHitResult.getDirection();
                if (((dir == NORTH || dir == SOUTH) && zd != 0.0) || ((dir == UP || dir == DOWN) && yd != 0.0)) {
                    if (zd >= 0.5 && yd < 0.5) {
                        return 0;
                    }
                    if (zd < 0.5 && yd < 0.5) {
                        return 1;
                    }
                    if (zd >= 0.5 && yd >= 0.5) {
                        return 2;
                    }
                    if (zd < 0.5 && yd >= 0.5) {
                        return 3;
                    }
                }
            }
        }

        return -1;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ShelfBlockEntity(blockPos, blockState);
    }

    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockentity = level.getBlockEntity(blockPos);
        if (blockentity instanceof ShelfBlockEntity) {
            NonNullList<ItemStack> items = ((ShelfBlockEntity) blockentity).getItems();
            int filledShelfSlots = 4 - Collections.frequency(items, ItemStack.EMPTY);
            switch (filledShelfSlots) {
                case 1 -> {
                    return 3;
                }
                case 2 -> {
                    return 7;
                }
                case 3 -> {
                    return 11;
                }
                case 4 -> {
                    return 15;
                }
            }
        }

        return 0;
    }
}
