package com.yannick.unbelievablemod.world.structures;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.apache.logging.log4j.Level;

import java.util.Optional;

public class UndergroundCabinStructure extends StructureFeature<JigsawConfiguration> {

    public UndergroundCabinStructure() {
        super(JigsawConfiguration.CODEC, UndergroundCabinStructure::createPiecesGenerator, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
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

        Optional<PieceGenerator<JigsawConfiguration>> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
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

    public String getFeatureName() {
        return this.getRegistryName().toString();
    }
}
