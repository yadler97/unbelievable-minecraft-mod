package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.tools.WoodsawingRecipeBuilder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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

        ShapedRecipeBuilder.shaped(Registration.DEPTH_METER.get())
                .pattern("ccc")
                .pattern("crc")
                .pattern("ccc")
                .define('c', Items.COPPER_INGOT)
                .define('r', Registration.RUBY.get())
                .unlockedBy("has_ruby", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY.get()))
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


        ShapedRecipeBuilder.shaped(Registration.BAMBOO_TABLE.get())
                .pattern("SSS")
                .pattern("b b")
                .pattern("b b")
                .define('S', Registration.BAMBOO_BLOCK_SLAB.get())
                .define('b', Items.BAMBOO)
                .unlockedBy("has_bamboo_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK_SLAB.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_CHAIR.get())
                .pattern("  S")
                .pattern("SSS")
                .pattern("b b")
                .define('S', Registration.BAMBOO_BLOCK_SLAB.get())
                .define('b', Items.BAMBOO)
                .unlockedBy("has_bamboo_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK_SLAB.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.BAMBOO_SHELF.get())
                .pattern("SSS")
                .pattern("b b")
                .pattern("SSS")
                .define('S', Registration.BAMBOO_BLOCK_SLAB.get())
                .define('b', Items.BAMBOO)
                .unlockedBy("has_bamboo_slabs", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BAMBOO_BLOCK_SLAB.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.CUT_GOLD.get(), 4)
                .pattern("GG")
                .pattern("GG")
                .define('G', Blocks.GOLD_BLOCK)
                .unlockedBy("has_gold_blocks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GOLD_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.CUT_GOLD_SLAB.get(), 6)
                .pattern("GGG")
                .define('G', Registration.CUT_GOLD.get())
                .unlockedBy("has_cut_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CUT_GOLD.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Registration.CUT_GOLD_STAIRS.get(), 4)
                .pattern("  G")
                .pattern(" GG")
                .pattern("GGG")
                .define('G', Registration.CUT_GOLD.get())
                .unlockedBy("has_cut_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CUT_GOLD.get()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(Registration.SAWMILL.get())
                .pattern(" I ")
                .pattern("PPP")
                .define('I', Items.IRON_INGOT)
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_iron_ingots", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT))
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

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.GRANITE), Registration.POLISHED_GRANITE_WALL.get())
                .unlockedBy("has_granite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GRANITE))
                .save(consumer, Registration.POLISHED_GRANITE_WALL.getId() + "_from_granite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_GRANITE), Registration.POLISHED_GRANITE_WALL.get())
                .unlockedBy("has_polished_granite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_GRANITE))
                .save(consumer, Registration.POLISHED_GRANITE_WALL.getId() + "_from_polished_granite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DIORITE), Registration.POLISHED_DIORITE_WALL.get())
                .unlockedBy("has_diorite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DIORITE))
                .save(consumer, Registration.POLISHED_DIORITE_WALL.getId() + "_from_diorite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_DIORITE), Registration.POLISHED_DIORITE_WALL.get())
                .unlockedBy("has_polished_diorite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_DIORITE))
                .save(consumer, Registration.POLISHED_DIORITE_WALL.getId() + "_from_polished_diorite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.ANDESITE), Registration.POLISHED_ANDESITE_WALL.get())
                .unlockedBy("has_andesite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.ANDESITE))
                .save(consumer, Registration.POLISHED_ANDESITE_WALL.getId() + "_from_andesite_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_ANDESITE), Registration.POLISHED_ANDESITE_WALL.get())
                .unlockedBy("has_polished_andesite_block", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.POLISHED_ANDESITE))
                .save(consumer, Registration.POLISHED_ANDESITE_WALL.getId() + "_from_polished_andesite_stonecutting");


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.GOLD_BLOCK), Registration.CUT_GOLD.get())
                .unlockedBy("has_gold_blocks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GOLD_BLOCK))
                .save(consumer, Registration.CUT_GOLD.getId() + "_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.GOLD_BLOCK), Registration.CUT_GOLD_SLAB.get(), 2)
                .unlockedBy("has_gold_blocks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GOLD_BLOCK))
                .save(consumer, Registration.CUT_GOLD_SLAB.getId() + "from_gold_block_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Registration.CUT_GOLD.get()), Registration.CUT_GOLD_SLAB.get(), 2)
                .unlockedBy("has_cut_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CUT_GOLD.get()))
                .save(consumer, Registration.CUT_GOLD_SLAB.getId() + "from_cut_gold_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.GOLD_BLOCK), Registration.CUT_GOLD_STAIRS.get())
                .unlockedBy("has_gold_blocks", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.GOLD_BLOCK))
                .save(consumer, Registration.CUT_GOLD_STAIRS.getId() + "from_gold_block_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Registration.CUT_GOLD.get()), Registration.CUT_GOLD_STAIRS.get())
                .unlockedBy("has_cut_gold", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.CUT_GOLD.get()))
                .save(consumer, Registration.CUT_GOLD_STAIRS.getId() + "from_cut_gold_stonecutting");



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



        // Woodsawing
        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_PLANKS, 4, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_PLANKS, 4, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_SLAB, 8, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_SLAB, 8, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_STAIRS, 4, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_STAIRS, 4, consumer);

        addWoodsawingRecipe(Blocks.OAK_PLANKS, Blocks.OAK_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB, 2, consumer);
        addWoodsawingRecipe(Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB, 2, consumer);

        addWoodsawingRecipe(Blocks.OAK_PLANKS, Blocks.OAK_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.BIRCH_PLANKS, Blocks.BIRCH_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.ACACIA_PLANKS, Blocks.ACACIA_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STAIRS, 1, consumer);
        addWoodsawingRecipe(Blocks.WARPED_PLANKS, Blocks.WARPED_STAIRS, 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Items.OAK_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Items.SPRUCE_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Items.BIRCH_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Items.JUNGLE_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Items.ACACIA_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Items.DARK_OAK_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Items.CRIMSON_SIGN, 2, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Items.WARPED_SIGN, 2, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_FENCE_GATE, 1, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_FENCE_GATE, 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_FENCE, 3, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_FENCE, 3, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Items.OAK_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Items.SPRUCE_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Items.BIRCH_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Items.JUNGLE_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Items.ACACIA_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Items.DARK_OAK_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Items.CRIMSON_DOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Items.WARPED_DOOR, 2, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_TRAPDOOR, 2, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_TRAPDOOR, 2, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_BUTTON, 4, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_BUTTON, 4, consumer);

        addWoodsawingRecipe(Blocks.OAK_PLANKS, Blocks.OAK_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.BIRCH_PLANKS, Blocks.BIRCH_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.ACACIA_PLANKS, Blocks.ACACIA_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_BUTTON, 1, consumer);
        addWoodsawingRecipe(Blocks.WARPED_PLANKS, Blocks.WARPED_BUTTON, 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Blocks.OAK_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Blocks.SPRUCE_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Blocks.BIRCH_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Blocks.JUNGLE_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Blocks.ACACIA_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Blocks.DARK_OAK_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Blocks.CRIMSON_PRESSURE_PLATE, 2, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Blocks.WARPED_PRESSURE_PLATE, 2, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Registration.OAK_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Registration.SPRUCE_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Registration.BIRCH_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Registration.JUNGLE_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Registration.ACACIA_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Registration.DARK_OAK_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Registration.CRIMSON_TABLE.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Registration.WARPED_TABLE.get(), 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Registration.OAK_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Registration.SPRUCE_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Registration.BIRCH_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Registration.JUNGLE_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Registration.ACACIA_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Registration.DARK_OAK_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Registration.CRIMSON_CHAIR.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Registration.WARPED_CHAIR.get(), 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Registration.OAK_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Registration.SPRUCE_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Registration.BIRCH_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Registration.JUNGLE_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Registration.ACACIA_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Registration.DARK_OAK_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.CRIMSON_STEMS, Registration.CRIMSON_SHELF.get(), 1, consumer);
        addWoodsawingRecipe(ItemTags.WARPED_STEMS, Registration.WARPED_SHELF.get(), 1, consumer);

        addWoodsawingRecipe(ItemTags.OAK_LOGS, Items.OAK_BOAT, 1, consumer);
        addWoodsawingRecipe(ItemTags.SPRUCE_LOGS, Items.SPRUCE_BOAT, 1, consumer);
        addWoodsawingRecipe(ItemTags.BIRCH_LOGS, Items.BIRCH_BOAT, 1, consumer);
        addWoodsawingRecipe(ItemTags.JUNGLE_LOGS, Items.JUNGLE_BOAT, 1, consumer);
        addWoodsawingRecipe(ItemTags.ACACIA_LOGS, Items.ACACIA_BOAT, 1, consumer);
        addWoodsawingRecipe(ItemTags.DARK_OAK_LOGS, Items.DARK_OAK_BOAT, 1, consumer);

        addWoodsawingRecipe(ItemTags.LOGS, Items.STICK, 8, consumer);
        addWoodsawingRecipe(ItemTags.PLANKS, Items.STICK, 2, consumer);
        addWoodsawingRecipe(ItemTags.LOGS, Blocks.CRAFTING_TABLE, 1, consumer);
        addWoodsawingRecipe(ItemTags.LOGS, Items.BOWL, 6, consumer);
    }

    private void addWoodsawingRecipe(Tag.Named<Item> tag, Block result, int count, Consumer<FinishedRecipe> consumer) {
        WoodsawingRecipeBuilder.woodsawing(Ingredient.of(tag), result, count)
                .unlockedBy("has_" + tag.getName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tag).build()))
                .save(consumer, new ResourceLocation(UnbelievableMod.MODID, "woodsawing/" + result.asItem() + "_from_" + tag.getName().getPath() + "_woodsawing"));
    }

    private void addWoodsawingRecipe(Block input, Block result, int count, Consumer<FinishedRecipe> consumer) {
        WoodsawingRecipeBuilder.woodsawing(Ingredient.of(input), result, count)
                .unlockedBy("has_" + input.asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(consumer, new ResourceLocation(UnbelievableMod.MODID, "woodsawing/" + result.asItem() + "_from_" + input.asItem() + "_woodsawing"));
    }

    private void addWoodsawingRecipe(Tag.Named<Item> tag, Item result, int count, Consumer<FinishedRecipe> consumer) {
        WoodsawingRecipeBuilder.woodsawing(Ingredient.of(tag), result, count)
                .unlockedBy("has_" + tag.getName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tag).build()))
                .save(consumer, new ResourceLocation(UnbelievableMod.MODID, "woodsawing/" + result + "_from_" + tag.getName().getPath() + "_woodsawing"));
    }

    private void addWoodsawingRecipe(Block input, Item result, int count, Consumer<FinishedRecipe> consumer) {
        WoodsawingRecipeBuilder.woodsawing(Ingredient.of(input), result, count)
                .unlockedBy("has_" + input.asItem(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(consumer, new ResourceLocation(UnbelievableMod.MODID, "woodsawing/" + result + "_from_" + input.asItem() + "_woodsawing"));
    }
}
