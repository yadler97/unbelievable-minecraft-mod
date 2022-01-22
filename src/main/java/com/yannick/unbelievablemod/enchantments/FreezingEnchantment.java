package com.yannick.unbelievablemod.enchantments;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class FreezingEnchantment  extends Enchantment {
    public FreezingEnchantment(Rarity rarity, EnchantmentCategory category, EquipmentSlot... applicableSlots) {
        super(rarity, category, applicableSlots);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean checkCompatibility(Enchantment otherEnchantment) {
        return otherEnchantment != Enchantments.FIRE_ASPECT;
    }

    @Override
    public void doPostAttack(LivingEntity attacker, Entity target, int level) {
        if (!(target instanceof Stray)) {
            target.setTicksFrozen(1000);
            if (target instanceof Mob mob) {
                mob.restrictTo(mob.blockPosition(), 0);
            }
        }
        if (target instanceof Skeleton skeleton) {
            skeleton.convertTo(EntityType.STRAY, true);
            if (!skeleton.isSilent()) {
                skeleton.level.levelEvent(null, 1048, skeleton.blockPosition(), 0);
            }
        }
        super.doPostAttack(attacker, target, level);
    }
}
