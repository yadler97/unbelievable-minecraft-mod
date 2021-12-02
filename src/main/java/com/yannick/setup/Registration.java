package com.yannick.setup;

import com.yannick.blocks.GeneratorBE;
import com.yannick.blocks.GeneratorBlock;
import com.yannick.blocks.GeneratorContainer;
import com.yannick.items.Tiers;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.items.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnbelievableMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnbelievableMod.MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, UnbelievableMod.MODID);
    private static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, UnbelievableMod.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        BLOCKS.register(bus);
        BLOCKENTITIES.register(bus);
        CONTAINERS.register(bus);
    }

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new Sapphire_Pickaxe(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new Sapphire_Axe(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new Sapphire_Shovel(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new HoeItem(Tiers.SAPPHIRE, -3, 0.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SwordItem(Tiers.SAPPHIRE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(Foods.FRIED_EGG)));

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItem(SAPPHIRE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> new BlockItem(SAPPHIRE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<WallBlock> QUARTZ_WALL = BLOCKS.register("quartz_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)));
    public static final RegistryObject<Item> QUARTZ_WALL_ITEM = ITEMS.register("quartz_wall", () -> new BlockItem(QUARTZ_WALL.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<GeneratorBlock> GENERATOR = BLOCKS.register("generator", GeneratorBlock::new);
    public static final RegistryObject<Item> GENERATOR_ITEM = ITEMS.register("generator", () -> new BlockItem(GENERATOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<BlockEntityType<GeneratorBE>> GENERATOR_BE = BLOCKENTITIES.register("generator",
            () -> BlockEntityType.Builder.of(GeneratorBE::new, GENERATOR.get()).build(null));
    public static final RegistryObject<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = CONTAINERS.register("generator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        Level world = inv.player.getCommandSenderWorld();
        return new GeneratorContainer(windowId, world, pos, inv, inv.player);
    }));
}
