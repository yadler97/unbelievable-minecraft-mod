package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.blocks.ChairBlock;
import com.yannick.unbelievablemod.blocks.SawmillBlock;
import com.yannick.unbelievablemod.blocks.ShelfBlock;
import com.yannick.unbelievablemod.blocks.TableBlock;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static net.minecraftforge.client.model.generators.ModelProvider.BLOCK_FOLDER;

public class BlockStates extends BlockStateProvider {

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, UnbelievableMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.RUBY_BLOCK.get(), models().cubeAll("ruby_block", new ResourceLocation(UnbelievableMod.MODID, "block/ruby_block")));
        simpleBlock(Registration.RUBY_ORE.get(), models().cubeAll("ruby_ore", new ResourceLocation(UnbelievableMod.MODID, "block/ruby_ore")));
        simpleBlock(Registration.DEEPSLATE_RUBY_ORE.get(), models().cubeAll("deepslate_ruby_ore", new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_ruby_ore")));

        simpleBlock(Registration.SAPPHIRE_BLOCK.get(), models().cubeAll("sapphire_block", new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_block")));
        simpleBlock(Registration.SAPPHIRE_ORE.get(), models().cubeAll("sapphire_ore", new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_ore")));
        simpleBlock(Registration.DEEPSLATE_SAPPHIRE_ORE.get(), models().cubeAll("deepslate_sapphire_ore", new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_sapphire_ore")));

        simpleBlock(Registration.BAMBOO_BLOCK.get(), models().cubeAll("bamboo_block", new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block")));
        slabBlock(Registration.BAMBOO_BLOCK_SLAB.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        stairsBlock(Registration.BAMBOO_BLOCK_STAIRS.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        fenceBlock(Registration.BAMBOO_BLOCK_FENCE.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        models().fenceInventory(Registration.BAMBOO_BLOCK_FENCE.getId() + "_inventory", new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        fenceGateBlock(Registration.BAMBOO_BLOCK_FENCE_GATE.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        doorBlock(Registration.BAMBOO_DOOR.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_door_bottom"), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_door_top"));
        trapdoorBlock(Registration.BAMBOO_TRAPDOOR.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_trapdoor"), true);
        pressurePlateBlock(Registration.BAMBOO_PRESSURE_PLATE.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        buttonBlock(Registration.BAMBOO_BUTTON.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        models().buttonInventory(Registration.BAMBOO_BUTTON.getId() + "_inventory", new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));

        wallBlock(Registration.QUARTZ_WALL.get(), new ResourceLocation("minecraft", "block/quartz_block_side"));
        models().wallInventory(Registration.QUARTZ_WALL.getId() + "_inventory", new ResourceLocation("minecraft", "block/quartz_block_side"));
        wallBlock(Registration.POLISHED_GRANITE_WALL.get(), new ResourceLocation("minecraft", "block/polished_granite"));
        models().wallInventory(Registration.POLISHED_GRANITE_WALL.getId() + "_inventory", new ResourceLocation("minecraft", "block/polished_granite"));
        wallBlock(Registration.POLISHED_DIORITE_WALL.get(), new ResourceLocation("minecraft", "block/polished_diorite"));
        models().wallInventory(Registration.POLISHED_DIORITE_WALL.getId() + "_inventory", new ResourceLocation("minecraft", "block/polished_diorite"));
        wallBlock(Registration.POLISHED_ANDESITE_WALL.get(), new ResourceLocation("minecraft", "block/polished_andesite"));
        models().wallInventory(Registration.POLISHED_ANDESITE_WALL.getId() + "_inventory", new ResourceLocation("minecraft", "block/polished_andesite"));

        simpleBlock(Registration.SPRUCE_BOOKSHELF.get(), models().cubeColumn("spruce_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/spruce_bookshelf"), new ResourceLocation("minecraft", "block/spruce_planks")));
        simpleBlock(Registration.BIRCH_BOOKSHELF.get(), models().cubeColumn("birch_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/birch_bookshelf"), new ResourceLocation("minecraft", "block/birch_planks")));
        simpleBlock(Registration.JUNGLE_BOOKSHELF.get(), models().cubeColumn("jungle_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/jungle_bookshelf"), new ResourceLocation("minecraft", "block/jungle_planks")));
        simpleBlock(Registration.ACACIA_BOOKSHELF.get(), models().cubeColumn("acacia_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/acacia_bookshelf"), new ResourceLocation("minecraft", "block/acacia_planks")));
        simpleBlock(Registration.DARK_OAK_BOOKSHELF.get(), models().cubeColumn("dark_oak_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_bookshelf"), new ResourceLocation("minecraft", "block/dark_oak_planks")));
        simpleBlock(Registration.CRIMSON_BOOKSHELF.get(), models().cubeColumn("crimson_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/crimson_bookshelf"), new ResourceLocation("minecraft", "block/crimson_planks")));
        simpleBlock(Registration.WARPED_BOOKSHELF.get(), models().cubeColumn("warped_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/warped_bookshelf"), new ResourceLocation("minecraft", "block/warped_planks")));
        simpleBlock(Registration.BAMBOO_BOOKSHELF.get(), models().cubeColumn("bamboo_bookshelf", new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_bookshelf"), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block")));

        tableBlock("oak_table", Registration.OAK_TABLE.get(), new ResourceLocation("minecraft", "block/oak_planks"));
        tableBlock("spruce_table", Registration.SPRUCE_TABLE.get(), new ResourceLocation("minecraft", "block/spruce_planks"));
        tableBlock("birch_table", Registration.BIRCH_TABLE.get(), new ResourceLocation("minecraft", "block/birch_planks"));
        tableBlock("jungle_table", Registration.JUNGLE_TABLE.get(), new ResourceLocation("minecraft", "block/jungle_planks"));
        tableBlock("acacia_table", Registration.ACACIA_TABLE.get(), new ResourceLocation("minecraft", "block/acacia_planks"));
        tableBlock("dark_oak_table", Registration.DARK_OAK_TABLE.get(), new ResourceLocation("minecraft", "block/dark_oak_planks"));
        tableBlock("crimson_table", Registration.CRIMSON_TABLE.get(), new ResourceLocation("minecraft", "block/crimson_planks"));
        tableBlock("warped_table", Registration.WARPED_TABLE.get(), new ResourceLocation("minecraft", "block/warped_planks"));
        tableBlock("bamboo_table", Registration.BAMBOO_TABLE.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));

        chairBlock("oak_chair", Registration.OAK_CHAIR.get(), new ResourceLocation("minecraft", "block/oak_planks"));
        chairBlock("spruce_chair", Registration.SPRUCE_CHAIR.get(), new ResourceLocation("minecraft", "block/spruce_planks"));
        chairBlock("birch_chair", Registration.BIRCH_CHAIR.get(), new ResourceLocation("minecraft", "block/birch_planks"));
        chairBlock("jungle_chair", Registration.JUNGLE_CHAIR.get(), new ResourceLocation("minecraft", "block/jungle_planks"));
        chairBlock("acacia_chair", Registration.ACACIA_CHAIR.get(), new ResourceLocation("minecraft", "block/acacia_planks"));
        chairBlock("dark_oak_chair", Registration.DARK_OAK_CHAIR.get(), new ResourceLocation("minecraft", "block/dark_oak_planks"));
        chairBlock("crimson_chair", Registration.CRIMSON_CHAIR.get(), new ResourceLocation("minecraft", "block/crimson_planks"));
        chairBlock("warped_chair", Registration.WARPED_CHAIR.get(), new ResourceLocation("minecraft", "block/warped_planks"));
        chairBlock("bamboo_chair", Registration.BAMBOO_CHAIR.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));

        shelfBlock("oak_shelf", Registration.OAK_SHELF.get(), new ResourceLocation("minecraft", "block/oak_planks"));
        shelfBlock("spruce_shelf", Registration.SPRUCE_SHELF.get(), new ResourceLocation("minecraft", "block/spruce_planks"));
        shelfBlock("birch_shelf", Registration.BIRCH_SHELF.get(), new ResourceLocation("minecraft", "block/birch_planks"));
        shelfBlock("jungle_shelf", Registration.JUNGLE_SHELF.get(), new ResourceLocation("minecraft", "block/jungle_planks"));
        shelfBlock("acacia_shelf", Registration.ACACIA_SHELF.get(), new ResourceLocation("minecraft", "block/acacia_planks"));
        shelfBlock("dark_oak_shelf", Registration.DARK_OAK_SHELF.get(), new ResourceLocation("minecraft", "block/dark_oak_planks"));
        shelfBlock("crimson_shelf", Registration.CRIMSON_SHELF.get(), new ResourceLocation("minecraft", "block/crimson_planks"));
        shelfBlock("warped_shelf", Registration.WARPED_SHELF.get(), new ResourceLocation("minecraft", "block/warped_planks"));
        shelfBlock("bamboo_shelf", Registration.BAMBOO_SHELF.get(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));

        simpleBlock(Registration.CUT_GOLD.get(), models().cubeAll("cut_gold", new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold")));
        slabBlock(Registration.CUT_GOLD_SLAB.get(), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold"), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold"));
        stairsBlock(Registration.CUT_GOLD_STAIRS.get(), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold"));

        sawmillBlock("sawmill", Registration.SAWMILL.get(), new ResourceLocation(UnbelievableMod.MODID, "block/sawmill_side"), new ResourceLocation(UnbelievableMod.MODID, "block/sawmill_top"), new ResourceLocation(UnbelievableMod.MODID, "block/sawmill_bottom"));
    }

    private void tableBlock(String name, TableBlock block, ResourceLocation texture) {
        ModelFile table = models().singleTexture(name, modLoc(BLOCK_FOLDER + "/table"), texture);
        simpleBlock(block, table);
    }

    private void chairBlock(String name, ChairBlock block, ResourceLocation texture) {
        ModelFile chair = models().singleTexture(name, modLoc(BLOCK_FOLDER + "/chair"), texture);

        getVariantBuilder(block).forAllStates(state -> {
            ModelFile model = chair;
            if (state.getValue(ChairBlock.CARPET)) {
                switch(state.getValue(ChairBlock.COLOR)) {
                    case ORANGE -> model = models().withExistingParent(name + "_with_cushion_orange", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/orange_wool"));
                    case MAGENTA -> model = models().withExistingParent(name + "_with_cushion_magenta", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/magenta_wool"));
                    case LIGHT_BLUE -> model = models().withExistingParent(name + "_with_cushion_light_blue", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/light_blue_wool"));
                    case YELLOW -> model = models().withExistingParent(name + "_with_cushion_yellow", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/yellow_wool"));
                    case LIME -> model = models().withExistingParent(name + "_with_cushion_lime", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/lime_wool"));
                    case PINK -> model = models().withExistingParent(name + "_with_cushion_pink", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/pink_wool"));
                    case GRAY -> model = models().withExistingParent(name + "_with_cushion_gray", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/gray_wool"));
                    case LIGHT_GRAY -> model = models().withExistingParent(name + "_with_cushion_light_gray", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/light_gray_wool"));
                    case CYAN -> model = models().withExistingParent(name + "_with_cushion_cyan", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/cyan_wool"));
                    case PURPLE -> model = models().withExistingParent(name + "_with_cushion_purple", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/purple_wool"));
                    case BLUE -> model = models().withExistingParent(name + "_with_cushion_blue", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/blue_wool"));
                    case BROWN -> model = models().withExistingParent(name + "_with_cushion_brown", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/brown_wool"));
                    case GREEN -> model = models().withExistingParent(name + "_with_cushion_green", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/green_wool"));
                    case RED -> model = models().withExistingParent(name + "_with_cushion_red", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/red_wool"));
                    case BLACK -> model = models().withExistingParent(name + "_with_cushion_black", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/black_wool"));
                    default -> model = models().withExistingParent(name + "_with_cushion_white", modLoc(BLOCK_FOLDER + "/chair_with_cushion")).texture("texture", texture).texture("wool", new ResourceLocation("minecraft", "block/white_wool"));
                }
            }
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) state.getValue(ChairBlock.FACING).toYRot())
                    .rotationY(((int) state.getValue(ChairBlock.FACING).toYRot() + 180) % 360)
                    .uvLock(true)
                    .build();
        });
    }

    private void shelfBlock(String name, ShelfBlock block, ResourceLocation texture) {
        ModelFile shelf = models().singleTexture(name, modLoc(BLOCK_FOLDER + "/shelf"), texture);
        horizontalBlock(block, shelf);
    }

    private void sawmillBlock(String name, SawmillBlock block, ResourceLocation side, ResourceLocation top, ResourceLocation bottom) {
        ModelFile shelf = models().withExistingParent(name, mcLoc(BLOCK_FOLDER + "/stonecutter")).texture("side", side).texture("top", top).texture("bottom", bottom).texture("particle", bottom);
        horizontalBlock(block, shelf);
    }
}
