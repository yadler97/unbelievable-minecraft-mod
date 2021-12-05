package com.yannick.datagen;

import com.yannick.setup.Registration;
import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        // Crafting Items
        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_PICKAXE.get())
                .pattern("xxx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_AXE.get())
                .pattern(" xx")
                .pattern(" sx")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SHOVEL.get())
                .pattern(" x ")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_HOE.get())
                .pattern(" xx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SWORD.get())
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.COPPER_WRENCH.get())
                .pattern(" c ")
                .pattern(" cc")
                .pattern("c  ")
                .define('c', Items.COPPER_INGOT)
                .unlockedBy("copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer);

        // Existing Items
        ShapelessRecipeBuilder.shapeless(Items.NAME_TAG)
                .requires(Items.PAPER)
                .requires(Items.STRING)
                .requires(Items.INK_SAC)
                .unlockedBy("paper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PAPER))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.SADDLE)
                .pattern("LLL")
                .pattern(" s ")
                .pattern(" i ")
                .define('L', Items.LEATHER)
                .define('s', Items.STRING)
                .define('i', Tags.Items.INGOTS_IRON)
                .unlockedBy("iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.IRON_HORSE_ARMOR)
                .pattern("i i")
                .pattern("iii")
                .pattern("i i")
                .define('i', Tags.Items.INGOTS_IRON)
                .unlockedBy("iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.GOLDEN_HORSE_ARMOR)
                .pattern("g g")
                .pattern("ggg")
                .pattern("g g")
                .define('g', Tags.Items.INGOTS_GOLD)
                .unlockedBy("gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.DIAMOND_HORSE_ARMOR)
                .pattern("d d")
                .pattern("ddd")
                .pattern("d d")
                .define('d', Items.DIAMOND)
                .unlockedBy("diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer);



        // Crafting Blocks
        ShapedRecipeBuilder.shaped(Registration.GENERATOR.get())
                .pattern("iii")
                .pattern("iCi")
                .pattern("ccc")
                .define('i', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_COAL)
                .define('c', ItemTags.COALS)
                .unlockedBy("coals", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.RUBY_BLOCK.get())
                .pattern("rrr")
                .pattern("rrr")
                .pattern("rrr")
                .define('r', Registration.RUBY.get())
                .unlockedBy("ruby", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.RUBY.get(), 9)
                .requires(Registration.RUBY_BLOCK.get())
                .unlockedBy("ruby_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_BLOCK.get())
                .pattern("sss")
                .pattern("sss")
                .pattern("sss")
                .define('s', Registration.SAPPHIRE.get())
                .unlockedBy("sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.SAPPHIRE.get(), 9)
                .requires(Registration.SAPPHIRE_BLOCK.get())
                .unlockedBy("sapphire_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.QUARTZ_WALL.get())
                .pattern("   ")
                .pattern("qqq")
                .pattern("qqq")
                .define('q', Blocks.QUARTZ_BLOCK)
                .unlockedBy("quartz_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.QUARTZ_BLOCK))
                .save(consumer);



        // Smelting/Cooking
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 200)
                .unlockedBy("egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId());

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 100)
                .unlockedBy("egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId() + "_from_smoking");

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 600)
                .unlockedBy("egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId() + "_from_campfire_cooking");

        // Existing Items
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.ROTTEN_FLESH), Items.LEATHER, 0.05F, 200)
                .unlockedBy("rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(consumer);



        // Stonecutting
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), Registration.QUARTZ_WALL.get())
                .unlockedBy("quartz_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.QUARTZ_BLOCK))
                .save(consumer, Registration.QUARTZ_WALL.getId() + "_stonecutting");
    }
}
