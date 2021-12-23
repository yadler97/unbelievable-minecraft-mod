package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
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
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_AXE.get())
                .pattern(" xx")
                .pattern(" sx")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SHOVEL.get())
                .pattern(" x ")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_HOE.get())
                .pattern(" xx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_SWORD.get())
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" s ")
                .define('x', Registration.SAPPHIRE.get())
                .define('s', Items.STICK)
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.COPPER_WRENCH.get())
                .pattern(" c ")
                .pattern(" cc")
                .pattern("c  ")
                .define('c', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer);

        // Existing Items
        ShapelessRecipeBuilder.shapeless(Items.NAME_TAG)
                .requires(Items.PAPER)
                .requires(Items.STRING)
                .requires(Items.INK_SAC)
                .unlockedBy("has_paper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.PAPER))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.SADDLE)
                .pattern("LLL")
                .pattern(" s ")
                .pattern(" i ")
                .define('L', Items.LEATHER)
                .define('s', Items.STRING)
                .define('i', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.IRON_HORSE_ARMOR)
                .pattern("i i")
                .pattern("iii")
                .pattern("i i")
                .define('i', Tags.Items.INGOTS_IRON)
                .unlockedBy("has_iron", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.GOLDEN_HORSE_ARMOR)
                .pattern("g g")
                .pattern("ggg")
                .pattern("g g")
                .define('g', Tags.Items.INGOTS_GOLD)
                .unlockedBy("has_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GOLD_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Items.DIAMOND_HORSE_ARMOR)
                .pattern("d d")
                .pattern("ddd")
                .pattern("d d")
                .define('d', Items.DIAMOND)
                .unlockedBy("has_diamond", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIAMOND))
                .save(consumer);



        // Crafting Blocks
        ShapedRecipeBuilder.shaped(Registration.GENERATOR.get())
                .pattern("iii")
                .pattern("iCi")
                .pattern("ccc")
                .define('i', Tags.Items.INGOTS_IRON)
                .define('C', Tags.Items.STORAGE_BLOCKS_COAL)
                .define('c', ItemTags.COALS)
                .unlockedBy("has_coals", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COAL))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.RUBY_BLOCK.get())
                .pattern("rrr")
                .pattern("rrr")
                .pattern("rrr")
                .define('r', Registration.RUBY.get())
                .unlockedBy("has_ruby", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.RUBY.get(), 9)
                .requires(Registration.RUBY_BLOCK.get())
                .unlockedBy("has_ruby_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SAPPHIRE_BLOCK.get())
                .pattern("sss")
                .pattern("sss")
                .pattern("sss")
                .define('s', Registration.SAPPHIRE.get())
                .unlockedBy("has_sapphire", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.SAPPHIRE.get(), 9)
                .requires(Registration.SAPPHIRE_BLOCK.get())
                .unlockedBy("has_sapphire_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE_BLOCK.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BLOCK.get())
                .pattern("bb")
                .pattern("bb")
                .define('b', Items.BAMBOO)
                .unlockedBy("has_bamboo", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BAMBOO))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BLOCK_SLAB.get(), 6)
                .pattern("bbb")
                .define('b', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BLOCK_STAIRS.get(), 4)
                .pattern("b  ")
                .pattern("bb ")
                .pattern("bbb")
                .define('b', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BLOCK_FENCE.get(), 3)
                .pattern("BbB")
                .pattern("BbB")
                .define('b', Items.BAMBOO)
                .define('B', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BLOCK_FENCE_GATE.get())
                .pattern("bBb")
                .pattern("bBb")
                .define('b', Items.BAMBOO)
                .define('B', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_DOOR.get(), 3)
                .pattern("bb")
                .pattern("bb")
                .pattern("bb")
                .define('b', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_TRAPDOOR.get(), 2)
                .pattern("bbb")
                .pattern("bbb")
                .define('b', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_PRESSURE_PLATE.get())
                .pattern("bb")
                .define('b', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Registration.BAMBOO_BUTTON.get())
                .requires(Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_bamboo_block", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.QUARTZ_WALL.get(), 6)
                .pattern("   ")
                .pattern("qqq")
                .pattern("qqq")
                .define('q', Blocks.QUARTZ_BLOCK)
                .unlockedBy("has_quartz_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.QUARTZ_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.POLISHED_GRANITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("ggg")
                .pattern("ggg")
                .define('g', Blocks.POLISHED_GRANITE)
                .unlockedBy("has_polished_granite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_GRANITE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.POLISHED_DIORITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("ddd")
                .pattern("ddd")
                .define('d', Blocks.POLISHED_DIORITE)
                .unlockedBy("has_polished_diorite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_DIORITE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.POLISHED_ANDESITE_WALL.get(), 6)
                .pattern("   ")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', Blocks.POLISHED_ANDESITE)
                .unlockedBy("has_polished_andesite", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_ANDESITE))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Blocks.BOOKSHELF)
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.OAK_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SPRUCE_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.SPRUCE_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BIRCH_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.BIRCH_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.JUNGLE_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.JUNGLE_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.ACACIA_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.ACACIA_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.DARK_OAK_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.DARK_OAK_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.CRIMSON_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.CRIMSON_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.WARPED_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Blocks.WARPED_PLANKS)
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_BOOKSHELF.get())
                .pattern("ppp")
                .pattern("bbb")
                .pattern("ppp")
                .define('b', Items.BOOK)
                .define('p', Registration.BAMBOO_BLOCK.get())
                .unlockedBy("has_books", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BOOK))
                .group("bookshelves")
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.OAK_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.OAK_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_oak_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.OAK_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.SPRUCE_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.SPRUCE_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_spruce_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.SPRUCE_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BIRCH_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.BIRCH_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_birch_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BIRCH_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.JUNGLE_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.JUNGLE_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_jungle_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.JUNGLE_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.ACACIA_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.ACACIA_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_acacia_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.ACACIA_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.DARK_OAK_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.DARK_OAK_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_dark_oak_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DARK_OAK_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.CRIMSON_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.CRIMSON_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_crimson_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRIMSON_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.WARPED_TABLE.get())
                .pattern("SSS")
                .pattern("s s")
                .pattern("s s")
                .define('S', Blocks.WARPED_SLAB)
                .define('s', Items.STICK)
                .unlockedBy("has_warped_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.WARPED_SLAB))
                .group("tables")
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_TABLE.get())
                .pattern("SSS")
                .pattern("b b")
                .pattern("b b")
                .define('S', Registration.BAMBOO_BLOCK_SLAB.get())
                .define('b', Items.BAMBOO)
                .unlockedBy("has_bamboo_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK_SLAB.get()))
                .group("tables")
                .save(consumer);



        // Smelting/Cooking
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 200)
                .unlockedBy("has_egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId());

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 100)
                .unlockedBy("has_egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId() + "_from_smoking");

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(Items.EGG), Registration.FRIED_EGG.get(), 0.35F, 600)
                .unlockedBy("has_egg", has(Items.EGG))
                .save(consumer, Registration.FRIED_EGG.getId() + "_from_campfire_cooking");

        // Existing Items
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.ROTTEN_FLESH), Items.LEATHER, 0.05F, 200)
                .unlockedBy("has_rotten_flesh", has(Items.ROTTEN_FLESH))
                .save(consumer);



        // Stonecutting
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), Registration.QUARTZ_WALL.get())
                .unlockedBy("has_quartz_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.QUARTZ_BLOCK))
                .save(consumer, Registration.QUARTZ_WALL.getId() + "_stonecutting");


        // Smithing
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_PICKAXE), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_PICKAXE.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_PICKAXE.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_AXE), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_AXE.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_AXE.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_SHOVEL), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_SHOVEL.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_SHOVEL.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_HOE), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_HOE.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_HOE.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_SWORD), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_SWORD.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_SWORD.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_HELMET), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_HELMET.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_HELMET.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_CHESTPLATE), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_CHESTPLATE.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_CHESTPLATE.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_LEGGINGS), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_LEGGINGS.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_LEGGINGS.getId() + "_smithing");

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.GOLDEN_BOOTS), Ingredient.of(Items.COPPER_INGOT), Registration.ROSEGOLD_BOOTS.get())
                .unlocks("has_copper_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT))
                .save(consumer, Registration.ROSEGOLD_BOOTS.getId() + "_smithing");
    }
}
