package model.enums;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

public enum EItem {

	//Blocks
	stone(1,0,"STONE",EItemCat.block),
	grass(2,0,"GRASS",EItemCat.block),
	dirt(3,0,"DIRT",EItemCat.block),
	cobblestone(4,0,"COBBLESTONE",EItemCat.block),
	oak_wood(5,0,"WOOD",EItemCat.block),
	red_wood(5,1,"WOOD",EItemCat.block),
	birch_wood(5,2,"WOOD",EItemCat.block),
	jungle_wood(5,3,"WOOD",EItemCat.block),
	oak_sapling(6,0,"SAPLING",EItemCat.decoration),
	red_sapling(6,1,"SAPLING",EItemCat.decoration),
	birch_sapling(6,2,"SAPLING",EItemCat.decoration),
	jungle_sapling(6,3,"SAPLING",EItemCat.decoration),
	sand(12,0,"SAND",EItemCat.block),
	//redsand(12,1,"SAND",EItemCat.block),
	gravel(13,0,"GRAVEL",EItemCat.block),
	gold_ore(14,0,"GOLD_ORE",EItemCat.block),
	iron_ore(15,0,"IRON_ORE",EItemCat.block),
	coal_ore(16,0,"COAL_ORE",EItemCat.block),
	oak_log(17,0,"LOG",EItemCat.block),
	red_log(17,1,"LOG",EItemCat.block),
	birch_log(17,2,"LOG",EItemCat.block),
	jungle_log(17,3,"LOG",EItemCat.block),
	oak_leaves(18,0,"LEAVES",EItemCat.decoration),
	red_leaves(18,1,"LEAVES",EItemCat.decoration),
	birch_leaves(18,2,"LEAVES",EItemCat.decoration),
	jungle_leaves(18,3,"LEAVES",EItemCat.decoration),
	glass(20,0,"GLASS",EItemCat.block),
	lapis_ore(21,0,"LAPIS_ORE",EItemCat.block),
	lapis_block(22,0,"LAPIS_BLOCK",EItemCat.block),
	dispenser(23,0,"DISPENSER",EItemCat.redstone),
	sandstone(24,0,"SANDSTONE",EItemCat.block),
	chiseled_sandstone(24,1,"SANDSTONE",EItemCat.block),
	smooth_sandstone(24,2,"SANDSTONE",EItemCat.block),
	note_block(25,0,"NOTE_BLOCK",EItemCat.redstone),
	powered_rail(27,0,"POWERED_RAIL",EItemCat.transport),
	detector_rail(28,0,"DETECTOR_RAIL",EItemCat.transport),
	sticky_piston(29,0,"PISTON_STICKY_BASE",EItemCat.redstone),
	cobweb(30,0,"WEB",EItemCat.decoration),
	long_grass(31,1,"LONG_GRASS",EItemCat.decoration),
	fern(31,2,"LONG_GRASS",EItemCat.decoration),
	dead_bush(32,0,"DEAD_BUSH",EItemCat.decoration),
	piston(33,0,"PISTON_BASE",EItemCat.redstone),
	white_wool(35,0,"WOOL",EItemCat.block),
	orange_wool(35,1,"WOOL",EItemCat.block),
	magenta_wool(35,2,"WOOL",EItemCat.block),
	lblue_wool(35,3,"WOOL",EItemCat.block),
	yellow_wool(35,4,"WOOL",EItemCat.block),
	lgreen_wool(35,5,"WOOL",EItemCat.block),
	pink_wool(35,6,"WOOL",EItemCat.block),
	gray_wool(35,7,"WOOL",EItemCat.block),
	lgray_wool(35,8,"WOOL",EItemCat.block),
	cyan_wool(35,9,"WOOL",EItemCat.block),
	purple_wool(35,10,"WOOL",EItemCat.block),
	blue_wool(35,11,"WOOL",EItemCat.block),
	brown_wool(35,12,"WOOL",EItemCat.block),
	green_wool(35,13,"WOOL",EItemCat.block),
	red_wool(35,14,"WOOL",EItemCat.block),
	black_wool(35,15,"WOOL",EItemCat.block),
	yellow_flower(37,0,"YELLOW_FLOWER",EItemCat.decoration),
	red_rose(38,0,"RED_ROSE",EItemCat.decoration),
	brown_mushroom(39,0,"BROWN_MUSHROOM",EItemCat.decoration),
	red_mushroom(40,0,"RED_MUSHROOM",EItemCat.decoration),
	gold_block(41,0,"GOLD_BLOCK",EItemCat.block),
	iron_block(42,0,"IRON_BLOCK",EItemCat.block),
	stone_slab(44,0,"STEP",EItemCat.block),
	sandstone_slab(44,1,"STEP",EItemCat.block),
	cobble_slab(44,2,"STEP",EItemCat.block),
	brick_slab(44,3,"STEP",EItemCat.block),
	stonebrick_slab(44,4,"STEP",EItemCat.block),
	netherbrick_slab(44,5,"STEP",EItemCat.block),
	quartz_slab(44,6,"STEP",EItemCat.block),
	brick(45,0,"BRICK",EItemCat.block),
	tnt(46,0,"TNT",EItemCat.redstone),
	bookshelf(47,0,"BOOKSHELF",EItemCat.block),
	mossy_cobblestone(48,0,"MOSSY_COBBLESTONE",EItemCat.block),
	obsidian(49,0,"OBSIDIAN",EItemCat.block),
	torch(50,0,"TORCH",EItemCat.decoration),
	wood_stairs(53,0,"WOOD_STAIRS",EItemCat.block),
	chest(54,0,"CHEST",EItemCat.decoration),
	diamond_ore(56,0,"DIAMOND_ORE",EItemCat.block),
	diamond_block(57,0,"DIAMOND_BLOCK",EItemCat.block),
	workbench(58,0,"WORKBENCH",EItemCat.block),
	furnace(61,0,"FURNACE",EItemCat.decoration),
	ladder(65,0,"LADDER",EItemCat.decoration),
	rails(66,0,"RAILS",EItemCat.transport),
	cobblestone_stairs(67,0,"COBBLESTONE_STAIRS",EItemCat.block),
	lever(68,0,"LEVER",EItemCat.redstone),
	stone_plate(70,0,"STONE_PLATE",EItemCat.redstone),
	wood_plate(72,0,"WOOD_PLATE",EItemCat.redstone),
	redstone_ore(73,0,"REDSTONE_ORE",EItemCat.block),
	redstone_torch_on(76,0,"REDSTONE_TORCH_ON",EItemCat.redstone),
	stone_button(77,0,"STONE_BUTTON",EItemCat.redstone),
	snow(78,0,"SNOW",EItemCat.decoration),
	ice(79,0,"ICE",EItemCat.block),
	snow_block(80,0,"SNOW_BLOCK",EItemCat.block),
	cactus(81,0,"CACTUS",EItemCat.decoration),
	clay(82,0,"CLAY",EItemCat.block),
	jukebox(84,0,"JUKEBOX",EItemCat.decoration),
	fence(85,0,"FENCE",EItemCat.decoration),
	pumpkin(86,0,"PUMPKIN",EItemCat.block),
	netherrack(87,0,"NETHERRACK",EItemCat.block),
	soul_sand(88,0,"SOUL_SAND",EItemCat.block),
	glowstone(89,0,"GLOWSTONE",EItemCat.block),
	jack_O_Lantern(91,0,"JACK_O_LANTERN",EItemCat.block),
	trap_door(96,0,"TRAP_DOOR",EItemCat.redstone),
	smooth_brick(97,0,"SMOOTH_BRICK",EItemCat.block),
	mossy_smooth_brick(97,1,"SMOOTH_BRICK",EItemCat.block),
	cracked_smooth_brick(97,2,"SMOOTH_BRICK",EItemCat.block),
	chiseled_smooth_brick(97,3,"SMOOTH_BRICK",EItemCat.block),
	huge_mushroom_1(99,0,"HUGE_MUSHROOM_1",EItemCat.block),
	huge_mushroom_2(100,0,"HUGE_MUSHROOM_1",EItemCat.block),
	iron_bars(101,0,"IRON_FENCE",EItemCat.decoration),
	glass_pane(102,0,"THIN_GLASS",EItemCat.decoration),
	melon_block(103,0,"MELON_BLOCK",EItemCat.block),
	vine(106,0,"VINE",EItemCat.decoration),
	fence_gate(107,0,"FENCE_GATE",EItemCat.redstone),
	brick_stairs(108,0,"BRICK_STAIRS",EItemCat.block),
	smooth_stairs(109,0,"SMOOTH_STAIRS",EItemCat.block),
	mycelium(110,0,"MYCEL",EItemCat.block),
	lilypad(111,0,"WATER_LILY",EItemCat.decoration),
	nether_brick_block(112,0,"NETHER_BRICK",EItemCat.block),
	nether_fence(113,0,"NETHER_FENCE",EItemCat.decoration),
	nether_brick_stairs(114,0,"NETHER_BRICK_STAIRS",EItemCat.block),
	enchantment_table(116,0,"ENCHANTMENT_TABLE",EItemCat.decoration),
	ender_stone(121,0,"ENDER_STONE",EItemCat.block),
	dragon_egg(122,0,"DRAGON_EGG",EItemCat.decoration),
	redstone_lamp_off(123,0,"REDSTONE_LAMP_OFF",EItemCat.redstone),
	redstone_lamp_on(124,0,"REDSTONE_LAMP_ON",EItemCat.redstone),
	oakwood_slab(126,0,"WOOD_STEP",EItemCat.block),
	redwood_slab(126,1,"WOOD_STEP",EItemCat.block),
	birchwood_slab(126,2,"WOOD_STEP",EItemCat.block),
	junglewood_slab(126,3,"WOOD_STEP",EItemCat.block),
	sandstone_stairs(128,0,"SANDSTONE_STAIRS",EItemCat.block),
	emerald_ore(129,0,"EMERALD_ORE",EItemCat.block),
	ender_chest(130,0,"ENDER_CHEST",EItemCat.decoration),
	tripwire_hook(131,0,"TRIPWIRE_HOOK",EItemCat.redstone),
	emerald_block(133,0,"EMERALD_BLOCK",EItemCat.block),
	spruce_wood_stairs(134,0,"SPRUCE_WOOD_STAIRS",EItemCat.block),
	birch_wood_stairs(135,0,"BIRCH_WOOD_STAIRS",EItemCat.block),
	jungle_wood_stairs(136,0,"JUNGLE_WOOD_STAIRS",EItemCat.block),
	beacon(138,0,"BEACON",EItemCat.misc),
	cobble_wall(139,0,"COBBLE_WALL",EItemCat.block),
	mossy_cobble_wall(139,1,"COBBLE_WALL",EItemCat.block),
	wood_button(143,0,"WOOD_BUTTON",EItemCat.redstone),
	anvil(145,0,"ANVIL",EItemCat.decoration),
	medium_damaged_anvil(145,1,"ANVIL",EItemCat.decoration),
	damaged_anvil(145,2,"ANVIL",EItemCat.decoration),
	trapped_chest(146,0,"TRAPPED_CHEST",EItemCat.decoration),
	gold_plate(147,0,"GOLD_PLATE",EItemCat.redstone),
	iron_plate(148,0,"IRON_PLATE",EItemCat.redstone),
	daylight_detector(151,0,"DAYLIGHT_DETECTOR",EItemCat.redstone),
	redstone_block(152,0,"REDSTONE_BLOCK",EItemCat.redstone),
	quartz_ore(153,0,"QUARTZ_ORE",EItemCat.block),
	hopper(154,0,"HOPPER",EItemCat.redstone),
	quartz_block(155,0,"QUARTZ_BLOCK",EItemCat.block),
	chiseled_quartz_block(155,1,"QUARTZ_BLOCK",EItemCat.block),
	pillar_quartz_block(155,2,"QUARTZ_BLOCK",EItemCat.block),
	quartz_stairs(156,0,"QUARTZ_STAIRS",EItemCat.block),
	activator_rail(157,0,"ACTIVATOR_RAIL",EItemCat.transport),
	dropper(158,0,"DROPPER",EItemCat.redstone),
	white_stained_clay(159,0,"STAINED_CLAY",EItemCat.block),
	orange_stained_clay(159,1,"STAINED_CLAY",EItemCat.block),
	magenta_stained_clay(159,2,"STAINED_CLAY",EItemCat.block),
	lblue_stained_clay(159,3,"STAINED_CLAY",EItemCat.block),
	yellow_stained_clay(159,4,"STAINED_CLAY",EItemCat.block),
	lgreen_stained_clay(159,5,"STAINED_CLAY",EItemCat.block),
	pink_stained_clay(159,6,"STAINED_CLAY",EItemCat.block),
	gray_stained_clay(159,7,"STAINED_CLAY",EItemCat.block),
	lgray_stained_clay(159,8,"STAINED_CLAY",EItemCat.block),
	cyan_stained_clay(159,9,"STAINED_CLAY",EItemCat.block),
	purple_stained_clay(159,10,"STAINED_CLAY",EItemCat.block),
	blue_stained_clay(159,11,"STAINED_CLAY",EItemCat.block),
	brown_stained_clay(159,12,"STAINED_CLAY",EItemCat.block),
	green_stained_clay(159,13,"STAINED_CLAY",EItemCat.block),
	red_stained_clay(159,14,"STAINED_CLAY",EItemCat.block),
	black_stained_clay(159,15,"STAINED_CLAY",EItemCat.block),
	hay_block(170,0,"HAY_BLOCK",EItemCat.block),
	white_carpet(171,0,"CARPET",EItemCat.decoration),
	orange_carpet(171,1,"CARPET",EItemCat.decoration),
	magenta_carpet(171,2,"CARPET",EItemCat.decoration),
	lblue_carpet(171,3,"CARPET",EItemCat.decoration),
	yellow_carpet(171,4,"CARPET",EItemCat.decoration),
	lgreen_carpet(171,5,"CARPET",EItemCat.decoration),
	pink_carpet(171,6,"CARPET",EItemCat.decoration),
	gray_carpet(171,7,"CARPET",EItemCat.decoration),
	lgray_carpet(171,8,"CARPET",EItemCat.decoration),
	cyan_carpet(171,9,"CARPET",EItemCat.decoration),
	purple_carpet(171,10,"CARPET",EItemCat.decoration),
	blue_carpet(171,11,"CARPET",EItemCat.decoration),
	brown_carpet(171,12,"CARPET",EItemCat.decoration),
	green_carpet(171,13,"CARPET",EItemCat.decoration),
	red_carpet(171,14,"CARPET",EItemCat.decoration),
	black_carpet(171,15,"CARPET",EItemCat.decoration),
	hardened_clay(172,0,"HARD_CLAY",EItemCat.block),
	coal_block(173,0,"COAL_BLOCK",EItemCat.block),

