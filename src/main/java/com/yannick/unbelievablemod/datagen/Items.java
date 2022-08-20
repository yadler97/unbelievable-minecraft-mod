package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.yannick.unbelievablemod.setup.ClientSetup.DEPTH_PROPERTY;

public class Items extends ItemModelProvider {
    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UnbelievableMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // Items
        singleTexture(Registration.RUBY.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/ruby"));

        singleTexture(Registration.SAPPHIRE.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire"));
        singleTexture(Registration.SAPPHIRE_PICKAXE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_pickaxe"));
        singleTexture(Registration.SAPPHIRE_AXE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_axe"));
        singleTexture(Registration.SAPPHIRE_SHOVEL.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_shovel"));
        singleTexture(Registration.SAPPHIRE_HOE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_hoe"));
        singleTexture(Registration.SAPPHIRE_SWORD.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_sword"));

        singleTexture(Registration.ROSEGOLD_PICKAXE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_pickaxe"));
        singleTexture(Registration.ROSEGOLD_AXE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_axe"));
        singleTexture(Registration.ROSEGOLD_SHOVEL.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_shovel"));
        singleTexture(Registration.ROSEGOLD_HOE.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_hoe"));
        singleTexture(Registration.ROSEGOLD_SWORD.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_sword"));

        singleTexture(Registration.ROSEGOLD_HELMET.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_helmet"));
        singleTexture(Registration.ROSEGOLD_CHESTPLATE.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_chestplate"));
        singleTexture(Registration.ROSEGOLD_LEGGINGS.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_leggings"));
        singleTexture(Registration.ROSEGOLD_BOOTS.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_boots"));

        singleTexture(Registration.COPPER_WRENCH.getId().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/copper_wrench"));

        singleTexture(Registration.FRIED_EGG.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/fried_egg"));

        singleTexture(Registration.BAMBOO_DOOR_ITEM.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/bamboo_door"));

        getBuilder(Registration.DEPTH_METER.getId().getPath())
                .parent(getExistingFile(modLoc("item/handheld_depth_meter")))
                .texture("layer0", "item/depth_meter0")
                .override().predicate(DEPTH_PROPERTY, 1).model(createDepthMeterModel(1)).end()
                .override().predicate(DEPTH_PROPERTY, 2).model(createDepthMeterModel(2)).end()
                .override().predicate(DEPTH_PROPERTY, 3).model(createDepthMeterModel(3)).end()
                .override().predicate(DEPTH_PROPERTY, 4).model(createDepthMeterModel(4)).end()
                .override().predicate(DEPTH_PROPERTY, 5).model(createDepthMeterModel(5)).end()
                .override().predicate(DEPTH_PROPERTY, 6).model(createDepthMeterModel(6)).end()
                .override().predicate(DEPTH_PROPERTY, 7).model(createDepthMeterModel(7)).end()
                .override().predicate(DEPTH_PROPERTY, 8).model(createDepthMeterModel(8)).end()
                .override().predicate(DEPTH_PROPERTY, 9).model(createDepthMeterModel(9)).end()
                .override().predicate(DEPTH_PROPERTY, 10).model(createDepthMeterModel(10)).end()
                .override().predicate(DEPTH_PROPERTY, 11).model(createDepthMeterModel(11)).end();

        singleTexture(Registration.WOODEN_BUCKET.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/wooden_bucket"));
        singleTexture(Registration.WOODEN_WATER_BUCKET.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/wooden_water_bucket"));
        singleTexture(Registration.WOODEN_MILK_BUCKET.getId().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/wooden_milk_bucket"));



        // BlockItems
        withExistingParent(Registration.RUBY_BLOCK.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/ruby_block"));
        withExistingParent(Registration.RUBY_ORE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/ruby_ore"));
        withExistingParent(Registration.DEEPSLATE_RUBY_ORE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_ruby_ore"));

        withExistingParent(Registration.SAPPHIRE_BLOCK.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_block"));
        withExistingParent(Registration.SAPPHIRE_ORE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_ore"));
        withExistingParent(Registration.DEEPSLATE_SAPPHIRE_ORE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_sapphire_ore"));

        withExistingParent(Registration.BAMBOO_BLOCK.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        withExistingParent(Registration.BAMBOO_BLOCK_SLAB.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_slab"));
        withExistingParent(Registration.BAMBOO_BLOCK_STAIRS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_stairs"));
        withExistingParent(Registration.BAMBOO_BLOCK_FENCE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_fence_inventory"));
        withExistingParent(Registration.BAMBOO_BLOCK_FENCE_GATE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_fence_gate"));
        withExistingParent(Registration.BAMBOO_TRAPDOOR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_trapdoor_bottom"));
        withExistingParent(Registration.BAMBOO_PRESSURE_PLATE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_pressure_plate"));
        withExistingParent(Registration.BAMBOO_BUTTON.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_button_inventory"));

        withExistingParent(Registration.SPRUCE_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/spruce_bookshelf"));
        withExistingParent(Registration.BIRCH_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/birch_bookshelf"));
        withExistingParent(Registration.JUNGLE_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/jungle_bookshelf"));
        withExistingParent(Registration.ACACIA_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/acacia_bookshelf"));
        withExistingParent(Registration.DARK_OAK_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_bookshelf"));
        withExistingParent(Registration.CRIMSON_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/crimson_bookshelf"));
        withExistingParent(Registration.WARPED_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/warped_bookshelf"));
        withExistingParent(Registration.BAMBOO_BOOKSHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_bookshelf"));

        withExistingParent(Registration.QUARTZ_WALL.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/quartz_wall_inventory"));
        withExistingParent(Registration.POLISHED_GRANITE_WALL.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_granite_wall_inventory"));
        withExistingParent(Registration.POLISHED_DIORITE_WALL.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_diorite_wall_inventory"));
        withExistingParent(Registration.POLISHED_ANDESITE_WALL.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_andesite_wall_inventory"));

        withExistingParent(Registration.GRANITE_BRICKS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/granite_bricks"));
        withExistingParent(Registration.DIORITE_BRICKS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/diorite_bricks"));
        withExistingParent(Registration.ANDESITE_BRICKS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/andesite_bricks"));
        withExistingParent(Registration.GRANITE_BRICK_SLAB.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/granite_brick_slab"));
        withExistingParent(Registration.DIORITE_BRICK_SLAB.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/diorite_brick_slab"));
        withExistingParent(Registration.ANDESITE_BRICK_SLAB.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/andesite_brick_slab"));
        withExistingParent(Registration.GRANITE_BRICK_STAIRS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/granite_brick_stairs"));
        withExistingParent(Registration.DIORITE_BRICK_STAIRS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/diorite_brick_stairs"));
        withExistingParent(Registration.ANDESITE_BRICK_STAIRS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/andesite_brick_stairs"));
        withExistingParent(Registration.GRANITE_PILLAR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/granite_pillar"));
        withExistingParent(Registration.DIORITE_PILLAR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/diorite_pillar"));
        withExistingParent(Registration.ANDESITE_PILLAR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/andesite_pillar"));

        withExistingParent(Registration.OAK_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/oak_table"));
        withExistingParent(Registration.SPRUCE_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/spruce_table"));
        withExistingParent(Registration.BIRCH_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/birch_table"));
        withExistingParent(Registration.JUNGLE_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/jungle_table"));
        withExistingParent(Registration.ACACIA_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/acacia_table"));
        withExistingParent(Registration.DARK_OAK_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_table"));
        withExistingParent(Registration.CRIMSON_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/crimson_table"));
        withExistingParent(Registration.WARPED_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/warped_table"));
        withExistingParent(Registration.BAMBOO_TABLE.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_table"));

        withExistingParent(Registration.OAK_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/oak_chair"));
        withExistingParent(Registration.SPRUCE_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/spruce_chair"));
        withExistingParent(Registration.BIRCH_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/birch_chair"));
        withExistingParent(Registration.JUNGLE_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/jungle_chair"));
        withExistingParent(Registration.ACACIA_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/acacia_chair"));
        withExistingParent(Registration.DARK_OAK_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_chair"));
        withExistingParent(Registration.CRIMSON_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/crimson_chair"));
        withExistingParent(Registration.WARPED_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/warped_chair"));
        withExistingParent(Registration.BAMBOO_CHAIR.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_chair"));

        withExistingParent(Registration.OAK_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/oak_shelf"));
        withExistingParent(Registration.SPRUCE_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/spruce_shelf"));
        withExistingParent(Registration.BIRCH_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/birch_shelf"));
        withExistingParent(Registration.JUNGLE_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/jungle_shelf"));
        withExistingParent(Registration.ACACIA_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/acacia_shelf"));
        withExistingParent(Registration.DARK_OAK_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_shelf"));
        withExistingParent(Registration.CRIMSON_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/crimson_shelf"));
        withExistingParent(Registration.WARPED_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/warped_shelf"));
        withExistingParent(Registration.BAMBOO_SHELF.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_shelf"));

        withExistingParent(Registration.CUT_GOLD.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold"));
        withExistingParent(Registration.CUT_GOLD_SLAB.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold_slab"));
        withExistingParent(Registration.CUT_GOLD_STAIRS.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/cut_gold_stairs"));

        withExistingParent(Registration.SAWMILL.getId().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sawmill"));
    }

    private ItemModelBuilder createDepthMeterModel(int suffix) {
        return getBuilder("depth_meter" + suffix).parent(getExistingFile(modLoc("item/handheld_depth_meter")))
                .texture("layer0", "item/depth_meter" + suffix);
    }
}
