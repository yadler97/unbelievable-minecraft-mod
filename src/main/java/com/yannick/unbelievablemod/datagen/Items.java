package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {
    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UnbelievableMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // Items
        singleTexture(Registration.RUBY.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/ruby"));

        singleTexture(Registration.SAPPHIRE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire"));
        singleTexture(Registration.SAPPHIRE_PICKAXE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_pickaxe"));
        singleTexture(Registration.SAPPHIRE_AXE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_axe"));
        singleTexture(Registration.SAPPHIRE_SHOVEL.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_shovel"));
        singleTexture(Registration.SAPPHIRE_HOE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_hoe"));
        singleTexture(Registration.SAPPHIRE_SWORD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_sword"));

        singleTexture(Registration.ROSEGOLD_PICKAXE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_pickaxe"));
        singleTexture(Registration.ROSEGOLD_AXE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_axe"));
        singleTexture(Registration.ROSEGOLD_SHOVEL.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_shovel"));
        singleTexture(Registration.ROSEGOLD_HOE.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_hoe"));
        singleTexture(Registration.ROSEGOLD_SWORD.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_sword"));

        singleTexture(Registration.ROSEGOLD_HELMET.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_helmet"));
        singleTexture(Registration.ROSEGOLD_CHESTPLATE.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_chestplate"));
        singleTexture(Registration.ROSEGOLD_LEGGINGS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_leggings"));
        singleTexture(Registration.ROSEGOLD_BOOTS.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/rosegold_boots"));

        singleTexture(Registration.COPPER_WRENCH.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/copper_wrench"));

        singleTexture(Registration.FRIED_EGG.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/fried_egg"));

        singleTexture(Registration.BAMBOO_DOOR_ITEM.get().getRegistryName().getPath(), new ResourceLocation("item/generated"), "layer0", new ResourceLocation(UnbelievableMod.MODID, "item/bamboo_door"));


        // BlockItems
        withExistingParent(Registration.GENERATOR.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/generator"));

        withExistingParent(Registration.RUBY_BLOCK.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/ruby_block"));
        withExistingParent(Registration.RUBY_ORE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/ruby_ore"));
        withExistingParent(Registration.DEEPSLATE_RUBY_ORE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_ruby_ore"));

        withExistingParent(Registration.SAPPHIRE_BLOCK.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_block"));
        withExistingParent(Registration.SAPPHIRE_ORE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_ore"));
        withExistingParent(Registration.DEEPSLATE_SAPPHIRE_ORE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/deepslate_sapphire_ore"));

        withExistingParent(Registration.BAMBOO_BLOCK.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block"));
        withExistingParent(Registration.BAMBOO_BLOCK_SLAB.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_slab"));
        withExistingParent(Registration.BAMBOO_BLOCK_STAIRS.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_stairs"));
        withExistingParent(Registration.BAMBOO_BLOCK_FENCE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_fence_inventory"));
        withExistingParent(Registration.BAMBOO_BLOCK_FENCE_GATE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block_fence_gate"));
        withExistingParent(Registration.BAMBOO_TRAPDOOR.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_trapdoor_bottom"));
        withExistingParent(Registration.BAMBOO_PRESSURE_PLATE.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_pressure_plate"));
        withExistingParent(Registration.BAMBOO_BUTTON.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_button_inventory"));

        withExistingParent(Registration.SPRUCE_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/spruce_bookshelf"));
        withExistingParent(Registration.BIRCH_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/birch_bookshelf"));
        withExistingParent(Registration.JUNGLE_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/jungle_bookshelf"));
        withExistingParent(Registration.ACACIA_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/acacia_bookshelf"));
        withExistingParent(Registration.DARK_OAK_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/dark_oak_bookshelf"));
        withExistingParent(Registration.CRIMSON_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/crimson_bookshelf"));
        withExistingParent(Registration.WARPED_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/warped_bookshelf"));
        withExistingParent(Registration.BAMBOO_BOOKSHELF.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_bookshelf"));

        withExistingParent(Registration.QUARTZ_WALL.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/quartz_wall_inventory"));
        withExistingParent(Registration.POLISHED_GRANITE_WALL.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_granite_wall_inventory"));
        withExistingParent(Registration.POLISHED_DIORITE_WALL.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_diorite_wall_inventory"));
        withExistingParent(Registration.POLISHED_ANDESITE_WALL.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/polished_andesite_wall_inventory"));
    }
}
