package com.yannick.unbelievablemod.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ShelfRenderer implements BlockEntityRenderer<ShelfBlockEntity> {

    public ShelfRenderer(BlockEntityRendererProvider.Context p_173529_) {
    }

    @Override
    public void render(ShelfBlockEntity shelfBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int combinedLight, int combinedOverlay) {
        Direction direction = shelfBlockEntity.getBlockState().getValue(ShelfBlock.FACING);
        NonNullList<ItemStack> items = NonNullList.withSize(4, ItemStack.EMPTY);
        //items.set(0, shelfBlockEntity.getStackInSlot(0));//.getItem() == Items.AIR ? ItemStack.EMPTY : shelfBlockEntity.getStackInSlot(0));
        //items.set(1, shelfBlockEntity.getStackInSlot(1));//.getItem() == Items.AIR ? ItemStack.EMPTY : shelfBlockEntity.getStackInSlot(1));
        //items.set(2, shelfBlockEntity.getStackInSlot(2));//.getItem() == Items.AIR ? ItemStack.EMPTY : shelfBlockEntity.getStackInSlot(2));
        //items.set(3, shelfBlockEntity.getStackInSlot(3));//.getItem() == Items.AIR ? ItemStack.EMPTY : shelfBlockEntity.getStackInSlot(3));
        items.set(0, new ItemStack(Items.PAPER));
        items.set(1, new ItemStack(Items.COBBLESTONE));
        items.set(2, new ItemStack(Items.DIAMOND));
        items.set(3, new ItemStack(Items.GOLDEN_AXE));
        int i = (int)shelfBlockEntity.getBlockPos().asLong();

        for(int j = 0; j < items.size(); ++j) {
            ItemStack itemstack = items.get(j);
            if (itemstack != ItemStack.EMPTY) {
                poseStack.pushPose();

                switch (direction) {
                    case NORTH -> {
                        switch (j) {
                            case 0 -> poseStack.translate(0.75D, 0.25D, 0.75D);
                            case 1 -> poseStack.translate(0.25D, 0.25D, 0.75D);
                            case 2 -> poseStack.translate(0.75D, 0.75D, 0.75D);
                            case 3 -> poseStack.translate(0.25D, 0.75D, 0.75D);
                        }
                    }
                    case EAST -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(270.0F));

                        switch (j) {
                            case 0 -> poseStack.translate(0.75D, 0.25D, -0.25D);
                            case 1 -> poseStack.translate(0.25D, 0.25D, -0.25D);
                            case 2 -> poseStack.translate(0.75D, 0.75D, -0.25D);
                            case 3 -> poseStack.translate(0.25D, 0.75D, -0.25D);
                        }
                    }
                    case SOUTH -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));

                        switch (j) {
                            case 0 -> poseStack.translate(-0.25D, 0.25D, -0.25D);
                            case 1 -> poseStack.translate(-0.75D, 0.25D, -0.25D);
                            case 2 -> poseStack.translate(-0.25D, 0.75D, -0.25D);
                            case 3 -> poseStack.translate(-0.75D, 0.75D, -0.25D);
                        }
                    }
                    case WEST -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));

                        switch (j) {
                            case 0 -> poseStack.translate(-0.25D, 0.25D, 0.75D);
                            case 1 -> poseStack.translate(-0.75D, 0.25D, 0.75D);
                            case 2 -> poseStack.translate(-0.25D, 0.75D, 0.75D);
                            case 3 -> poseStack.translate(-0.75D, 0.75D, 0.75D);
                        }
                    }
                }

                if (itemstack.getItem() instanceof BlockItem) {
                    poseStack.scale(0.5F, 0.5F, 0.5F);
                    poseStack.translate(0.0D, -0.125D, 0.0D);
                } else {
                    poseStack.scale(0.375F, 0.375F, 0.375F);
                }

                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, combinedLight, combinedOverlay, poseStack, multiBufferSource, i + j);
                poseStack.popPose();
            }
        }
    }

    public static void register() {
        BlockEntityRenderers.register(Registration.SHELF_BE.get(), ShelfRenderer::new);
    }
}
