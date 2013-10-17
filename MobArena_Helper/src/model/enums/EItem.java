package model.enums;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

public enum EItem {

	//Blocks
	stone(1,0,"STONE",EItemCat.block),
	grass(2,0,"GRASS",null),
	dirt(3,0,"DIRT",null),
	cobblestone(4,0,"COBBLESTONE",null),
	oak_wood(5,0,"WOOD",null),
	red_wood(5,1,"WOOD",null),
	birch_wood(5,2,"WOOD",null),
	jungle_wood(5,3,"WOOD",null),
	oak_sapling(6,0,"SAPLING",null),
	red_sapling(6,1,"SAPLING",null),
	birch_sapling(6,2,"SAPLING",null),
	jungle_sapling(6,3,"SAPLING",null),
	sand(12,0,"SAND",null),
	//redsand(12,1,"SAND",null),
	gravel(13,0,"GRAVEL",null),
	gold_ore(14,0,"GOLD_ORE",null),
	iron_ore(15,0,"IRON_ORE",null),
	coal_ore(16,0,"COAL_ORE",null),
	oak_log(17,0,"LOG",null),
	red_log(17,1,"LOG",null),
	birch_log(17,2,"LOG",null),
	jungle_log(17,3,"LOG",null),
	oak_leaves(18,0,"LEAVES",null),
	red_leaves(18,1,"LEAVES",null),
	birch_leaves(18,2,"LEAVES",null),
	jungle_leaves(18,3,"LEAVES",null),
	glass(20,0,"GLASS",null),
	lapis_ore(21,0,"LAPIS_ORE",null),
	lapis_block(22,0,"LAPIS_BLOCK",null),
	dispenser(23,0,"DISPENSER",null),
	sandstone(24,0,"SANDSTONE",null),
	chiseled_sandstone(24,1,"SANDSTONE",null),
	smooth_sandstone(24,2,"SANDSTONE",null),
	note_block(25,0,"NOTE_BLOCK",null),
	powered_rail(27,0,"POWERED_RAIL",null),
	detector_rail(28,0,"DETECTOR_RAIL",null),
	sticky_piston(29,0,"PISTON_STICKY_BASE",null),
	cobweb(30,0,"WEB",null),
	long_grass(31,1,"LONG_GRASS",null),
	fern(31,2,"LONG_GRASS",null),
	dead_bush(32,0,"DEAD_BUSH",null),
	piston(33,0,"PISTON_BASE",null),
	white_wool(35,0,"WOOL",null),
	orange_wool(35,1,"WOOL",null),
	magenta_wool(35,2,"WOOL",null),
	lblue_wool(35,3,"WOOL",null),
	yellow_wool(35,4,"WOOL",null),
	lgreen_wool(35,5,"WOOL",null),
	pink_wool(35,6,"WOOL",null),
	gray_wool(35,7,"WOOL",null),
	lgray_wool(35,8,"WOOL",null),
	cyan_wool(35,9,"WOOL",null),
	purple_wool(35,10,"WOOL",null),
	blue_wool(35,11,"WOOL",null),
	brown_wool(35,12,"WOOL",null),
	green_wool(35,13,"WOOL",null),
	red_wool(35,14,"WOOL",null),
	black_wool(35,15,"WOOL",null),
	yellow_flower(37,0,"YELLOW_FLOWER",null),
	red_rose(38,0,"RED_ROSE",null),
	brown_mushroom(39,0,"BROWN_MUSHROOM",null),
	red_mushroom(40,0,"RED_MUSHROOM",null),
	gold_block(41,0,"GOLD_BLOCK",null),
	iron_block(42,0,"IRON_BLOCK",null),
	stone_slab(44,0,"STEP",null),
	sandstone_slab(44,1,"STEP",null),
	cobble_slab(44,2,"STEP",null),
	brick_slab(44,3,"STEP",null),
	stonebrick_slab(44,4,"STEP",null),
	netherbrick_slab(44,5,"STEP",null),
	quartz_slab(44,6,"STEP",null),
	brick(45,0,"BRICK",null),
	tnt(46,0,"TNT",null),
	bookshelf(47,0,"BOOKSHELF",null),
	mossy_cobblestone(48,0,"MOSSY_COBBLESTONE",null),
	obsidian(49,0,"OBSIDIAN",null),
	torch(50,0,"TORCH",null),
	wood_stairs(53,0,"WOOD_STAIRS",null),
	chest(54,0,"CHEST",null),
	diamond_ore(56,0,"DIAMOND_ORE",null),
	diamond_block(57,0,"DIAMOND_BLOCK",null),
	workbench(58,0,"WORKBENCH",null),
	furnace(61,0,"FURNACE",null),
	ladder(65,0,"LADDER",null),
	rails(66,0,"RAILS",null),
	cobblestone_stairs(67,0,"COBBLESTONE_STAIRS",null),
	lever(68,0,"LEVER",null),
	stone_plate(70,0,"STONE_PLATE",null),
	wood_plate(72,0,"WOOD_PLATE",null),
	redstone_ore(73,0,"REDSTONE_ORE",null),
	redstone_torch_on(76,0,"REDSTONE_TORCH_ON",null),
	stone_button(77,0,"STONE_BUTTON",null),
	snow(78,0,"SNOW",null),
	ice(79,0,"ICE",null),
	snow_block(80,0,"SNOW_BLOCK",null),
	cactus(81,0,"CACTUS",null),
	clay(82,0,"CLAY",null),
	jukebox(84,0,"JUKEBOX",null),
	fence(85,0,"FENCE",null),
	pumpkin(86,0,"PUMPKIN",null),
	netherrack(87,0,"NETHERRACK",null),
	soul_sand(88,0,"SOUL_SAND",null),
	glowstone(89,0,"GLOWSTONE",null),
	jack_O_Lantern(91,0,"JACK_O_LANTERN",null),
	trap_door(96,0,"TRAP_DOOR",null),
	smooth_brick(97,0,"SMOOTH_BRICK",null),
	mossy_smooth_brick(97,1,"SMOOTH_BRICK",null),
	cracked_smooth_brick(97,2,"SMOOTH_BRICK",null),
	chiseled_smooth_brick(97,3,"SMOOTH_BRICK",null),
	huge_mushroom_1(99,0,"HUGE_MUSHROOM_1",null),
	huge_mushroom_2(100,0,"HUGE_MUSHROOM_1",null),
	iron_bars(101,0,"IRON_FENCE",null),
	glass_pane(102,0,"THIN_GLASS",null),
	melon_block(103,0,"MELON_BLOCK",null),
	vine(106,0,"VINE",null),
	fence_gate(107,0,"FENCE_GATE",null),
	brick_stairs(108,0,"BRICK_STAIRS",null),
	smooth_stairs(109,0,"SMOOTH_STAIRS",null),
	mycelium(110,0,"MYCEL",null),
	lilypad(111,0,"WATER_LILY",null),
	nether_brick_block(112,0,"NETHER_BRICK",null),
	nether_fence(113,0,"NETHER_FENCE",null),
	nether_brick_stairs(114,0,"NETHER_BRICK_STAIRS",null),
	enchantment_table(116,0,"ENCHANTMENT_TABLE",null),
	ender_stone(121,0,"ENDER_STONE",null),
	dragon_egg(122,0,"DRAGON_EGG",null),
	redstone_lamp_off(123,0,"REDSTONE_LAMP_OFF",null),
	redstone_lamp_on(124,0,"REDSTONE_LAMP_ON",null),
	oakwood_slab(126,0,"WOOD_STEP",null),
	redwood_slab(126,1,"WOOD_STEP",null),
	birchwood_slab(126,2,"WOOD_STEP",null),
	junglewood_slab(126,3,"WOOD_STEP",null),
	sandstone_stairs(128,0,"SANDSTONE_STAIRS",null),
	emerald_ore(129,0,"EMERALD_ORE",null),
	ender_chest(130,0,"ENDER_CHEST",null),
	tripwire_hook(131,0,"TRIPWIRE_HOOK",null),
	emerald_block(133,0,"EMERALD_BLOCK",null),
	spruce_wood_stairs(134,0,"SPRUCE_WOOD_STAIRS",null),
	birch_wood_stairs(135,0,"BIRCH_WOOD_STAIRS",null),
	jungle_wood_stairs(136,0,"JUNGLE_WOOD_STAIRS",null),
	beacon(138,0,"BEACON",null),
	cobble_wall(139,0,"COBBLE_WALL",null),
	mossy_cobble_wall(139,1,"COBBLE_WALL",null),
	wood_button(143,0,"WOOD_BUTTON",null),
	anvil(145,0,"ANVIL",null),
	medium_damaged_anvil(145,1,"ANVIL",null),
	damaged_anvil(145,2,"ANVIL",null),
	trapped_chest(146,0,"TRAPPED_CHEST",null),
	gold_plate(147,0,"GOLD_PLATE",null),
	iron_plate(148,0,"IRON_PLATE",null),
	daylight_detector(151,0,"DAYLIGHT_DETECTOR",null),
	redstone_block(152,0,"REDSTONE_BLOCK",null),
	quartz_ore(153,0,"QUARTZ_ORE",null),
	hopper(154,0,"HOPPER",null),
	quartz_block(155,0,"QUARTZ_BLOCK",null),
	chiseled_quartz_block(155,1,"QUARTZ_BLOCK",null),
	pillar_quartz_block(155,2,"QUARTZ_BLOCK",null),
	quartz_stairs(156,0,"QUARTZ_STAIRS",null),
	activator_rail(157,0,"ACTIVATOR_RAIL",null),
	dropper(158,0,"DROPPER",null),
	white_stained_clay(159,0,"STAINED_CLAY",null),
	orange_stained_clay(159,1,"STAINED_CLAY",null),
	magenta_stained_clay(159,2,"STAINED_CLAY",null),
	lblue_stained_clay(159,3,"STAINED_CLAY",null),
	yellow_stained_clay(159,4,"STAINED_CLAY",null),
	lgreen_stained_clay(159,5,"STAINED_CLAY",null),
	pink_stained_clay(159,6,"STAINED_CLAY",null),
	gray_stained_clay(159,7,"STAINED_CLAY",null),
	lgray_stained_clay(159,8,"STAINED_CLAY",null),
	cyan_stained_clay(159,9,"STAINED_CLAY",null),
	purple_stained_clay(159,10,"STAINED_CLAY",null),
	blue_stained_clay(159,11,"STAINED_CLAY",null),
	brown_stained_clay(159,12,"STAINED_CLAY",null),
	green_stained_clay(159,13,"STAINED_CLAY",null),
	red_stained_clay(159,14,"STAINED_CLAY",null),
	black_stained_clay(159,15,"STAINED_CLAY",null),
	hay_block(170,0,"HAY_BLOCK",null),
	white_carpet(171,0,"CARPET",null),
	orange_carpet(171,1,"CARPET",null),
	magenta_carpet(171,2,"CARPET",null),
	lblue_carpet(171,3,"CARPET",null),
	yellow_carpet(171,4,"CARPET",null),
	lgreen_carpet(171,5,"CARPET",null),
	pink_carpet(171,6,"CARPET",null),
	gray_carpet(171,7,"CARPET",null),
	lgray_carpet(171,8,"CARPET",null),
	cyan_carpet(171,9,"CARPET",null),
	purple_carpet(171,10,"CARPET",null),
	blue_carpet(171,11,"CARPET",null),
	brown_carpet(171,12,"CARPET",null),
	green_carpet(171,13,"CARPET",null),
	red_carpet(171,14,"CARPET",null),
	black_carpet(171,15,"CARPET",null),
	hardened_clay(172,0,"HARD_CLAY",null),
	coal_block(173,0,"COAL_BLOCK",null),

