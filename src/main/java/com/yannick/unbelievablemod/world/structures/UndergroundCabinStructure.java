package com.yannick.unbelievablemod.world.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.yannick.unbelievablemod.world.Structures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class UndergroundCabinStructure extends Structure {

    public static final Codec<UndergroundCabinStructure> CODEC = RecordCodecBuilder.<UndergroundCabinStructure>mapCodec(instance ->
            instance.group(UndergroundCabinStructure.settingsCodec(instance),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
                    Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
                    Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
            ).apply(instance, UndergroundCabinStructure::new)).codec();

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int size;
    private final HeightProvider startHeight;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    public UndergroundCabinStructure(Structure.StructureSettings config,
                                     Holder<StructureTemplatePool> startPool,
                                     Optional<ResourceLocation> startJigsawName,
                                     int size,
                                     HeightProvider startHeight,
                                     Optional<Heightmap.Types> projectStartToHeightmap,
                                     int maxDistanceFromCenter)
    {
        super(config);
        this.startPool = startPool;
        this.startJigsawName = startJigsawName;
        this.size = size;
        this.startHeight = startHeight;
        this.projectStartToHeightmap = projectStartToHeightmap;
        this.maxDistanceFromCenter = maxDistanceFromCenter;
    }

    private static boolean extraSpawningChecks(Structure.GenerationContext context) {
        ChunkPos chunkpos = context.chunkPos();

        int landHeight = context.chunkGenerator().getFirstOccupiedHeight(
                chunkpos.getMinBlockX(),
                chunkpos.getMinBlockZ(),
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                context.heightAccessor(),
                context.randomState());

        return landHeight <= 0;
    }

    @Override
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {

        if (!UndergroundCabinStructure.extraSpawningChecks(context)) {
            return Optional.empty();
        }

        int height = UndergroundCabinStructure.getHeight(context);
        if (height == 0) {
            return Optional.empty();
        }

        BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos(context.chunkPos().getMinBlockX(), -64, context.chunkPos().getMinBlockZ());
        blockPos.move(Direction.UP, height + 64);

        Optional<Structure.GenerationStub> structurePiecesGenerator =
                JigsawPlacement.addPieces(
                        context,
                        this.startPool,
                        this.startJigsawName,
                        this.size,
                        blockPos,
                        false,
                        this.projectStartToHeightmap,
                        this.maxDistanceFromCenter);

        return structurePiecesGenerator;
    }

    @Override
    public StructureType<?> type() {
        return Structures.UNDERGROUND_CABIN.get();
    }

    private static int getHeight(Structure.GenerationContext context) {
        BlockPos blockPos = context.chunkPos().getWorldPosition();
        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(blockPos.getX(), blockPos.getZ(), context.heightAccessor(), context.randomState());
        for (int i = -64; i < 0; i++) {
            if (columnOfBlocks.getBlock(i).getBlock() == Blocks.AIR) {
                if (columnOfBlocks.getBlock(i-1).getFluidState().isEmpty()) {
                    return i;
                }
            }
        }

        return 0;
    }
}
