package com.yannick.unbelievablemod.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.IntValue MAX_SAPPHIRE_DISTANCE;
    public static ForgeConfigSpec.BooleanValue CONNECTING_TABLES;

    public static ForgeConfigSpec.BooleanValue RENDER_SHELF_BLOCK_ITEMS_AS_BLOCKS;
    public static ForgeConfigSpec.BooleanValue RENDER_SHELF_ITEMS_LYING;

    public static void init() {
        initServer();
        initClient();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }

    private static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("Tools Config").push("tools");
        MAX_SAPPHIRE_DISTANCE = builder
                .comment("How many additional blocks in a row sapphire tools can mine at max")
                .defineInRange("sapphireToolsMaxMiningBlocks", 3, 0, 20);
        CONNECTING_TABLES = builder
                .comment("Determines if tables should connect with neighbouring tables of the same type")
                .define("connectingTables", true);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }

    private static void initClient() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.comment("Shelf Rendering").push("shelf");
        RENDER_SHELF_BLOCK_ITEMS_AS_BLOCKS = builder
                .comment("Determines if BlockItems should be rendered as blocks instead of items in shelves")
                .define("renderBlockItemsAsBlocks", true);
        RENDER_SHELF_ITEMS_LYING = builder
                .comment("Determines if Items should be rendered lying on the floor of the shelf slot instead of floating")
                .define("renderItemsLying", false);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }
}