	//Items
	iron_spade(256,0,"IRON_SPADE",null),
	iron_pickaxe(257,0,"IRON_PICKAXE",null),
	iron_axe(258,0,"IRON_AXE",null),
	flint_and_steel(259,0,"FLINT_AND_STEEL",null),
	apple(260,0,"APPLE",null),
	bow(261,0,"BOW",null),
	arrow(262,0,"ARROW",null),
	coal(263,0,"COAL",null),
	charcoal(263,1,"COAL",null),
	diamond(264,0,"DIAMOND",null),
	iron_ingot(265,0,"IRON_INGOT",null),
	gold_ingot(266,0,"GOLD_INGOT",null),
	iron_sword(267,0,"IRON_SWORD",null),
	wood_sword(268,0,"WOOD_SWORD",null),
	wood_spade(269,0,"WOOD_SPADE",null),
	wood_pickaxe(270,0,"WOOD_PICKAXE",null),
	wood_axe(271,0,"WOOD_AXE",null),
	stone_sword(272,0,"STONE_SWORD",null),
	stone_spade(273,0,"STONE_SPADE",null),
	stone_pickaxe(274,0,"STONE_PICKAXE",null),
	stone_axe(275,0,"STONE_AXE",null),
	diamond_sword(276,0,"DIAMOND_SWORD",null),
	diamond_spade(277,0,"DIAMOND_SPADE",null),
	diamond_pickaxe(278,0,"DIAMOND_PICKAXE",null),
	diamond_axe(279,0,"DIAMOND_AXE",null),
	stick(280,0,"STICK",null),
	bowl(281,0,"BOWL",null),
	mushroom_soup(282,0,"MUSHROOM_SOUP",null),
	gold_sword(283,0,"GOLD_SWORD",null),
	gold_spade(284,0,"GOLD_SPADE",null),
	gold_pickaxe(285,0,"GOLD_PICKAXE",null),
	gold_axe(286,0,"GOLD_AXE",null),
	string(287,0,"STRING",null),
	feather(288,0,"FEATHER",null),
	gunpowder(289,0,"SULPHUR",null),
	wood_hoe(290,0,"WOOD_HOE",null),
	stone_hoe(291,0,"STONE_HOE",null),
	iron_hoe(292,0,"IRON_HOE",null),
	diamond_hoe(293,0,"DIAMOND_HOE",null),
	gold_hoe(294,0,"GOLD_HOE",null),
	seeds(295,0,"SEEDS",null),
	wheat(296,0,"WHEAT",null),
	bread(297,0,"BREAD",null),
	leather_helmet(298,0,"LEATHER_HELMET",null),
	leather_chestplate(299,0,"LEATHER_CHESTPLATE",null),
	leather_leggings(300,0,"LEATHER_LEGGINGS",null),
	leather_boots(301,0,"LEATHER_BOOTS",null),
	chainmail_helmet(302,0,"CHAINMAIL_HELMET",null),
	chainmail_chestplate(303,0,"CHAINMAIL_CHESTPLATE",null),
	chainmail_leggings(304,0,"CHAINMAIL_LEGGINGS",null),
	chainmail_boots(305,0,"CHAINMAIL_BOOTS",null),
	iron_helmet(306,0,"IRON_HELMET",null),
	iron_chestplate(307,0,"IRON_CHESTPLATE",null),
	iron_leggings(308,0,"IRON_LEGGINGS",null),
	iron_boots(309,0,"IRON_BOOTS",null),
	diamond_helmet(310,0,"DIAMOND_HELMET",null),
	diamond_chestplate(311,0,"DIAMOND_CHESTPLATE",null),
	diamond_leggings(312,0,"DIAMOND_LEGGINGS",null),
	diamond_boots(313,0,"DIAMOND_BOOTS",null),
	gold_helmet(314,0,"GOLD_HELMET",null),
	gold_chestplate(315,0,"GOLD_CHESTPLATE",null),
	gold_leggings(316,0,"GOLD_LEGGINGS",null),
	gold_boots(317,0,"GOLD_BOOTS",null),
	flint(318,0,"FLINT",null),
	raw_pork(319,0,"PORK",null),
	cooked_pork(320,0,"GRILLED_PORK",null),
	painting(321,0,"PAINTING",null),
	golden_apple_1(322,0,"GOLDEN_APPLE",null),
	golden_apple_2(322,1,"GOLDEN_APPLE",null),
	sign(323,0,"SIGN",null),
	wood_door(324,0,"WOOD_DOOR",null),
	bucket(325,0,"BUCKET",null),
	water_bucket(326,0,"WATER_BUCKET",null),
	lava_bucket(327,0,"LAVA_BUCKET",null),
	minecart(328,0,"MINECART",null),
	saddle(329,0,"SADDLE",null),
	iron_door(330,0,"IRON_DOOR",null),
	redstone(331,0,"REDSTONE",null),
	snow_ball(332,0,"SNOW_BALL",null),
	boat(333,0,"BOAT",null),
	leather(334,0,"LEATHER",null),
	milk_bucket(335,0,"MILK_BUCKET",null),
	clay_brick(336,0,"CLAY_BRICK",null),
	clay_ball(337,0,"CLAY_BALL",null),
	sugar_cane(338,0,"SUGAR_CANE",null),
	paper(339,0,"PAPER",null),
	book(340,0,"BOOK",null),
	slime_ball(341,0,"SLIME_BALL",null),
	minecart_with_chest(342,0,"STORAGE_MINECART",null),
	minecart_with_furnace(343,0,"POWERED_MINECART",null),
	egg(344,0,"EGG",null),
	compass(345,0,"COMPASS",null),
	fishing_rod(346,0,"FISHING_ROD",null),
	watch(347,0,"WATCH",null),
	glowstone_dust(348,0,"GLOWSTONE_DUST",null),
	raw_fish(349,0,"RAW_FISH",null),
	cooked_fish(350,0,"COOKED_FISH",null),
	/*raw_salmon(349,1,"RAW_FISH",null),
	cooked_salmon(350,1,"COOKED_FISH",null),
	clownfish(349,2,"RAW_FISH",null),
	pufferfish(349,3,"RAW_FISH",null),*/
	ink_sack(351,0,"INK_SACK",null),
	rose_red(351,1,"INK_SACK",null),
	cactus_green(351,2,"INK_SACK",null),
	cocoa_beans(351,3,"INK_SACK",null),
	lapis_lazuli(351,4,"INK_SACK",null),
	purple_dye(351,5,"INK_SACK",null),
	cyan_dye(351,6,"INK_SACK",null),
	lgray_dye(351,7,"INK_SACK",null),
	gray_dye(351,8,"INK_SACK",null),
	pink_dye(351,9,"INK_SACK",null),
	lgreen_dye(351,10,"INK_SACK",null),
	dandelion_yellow(351,11,"INK_SACK",null),
	lblue_dye(351,12,"INK_SACK",null),
	magenta_dye(351,13,"INK_SACK",null),
	orange_dye(351,14,"INK_SACK",null),
	white_dye(351,15,"INK_SACK",null),
	bone(352,0,"BONE",null),
	sugar(353,0,"SUGAR",null),
	cake(354,0,"CAKE",null),
	bed(355,0,"BED",null),
	repeater(356,0,"DIODE",null),
	cookie(357,0,"COOKIE",null),
	shears(359,0,"SHEARS",null),
	melon(360,0,"MELON",null),
	pumpkin_seeds(361,0,"PUMPKIN_SEEDS",null),
	melon_seeds(362,0,"MELON_SEEDS",null),
	raw_beef(363,0,"RAW_BEEF",null),
	cooked_beef(364,0,"COOKED_BEEF",null),
	raw_chicken(365,0,"RAW_CHICKEN",null),
	cooked_chicken(366,0,"COOKED_CHICKEN",null),
	rotten_flesh(367,0,"ROTTEN_FLESH",null),
	ender_pearl(368,0,"ENDER_PEARL",null),
	blaze_rod(369,0,"BLAZE_ROD",null),
	ghast_tear(370,0,"GHAST_TEAR",null),
	gold_nugget(371,0,"GOLD_NUGGET",null),
	nether_wart(372,0,"NETHER_STALK",null),
	glass_bottle(374,0,"GLASS_BOTTLE",null),
	spider_eye(375,0,"SPIDER_EYE",null),
	fermented_spider_eye(376,0,"FERMENTED_SPIDER_EYE",null),
	blaze_powder(377,0,"BLAZE_POWDER",null),
	magma_cream(378,0,"MAGMA_CREAM",null),
	brewing_stand(379,0,"BREWING_STAND_ITEM",null),
	cauldron(380,0,"CAULDRON_ITEM",null),
	eye_of_ender(381,0,"EYE_OF_ENDER",null),
	speckled_melon(382,0,"SPECKLED_MELON",null),
	creeper_egg(383,50,"MONSTER_EGG",null),
	skeleton_egg(383,51,"MONSTER_EGG",null),
	spider_egg(383,52,"MONSTER_EGG",null),
	zombie_egg(383,54,"MONSTER_EGG",null),
	slime_egg(383,55,"MONSTER_EGG",null),
	ghast_egg(383,56,"MONSTER_EGG",null),
	zombie_pigman_egg(383,57,"MONSTER_EGG",null),
	enderman_egg(383,58,"MONSTER_EGG",null),
	cavespider_egg(383,59,"MONSTER_EGG",null),
	silverfish_egg(383,60,"MONSTER_EGG",null),
	blaze_egg(383,61,"MONSTER_EGG",null),
	magmacube_egg(383,62,"MONSTER_EGG",null),
	bat_egg(383,65,"MONSTER_EGG",null),
	witch_egg(383,66,"MONSTER_EGG",null),
	pig_egg(383,90,"MONSTER_EGG",null),
	sheep_egg(383,91,"MONSTER_EGG",null),
	cow_egg(383,92,"MONSTER_EGG",null),
	chicken_egg(383,93,"MONSTER_EGG",null),
	squid_egg(383,94,"MONSTER_EGG",null),
	wolf_egg(383,95,"MONSTER_EGG",null),
	mooshroom_egg(383,96,"MONSTER_EGG",null),
	ocelot_egg(383,98,"MONSTER_EGG",null),
	horse_egg(383,100,"MONSTER_EGG",null),
	villager_egg(383,120,"MONSTER_EGG",null),
	bottle_O_Enchanting(384,0,"EXP_BOTTLE",null),
	fireball(385,0,"FIREBALL",null),
	book_and_quill(386,0,"BOOK_AND_QUILL",null),
	emerald(388,0,"EMERALD",null),
	item_frame(389,0,"ITEM_FRAME",null),
	flower_pot(390,0,"FLOWER_POT_ITEM",null),
	carrot(391,0,"CARROT_ITEM",null),
	potato(392,0,"POTATO_ITEM",null),
	baked_potato(393,0,"BAKED_POTATO",null),
	poisonous_potato(394,0,"POISONOUS_POTATO",null),
	empty_map(395,0,"EMPTY_MAP",null),
	golden_carrot(396,0,"GOLDEN_CARROT",null),
	skeleton_skull(397,0,"SKULL_ITEM",null),
	wither_skeleton_skull(397,1,"SKULL_ITEM",null),
	zombie_skull(397,2,"SKULL_ITEM",null),
	human_skull(397,3,"SKULL_ITEM",null),
	creeper_skull(397,4,"SKULL_ITEM",null),
	carrot_stick(398,0,"CARROT_STICK",null),
	nether_star(399,0,"NETHER_STAR",null),
	pumpkin_pie(400,0,"PUMPKIN_PIE",null),
	firework(401,0,"FIREWORK",null),
	redstone_comparator(404,0,"REDSTONE_COMPARATOR",null),
	nether_brick_(405,0,"NETHER_BRICK_ITEM",null),
	quartz(406,0,"QUARTZ",null),
	minecart_with_tnt(407,0,"EXPLOSIVE_MINECART",null),
	minecart_with_hopper(408,0,"HOPPER_MINECART",null),
	iron_barding(417,0,"IRON_BARDING",null),
	gold_barding(418,0,"GOLD_BARDING",null),
	diamond_barding(419,0,"DIAMOND_BARDING",null),
	leash(420,0,"LEASH",null),
	name_tag(421,0,"NAME_TAG",null),
	_13_disc(2256,0,"GOLD_RECORD",null),
	cat_disc(2257,0,"GREEN_RECORD",null),
	blocks_disc(2258,0,"RECORD_3",null),
	chirp_disc(2259,0,"RECORD_4",null),
	far_disc(2260,0,"RECORD_5",null),
	mall_disc(2261,0,"RECORD_6",null),
	mellohi_disc(2262,0,"RECORD_7",null),
	stal_disc(2263,0,"RECORD_8",null),
	strad_disc(2264,0,"RECORD_9",null),
	ward_disc(2265,0,"RECORD_10",null),
	_11_disc(2266,0,"RECORD_11",null),
	wait_disc(2267,0,"RECORD_12",null),

