package com.yannick.unbelievablemod.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class SmeltingEnchantment extends Enchantment {
    public SmeltingEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... applicableSlots) {
        super(rarity, category, applicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean checkCompatibility(Enchantment otherEnchantment) {
        return otherEnchantment != Enchantments.SILK_TOUCH;
    }
}
