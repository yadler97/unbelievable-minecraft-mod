package com.yannick.unbelievablemod.setup;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;

public class WoodsawingRecipe extends SingleItemRecipe {

    public WoodsawingRecipe(ResourceLocation location, String group, Ingredient ingredient, ItemStack result) {
        super(RecipeTypes.WOODSAWING, Registration.WOODSAWING_RECIPES.get(), location, group, ingredient, result);
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.ingredient.test(container.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Registration.SAWMILL.get());
    }
}