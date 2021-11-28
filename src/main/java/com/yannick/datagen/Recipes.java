package com.yannick.datagen;

import com.yannick.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_PICKAXE.get())
                .pattern("xxx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .group("examplemod")
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_AXE.get())
                .pattern(" xx")
                .pattern(" sx")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .group("examplemod")
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SHOVEL.get())
                .pattern(" x ")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .group("examplemod")
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_HOE.get())
                .pattern(" xx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .group("examplemod")
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SWORD.get())
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .group("examplemod")
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 200).unlockedBy("egg", has(Items.EGG)).save(consumer);
    }
}
