# Yannick's Unbelievable Minecraft Mod

A truly unbelievable Minecraft Mod which adds various things like new ores, tools, food and building blocks.

This mod requires Forge. To install the mod, just move the built jar into the mods folder of your Minecraft installation.

Before building the jar, runData must be executed first. To then build the jar, simply run `./gradlew.bat build` (Windows).

## Items

### List
- Ruby
- Sapphire
- Sapphire Pickaxe
- Sapphire Axe
- Sapphire Shovel
- Sapphire Hoe
- Sapphire Sword
- Rosegold Pickaxe
- Rosegold Axe
- Rosegold Shovel
- Rosegold Hoe
- Rosegold Sword
- Rosegold Helmet
- Rosegold Chestplate
- Rosegold Leggings
- Rosegold Boots
- Copper Wrench
- Bundle
- Fried Egg
- Depth Meter
- Wooden Bucket
  - Wooden Water Bucket
  - Wooden Milk Bucket

### Details

#### Sapphire Tools
- slightly slower and break earlier than diamond tools, but mine four blocks in a row.
- able to mine all blocks that diamond tools can mine
- crafted with sticks and sapphires like other tools

#### Rosegold Tools and Armor
- created by combining a golden tool or piece of armor and a copper ingot in a smithing table
- has twice the durability of golden tools and armor (64 instead of 32)

#### Copper Wrench
- allows rotating placed blocks
- break after 100 uses (can be enchanted with Unbreaking and Mending)
- cannot be used on double blocks like beds, double chests and extended pistons
- crafted from four copper ingots

#### Depth Meter
- visually displays the current depth where the player is located
- crafted from copper ingots and rubies

#### Wooden Bucket
- Bucket made of wood
- cannot contain lava, powder snow or mobs like fishes
- breaks after a certain amount of uses

## Blocks

### List
- Ruby Ore
  - Deepslate Ruby Ore
- Block of Ruby
- Sapphire Ore
  - Deepslate Sapphire Ore
- Block of Sapphire
- Bamboo Block
  - Bamboo Slab
  - Bamboo Stairs
  - Bamboo Fence
  - Bamboo Fence Gate
  - Bamboo Door
  - Bamboo Trap Door
  - Bamboo Pressure Plate
  - Bamboo Button
- Quartz Wall
- Polished Granite Wall
- Polished Diorite Wall
- Polished Andesite Wall
- Granite Bricks
  - Granite Brick Slab
  - Granite Brick Stairs
- Diorite Bricks
  - Diorite Brick Slab
  - Diorite Brick Stairs
- Andesite Bricks
  - Andesite Brick Slab
  - Andesite Brick Stairs
- Granite Pillar
- Diorite Pillar
- Andesite Pillar
- Spruce Bookshelf
- Birch Bookshelf
- Jungle Bookshelf
- Acacia Bookshelf
- Dark Oak Bookshelf
- Crimson Bookshelf
- Warped Bookshelf
- Bamboo Bookshelf
- Oak Table
- Spruce Table
- Birch Table
- Jungle Table
- Acacia Table
- Dark Oak Table
- Crimson Table
- Warped Table
- Bamboo Table
- Oak Chair
- Spruce Chair
- Birch Chair
- Jungle Chair
- Acacia Chair
- Dark Oak Chair
- Crimson Chair
- Warped Chair
- Bamboo Chair
- Oak Shelf
- Spruce Shelf
- Birch Shelf
- Jungle Shelf
- Acacia Shelf
- Dark Oak Shelf
- Crimson Shelf
- Warped Shelf
- Bamboo Shelf
- Cut Gold
  - Cut Gold Slab
  - Cut Gold Stairs
- Sawmill

### Details

#### Sapphire Ore
- generates from the button of the world to level 40 in deserts and savannas and to level 20 in other biomes
- can be found in abundance in deserts and savannas and very rarely in other biomes

#### Ruby Ore
- generates from the button of the world to level 40 in jungles and to level 20 in other biomes
- can be found in abundance in jungles and very rarely in other biomes

#### Bamboo Blocks
- crafted from four bamboo items in a square
- can be used as a building material

#### Chairs
- players can sit on chairs by right-clicking on them
- cushions can be added by right-clicking with a carpet

#### Shelves
- can store up to four items for decorative purposes
- an item can be added to the shelf by right-clicking with the item on one of the four shelf slots
- stored items are visually displayed in the shelf
- a redstone comparator can be used to get the amount of items in a shelf in form of a redstone signal
- emit light when they store a light source item

#### Sawmill
- stonecutter variant for sawing wood
- wooden tables, chairs and shelves can only be crafted using the sawmill

## Structures

### Abandoned Lumberjack House
- generates only in extreme hills biomes
- contains three strays and a chest with loot

### Castle Ruins
- consists of multiple parts that are randomly put together during generation
- may have special rooms with treasure chests and/or a basement with treasure chests and mob spawners

### Underground Cabin
- small miner's hut that only generates below y = 0
- loot chest can contain enchanted book with Smelting

### Mountain Fortress
- large fortress that only generates between y = 150 and y = 200
- populated by pillagers

## Enchantments

### Smelting
- smelts mined blocks directly without needing a furnace
- cannot be obtained using an enchantment table
- is incompatible with Silk Touch
- gives no experience orbs when mining

## Advancements
- the mod contains several advancements that can be found in a separate tab in the advancement screen

## Config

### Server Config
- **sapphireToolsMaxMiningBlocks**: How many additional blocks in a row sapphire tools can mine at max

### Client Config
- **renderBlockItemsAsBlocks**: Determines if BlockItems should be rendered as blocks instead of items in shelves
- **renderItemsLying**: Determines if Items should be rendered lying on the floor of the shelf slot instead of floating

## Special Thanks
Special thanks go to the creators of Forge modding tutorials that were really useful for me as a beginner:

- [McJty](https://github.com/McJty/YouTubeTutorial17)
- [TurtyWurty](https://github.com/DaRealTurtyWurty/1.17-Tutorial-Mod)
- [Tutorials By Kaupenjoe](https://github.com/Tutorials-By-Kaupenjoe/Forge-Tutorial-1.17.1)
- [TelepathicGrunt](https://github.com/TelepathicGrunt/StructureTutorialMod/)

Block models have been created using [Blockbench](https://www.blockbench.net/).