package com.yannick.unbelievablemod.events;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.advancements.ModCriteriaTriggers;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MineWithSmeltingEvent {

    @SubscribeEvent
    public static boolean onMineWithSmelting(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ServerLevel level = (ServerLevel) player.getLevel();
        ItemStack itemStack = player.getMainHandItem();
        BlockState blockState = event.getState();

        if (blockState != null && ForgeHooks.isCorrectToolForDrops(blockState, player) && EnchantmentHelper.getItemEnchantmentLevel(Registration.SMELTING.get(), itemStack) != 0 && (
                blockState.is(Tags.Blocks.ORES_IRON) || blockState.is(Tags.Blocks.ORES_COPPER) || blockState.is(Tags.Blocks.ORES_GOLD) || blockState.is(Blocks.ANCIENT_DEBRIS)||
                blockState.is(Tags.Blocks.SAND) || blockState.is(Blocks.SANDSTONE) || blockState.is(Blocks.RED_SANDSTONE) || blockState.is(Blocks.NETHERRACK) ||
                blockState.is(Blocks.COBBLESTONE) || blockState.is(Blocks.COBBLED_DEEPSLATE) || blockState.is(Blocks.QUARTZ_BLOCK) || blockState.is(Blocks.BASALT) ||
                blockState.is(Blocks.CLAY) || blockState.is(Blocks.WHITE_TERRACOTTA) || blockState.is(Blocks.ORANGE_TERRACOTTA) || blockState.is(Blocks.MAGENTA_TERRACOTTA) ||
                blockState.is(Blocks.LIGHT_BLUE_TERRACOTTA) || blockState.is(Blocks.YELLOW_TERRACOTTA) || blockState.is(Blocks.LIME_TERRACOTTA) || blockState.is(Blocks.PINK_TERRACOTTA) ||
                blockState.is(Blocks.GRAY_TERRACOTTA) || blockState.is(Blocks.LIGHT_GRAY_TERRACOTTA) || blockState.is(Blocks.CYAN_TERRACOTTA) || blockState.is(Blocks.PURPLE_TERRACOTTA) ||
                blockState.is(Blocks.BLUE_TERRACOTTA) || blockState.is(Blocks.BROWN_TERRACOTTA) || blockState.is(Blocks.GREEN_TERRACOTTA) || blockState.is(Blocks.RED_TERRACOTTA) ||
                blockState.is(Blocks.BLACK_TERRACOTTA))) {
            BlockPos pos = event.getPos();
            level.playSound(null, pos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS, 1.0F, 1.0F);
            spawnParticlesOnBlockFaces(level, pos, ParticleTypes.FLAME, UniformInt.of(2, 4));
            ModCriteriaTriggers.MINE_WITH_SMELTING.trigger((ServerPlayer) player);

            Optional<SmeltingRecipe> optional = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(blockState.getBlock())), level);
            if (optional.isPresent()) {
                SmeltingRecipe recipe = optional.get();

                if (blockState.is(Blocks.ANCIENT_DEBRIS)) {
                    event.setExpToDrop((int) recipe.getExperience());
                } else {
                    if (Math.random() <= recipe.getExperience()) {
                        event.setExpToDrop(1);
                    }
                }

                return true;
            }
        }

        return false;
    }

    private static void spawnParticlesOnBlockFaces(ServerLevel serverLevel, BlockPos pos, ParticleOptions particleType, UniformInt amount) {
        for (Direction direction : Direction.values()) {
            int i = amount.sample(serverLevel.random);

            for (int j = 0; j < i; ++j) {
                spawnParticleOnFace(serverLevel, pos, direction, particleType);
            }
        }
    }

    private static void spawnParticleOnFace(ServerLevel serverLevel, BlockPos pos, Direction direction, ParticleOptions particleType) {
        Vec3 vec3 = Vec3.atCenterOf(pos);
        int i = direction.getStepX();
        int j = direction.getStepY();
        int k = direction.getStepZ();
        double d0 = vec3.x + (i == 0 ? Mth.nextDouble(serverLevel.random, -0.5D, 0.5D) : (double)i * 0.55D);
        double d1 = vec3.y + (j == 0 ? Mth.nextDouble(serverLevel.random, -0.5D, 0.5D) : (double)j * 0.55D);
        double d2 = vec3.z + (k == 0 ? Mth.nextDouble(serverLevel.random, -0.5D, 0.5D) : (double)k * 0.55D);
        double d3 = i == 0 && j == 0 && k == 0 ? Mth.nextDouble(serverLevel.random, -1.0D, 1.0D) : 0.0D;
        serverLevel.sendParticles(particleType, d0, d1, d2, 4, 0.0D, 0.0D, 0.0D, d3);
    }
}
