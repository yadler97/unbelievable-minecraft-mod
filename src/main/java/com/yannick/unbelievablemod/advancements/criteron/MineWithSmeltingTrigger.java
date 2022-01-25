package com.yannick.unbelievablemod.advancements.criteron;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class MineWithSmeltingTrigger extends SimpleCriterionTrigger<MineWithSmeltingTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation("mine_with_smelting");

    public ResourceLocation getId() {
        return ID;
    }

    public MineWithSmeltingTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite entityPredicate, DeserializationContext conditionsParser) {
        return new MineWithSmeltingTrigger.TriggerInstance(entityPredicate);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::matches);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {

        public TriggerInstance(EntityPredicate.Composite player) {
            super(MineWithSmeltingTrigger.ID, player);
        }

        public static MineWithSmeltingTrigger.TriggerInstance minedWithSmelting() {
            return new MineWithSmeltingTrigger.TriggerInstance(EntityPredicate.Composite.ANY);
        }

        public boolean matches() {
            return true;
        }

        public JsonObject serializeToJson(SerializationContext conditions) {
            return super.serializeToJson(conditions);
        }
    }
}