	//Potions
	p_regeneration(373,8193,"POTION",null),
	p_regeneration_ext(373,8257,"POTION",null),
	p_regeneration_II(373,8225,"POTION",null),
	p_swiftness(373,8194,"POTION",null),
	p_swiftness_ext(373,8258,"POTION",null),
	p_swiftness_II(373,8226,"POTION",null),
	p_fire_resistance(373,8195,"POTION",null),
	p_fire_resistance_ext(373,8259,"POTION",null),
	p_healing(373,8197,"POTION",null),
	p_healing_II(373,8229,"POTION",null),
	p_night_vision(373,8198,"POTION",null),
	p_night_vision_ext(373,8262,"POTION",null),
	p_strength(373,8201,"POTION",null),
	p_strength_ext(373,8265,"POTION",null),
	p_strength_II(373,8233,"POTION",null),
	p_invisibility(373,8206,"POTION",null),
	p_invisibility_ext(373,8270,"POTION",null),
	//p_water_breathing(373,8237,"POTION",null),
	//p_water_breathing_ext(373,8269,"POTION",null),
	p_poison(373,8196,"POTION",null),
	p_poison_ext(373,8260,"POTION",null),
	p_poison_II(373,8228,"POTION",null),
	p_weakness(373,8200,"POTION",null),
	p_weakness_ext(373,8264,"POTION",null),
	p_slowness(373,8202,"POTION",null),
	p_slowness_ext(373,8266,"POTION",null),
	p_harming(373,8204,"POTION",null),
	p_harming_II(373,8236,"POTION",null),
	
