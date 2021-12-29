package com.yannick.unbelievablemod.setup;

import com.yannick.unbelievablemod.blocks.*;
import com.yannick.unbelievablemod.inventory.GeneratorContainer;
import com.yannick.unbelievablemod.inventory.SawmillMenu;
import com.yannick.unbelievablemod.items.*;
import com.yannick.unbelievablemod.UnbelievableMod;
import com.yannick.unbelievablemod.items.ArmorMaterials;
import com.yannick.unbelievablemod.items.Tiers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.ContainerLevelAccess;
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

    public static final RegistryObject<Item> ROSEGOLD_HELMET = ITEMS.register("rosegold_helmet",
            () -> new ArmorItem(ArmorMaterials.ROSEGOLD, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_CHESTPLATE = ITEMS.register("rosegold_chestplate",
            () -> new ArmorItem(ArmorMaterials.ROSEGOLD, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_LEGGINGS = ITEMS.register("rosegold_leggings",
            () -> new ArmorItem(ArmorMaterials.ROSEGOLD, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));
    public static final RegistryObject<Item> ROSEGOLD_BOOTS = ITEMS.register("rosegold_boots",
            () -> new ArmorItem(ArmorMaterials.ROSEGOLD, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

    public static final RegistryObject<Item> FRIED_EGG = ITEMS.register("fried_egg",
            () -> new Item(new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB).food(Foods.FRIED_EGG)));

    public static final RegistryObject<Item> COPPER_WRENCH = ITEMS.register("copper_wrench",
            () -> new Wrench(Tiers.COPPER, new Item.Properties().tab(CreativeModeTabs.UNBELIEVABLE_TAB)));

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
    public static final RegistryObject<PressurePlateBlock> BAMBOO_PRESSURE_PLATE = registerBlock("bamboo_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).noCollission().strength(0.5F).sound(SoundType.WOOD)), true);
    public static final RegistryObject<WoodButtonBlock> BAMBOO_BUTTON = registerBlock("bamboo_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PLANT).noCollission().strength(0.5F).sound(SoundType.WOOD)), true);

    public static final RegistryObject<WallBlock> QUARTZ_WALL = registerBlock("quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)), false);
    public static final RegistryObject<WallBlock> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)), false);
    public static final RegistryObject<WallBlock> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE)), false);
    public static final RegistryObject<WallBlock> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE)), false);

    public static final RegistryObject<EnchantPowerBonusBlock> SPRUCE_BOOKSHELF = registerBlock("spruce_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);
    public static final RegistryObject<EnchantPowerBonusBlock> BIRCH_BOOKSHELF = registerBlock("birch_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);
    public static final RegistryObject<EnchantPowerBonusBlock> JUNGLE_BOOKSHELF = registerBlock("jungle_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);
    public static final RegistryObject<EnchantPowerBonusBlock> ACACIA_BOOKSHELF = registerBlock("acacia_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);
    public static final RegistryObject<EnchantPowerBonusBlock> DARK_OAK_BOOKSHELF = registerBlock("dark_oak_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);
    public static final RegistryObject<EnchantPowerBonusBlock> CRIMSON_BOOKSHELF = registerBlock("crimson_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 0, 0), false);
    public static final RegistryObject<EnchantPowerBonusBlock> WARPED_BOOKSHELF = registerBlock("warped_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 0, 0), false);
    public static final RegistryObject<EnchantPowerBonusBlock> BAMBOO_BOOKSHELF = registerBlock("bamboo_bookshelf",
            () -> new EnchantPowerBonusBlock(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF), 30, 20), true);

    public static final RegistryObject<TableBlock> OAK_TABLE = registerBlock("oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> SPRUCE_TABLE = registerBlock("spruce_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> BIRCH_TABLE = registerBlock("birch_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> JUNGLE_TABLE = registerBlock("jungle_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> ACACIA_TABLE = registerBlock("acacia_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> DARK_OAK_TABLE = registerBlock("dark_oak_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<TableBlock> CRIMSON_TABLE = registerBlock("crimson_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), 0, 0), false);
    public static final RegistryObject<TableBlock> WARPED_TABLE = registerBlock("warped_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), 0, 0), false);
    public static final RegistryObject<TableBlock> BAMBOO_TABLE = registerBlock("bamboo_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Registration.BAMBOO_BLOCK.get()), 5 , 20), true);

    public static final RegistryObject<ChairBlock> OAK_CHAIR = registerBlock("oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> SPRUCE_CHAIR = registerBlock("spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> BIRCH_CHAIR = registerBlock("birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> JUNGLE_CHAIR = registerBlock("jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> ACACIA_CHAIR = registerBlock("acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> DARK_OAK_CHAIR = registerBlock("dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<ChairBlock> CRIMSON_CHAIR = registerBlock("crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), 0, 0), false);
    public static final RegistryObject<ChairBlock> WARPED_CHAIR = registerBlock("warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), 0, 0), false);
    public static final RegistryObject<ChairBlock> BAMBOO_CHAIR = registerBlock("bamboo_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Registration.BAMBOO_BLOCK.get()), 5 , 20), true);

    public static final RegistryObject<ShelfBlock> OAK_SHELF = registerBlock("oak_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> SPRUCE_SHELF = registerBlock("spruce_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> BIRCH_SHELF = registerBlock("birch_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> JUNGLE_SHELF = registerBlock("jungle_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> ACACIA_SHELF = registerBlock("acacia_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> DARK_OAK_SHELF = registerBlock("dark_oak_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), 5 , 20), true);
    public static final RegistryObject<ShelfBlock> CRIMSON_SHELF = registerBlock("crimson_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS), 0, 0), false);
    public static final RegistryObject<ShelfBlock> WARPED_SHELF = registerBlock("warped_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS), 0, 0), false);
    public static final RegistryObject<ShelfBlock> BAMBOO_SHELF = registerBlock("bamboo_shelf",
            () -> new ShelfBlock(BlockBehaviour.Properties.copy(Registration.BAMBOO_BLOCK.get()), 5 , 20), true);

    public static final RegistryObject<Block> CUT_GOLD = registerBlock("cut_gold",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), false);
    public static final RegistryObject<SlabBlock> CUT_GOLD_SLAB = registerBlock("cut_gold_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), false);
    public static final RegistryObject<StairBlock> CUT_GOLD_STAIRS = registerBlock("cut_gold_stairs",
            () -> new StairBlock(() -> CUT_GOLD.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), false);

    public static final RegistryObject<SawmillBlock> SAWMILL = registerBlock("sawmill",
            () -> new SawmillBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), false);
    public static final RegistryObject<MenuType<SawmillMenu>> SAWMILL_MENU = CONTAINERS.register("sawmill",
            () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();
                ContainerLevelAccess cla = ContainerLevelAccess.create(world, pos);
                return new SawmillMenu(windowId, inv, cla);
            }));

    // based on tutorial from McJty - will be changed later
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
