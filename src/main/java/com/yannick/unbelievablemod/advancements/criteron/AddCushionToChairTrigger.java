package com.yannick.unbelievablemod.advancements.criteron;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class AddCushionToChairTrigger extends SimpleCriterionTrigger<AddCushionToChairTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation("add_cushion_to_chair");

    public ResourceLocation getId() {
        return ID;
    }

    public AddCushionToChairTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite entityPredicate, DeserializationContext conditionsParser) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(json.get("item"));
        return new AddCushionToChairTrigger.TriggerInstance(entityPredicate, itemPredicate);
    }

    public void trigger(ServerPlayer player, ItemStack itemStack) {
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(itemStack));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate itemPredicate;

        public TriggerInstance(EntityPredicate.Composite player, ItemPredicate itemPredicate) {
            super(AddCushionToChairTrigger.ID, player);
            this.itemPredicate = itemPredicate;
        }

        public static AddCushionToChairTrigger.TriggerInstance addedCushionToChair(ItemPredicate itemPredicate) {
            return new AddCushionToChairTrigger.TriggerInstance(EntityPredicate.Composite.ANY, itemPredicate);
        }

        public boolean matches(ItemStack itemStack) {
            return this.itemPredicate.matches(itemStack);
        }

        public JsonObject serializeToJson(SerializationContext conditions) {
            JsonObject jsonobject = super.serializeToJson(conditions);
            jsonobject.add("item", this.itemPredicate.serializeToJson());
            return jsonobject;
        }
    }
}