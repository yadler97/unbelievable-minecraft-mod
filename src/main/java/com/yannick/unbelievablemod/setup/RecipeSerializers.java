package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.UnbelievableMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnbelievableMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RecipeSerializers {
    public static final RecipeSerializer<WoodsawingRecipe> WOODSAWING = new SingleItemRecipe.Serializer<>(WoodsawingRecipe::new) {};

    @SubscribeEvent
    public static void onRegisterSerializers(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        event.getRegistry().register(WOODSAWING.setRegistryName(new ResourceLocation(UnbelievableMod.MODID, "woodsawing")));
    }
}