	//Items
	iron_spade(256,0,"IRON_SPADE",EItemCat.tool),
	iron_pickaxe(257,0,"IRON_PICKAXE",EItemCat.tool),
	iron_axe(258,0,"IRON_AXE",EItemCat.tool),
	flint_and_steel(259,0,"FLINT_AND_STEEL",EItemCat.tool),
	apple(260,0,"APPLE",EItemCat.food),
	bow(261,0,"BOW",EItemCat.weapon),
	arrow(262,0,"ARROW",EItemCat.weapon),
	coal(263,0,"COAL",EItemCat.materials),
	charcoal(263,1,"COAL",EItemCat.materials),
	diamond(264,0,"DIAMOND",EItemCat.materials),
	iron_ingot(265,0,"IRON_INGOT",EItemCat.materials),
	gold_ingot(266,0,"GOLD_INGOT",EItemCat.materials),
	iron_sword(267,0,"IRON_SWORD",EItemCat.weapon),
	wood_sword(268,0,"WOOD_SWORD",EItemCat.weapon),
	wood_spade(269,0,"WOOD_SPADE",EItemCat.tool),
	wood_pickaxe(270,0,"WOOD_PICKAXE",EItemCat.tool),
	wood_axe(271,0,"WOOD_AXE",EItemCat.tool),
	stone_sword(272,0,"STONE_SWORD",EItemCat.weapon),
	stone_spade(273,0,"STONE_SPADE",EItemCat.tool),
	stone_pickaxe(274,0,"STONE_PICKAXE",EItemCat.tool),
	stone_axe(275,0,"STONE_AXE",EItemCat.tool),
	diamond_sword(276,0,"DIAMOND_SWORD",EItemCat.weapon),
	diamond_spade(277,0,"DIAMOND_SPADE",EItemCat.tool),
	diamond_pickaxe(278,0,"DIAMOND_PICKAXE",EItemCat.tool),
	diamond_axe(279,0,"DIAMOND_AXE",EItemCat.tool),
	stick(280,0,"STICK",EItemCat.materials),
	bowl(281,0,"BOWL",EItemCat.materials),
	mushroom_soup(282,0,"MUSHROOM_SOUP",EItemCat.food),
	gold_sword(283,0,"GOLD_SWORD",EItemCat.weapon),
	gold_spade(284,0,"GOLD_SPADE",EItemCat.tool),
	gold_pickaxe(285,0,"GOLD_PICKAXE",EItemCat.tool),
	gold_axe(286,0,"GOLD_AXE",EItemCat.tool),
	string(287,0,"STRING",EItemCat.materials),
	feather(288,0,"FEATHER",EItemCat.materials),
	gunpowder(289,0,"SULPHUR",EItemCat.materials),
	wood_hoe(290,0,"WOOD_HOE",EItemCat.tool),
	stone_hoe(291,0,"STONE_HOE",EItemCat.tool),
	iron_hoe(292,0,"IRON_HOE",EItemCat.tool),
	diamond_hoe(293,0,"DIAMOND_HOE",EItemCat.tool),
	gold_hoe(294,0,"GOLD_HOE",EItemCat.tool),
	seeds(295,0,"SEEDS",EItemCat.materials),
	wheat(296,0,"WHEAT",EItemCat.materials),
	bread(297,0,"BREAD",EItemCat.food),
	leather_helmet(298,0,"LEATHER_HELMET",EItemCat.weapon),
	leather_chestplate(299,0,"LEATHER_CHESTPLATE",EItemCat.weapon),
	leather_leggings(300,0,"LEATHER_LEGGINGS",EItemCat.weapon),
	leather_boots(301,0,"LEATHER_BOOTS",EItemCat.weapon),
	chainmail_helmet(302,0,"CHAINMAIL_HELMET",EItemCat.weapon),
	chainmail_chestplate(303,0,"CHAINMAIL_CHESTPLATE",EItemCat.weapon),
	chainmail_leggings(304,0,"CHAINMAIL_LEGGINGS",EItemCat.weapon),
	chainmail_boots(305,0,"CHAINMAIL_BOOTS",EItemCat.weapon),
	iron_helmet(306,0,"IRON_HELMET",EItemCat.weapon),
	iron_chestplate(307,0,"IRON_CHESTPLATE",EItemCat.weapon),
	iron_leggings(308,0,"IRON_LEGGINGS",EItemCat.weapon),
	iron_boots(309,0,"IRON_BOOTS",EItemCat.weapon),
	diamond_helmet(310,0,"DIAMOND_HELMET",EItemCat.weapon),
	diamond_chestplate(311,0,"DIAMOND_CHESTPLATE",EItemCat.weapon),
	diamond_leggings(312,0,"DIAMOND_LEGGINGS",EItemCat.weapon),
	diamond_boots(313,0,"DIAMOND_BOOTS",EItemCat.weapon),
	gold_helmet(314,0,"GOLD_HELMET",EItemCat.weapon),
	gold_chestplate(315,0,"GOLD_CHESTPLATE",EItemCat.weapon),
	gold_leggings(316,0,"GOLD_LEGGINGS",EItemCat.weapon),
	gold_boots(317,0,"GOLD_BOOTS",EItemCat.weapon),
	flint(318,0,"FLINT",EItemCat.materials),
	raw_pork(319,0,"PORK",EItemCat.food),
	cooked_pork(320,0,"GRILLED_PORK",EItemCat.food),
	painting(321,0,"PAINTING",EItemCat.decoration),
	golden_apple_1(322,0,"GOLDEN_APPLE",EItemCat.food),
	golden_apple_2(322,1,"GOLDEN_APPLE",EItemCat.food),
	sign(323,0,"SIGN",EItemCat.decoration),
	wood_door(324,0,"WOOD_DOOR",EItemCat.redstone),
	bucket(325,0,"BUCKET",EItemCat.misc),
	water_bucket(326,0,"WATER_BUCKET",EItemCat.misc),
	lava_bucket(327,0,"LAVA_BUCKET",EItemCat.misc),
	minecart(328,0,"MINECART",EItemCat.transport),
	saddle(329,0,"SADDLE",EItemCat.transport),
	iron_door(330,0,"IRON_DOOR",EItemCat.redstone),
	redstone(331,0,"REDSTONE",EItemCat.redstone),
	snow_ball(332,0,"SNOW_BALL",EItemCat.misc),
	boat(333,0,"BOAT",EItemCat.transport),
	leather(334,0,"LEATHER",EItemCat.materials),
	milk_bucket(335,0,"MILK_BUCKET",EItemCat.misc),
	clay_brick(336,0,"CLAY_BRICK",EItemCat.materials),
	clay_ball(337,0,"CLAY_BALL",EItemCat.materials),
	sugar_cane(338,0,"SUGAR_CANE",EItemCat.materials),
	paper(339,0,"PAPER",EItemCat.misc),
	book(340,0,"BOOK",EItemCat.misc),
	slime_ball(341,0,"SLIME_BALL",EItemCat.misc),
	minecart_with_chest(342,0,"STORAGE_MINECART",EItemCat.transport),
	minecart_with_furnace(343,0,"POWERED_MINECART",EItemCat.transport),
	egg(344,0,"EGG",EItemCat.materials),
	compass(345,0,"COMPASS",EItemCat.tool),
	fishing_rod(346,0,"FISHING_ROD",EItemCat.tool),
	watch(347,0,"WATCH",EItemCat.tool),
	glowstone_dust(348,0,"GLOWSTONE_DUST",EItemCat.materials),
	raw_fish(349,0,"RAW_FISH",EItemCat.food),
	cooked_fish(350,0,"COOKED_FISH",EItemCat.food),
	/*raw_salmon(349,1,"RAW_FISH",EItemCat.food),
	cooked_salmon(350,1,"COOKED_FISH",EItemCat.food),
	clownfish(349,2,"RAW_FISH",EItemCat.food),
	pufferfish(349,3,"RAW_FISH",EItemCat.food),*/
	ink_sack(351,0,"INK_SACK",EItemCat.materials),
	rose_red(351,1,"INK_SACK",EItemCat.materials),
	cactus_green(351,2,"INK_SACK",EItemCat.materials),
	cocoa_beans(351,3,"INK_SACK",EItemCat.materials),
	lapis_lazuli(351,4,"INK_SACK",EItemCat.materials),
	purple_dye(351,5,"INK_SACK",EItemCat.materials),
	cyan_dye(351,6,"INK_SACK",EItemCat.materials),
	lgray_dye(351,7,"INK_SACK",EItemCat.materials),
	gray_dye(351,8,"INK_SACK",EItemCat.materials),
	pink_dye(351,9,"INK_SACK",EItemCat.materials),
	lgreen_dye(351,10,"INK_SACK",EItemCat.materials),
	dandelion_yellow(351,11,"INK_SACK",EItemCat.materials),
	lblue_dye(351,12,"INK_SACK",EItemCat.materials),
	magenta_dye(351,13,"INK_SACK",EItemCat.materials),
	orange_dye(351,14,"INK_SACK",EItemCat.materials),
	white_dye(351,15,"INK_SACK",EItemCat.materials),
	bone(352,0,"BONE",EItemCat.misc),
	sugar(353,0,"SUGAR",EItemCat.materials),
	cake(354,0,"CAKE",EItemCat.food),
	bed(355,0,"BED",EItemCat.decoration),
	repeater(356,0,"DIODE",EItemCat.redstone),
	cookie(357,0,"COOKIE",EItemCat.food),
	shears(359,0,"SHEARS",EItemCat.tool),
	melon(360,0,"MELON",EItemCat.food),
	pumpkin_seeds(361,0,"PUMPKIN_SEEDS",EItemCat.materials),
	melon_seeds(362,0,"MELON_SEEDS",EItemCat.materials),
	raw_beef(363,0,"RAW_BEEF",EItemCat.food),
	cooked_beef(364,0,"COOKED_BEEF",EItemCat.food),
	raw_chicken(365,0,"RAW_CHICKEN",EItemCat.food),
	cooked_chicken(366,0,"COOKED_CHICKEN",EItemCat.food),
	rotten_flesh(367,0,"ROTTEN_FLESH",EItemCat.food),
	ender_pearl(368,0,"ENDER_PEARL",EItemCat.misc),
	blaze_rod(369,0,"BLAZE_ROD",EItemCat.materials),
	ghast_tear(370,0,"GHAST_TEAR",EItemCat.potion),
	gold_nugget(371,0,"GOLD_NUGGET",EItemCat.materials),
	nether_wart(372,0,"NETHER_STALK",EItemCat.materials),
	glass_bottle(374,0,"GLASS_BOTTLE",EItemCat.potion),
	spider_eye(375,0,"SPIDER_EYE",EItemCat.food),
	fermented_spider_eye(376,0,"FERMENTED_SPIDER_EYE",EItemCat.potion),
	blaze_powder(377,0,"BLAZE_POWDER",EItemCat.potion),
	magma_cream(378,0,"MAGMA_CREAM",EItemCat.potion),
	brewing_stand(379,0,"BREWING_STAND_ITEM",EItemCat.potion),
	cauldron(380,0,"CAULDRON_ITEM",EItemCat.potion),
	eye_of_ender(381,0,"EYE_OF_ENDER",EItemCat.misc),
	speckled_melon(382,0,"SPECKLED_MELON",EItemCat.potion),
	creeper_egg(383,50,"MONSTER_EGG",EItemCat.misc),
	skeleton_egg(383,51,"MONSTER_EGG",EItemCat.misc),
	spider_egg(383,52,"MONSTER_EGG",EItemCat.misc),
	zombie_egg(383,54,"MONSTER_EGG",EItemCat.misc),
	slime_egg(383,55,"MONSTER_EGG",EItemCat.misc),
	ghast_egg(383,56,"MONSTER_EGG",EItemCat.misc),
	zombie_pigman_egg(383,57,"MONSTER_EGG",EItemCat.misc),
	enderman_egg(383,58,"MONSTER_EGG",EItemCat.misc),
	cavespider_egg(383,59,"MONSTER_EGG",EItemCat.misc),
	silverfish_egg(383,60,"MONSTER_EGG",EItemCat.misc),
	blaze_egg(383,61,"MONSTER_EGG",EItemCat.misc),
	magmacube_egg(383,62,"MONSTER_EGG",EItemCat.misc),
	bat_egg(383,65,"MONSTER_EGG",EItemCat.misc),
	witch_egg(383,66,"MONSTER_EGG",EItemCat.misc),
	pig_egg(383,90,"MONSTER_EGG",EItemCat.misc),
	sheep_egg(383,91,"MONSTER_EGG",EItemCat.misc),
	cow_egg(383,92,"MONSTER_EGG",EItemCat.misc),
	chicken_egg(383,93,"MONSTER_EGG",EItemCat.misc),
	squid_egg(383,94,"MONSTER_EGG",EItemCat.misc),
	wolf_egg(383,95,"MONSTER_EGG",EItemCat.misc),
	mooshroom_egg(383,96,"MONSTER_EGG",EItemCat.misc),
	ocelot_egg(383,98,"MONSTER_EGG",EItemCat.misc),
	horse_egg(383,100,"MONSTER_EGG",EItemCat.misc),
	villager_egg(383,120,"MONSTER_EGG",EItemCat.misc),
	bottle_O_Enchanting(384,0,"EXP_BOTTLE",EItemCat.misc),
	fireball(385,0,"FIREBALL",EItemCat.misc),
	book_and_quill(386,0,"BOOK_AND_QUILL",EItemCat.misc),
	emerald(388,0,"EMERALD",EItemCat.materials),
	item_frame(389,0,"ITEM_FRAME",EItemCat.decoration),
	flower_pot(390,0,"FLOWER_POT_ITEM",EItemCat.decoration),
	carrot(391,0,"CARROT_ITEM",EItemCat.food),
	potato(392,0,"POTATO_ITEM",EItemCat.food),
	baked_potato(393,0,"BAKED_POTATO",EItemCat.food),
	poisonous_potato(394,0,"POISONOUS_POTATO",EItemCat.food),
	empty_map(395,0,"EMPTY_MAP",EItemCat.misc),
	golden_carrot(396,0,"GOLDEN_CARROT",EItemCat.food),
	skeleton_skull(397,0,"SKULL_ITEM",EItemCat.decoration),
	wither_skeleton_skull(397,1,"SKULL_ITEM",EItemCat.decoration),
	zombie_skull(397,2,"SKULL_ITEM",EItemCat.decoration),
	human_skull(397,3,"SKULL_ITEM",EItemCat.decoration),
	creeper_skull(397,4,"SKULL_ITEM",EItemCat.decoration),
	carrot_on_a_stick(398,0,"CARROT_STICK",EItemCat.transport),
	nether_star(399,0,"NETHER_STAR",EItemCat.materials),
	pumpkin_pie(400,0,"PUMPKIN_PIE",EItemCat.food),
	firework(401,0,"FIREWORK",EItemCat.misc),
	redstone_comparator(404,0,"REDSTONE_COMPARATOR",EItemCat.redstone),
	nether_brick_(405,0,"NETHER_BRICK_ITEM",EItemCat.materials),
	quartz(406,0,"QUARTZ",EItemCat.materials),
	minecart_with_tnt(407,0,"EXPLOSIVE_MINECART",EItemCat.transport),
	minecart_with_hopper(408,0,"HOPPER_MINECART",EItemCat.transport),
	iron_barding(417,0,"IRON_BARDING",EItemCat.misc),
	gold_barding(418,0,"GOLD_BARDING",EItemCat.misc),
	diamond_barding(419,0,"DIAMOND_BARDING",EItemCat.misc),
	leash(420,0,"LEASH",EItemCat.tool),
	name_tag(421,0,"NAME_TAG",EItemCat.tool),
	_13_disc(2256,0,"GOLD_RECORD",EItemCat.misc),
	cat_disc(2257,0,"GREEN_RECORD",EItemCat.misc),
	blocks_disc(2258,0,"RECORD_3",EItemCat.misc),
	chirp_disc(2259,0,"RECORD_4",EItemCat.misc),
	far_disc(2260,0,"RECORD_5",EItemCat.misc),
	mall_disc(2261,0,"RECORD_6",EItemCat.misc),
	mellohi_disc(2262,0,"RECORD_7",EItemCat.misc),
	stal_disc(2263,0,"RECORD_8",EItemCat.misc),
	strad_disc(2264,0,"RECORD_9",EItemCat.misc),
	ward_disc(2265,0,"RECORD_10",EItemCat.misc),
	_11_disc(2266,0,"RECORD_11",EItemCat.misc),
	wait_disc(2267,0,"RECORD_12",EItemCat.misc),

