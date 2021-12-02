package com.yannick.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.setup.Registration;
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
        singleTexture(
                Registration.SAPPHIRE.get().getRegistryName().getPath(),
                new ResourceLocation("item/generated"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire"));

        singleTexture(
                Registration.SAPPHIRE_PICKAXE.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_pickaxe"));

        singleTexture(
                Registration.SAPPHIRE_AXE.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_axe"));

        singleTexture(
                Registration.SAPPHIRE_SHOVEL.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_shovel"));

        singleTexture(
                Registration.SAPPHIRE_HOE.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_hoe"));

        singleTexture(
                Registration.SAPPHIRE_SWORD.get().getRegistryName().getPath(),
                new ResourceLocation("item/handheld"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/sapphire_sword"));

        singleTexture(
                Registration.FRIED_EGG.get().getRegistryName().getPath(),
                new ResourceLocation("item/generated"),
                "layer0",
                new ResourceLocation(UnbelievableMod.MODID, "item/fried_egg"));


        withExistingParent(Registration.GENERATOR_ITEM.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/generator"));
        withExistingParent(Registration.SAPPHIRE_BLOCK_ITEM.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_block"));
        withExistingParent(Registration.SAPPHIRE_ORE_ITEM.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/sapphire_ore"));
        withExistingParent(Registration.QUARTZ_WALL_ITEM.get().getRegistryName().getPath(), new ResourceLocation(UnbelievableMod.MODID, "block/quartz_wall_inventory"));
    }
}
