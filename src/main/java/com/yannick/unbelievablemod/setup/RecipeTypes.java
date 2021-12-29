package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeTypes {
    public static final RecipeType<WoodsawingRecipe> WOODSAWING = registerRecipeType("woodsawing");

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String key) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(UnbelievableMod.MODID, key), new RecipeType<T>() {
            public String toString() {
                return UnbelievableMod.MODID + ":" + key;
            }
        });
    }
}