	//Potions
	p_regeneration(373,8193,"POTION",EItemCat.potion),
	p_regeneration_ext(373,8257,"POTION",EItemCat.potion),
	p_regeneration_II(373,8225,"POTION",EItemCat.potion),
	p_swiftness(373,8194,"POTION",EItemCat.potion),
	p_swiftness_ext(373,8258,"POTION",EItemCat.potion),
	p_swiftness_II(373,8226,"POTION",EItemCat.potion),
	p_fire_resistance(373,8195,"POTION",EItemCat.potion),
	p_fire_resistance_ext(373,8259,"POTION",EItemCat.potion),
	p_healing(373,8197,"POTION",EItemCat.potion),
	p_healing_II(373,8229,"POTION",EItemCat.potion),
	p_night_vision(373,8198,"POTION",EItemCat.potion),
	p_night_vision_ext(373,8262,"POTION",EItemCat.potion),
	p_strength(373,8201,"POTION",EItemCat.potion),
	p_strength_ext(373,8265,"POTION",EItemCat.potion),
	p_strength_II(373,8233,"POTION",EItemCat.potion),
	p_invisibility(373,8206,"POTION",EItemCat.potion),
	p_invisibility_ext(373,8270,"POTION",EItemCat.potion),
	//p_water_breathing(373,8237,"POTION",EItemCat.potion),
	//p_water_breathing_ext(373,8269,"POTION",EItemCat.potion),
	p_poison(373,8196,"POTION",EItemCat.potion),
	p_poison_ext(373,8260,"POTION",EItemCat.potion),
	p_poison_II(373,8228,"POTION",EItemCat.potion),
	p_weakness(373,8200,"POTION",EItemCat.potion),
	p_weakness_ext(373,8264,"POTION",EItemCat.potion),
	p_slowness(373,8202,"POTION",EItemCat.potion),
	p_slowness_ext(373,8266,"POTION",EItemCat.potion),
	p_harming(373,8204,"POTION",EItemCat.potion),
	p_harming_II(373,8236,"POTION",EItemCat.potion),

