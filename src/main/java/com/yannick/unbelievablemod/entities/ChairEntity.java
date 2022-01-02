package com.yannick.unbelievablemod.entities;

import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ChairEntity extends Entity {

    private BlockPos location;

    public ChairEntity(EntityType<? extends ChairEntity> entityType, Level level) {
        super(entityType, level);
        this.noPhysics = true;
    }

    public ChairEntity(Level level, BlockPos blockPos) {
        this(Registration.CHAIR_ENTITY.get(), level);
        this.setPos(blockPos.getX() + 0.5D, blockPos.getY() - 1.2D, blockPos.getZ() + 0.5D);
        this.location = blockPos;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.location == null) {
            this.location = this.blockPosition();
        }

        if (!this.level.isClientSide) {
            if (this.getPassengers().isEmpty()) {
                this.remove(RemovalReason.UNLOADED_WITH_PLAYER);
            }
            if (this.level.isEmptyBlock(this.location)) {
                Entity player = this.getFirstPassenger();
                if (player != null) {
                    player.stopRiding();
                }
                this.remove(RemovalReason.DISCARDED);
            }
        }
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
