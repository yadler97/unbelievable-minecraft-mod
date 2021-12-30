package com.yannick.unbelievablemod.blocks;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.setup.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.EmptyModelData;

import java.util.Random;

public class ShelfRenderer implements BlockEntityRenderer<ShelfBlockEntity> {

    public static final ResourceLocation MAGICBLOCK_TEXTURE = new ResourceLocation(UnbelievableMod.MODID, "block/bamboo_block");

    public ShelfRenderer(BlockEntityRendererProvider.Context p_173529_) {
    }

    private void add(VertexConsumer renderer, PoseStack stack, float x, float y, float z, float u, float v) {
        renderer.vertex(stack.last().pose(), x, y, z)
                .color(1.0f, 1.0f, 1.0f, 1.0f)
                .uv(u, v)
                .uv2(0, 240)
                .normal(1, 0, 0)
                .endVertex();
    }

    private static float diffFunction(long time, long delta, float scale) {
        long dt = time % (delta * 2);
        if (dt > delta) {
            dt = 2*delta - dt;
        }
        return dt * scale;
    }

    @Override
    public void render(ShelfBlockEntity tileEntity, float p_112141_, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {

        int brightness = LightTexture.FULL_BRIGHT;
        // To achieve a pulsating effect we use the current time
        float s = (System.currentTimeMillis() % 1000) / 1000.0f;
        if (s > 0.5f) {
            s = 1.0f - s;
        }
        float scale = 0.1f + s * .3f;

        // Get our texture from the atlas
        TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(MAGICBLOCK_TEXTURE);

        // Always remember to push the current transformation so that you can restore it later
        poseStack.pushPose();

        // Translate to the middle of the block and 1 unit higher
        poseStack.translate(0.5, 1.5, 0.5);

        // Use the orientation of the main camera to make sure the single quad that we are going to render always faces the camera
        Quaternion rotation = Minecraft.getInstance().gameRenderer.getMainCamera().rotation();
        poseStack.mulPose(rotation);

        // Actually render the quad in our own custom render type
        VertexConsumer buffer = bufferSource.getBuffer(CustomRenderType.ADD);
        Matrix4f matrix = poseStack.last().pose();
        // Vertex data has to appear in a specific order:
        buffer.vertex(matrix, -scale, -scale, 0.0f).color(1.0f, 1.0f, 1.0f, 0.3f).uv(sprite.getU0(), sprite.getV0()).uv2(brightness).normal(1,0,0).endVertex();
        buffer.vertex(matrix, -scale, scale, 0.0f).color(1.0f, 1.0f, 1.0f, 0.3f).uv(sprite.getU0(), sprite.getV1()).uv2(brightness).normal(1,0,0).endVertex();
        buffer.vertex(matrix, scale, scale, 0.0f).color(1.0f, 1.0f, 1.0f, 0.3f).uv(sprite.getU1(), sprite.getV1()).uv2(brightness).normal(1,0,0).endVertex();
        buffer.vertex(matrix, scale, -scale, 0.0f).color(1.0f, 1.0f, 1.0f, 0.3f).uv(sprite.getU1(), sprite.getV0()).uv2(brightness).normal(1,0,0).endVertex();
        poseStack.popPose();
    }

    public boolean shouldRenderOffScreen(ShelfBlockEntity p_112138_) {
        return true;
    }

    public int getViewDistance() {
        return 256;
    }

    public boolean shouldRender(ShelfBlockEntity p_173531_, Vec3 p_173532_) {
        return Vec3.atCenterOf(p_173531_.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(p_173532_.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
    }

    public static void register() {
        BlockEntityRenderers.register(Registration.SHELF_BE.get(), ShelfRenderer::new);
    }
}