	//Splash potions
	s_p_regeneration(373,16385,"POTION",EItemCat.potion),
	s_p_regeneration_ext(373,16449,"POTION",EItemCat.potion),
	s_p_regeneration_II(373,16417,"POTION",EItemCat.potion),
	s_p_swiftness(373,16386,"POTION",EItemCat.potion),
	s_p_swiftness_ext(373,16450,"POTION",EItemCat.potion),
	s_p_swiftness_II(373,16418,"POTION",EItemCat.potion),
	s_p_fire_resistance(373,16387,"POTION",EItemCat.potion),
	s_p_fire_resistance_ext(373,16451,"POTION",EItemCat.potion),
	s_p_healing(373,16389,"POTION",EItemCat.potion),
	s_p_healing_II(373,16421,"POTION",EItemCat.potion),
	s_p_night_vision(373,16390,"POTION",EItemCat.potion),
	s_p_night_vision_ext(373,16454,"POTION",EItemCat.potion),
	s_p_strength(373,16393,"POTION",EItemCat.potion),
	s_p_strength_ext(373,16457,"POTION",EItemCat.potion),
	s_p_strength_II(373,16425,"POTION",EItemCat.potion),
	s_p_invisibility(373,16398,"POTION",EItemCat.potion),
	s_p_invisibility_ext(373,16462,"POTION",EItemCat.potion),
	//s_p_water_breathing(373,16429,"POTION",EItemCat.potion),
	//s_p_water_breathing_ext(373,16461,"POTION",EItemCat.potion),
	s_p_poison(373,16388,"POTION",EItemCat.potion),
	s_p_poison_ext(373,16452,"POTION",EItemCat.potion),
	s_p_poison_II(373,16420,"POTION",EItemCat.potion),
	s_p_weakness(373,16392,"POTION",EItemCat.potion),
	s_p_weakness_ext(373,16456,"POTION",EItemCat.potion),
	s_p_slowness(373,16394,"POTION",EItemCat.potion),
	s_p_slowness_ext(373,16458,"POTION",EItemCat.potion),
	s_p_harming(373,16396,"POTION",EItemCat.potion),
	s_p_harming_II(373,16428,"POTION",EItemCat.potion),
	;

