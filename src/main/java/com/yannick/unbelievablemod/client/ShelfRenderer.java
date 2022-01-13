package com.yannick.unbelievablemod.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.yannick.unbelievablemod.blocks.ShelfBlock;
import com.yannick.unbelievablemod.blocks.ShelfBlockEntity;
import com.yannick.unbelievablemod.setup.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShelfRenderer implements BlockEntityRenderer<ShelfBlockEntity> {

    public ShelfRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ShelfBlockEntity shelfBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        Direction direction = shelfBlockEntity.getBlockState().getValue(ShelfBlock.FACING);
        NonNullList<ItemStack> items = shelfBlockEntity.getItems();
        int i = (int)shelfBlockEntity.getBlockPos().asLong();

        for(int itemSlot = 0; itemSlot < items.size(); ++itemSlot) {
            ItemStack itemstack = items.get(itemSlot);
            if (itemstack != ItemStack.EMPTY) {
                poseStack.pushPose();

                switch (direction) {
                    case NORTH -> {
                        switch (itemSlot) {
                            case 0 -> poseStack.translate(0.75D, 0.25D, 0.75D);
                            case 1 -> poseStack.translate(0.25D, 0.25D, 0.75D);
                            case 2 -> poseStack.translate(0.75D, 0.75D, 0.75D);
                            case 3 -> poseStack.translate(0.25D, 0.75D, 0.75D);
                        }
                    }
                    case EAST -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(270.0F));

                        switch (itemSlot) {
                            case 0 -> poseStack.translate(0.75D, 0.25D, -0.25D);
                            case 1 -> poseStack.translate(0.25D, 0.25D, -0.25D);
                            case 2 -> poseStack.translate(0.75D, 0.75D, -0.25D);
                            case 3 -> poseStack.translate(0.25D, 0.75D, -0.25D);
                        }
                    }
                    case SOUTH -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));

                        switch (itemSlot) {
                            case 0 -> poseStack.translate(-0.25D, 0.25D, -0.25D);
                            case 1 -> poseStack.translate(-0.75D, 0.25D, -0.25D);
                            case 2 -> poseStack.translate(-0.25D, 0.75D, -0.25D);
                            case 3 -> poseStack.translate(-0.75D, 0.75D, -0.25D);
                        }
                    }
                    case WEST -> {
                        poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));

                        switch (itemSlot) {
                            case 0 -> poseStack.translate(-0.25D, 0.25D, 0.75D);
                            case 1 -> poseStack.translate(-0.75D, 0.25D, 0.75D);
                            case 2 -> poseStack.translate(-0.25D, 0.75D, 0.75D);
                            case 3 -> poseStack.translate(-0.75D, 0.75D, 0.75D);
                        }
                    }
                }

                if (itemstack.getItem() instanceof BlockItem blockItem && !(itemstack.is(ItemTags.FLOWERS) || itemstack.is(ItemTags.DOORS) || itemstack.is(ItemTags.SIGNS) || itemstack.is(ItemTags.SAPLINGS) ||
                        itemstack.getItem() == Items.BAMBOO || itemstack.getItem() == Items.KELP || itemstack.getItem() == Items.SUGAR_CANE || itemstack.getItem() == Items.BELL || itemstack.getItem() == Items.TRIPWIRE_HOOK ||
                        itemstack.getItem() == Items.VINE || itemstack.getItem() == Items.GLOW_LICHEN || itemstack.getItem() == Items.LILY_PAD || itemstack.getItem() == Items.LADDER || itemstack.getItem() == Items.AMETHYST_CLUSTER ||
                        ((BlockItem) itemstack.getItem()).getBlock() instanceof IronBarsBlock || (((BlockItem) itemstack.getItem()).getBlock() instanceof BushBlock && !(((BlockItem) itemstack.getItem()).getBlock() instanceof SeaPickleBlock)) ||
                        itemstack.getItem() instanceof ItemNameBlockItem || ((BlockItem) itemstack.getItem()).getBlock() instanceof BaseCoralPlantTypeBlock ||
                        ((BlockItem) itemstack.getItem()).getBlock() instanceof WeepingVinesBlock || ((BlockItem) itemstack.getItem()).getBlock() instanceof WeepingVinesPlantBlock ||
                        ((BlockItem) itemstack.getItem()).getBlock() instanceof TwistingVinesBlock || ((BlockItem) itemstack.getItem()).getBlock() instanceof TwistingVinesPlantBlock)) {
                    if (Config.RENDER_SHELF_BLOCK_ITEMS_AS_BLOCKS.get()) {
                        if (itemstack.is(ItemTags.BEDS)) {
                            poseStack.scale(0.375F, 0.375F, 0.375F);
                            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                            poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                            poseStack.translate(0.0D, 0.0D, 0.375D);
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                        } else if (itemstack.getItem() == Items.CAKE || itemstack.is(ItemTags.CANDLES) || itemstack.getItem() == Items.LANTERN || itemstack.getItem() == Items.SOUL_LANTERN || itemstack.getItem() == Items.FLOWER_POT ||
                                itemstack.getItem() == Items.TURTLE_EGG || itemstack.getItem() == Items.SEA_PICKLE || itemstack.getItem() == Items.TORCH || itemstack.getItem() == Items.SOUL_TORCH ||
                                itemstack.getItem() == Items.REDSTONE_TORCH || itemstack.getItem() == Items.COBWEB || itemstack.getItem() == Items.HANGING_ROOTS) {
                            poseStack.scale(0.375F, 0.375F, 0.375F);
                            poseStack.translate(-0.5D, -0.5D, -0.5D);
                            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState(), poseStack, multiBufferSource, packedLight, packedOverlay, net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
                        } else if (itemstack.getItem() == Items.REPEATER || itemstack.getItem() == Items.COMPARATOR || itemstack.getItem() == Items.BREWING_STAND || itemstack.getItem() == Items.CAULDRON || itemstack.getItem() == Items.HOPPER ||
                                itemstack.getItem() == Items.CAMPFIRE || itemstack.getItem() == Items.SOUL_CAMPFIRE) {
                            poseStack.scale(0.25F, 0.25F, 0.25F);
                            poseStack.translate(-0.5D, -0.75D, -0.5D);
                            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState(), poseStack, multiBufferSource, packedLight, packedOverlay, net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
                        } else if (itemstack.getItem() == Items.LEVER || itemstack.is(ItemTags.BUTTONS)) {
                            poseStack.scale(0.375F, 0.375F, 0.375F);
                            poseStack.translate(-0.5D, -0.5D, -0.5D);
                            Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState().setValue(BlockStateProperties.ATTACH_FACE, AttachFace.FLOOR), poseStack, multiBufferSource, packedLight, packedOverlay, net.minecraftforge.client.model.data.EmptyModelData.INSTANCE);
                        } else {
                            poseStack.scale(0.5F, 0.5F, 0.5F);
                            poseStack.translate(0.0D, -0.125D, 0.0D);
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                        }
                    } else {
                        if (itemstack.is(ItemTags.BEDS)) {
                            poseStack.scale(0.375F, 0.375F, 0.375F);
                            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                            poseStack.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                            poseStack.translate(0.0D, 0.0D, 0.375D);
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                        } else if (itemstack.getItem() == Items.CAKE || itemstack.is(ItemTags.CANDLES) || itemstack.getItem() == Items.LANTERN || itemstack.getItem() == Items.SOUL_LANTERN || itemstack.getItem() == Items.FLOWER_POT ||
                                itemstack.getItem() == Items.TURTLE_EGG || itemstack.getItem() == Items.SEA_PICKLE || itemstack.getItem() == Items.TORCH || itemstack.getItem() == Items.SOUL_TORCH ||
                                itemstack.getItem() == Items.REDSTONE_TORCH || itemstack.getItem() == Items.COBWEB || itemstack.getItem() == Items.HANGING_ROOTS || itemstack.getItem() == Items.REPEATER ||
                                itemstack.getItem() == Items.COMPARATOR || itemstack.getItem() == Items.BREWING_STAND || itemstack.getItem() == Items.CAULDRON || itemstack.getItem() == Items.HOPPER ||
                                itemstack.getItem() == Items.CAMPFIRE || itemstack.getItem() == Items.SOUL_CAMPFIRE || itemstack.getItem() == Items.LEVER || itemstack.is(ItemTags.BUTTONS)) {
                            if (Config.RENDER_SHELF_ITEMS_LYING.get()) {
                                poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                                poseStack.translate(0.0D, 0.0D, 0.175D);
                            }

                            poseStack.scale(0.375F, 0.375F, 0.375F);
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                        } else {
                            poseStack.scale(0.5F, 0.5F, 0.5F);
                            poseStack.translate(0.0D, -0.125D, 0.0D);
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                        }
                    }
                } else {
                    if (Config.RENDER_SHELF_ITEMS_LYING.get()) {
                        poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                        poseStack.translate(0.0D, 0.0D, 0.175D);
                    }

                    poseStack.scale(0.375F, 0.375F, 0.375F);
                    Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, packedLight, packedOverlay, poseStack, multiBufferSource, i + itemSlot);
                }

                poseStack.popPose();
            }
        }
    }
}
