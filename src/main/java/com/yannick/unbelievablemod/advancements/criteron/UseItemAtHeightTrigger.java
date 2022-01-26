package com.yannick.unbelievablemod.advancements.criteron;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class UseItemAtHeightTrigger extends SimpleCriterionTrigger<UseItemAtHeightTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation("use_item_at_height");

    public ResourceLocation getId() {
        return ID;
    }

    public UseItemAtHeightTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite entityPredicate, DeserializationContext conditionsParser) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(json.get("item"));
        MinMaxBounds.Ints height = MinMaxBounds.Ints.fromJson(json.get("height"));
        return new UseItemAtHeightTrigger.TriggerInstance(entityPredicate, itemPredicate, height);
    }

    public void trigger(ServerPlayer player, ItemStack itemStack, int height) {
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(itemStack, height));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate itemPredicate;
        private final MinMaxBounds.Ints height;

        public TriggerInstance(EntityPredicate.Composite player, ItemPredicate itemPredicate, MinMaxBounds.Ints height) {
            super(UseItemAtHeightTrigger.ID, player);
            this.itemPredicate = itemPredicate;
            this.height = height;
        }

        public static UseItemAtHeightTrigger.TriggerInstance usedItemAtHeight(ItemPredicate itemPredicate, MinMaxBounds.Ints height) {
            return new UseItemAtHeightTrigger.TriggerInstance(EntityPredicate.Composite.ANY, itemPredicate, height);
        }

        public boolean matches(ItemStack itemStack, int height) {
            return this.itemPredicate.matches(itemStack) && this.height.matches(height);
        }

        public JsonObject serializeToJson(SerializationContext conditions) {
            JsonObject jsonobject = super.serializeToJson(conditions);
            jsonobject.add("item", this.itemPredicate.serializeToJson());
            jsonobject.add("height", this.height.serializeToJson());
            return jsonobject;
        }
    }
}