	private int id;
	private int meta;
	private String realname;
	private EItemCat category;
	private Image image;

	private EItem(int id, int meta, String realname, EItemCat category) {
		this.id = id;
		this.meta = meta;
		this.realname = realname;
		this.category = category;


		String dossier;
		if(id<256){
			dossier = "blocks";
		}
		else if(id==373){
			dossier = "potions";
		}
		else {
			dossier = "items";
		}
		StringBuffer imagepath = new StringBuffer("/gui/eitems/"+dossier+"/"+id+"_");
		if(name().startsWith("s_p_")){
			imagepath.append("s_"+name().substring(4).split("[_]")[0]);
		}
		else if(name().startsWith("p_")){
			imagepath.append(name().substring(2).split("[_]")[0]);
		}
		else {
			imagepath.append(meta);
		}
		imagepath.append(".png");
		this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imagepath.toString()));
	}

	public int getId() {
		return id;
	}

	public int getMeta() {
		return meta;
	}

	public String getRealName() {
		return realname;
	}

	public EItemCat getCategory() {
		return category;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		String name = name();
		if(name.endsWith("wool") || name.endsWith("stained_clay") || name.endsWith("carpet") || name.endsWith("dye")) {
			name = name.replaceFirst("^l", "light_");
		}
		if(name.startsWith("p_")) {
			name = name.replaceFirst("^p", "potion_of");
		}
		if(name.startsWith("s_p_")){
			name = name.replaceFirst("^s_p", "splash_potion_of");
		}

		//Pour les potions
		name = name.replaceFirst("_ext", "_extended");

		name = name.replace('_', ' ').trim();
		String first = ""+name.charAt(0);
		name = name.replaceFirst("^[a-z]", first.toUpperCase());

		return name;
	}

	public String toString() {
		return name()+"("+id+","+meta+","+realname+","+category+")";
	}

	public static ArrayList<EItem> getByCategory(EItemCat category) {
		EItem[] values = values();
		ArrayList<EItem> items = new ArrayList<EItem>();

		for(int i=0;i<values.length;i++) {
			EItem item = values[i];
			if(item.getCategory()==category){
				items.add(item);
			}

		}

		return items;
	}

	private static EItem getByName(String name) {

		if (name!=null) {
			EItem[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getRealName().equalsIgnoreCase(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EItem." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

	private static EItem getById(int id) {

		if(id!=0) {
			EItem[] values = values();
			int i = 0;
			while(i < values.length && values[i].getId()!=id) {
				i++;
			}
			if(i < values.length) {
				return values[i];
			}
			else {
				throw new IllegalArgumentException(
						"No enum constant EItem for id " + id);
			}
		}
		else {
			throw new NullPointerException("ID equals 0");
		}

	}

	/**
	 * Cherche un objet par son nom Minecraft et sa m�ta-donn�e
	 * @param name
	 * @param meta
	 * @return l'EItem s'il existe, {@code null} sinon
	 */
	public static EItem searchBy(String name, int meta) {
		ArrayList<EItem> values = new ArrayList<EItem>(Arrays.asList(values()));

		EItem item = EItem.getByName(name);
		if(item!=null){
			while(item.getMeta()!=meta) {

				item = values.get(values.indexOf(item)+1);

			}
			return item;
		}
		else {
			return null;
		}

	}

	/**
	 * Cherche un objet par son id et sa m�ta-donn�e
	 * @param id
	 * @param meta
	 * @return l'EItem s'il existe, {@code null} sinon
	 */
	public static EItem searchBy(int id, int meta) {
		ArrayList<EItem> values = new ArrayList<EItem>(Arrays.asList(values()));

		EItem item = EItem.getById(id);
		if(item!=null){
			while(item.getMeta()!=meta) {

				item = values.get(values.indexOf(item)+1);

			}
			return item;
		}
		else {
			return null;
		}

	}

	/**
	 * 
	 * @param name
	 * @return la liste des EItem correspondant au nom Minecraft pass� en param�tre
	 */
	public static ArrayList<EItem> searchBy(String name) {
		ArrayList<EItem> ret = new ArrayList<>();
		EItem[] values = values();

		for (int i = 0; i < values.length; i++) {
			if (values[i].getName().toLowerCase()
					.contains(name.toLowerCase())) {
				ret.add(values[i]);
			}
		}

		return ret;
	}
}