	//Splash potions
	s_p_regeneration(373,16385,"POTION",null),
	s_p_regeneration_ext(373,16449,"POTION",null),
	s_p_regeneration_II(373,16417,"POTION",null),
	s_p_swiftness(373,16386,"POTION",null),
	s_p_swiftness_ext(373,16450,"POTION",null),
	s_p_swiftness_II(373,16418,"POTION",null),
	s_p_fire_resistance(373,16387,"POTION",null),
	s_p_fire_resistance_ext(373,16451,"POTION",null),
	s_p_healing(373,16389,"POTION",null),
	s_p_healing_II(373,16421,"POTION",null),
	s_p_night_vision(373,16390,"POTION",null),
	s_p_night_vision_ext(373,16454,"POTION",null),
	s_p_strength(373,16393,"POTION",null),
	s_p_strength_ext(373,16457,"POTION",null),
	s_p_strength_II(373,16425,"POTION",null),
	s_p_invisibility(373,16398,"POTION",null),
	s_p_invisibility_ext(373,16462,"POTION",null),
	//s_p_water_breathing(373,16429,"POTION",null),
	//s_p_water_breathing_ext(373,16461,"POTION",null),
	s_p_poison(373,16388,"POTION",null),
	s_p_poison_ext(373,16452,"POTION",null),
	s_p_poison_II(373,16420,"POTION",null),
	s_p_weakness(373,16392,"POTION",null),
	s_p_weakness_ext(373,16456,"POTION",null),
	s_p_slowness(373,16394,"POTION",null),
	s_p_slowness_ext(373,16458,"POTION",null),
	s_p_harming(373,16396,"POTION",null),
	s_p_harming_II(373,16428,"POTION",null),
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
		ArrayList<EItem> items = new ArrayList<>();

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
}
