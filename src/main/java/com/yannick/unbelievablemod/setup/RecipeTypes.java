package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeTypes {
    public static final RecipeType<WoodsawingRecipe> WOODSAWING = registerRecipeType("woodsawing");

    public static void init() {}

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String key) {
        return RecipeType.register(UnbelievableMod.MODID + ":" + key);
    }
}
