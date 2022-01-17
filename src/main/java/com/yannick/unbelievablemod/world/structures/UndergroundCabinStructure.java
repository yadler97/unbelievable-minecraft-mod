package com.yannick.unbelievablemod.world.structures;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.world.Structures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Optional;

public class UndergroundCabinStructure extends StructureFeature<JigsawConfiguration> {

    public UndergroundCabinStructure(Codec<JigsawConfiguration> codec) {
        super(codec, UndergroundCabinStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
    }

    private static final Lazy<List<MobSpawnSettings.SpawnerData>> STRUCTURE_MONSTERS = Lazy.of(ImmutableList::of);

    private static final Lazy<List<MobSpawnSettings.SpawnerData>> STRUCTURE_CREATURES = Lazy.of(ImmutableList::of);

    public static void setupStructureSpawns(final StructureSpawnListGatherEvent event) {
        if (event.getStructure() == Structures.CASTLE_RUINS.get()) {
            event.addEntitySpawns(MobCategory.MONSTER, STRUCTURE_MONSTERS.get());
            event.addEntitySpawns(MobCategory.CREATURE, STRUCTURE_CREATURES.get());
        }
    }

    private static int getHeight(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos blockPos = context.chunkPos().getWorldPosition();
        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(blockPos.getX(), blockPos.getZ(), context.heightAccessor());
        for (int i = -64; i < 0; i++) {
            if (columnOfBlocks.getBlock(i).getBlock() == Blocks.AIR) {
                if (columnOfBlocks.getBlock(i-1).getFluidState().isEmpty()) {
                    return i;
                }
            }
        }

        return 0;
    }

    public static Optional<PieceGenerator<JigsawConfiguration>> createPiecesGenerator(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {

        int height = UndergroundCabinStructure.getHeight(context);
        if (height == 0) {
            return Optional.empty();
        }

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(context.chunkPos().getMinBlockX(), -64, context.chunkPos().getMinBlockZ());
        pos.move(Direction.UP, height + 64);

        JigsawConfiguration newConfig = new JigsawConfiguration(
                () -> context.registryAccess().ownedRegistryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
                        .get(new ResourceLocation(UnbelievableMod.MODID, "underground_cabin/start_pool")),
                10
        );

        PieceGeneratorSupplier.Context<JigsawConfiguration> newContext = new PieceGeneratorSupplier.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.heightAccessor(),
                context.validBiome(),
                context.structureManager(),
                context.registryAccess()
        );

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        newContext,
                        PoolElementStructurePiece::new,
                        pos,
                        false,
                        false
                );

        if (structurePiecesGenerator.isPresent()) {
            UnbelievableMod.LOGGER.log(Level.DEBUG, "Underground Cabin at " + pos);
        }

        return structurePiecesGenerator;
    }
}
