package com.yannick.unbelievablemod.advancements.criteron;

import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class AddItemToShelfTrigger extends SimpleCriterionTrigger<AddItemToShelfTrigger.TriggerInstance> {
    static final ResourceLocation ID = new ResourceLocation("add_item_to_shelf");

    public ResourceLocation getId() {
        return ID;
    }

    public AddItemToShelfTrigger.TriggerInstance createInstance(JsonObject json, EntityPredicate.Composite entityPredicate, DeserializationContext conditionsParser) {
        ItemPredicate itemPredicate1 = ItemPredicate.fromJson(json.get("item1"));
        ItemPredicate itemPredicate2 = ItemPredicate.fromJson(json.get("item2"));
        ItemPredicate itemPredicate3 = ItemPredicate.fromJson(json.get("item3"));
        ItemPredicate itemPredicate4 = ItemPredicate.fromJson(json.get("item4"));
        return new AddItemToShelfTrigger.TriggerInstance(entityPredicate, itemPredicate1, itemPredicate2, itemPredicate3, itemPredicate4);
    }

    public void trigger(ServerPlayer player, NonNullList<ItemStack> items) {
        this.trigger(player, (triggerInstance) -> triggerInstance.matches(items));
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        private final ItemPredicate itemPredicate1;
        private final ItemPredicate itemPredicate2;
        private final ItemPredicate itemPredicate3;
        private final ItemPredicate itemPredicate4;

        public TriggerInstance(EntityPredicate.Composite player, ItemPredicate itemPredicate1, ItemPredicate itemPredicate2, ItemPredicate itemPredicate3, ItemPredicate itemPredicate4) {
            super(AddItemToShelfTrigger.ID, player);
            this.itemPredicate1 = itemPredicate1;
            this.itemPredicate2 = itemPredicate2;
            this.itemPredicate3 = itemPredicate3;
            this.itemPredicate4 = itemPredicate4;
        }

        public static AddItemToShelfTrigger.TriggerInstance itemAddedToShelf(ItemPredicate itemPredicate1, ItemPredicate itemPredicate2, ItemPredicate itemPredicate3, ItemPredicate itemPredicate4) {
            return new AddItemToShelfTrigger.TriggerInstance(EntityPredicate.Composite.ANY, itemPredicate1, itemPredicate2, itemPredicate3, itemPredicate4);
        }

        public boolean matches(NonNullList<ItemStack> items) {
            if (items.stream().map(ItemStack::getItem).distinct().count() != 4) {
                return false;
            }
            for (ItemStack itemStack : items) {
                if (!(this.itemPredicate1.matches(itemStack) || this.itemPredicate2.matches(itemStack) || this.itemPredicate3.matches(itemStack) || this.itemPredicate4.matches(itemStack))) {
                    return false;
                }
            }

            return true;
        }

        public JsonObject serializeToJson(SerializationContext conditions) {
            JsonObject jsonobject = super.serializeToJson(conditions);
            jsonobject.add("item1", this.itemPredicate1.serializeToJson());
            jsonobject.add("item2", this.itemPredicate2.serializeToJson());
            jsonobject.add("item3", this.itemPredicate3.serializeToJson());
            jsonobject.add("item4", this.itemPredicate4.serializeToJson());
            return jsonobject;
        }
    }
}
