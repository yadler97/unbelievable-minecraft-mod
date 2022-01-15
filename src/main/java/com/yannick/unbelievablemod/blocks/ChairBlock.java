package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.entities.ChairEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
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
    public static final BooleanProperty CARPET = BooleanProperty.create("has_carpet");
    public static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

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
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE).setValue(CARPET, Boolean.FALSE));
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(interactionHand);
            if (stack.is(ItemTags.CARPETS)) {
                if (blockState.getValue(CARPET)) {
                    level.setBlock(pos, blockState.setValue(CARPET, Boolean.FALSE), UPDATE_ALL);
                    level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

                    if (!player.getAbilities().instabuild) {
                        Direction direction = blockHitResult.getDirection();
                        Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
                        ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) direction1.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction1.getStepZ() * 0.65D, getReturnCarpet(blockState.getValue(COLOR)));
                        itementity.setDeltaMovement(0.05D * (double) direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction1.getStepZ() + level.random.nextDouble() * 0.02D);
                        level.addFreshEntity(itementity);
                    }
                } else {
                    if (stack.getItem() instanceof BlockItem carpetItem && carpetItem.getBlock() instanceof WoolCarpetBlock carpetBlock) {
                        level.setBlock(pos, blockState.setValue(CARPET, Boolean.TRUE).setValue(COLOR, carpetBlock.getColor()), UPDATE_ALL);
                        level.playSound(null, pos, SoundEvents.WOOL_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                        if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                        }
                    }
                }
            } else {
                ChairEntity entity = new ChairEntity(level, pos);
                level.addFreshEntity(entity);
                player.startRiding(entity);
            }

            return InteractionResult.CONSUME;
        }

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER).setValue(CARPET, Boolean.FALSE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState>  builder) {
        builder.add(FACING, WATERLOGGED, CARPET, COLOR);
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

    public void onRemove(BlockState blockState, Level level, BlockPos pos, BlockState replacingBlockState, boolean isMoving) {
        if (!blockState.is(replacingBlockState.getBlock())) {
            if (blockState.getValue(CARPET)) {
                ItemStack returnStack = getReturnCarpet(blockState.getValue(COLOR));
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), returnStack);
            }

            super.onRemove(blockState, level, pos, replacingBlockState, isMoving);
        }
    }

    private ItemStack getReturnCarpet(DyeColor color) {
        return switch(color) {
            case ORANGE -> new ItemStack(Items.ORANGE_CARPET);
            case MAGENTA -> new ItemStack(Items.MAGENTA_CARPET);
            case LIGHT_BLUE -> new ItemStack(Items.LIGHT_BLUE_CARPET);
            case YELLOW -> new ItemStack(Items.YELLOW_CARPET);
            case LIME -> new ItemStack(Items.LIME_CARPET);
            case PINK -> new ItemStack(Items.PINK_CARPET);
            case GRAY -> new ItemStack(Items.GRAY_CARPET);
            case LIGHT_GRAY -> new ItemStack(Items.LIGHT_GRAY_CARPET);
            case CYAN -> new ItemStack(Items.CYAN_CARPET);
            case PURPLE -> new ItemStack(Items.PURPLE_CARPET);
            case BLUE -> new ItemStack(Items.BLUE_CARPET);
            case BROWN -> new ItemStack(Items.BROWN_CARPET);
            case GREEN -> new ItemStack(Items.GREEN_CARPET);
            case RED -> new ItemStack(Items.RED_CARPET);
            case BLACK -> new ItemStack(Items.BLACK_CARPET);
            default -> new ItemStack(Items.WHITE_CARPET);
        };
    }
}
