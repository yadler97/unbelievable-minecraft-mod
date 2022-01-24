package com.yannick.unbelievablemod.advancements.criteron;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class SapphireMineMaxDistanceTrigger extends SimpleCriterionTrigger<SapphireMineMaxDistanceTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation("sapphire_mine_max_distance");

    public ResourceLocation getId() {
        return ID;
    }

    public SapphireMineMaxDistanceTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite entityPredicate, DeserializationContext conditionsParser) {
        ItemPredicate itemPredicate = ItemPredicate.fromJson(json.get("item"));
        return new SapphireMineMaxDistanceTrigger.TriggerInstance(entityPredicate, itemPredicate);
    }

    public void trigger(ServerPlayer player, ItemStack itemStack) {
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(itemStack));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate itemPredicate;

        public TriggerInstance(EntityPredicate.Composite player, ItemPredicate itemPredicate) {
            super(SapphireMineMaxDistanceTrigger.ID, player);
            this.itemPredicate = itemPredicate;
        }

        public static SapphireMineMaxDistanceTrigger.TriggerInstance minedWithMaxDistance(ItemPredicate itemPredicate) {
            return new SapphireMineMaxDistanceTrigger.TriggerInstance(EntityPredicate.Composite.ANY, itemPredicate);
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
