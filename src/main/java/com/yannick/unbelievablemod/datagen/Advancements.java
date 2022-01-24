package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.advancements.criteron.AddCushionToChairTrigger;
import com.yannick.unbelievablemod.advancements.criteron.AddItemToShelfTrigger;
import com.yannick.unbelievablemod.advancements.criteron.SapphireMineMaxDistanceTrigger;
import com.yannick.unbelievablemod.setup.ModTags;
import com.yannick.unbelievablemod.setup.Registration;
import com.yannick.unbelievablemod.world.Structures;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class Advancements extends AdvancementProvider {

    public Advancements(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {

        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(
                        Registration.ROSEGOLD_SWORD.get(),
                        new TranslatableComponent("advancements.mod.root.title"),
                        new TranslatableComponent("advancements.mod.root.description"),
                        new ResourceLocation(UnbelievableMod.MODID, "textures/block/diorite_bricks.png"),
                        FrameType.TASK,
                        false,
                        false,
                        false)
                .addCriterion("has_crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/root")));

        Advancement interiorDesignerAdvancement = Advancement.Builder.advancement()
                .display(
                    Registration.OAK_CHAIR.get(),
                    new TranslatableComponent("advancements.mod.professional_interior_designer.title"),
                    new TranslatableComponent("advancements.mod.professional_interior_designer.description"),
                    null,
                    FrameType.TASK,
                    true,
                    false,
                    false)
                .addCriterion("has_table", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModTags.Items.TABLES).build()))
                .addCriterion("has_chair", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModTags.Items.CHAIRS).build()))
                .addCriterion("has_shelf", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModTags.Items.SHELVES).build()))
                .requirements(RequirementsStrategy.AND)
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/professional_interior_designer")));

        Advancement.Builder.advancement()
                .display(
                        Items.MAGENTA_DYE,
                        new TranslatableComponent("advancements.mod.colorful.title"),
                        new TranslatableComponent("advancements.mod.colorful.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_white_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.WHITE_CARPET).build()))
                .addCriterion("has_orange_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.ORANGE_CARPET).build()))
                .addCriterion("has_magenta_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.MAGENTA_CARPET).build()))
                .addCriterion("has_light_blue_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.LIGHT_BLUE_CARPET).build()))
                .addCriterion("has_yellow_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.YELLOW_CARPET).build()))
                .addCriterion("has_lime_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.LIME_CARPET).build()))
                .addCriterion("has_pink_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.PINK_CARPET).build()))
                .addCriterion("has_gray_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.GRAY_CARPET).build()))
                .addCriterion("has_light_gray_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.LIGHT_GRAY_CARPET).build()))
                .addCriterion("has_cyan_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.CYAN_CARPET).build()))
                .addCriterion("has_purple_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.PURPLE_CARPET).build()))
                .addCriterion("has_blue_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.BLUE_CARPET).build()))
                .addCriterion("has_brown_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.BROWN_CARPET).build()))
                .addCriterion("has_green_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.GREEN_CARPET).build()))
                .addCriterion("has_red_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.RED_CARPET).build()))
                .addCriterion("has_black_cushion", AddCushionToChairTrigger.TriggerInstance.addedCushionToChair(ItemPredicate.Builder.item().of(Items.BLACK_CARPET).build()))
                .requirements(RequirementsStrategy.AND)
                .parent(interiorDesignerAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/colorful")));

        Advancement.Builder.advancement()
                .display(
                        Registration.OAK_SHELF.get(),
                        new TranslatableComponent("advancements.mod.all_my_treasure.title"),
                        new TranslatableComponent("advancements.mod.all_my_treasure.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        false,
                        false)
                .addCriterion("has_added_treasure", AddItemToShelfTrigger.TriggerInstance.itemAddedToShelf(
                        ItemPredicate.Builder.item().of(Items.DIAMOND).build(),
                        ItemPredicate.Builder.item().of(Items.EMERALD).build(),
                        ItemPredicate.Builder.item().of(Registration.RUBY.get()).build(),
                        ItemPredicate.Builder.item().of(Registration.SAPPHIRE.get()).build()))
                .parent(interiorDesignerAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/all_my_treasure")));

        Advancement.Builder.advancement()
                .display(
                        Registration.COPPER_WRENCH.get(),
                        new TranslatableComponent("advancements.mod.let_me_fix_this.title"),
                        new TranslatableComponent("advancements.mod.let_me_fix_this.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_copper_wrench", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.COPPER_WRENCH.get()))
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/let_me_fix_this")));

        Advancement rubyAdvancement = Advancement.Builder.advancement()
                .display(
                        Registration.RUBY.get(),
                        new TranslatableComponent("advancements.mod.is_that_redstone.title"),
                        new TranslatableComponent("advancements.mod.is_that_redstone.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_rubies", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.RUBY.get()))
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/is_that_redstone")));

        Advancement sapphireAdvancement = Advancement.Builder.advancement()
                .display(
                        Registration.SAPPHIRE.get(),
                        new TranslatableComponent("advancements.mod.diamonds_wait.title"),
                        new TranslatableComponent("advancements.mod.diamonds_wait.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_sapphires", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.SAPPHIRE.get()))
                .parent(rubyAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/diamonds_wait")));

        Advancement.Builder.advancement()
                .display(
                        Registration.SAPPHIRE_SHOVEL.get(),
                        new TranslatableComponent("advancements.mod.terraforming_specialist.title"),
                        new TranslatableComponent("advancements.mod.terraforming_specialist.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("mines_with_max_distance", SapphireMineMaxDistanceTrigger.TriggerInstance.minedWithMaxDistance(ItemPredicate.Builder.item().of(Registration.SAPPHIRE_SHOVEL.get()).build()))
                .parent(sapphireAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/terraforming_specialist")));

        Advancement.Builder.advancement()
                .display(
                        Registration.WOODEN_BUCKET.get(),
                        new TranslatableComponent("advancements.mod.it_fulfilled_its_purpose.title"),
                        new TranslatableComponent("advancements.mod.it_fulfilled_its_purpose.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("breaks_wooden_bucket", ItemDurabilityTrigger.TriggerInstance.changedDurability(ItemPredicate.Builder.item().of(Registration.WOODEN_BUCKET.get()).build(), MinMaxBounds.Ints.atMost(0)))
                .addCriterion("breaks_wooden_water_bucket", ItemDurabilityTrigger.TriggerInstance.changedDurability(ItemPredicate.Builder.item().of(Registration.WOODEN_WATER_BUCKET.get()).build(), MinMaxBounds.Ints.atMost(0)))
                .addCriterion("breaks_wooden_milk_bucket", ItemDurabilityTrigger.TriggerInstance.changedDurability(ItemPredicate.Builder.item().of(Registration.WOODEN_MILK_BUCKET.get()).build(), MinMaxBounds.Ints.atMost(0)))
                .requirements(RequirementsStrategy.OR)
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/it_fulfilled_its_purpose")));

        Advancement rosegoldBaseAdvancement = Advancement.Builder.advancement()
                .display(
                        Registration.ROSEGOLD_PICKAXE.get(),
                        new TranslatableComponent("advancements.mod.small_upgrade.title"),
                        new TranslatableComponent("advancements.mod.small_upgrade.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("has_rosegold_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_PICKAXE.get()))
                .addCriterion("has_rosegold_axe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_AXE.get()))
                .addCriterion("has_rosegold_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_SHOVEL.get()))
                .addCriterion("has_rosegold_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_HOE.get()))
                .addCriterion("has_rosegold_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_SWORD.get()))
                .addCriterion("has_rosegold_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_HELMET.get()))
                .addCriterion("has_rosegold_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_CHESTPLATE.get()))
                .addCriterion("has_rosegold_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_LEGGINGS.get()))
                .addCriterion("has_rosegold_boots", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_BOOTS.get()))
                .requirements(RequirementsStrategy.OR)
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/small_upgrade")));

        Advancement.Builder.advancement()
                .display(
                        Registration.ROSEGOLD_CHESTPLATE.get(),
                        new TranslatableComponent("advancements.mod.bigger_upgrade.title"),
                        new TranslatableComponent("advancements.mod.bigger_upgrade.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        false,
                        false)
                .addCriterion("has_rosegold_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_PICKAXE.get()))
                .addCriterion("has_rosegold_axe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_AXE.get()))
                .addCriterion("has_rosegold_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_SHOVEL.get()))
                .addCriterion("has_rosegold_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_HOE.get()))
                .addCriterion("has_rosegold_sword", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_SWORD.get()))
                .addCriterion("has_rosegold_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_HELMET.get()))
                .addCriterion("has_rosegold_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_CHESTPLATE.get()))
                .addCriterion("has_rosegold_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_LEGGINGS.get()))
                .addCriterion("has_rosegold_boots", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.ROSEGOLD_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .parent(rosegoldBaseAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/bigger_upgrade")));

        Advancement longAgoAdvancement = Advancement.Builder.advancement()
                .display(
                        Blocks.CRACKED_STONE_BRICKS,
                        new TranslatableComponent("advancements.mod.long_ago.title"),
                        new TranslatableComponent("advancements.mod.long_ago.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("find_castle_ruins", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(Structures.CASTLE_RUINS.get())))
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/long_ago")));

        Advancement lumberjackHouseAdvancement = Advancement.Builder.advancement()
                .display(
                        Blocks.SPRUCE_LOG,
                        new TranslatableComponent("advancements.mod.hello_anybody_here.title"),
                        new TranslatableComponent("advancements.mod.hello_anybody_here.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("find_lumberjack_house", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(Structures.ABANDONED_LUMBERJACK_HOUSE.get())))
                .parent(longAgoAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/hello_anybody_here")));

        Advancement undergroundCabinAdvancement = Advancement.Builder.advancement()
                .display(
                        Items.BLACK_CANDLE,
                        new TranslatableComponent("advancements.mod.anybody_living_down_here.title"),
                        new TranslatableComponent("advancements.mod.anybody_living_down_here.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("find_underground_cabin", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(Structures.UNDERGROUND_CABIN.get())))
                .parent(lumberjackHouseAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/anybody_living_down_here")));

        Advancement.Builder.advancement()
                .display(
                        Registration.ANDESITE_PILLAR.get(),
                        new TranslatableComponent("advancements.mod.mountaineer.title"),
                        new TranslatableComponent("advancements.mod.mountaineer.description"),
                        null,
                        FrameType.TASK,
                        true,
                        false,
                        false)
                .addCriterion("find_mountain_fortress", LocationTrigger.TriggerInstance.located(LocationPredicate.inFeature(Structures.MOUNTAIN_FORTRESS.get())))
                .parent(undergroundCabinAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/mountaineer")));
    }
}
