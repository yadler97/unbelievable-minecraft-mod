package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.blocks.*;
import com.yannick.unbelievablemod.items.*;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.items.Tiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UnbelievableMod.MODID);
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

    // Items
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new SapphirePickaxe(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new SapphireAxe(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new SapphireShovel(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(com.yannick.unbelievablemod.items.Tiers.SAPPHIRE, -3, 0.0F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(Tiers.SAPPHIRE, 3, -2.4F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

    public static final RegistryObject<Item> ROSEGOLD_PICKAXE = ITEMS.register("rosegold_pickaxe",
            () -> new PickaxeItem(Tiers.ROSEGOLD, 1, -2.8F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_AXE = ITEMS.register("rosegold_axe",
            () -> new AxeItem(Tiers.ROSEGOLD, 6.0F, -3.0F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_SHOVEL = ITEMS.register("rosegold_shovel",
            () -> new ShovelItem(Tiers.ROSEGOLD, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_HOE = ITEMS.register("rosegold_hoe",
            () -> new HoeItem(Tiers.ROSEGOLD, 0, -3.0F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_SWORD = ITEMS.register("rosegold_sword",
            () -> new SwordItem(Tiers.ROSEGOLD, 3, -2.4F, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB).food(Foods.FRIED_EGG)));

    public static final RegistryObject<Item> COPPER_WRENCH = ITEMS.register("copper_wrench",
            () -> new Wrench(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

    public static final RegistryObject<Item> BAMBOO_DOOR_ITEM = ITEMS.register("bamboo_door_item",
            () -> new FuelDoubleHighBlockItem(Registration.BAMBOO_DOOR.get(), (new Item.Properties()).tab(CreativeModeTabs.UNBELIEVABLE_TAB), 200));


    // Blocks
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)), false);
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), false);
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(RUBY_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)), false);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)), false);
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)), false);
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new OreBlock(BlockBehaviour.Properties.copy(SAPPHIRE_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)), false);

    public static final RegistryObject<FlammableBlock> BAMBOO_BLOCK = registerBlock("bamboo_block",
            () -> new FlammableBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD), 5 , 20), true);
    public static final RegistryObject<FlammableSlabBlock> BAMBOO_BLOCK_SLAB = registerBlock("bamboo_block_slab",
            () -> new FlammableSlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD), 5 , 20), true);
    public static final RegistryObject<FlammableStairBlock> BAMBOO_BLOCK_STAIRS = registerBlock("bamboo_block_stairs",
            () -> new FlammableStairBlock(() -> BAMBOO_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD), 5 , 20), true);
    public static final RegistryObject<FlammableFenceBlock> BAMBOO_BLOCK_FENCE = registerBlock("bamboo_block_fence",
            () -> new FlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD), 5 , 20), true);
    public static final RegistryObject<FlammableFenceGateBlock> BAMBOO_BLOCK_FENCE_GATE = registerBlock("bamboo_block_fence_gate",
            () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD), 5 , 20), true);
    public static final RegistryObject<DoorBlock> BAMBOO_DOOR = BLOCKS.register("bamboo_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> BAMBOO_TRAPDOOR = registerBlock("bamboo_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).strength(1.5F, 2.0F).sound(SoundType.WOOD).noOcclusion().isValidSpawn(Registration::never)), true);

    public static final RegistryObject<WallBlock> QUARTZ_WALL = registerBlock("quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)), false);

    public static final RegistryObject<GeneratorBlock> GENERATOR = registerBlock("generator", GeneratorBlock::new, false);
    public static final RegistryObject<BlockEntityType<GeneratorBE>> GENERATOR_BE = BLOCKENTITIES.register("generator",
            () -> BlockEntityType.Builder.of(GeneratorBE::new, GENERATOR.get()).build(null));
    public static final RegistryObject<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = CONTAINERS.register("generator",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();
                return new GeneratorContainer(windowId, world, pos, inv, inv.player);
    }));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean isFuel) {
        RegistryObject<T> registryBlock = BLOCKS.register(name, block);
        registerBlockItem(name, registryBlock, isFuel);
        return registryBlock;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, boolean isFuel) {
        if (isFuel) {
            ITEMS.register(name, () -> new FuelBlockItem(block.get(),
                    new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB), 200));
        } else {
            ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
        }

    }

    private static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }
}
