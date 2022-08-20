package com.yannick.unbelievablemod.items;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;

public class WoodenBucket extends TieredItem implements Vanishable, DispensibleContainerItem {

    private final Fluid content;

    public WoodenBucket(Fluid content, net.minecraft.world.item.Tiers tier, Item.Properties properties) {
        super(tier, properties);
        this.content = content;
        this.fluidSupplier = net.minecraftforge.registries.ForgeRegistries.FLUIDS.getDelegateOrThrow(content);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult blockHitResult = getPlayerPOVHitResult(level, player, this.content == Fluids.EMPTY ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE);
        InteractionResultHolder<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(player, level, new ItemStack(Items.BUCKET), blockHitResult);
        if (ret != null) {
            return ret;
        }

        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemStack);
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemStack);
        } else {
            BlockPos blockpos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);

            if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos1, direction, itemStack)) {
                BlockState blockState = level.getBlockState(blockpos);

                if (this.content == Fluids.EMPTY) {
                    if (blockState.getBlock() instanceof BucketPickup && blockState.getBlock() != Blocks.LAVA && blockState.getBlock() != Blocks.POWDER_SNOW) {
                        itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.swingingArm));
                        if (itemStack != ItemStack.EMPTY && !itemStack.is(Items.AIR)) {
                            int remainDurability = itemStack.getDamageValue();
                            player.playSound(SoundEvents.BUCKET_FILL, 1.0F, 1.0F);
                            level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 11);
                            ItemStack returnStack = new ItemStack(Registration.WOODEN_WATER_BUCKET.get());
                            returnStack.setDamageValue(remainDurability);

                            if (!level.isClientSide) {
                                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, returnStack);
                            }

                            player.awardStat(Stats.ITEM_USED.get(this));

                            if (player.getAbilities().instabuild) {
                                if (!player.getInventory().contains(returnStack)) {
                                    player.addItem(returnStack);
                                }
                                return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
                            }

                            return InteractionResultHolder.sidedSuccess(returnStack, level.isClientSide());
                        }
                    }
                } else {
                    BlockPos blockpos2 = canBlockContainFluid(level, blockpos, blockState) ? blockpos : blockpos1;
                    if (this.emptyContents(player, level, blockpos2, blockHitResult)) {
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos2, itemStack);
                        }

                        itemStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(player.swingingArm));
                        if (itemStack != ItemStack.EMPTY && !itemStack.is(Items.AIR)) {
                            int remainDurability = itemStack.getDamageValue();
                            ItemStack returnStack = getEmptySuccessItem(itemStack, player);
                            returnStack.setDamageValue(remainDurability);

                            player.awardStat(Stats.ITEM_USED.get(this));
                            return InteractionResultHolder.sidedSuccess(returnStack, level.isClientSide());
                        }
                    }
                }
            }

            return InteractionResultHolder.fail(itemStack);
        }
    }

    public static ItemStack getEmptySuccessItem(ItemStack bucketStack, Player player) {
        return !player.getAbilities().instabuild ? new ItemStack(Registration.WOODEN_BUCKET.get()) : bucketStack;
    }

    public boolean emptyContents(@Nullable Player player, Level level, BlockPos pos, @Nullable BlockHitResult blockHitResult) {
        if (!(this.content instanceof FlowingFluid)) {
            return false;
        } else {
            BlockState blockstate = level.getBlockState(pos);
            Block block = blockstate.getBlock();
            Material material = blockstate.getMaterial();
            boolean flag = blockstate.canBeReplaced(this.content);
            boolean flag1 = blockstate.isAir() || flag || block instanceof LiquidBlockContainer && ((LiquidBlockContainer)block).canPlaceLiquid(level, pos, blockstate, this.content);
            if (!flag1) {
                return blockHitResult != null && this.emptyContents(player, level, blockHitResult.getBlockPos().relative(blockHitResult.getDirection()), (BlockHitResult)null);
            } else if (level.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
                int i = pos.getX();
                int j = pos.getY();
                int k = pos.getZ();
                level.playSound(player, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.8F);

                for(int l = 0; l < 8; ++l) {
                    level.addParticle(ParticleTypes.LARGE_SMOKE, (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
                }

                return true;
            } else if (block instanceof LiquidBlockContainer && ((LiquidBlockContainer)block).canPlaceLiquid(level,pos,blockstate,content)) {
                ((LiquidBlockContainer)block).placeLiquid(level, pos, blockstate, ((FlowingFluid)this.content).getSource(false));
                this.playEmptySound(player, level, pos);
                return true;
            } else {
                if (!level.isClientSide && flag && !material.isLiquid()) {
                    level.destroyBlock(pos, true);
                }

                if (!level.setBlock(pos, this.content.defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
                    return false;
                } else {
                    this.playEmptySound(player, level, pos);
                    return true;
                }
            }
        }
    }

    protected void playEmptySound(@Nullable Player player, LevelAccessor levelAccessor, BlockPos pos) {
        levelAccessor.playSound(player, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
        levelAccessor.gameEvent(player, GameEvent.FLUID_PLACE, pos);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundTag nbt) {
        if (this.getClass() == WoodenBucket.class) {
            return new net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper(stack);
        } else {
            return super.initCapabilities(stack, nbt);
        }
    }

    private final java.util.function.Supplier<? extends Fluid> fluidSupplier;
    public Fluid getFluid() {
        return fluidSupplier.get();
    }

    private boolean canBlockContainFluid(Level worldIn, BlockPos posIn, BlockState blockstate) {
        return blockstate.getBlock() instanceof LiquidBlockContainer && ((LiquidBlockContainer)blockstate.getBlock()).canPlaceLiquid(worldIn, posIn, blockstate, this.content);
    }
}
