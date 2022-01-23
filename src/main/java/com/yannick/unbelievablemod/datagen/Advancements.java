package com.yannick.unbelievablemod.datagen;

import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.CustomTags;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
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

        Advancement.Builder.advancement()
                .display(
                    Registration.OAK_CHAIR.get(),
                    new TranslatableComponent("advancements.mod.professional_interior_designer.title"),
                    new TranslatableComponent("advancements.mod.professional_interior_designer.description"),
                    null,
                    FrameType.TASK,
                    true,
                    false,
                    false)
                .addCriterion("has_table", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(CustomTags.Items.TABLES).build()))
                .addCriterion("has_chair", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(CustomTags.Items.CHAIRS).build()))
                .addCriterion("has_shelf", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(CustomTags.Items.SHELVES).build()))
                .requirements(RequirementsStrategy.AND)
                .parent(rootAdvancement)
                .save(consumer, String.valueOf(new ResourceLocation(UnbelievableMod.MODID, "mod/professional_interior_designer")));

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

        Advancement.Builder.advancement()
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
    }
}
