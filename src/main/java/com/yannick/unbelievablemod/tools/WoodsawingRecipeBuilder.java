package com.yannick.unbelievablemod.tools;

import com.google.gson.JsonObject;
import com.yannick.unbelievablemod.setup.RecipeSerializers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class WoodsawingRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<?> type;

    public WoodsawingRecipeBuilder(RecipeSerializer<?> type, Ingredient ingredient, ItemLike result, int count) {
        this.type = type;
        this.result = result.asItem();
        this.ingredient = ingredient;
        this.count = count;
    }

    public static WoodsawingRecipeBuilder woodsawing(Ingredient ingredient, ItemLike itemLike) {
        return new WoodsawingRecipeBuilder(RecipeSerializers.WOODSAWING, ingredient, itemLike, 1);
    }

    public static WoodsawingRecipeBuilder woodsawing(Ingredient ingredient, ItemLike itemLike, int count) {
        return new WoodsawingRecipeBuilder(RecipeSerializers.WOODSAWING, ingredient, itemLike, count);
    }

    public WoodsawingRecipeBuilder unlockedBy(String name, CriterionTriggerInstance criterionTriggerInstance) {
        this.advancement.addCriterion(name, criterionTriggerInstance);
        return this;
    }

    public WoodsawingRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public Item getResult() {
        return this.result;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        consumer.accept(new SingleItemRecipeBuilder.Result(resourceLocation, this.type, this.group == null ? "" : this.group, this.ingredient, this.result, this.count, this.advancement, new ResourceLocation(resourceLocation.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + resourceLocation.getPath())));
    }

    private void ensureValid(ResourceLocation resourceLocation) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceLocation);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final Item result;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> type;

        public Result(ResourceLocation id, RecipeSerializer<?> type, String group, Ingredient ingredient, Item result, int count, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.type = type;
            this.group = group;
            this.ingredient = ingredient;
            this.result = result;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        public void serializeRecipeData(JsonObject recipeFile) {
            if (!this.group.isEmpty()) {
                recipeFile.addProperty("group", this.group);
            }

            recipeFile.add("ingredient", this.ingredient.toJson());
            recipeFile.addProperty("result", Registry.ITEM.getKey(this.result).toString());
            recipeFile.addProperty("count", this.count);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return this.type;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
