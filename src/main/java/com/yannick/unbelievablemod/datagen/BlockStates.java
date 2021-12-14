package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, UnbelievableMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerGeneratorBlock();

        simpleBlock(Registration.RUBY_BLOCK.get(), models().cubeAll("ruby_block", new ResourceLocation(UnbelievableMod.MODID, "block/ruby_block")));
        simpleBlock(Registration.RUBY_ORE.get(), models().cubeAll("ruby_ore", new ResourceLocation(UnbelievableMod.MODID, "block/ruby_ore")));
        simpleBlock(Registration.DEEPSLATE_RUBY_ORE.get(), models().cubeAll("deepslate_ruby_ore", new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_ruby_ore")));

        simpleBlock(Registration.SAPPHIRE_BLOCK.get(), models().cubeAll("sapphire_block", new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_block")));
        simpleBlock(Registration.SAPPHIRE_ORE.get(), models().cubeAll("sapphire_ore", new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_ore")));
        simpleBlock(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), models().cubeAll("deepslate_sapphire_ore", new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_sapphire_ore")));

        simpleBlock(Registration.BAMBOO_BLOCK.get(), models().cubeAll("bamboo_block", new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block")));
        slabBlock(Registration.BAMBOO_BLOCK_SLAB.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        stairsBlock(Registration.BAMBOO_BLOCK_STAIRS.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));

        wallBlock(Registration.QUARTZ_WALL.get(), new ResourceLocation("minecraft", "block/quartz_block_side"));
        models().wallInventory("quartz_wall_inventory", new ResourceLocation("minecraft", "block/quartz_block_side"));
    }

    private void registerGeneratorBlock() {
        ResourceLocation txt = new ResourceLocation(UnbelievableMod.MODID, "block/generator");
        BlockModelBuilder modelGenerator = models().cube("generator", txt, txt, new ResourceLocation(UnbelievableMod.MODID, "block/generator_front"), txt, txt, txt);
        BlockModelBuilder modelGeneratorPowered = models().cube("generator_powered", txt, txt, new ResourceLocation(UnbelievableMod.MODID, "block/generator_powered"), txt, txt, txt);
        orientedBlock(Registration.GENERATOR.get(), state -> {
            if (state.getValue(BlockStateProperties.POWERED)) {
                return modelGeneratorPowered;
            } else {
                return modelGenerator;
            }
        });
    }

    private void orientedBlock(Block block, Function<BlockState, ModelFile> modelFunc) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir.getAxis() == Direction.Axis.Y ? dir.getAxisDirection().getStep() * -90 : 0)
                            .rotationY(dir.getAxis() != Direction.Axis.Y ? ((dir.get2DDataValue() +2) % 4) * 90 : 0)
                            .build();
                });
    }
}
