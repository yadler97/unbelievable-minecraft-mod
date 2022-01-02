package com.yannick.unbelievablemod.blocks;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ChairEntity extends Entity {
    public ChairEntity(EntityType<? extends ChairEntity> entityType, Level level) {
        super(entityType, level);
    }

    public ChairEntity(Level level, BlockPos blockPos) {
        this(Registration.CHAIR_ENTITY.get(), level);
        this.setPos(blockPos.getX() + 0.5D, blockPos.getY() - 1.2D, blockPos.getZ() + 0.5D);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
