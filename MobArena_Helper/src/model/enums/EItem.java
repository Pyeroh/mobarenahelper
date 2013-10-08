package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum EItem {

	//Blocks
	stone(1,0,"STONE",EItemCat.block),
	grass(2,0,"GRASS",null),
	dirt(3,0,"DIRT",null),
	cobblestone(4,0,"COBBLESTONE",null),
	oakwood(5,0,"WOOD",null),
	redwood(5,1,"WOOD",null),
	birchwood(5,2,"WOOD",null),
	junglewood(5,3,"WOOD",null),
	oaksapling(6,0,"SAPLING",null),
	redsapling(6,1,"SAPLING",null),
	birchsapling(6,2,"SAPLING",null),
	junglesapling(6,3,"SAPLING",null),
	sand(12,0,"SAND",null),
	gravel(13,0,"GRAVEL",null),
	gold_ore(14,0,"GOLD_ORE",null),
	iron_ore(15,0,"IRON_ORE",null),
	coal_ore(16,0,"COAL_ORE",null),
	oaklog(17,0,"LOG",null),
	redlog(17,1,"LOG",null),
	birchlog(17,2,"LOG",null),
	junglelog(17,3,"LOG",null),
	oakleaves(18,0,"LEAVES",null),
	redleaves(18,1,"LEAVES",null),
	birchleaves(18,2,"LEAVES",null),
	jungleleaves(18,3,"LEAVES",null),
	glass(20,0,"GLASS",null),
	lapis_ore(21,0,"LAPIS_ORE",null),
	lapis_block(22,0,"LAPIS_BLOCK",null),
	dispenser(23,0,"DISPENSER",null),
	sandstone(24,0,"SANDSTONE",null),
	sandstonechiseled(24,1,"SANDSTONE",null),
	sandstonesmooth(24,2,"SANDSTONE",null),
	note_block(25,0,"NOTE_BLOCK",null),
	powered_rail(27,0,"POWERED_RAIL",null),
	detector_rail(28,0,"DETECTOR_RAIL",null),
	piston_sticky_base(29,0,"PISTON_STICKY_BASE",null),
	web(30,0,"WEB",null),
	long_grass(31,1,"LONG_GRASS",null),
	fern(31,2,"LONG_GRASS",null),
	dead_bush(32,0,"DEAD_BUSH",null),
	piston_base(33,0,"PISTON_BASE",null),
	woolwhite(35,0,"WOOL",null),
	woolorange(35,1,"WOOL",null),
	woolmagenta(35,2,"WOOL",null),
	woollblue(35,3,"WOOL",null),
	woolyellow(35,4,"WOOL",null),
	woollgreen(35,5,"WOOL",null),
	woolpink(35,6,"WOOL",null),
	woolgray(35,7,"WOOL",null),
	woollgray(35,8,"WOOL",null),
	woolcyan(35,9,"WOOL",null),
	woolpurple(35,10,"WOOL",null),
	woolblue(35,11,"WOOL",null),
	woolbrown(35,12,"WOOL",null),
	woolgreen(35,13,"WOOL",null),
	woolred(35,14,"WOOL",null),
	woolblack(35,15,"WOOL",null),
	yellow_flower(37,0,"YELLOW_FLOWER",null),
	red_rose(38,0,"RED_ROSE",null),
	brown_mushroom(39,0,"BROWN_MUSHROOM",null),
	red_mushroom(40,0,"RED_MUSHROOM",null),
	gold_block(41,0,"GOLD_BLOCK",null),
	iron_block(42,0,"IRON_BLOCK",null),
	stonestep(44,0,"STEP",null),
	sandstep(44,1,"STEP",null),
	cobblestep(44,2,"STEP",null),
	brickstep(44,3,"STEP",null),
	stonebrickstep(44,4,"STEP",null),
	netherbrickstep(44,5,"STEP",null),
	quartzstep(44,6,"STEP",null),
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
	jack_o_lantern(91,0,"JACK_O_LANTERN",null),
	trap_door(96,0,"TRAP_DOOR",null),
	smooth_brick(97,0,"SMOOTH_BRICK",null),
	mosssmooth_brick(97,1,"SMOOTH_BRICK",null),
	cracksmooth_brick(97,2,"SMOOTH_BRICK",null),
	chissmooth_brick(97,3,"SMOOTH_BRICK",null),
	huge_mushroom_1(99,0,"HUGE_MUSHROOM_1",null),
	huge_mushroom_2(100,0,"HUGE_MUSHROOM_1",null),
	iron_fence(101,0,"IRON_FENCE",null),
	thin_glass(102,0,"THIN_GLASS",null),
	melon_block(103,0,"MELON_BLOCK",null),
	vine(106,0,"VINE",null),
	fence_gate(107,0,"FENCE_GATE",null),
	brick_stairs(108,0,"BRICK_STAIRS",null),
	smooth_stairs(109,0,"SMOOTH_STAIRS",null),
	mycel(110,0,"MYCEL",null),
	water_lily(111,0,"WATER_LILY",null),
	nether_brick(112,0,"NETHER_BRICK",null),
	nether_fence(113,0,"NETHER_FENCE",null),
	nether_brick_stairs(114,0,"NETHER_BRICK_STAIRS",null),
	enchantment_table(116,0,"ENCHANTMENT_TABLE",null),
	ender_stone(121,0,"ENDER_STONE",null),
	dragon_egg(122,0,"DRAGON_EGG",null),
	redstone_lamp_off(123,0,"REDSTONE_LAMP_OFF",null),
	redstone_lamp_on(124,0,"REDSTONE_LAMP_ON",null),
	oakwood_step(126,0,"WOOD_STEP",null),
	redwood_step(126,1,"WOOD_STEP",null),
	birchwood_step(126,2,"WOOD_STEP",null),
	junglewood_step(126,3,"WOOD_STEP",null),
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
	mosscobble_wall(139,1,"COBBLE_WALL",null),
	wood_button(143,0,"WOOD_BUTTON",null),
	anvil(145,0,"ANVIL",null),
	anvilmid(145,1,"ANVIL",null),
	anvilbad(145,2,"ANVIL",null),
	trapped_chest(146,0,"TRAPPED_CHEST",null),
	gold_plate(147,0,"GOLD_PLATE",null),
	iron_plate(148,0,"IRON_PLATE",null),
	daylight_detector(151,0,"DAYLIGHT_DETECTOR",null),
	redstone_block(151,0,"REDSTONE_BLOCK",null),
	quartz_ore(153,0,"QUARTZ_ORE",null),
	hopper(154,0,"HOPPER",null),
	quartz_block(155,0,"QUARTZ_BLOCK",null),
	chiseledquartz_block(155,1,"QUARTZ_BLOCK",null),
	pillarquartz_block(155,2,"QUARTZ_BLOCK",null),
	quartz_stairs(154,0,"QUARTZ_STAIRS",null),
	activator_rail(157,0,"ACTIVATOR_RAIL",null),
	dropper(158,0,"DROPPER",null),
	stained_claywhite(159,0,"STAINED_CLAY",null),
	stained_clayorange(159,1,"STAINED_CLAY",null),
	stained_claymagenta(159,2,"STAINED_CLAY",null),
	stained_claylblue(159,3,"STAINED_CLAY",null),
	stained_clayyellow(159,4,"STAINED_CLAY",null),
	stained_claylgreen(159,5,"STAINED_CLAY",null),
	stained_claypink(159,6,"STAINED_CLAY",null),
	stained_claygray(159,7,"STAINED_CLAY",null),
	stained_claylgray(159,8,"STAINED_CLAY",null),
	stained_claycyan(159,9,"STAINED_CLAY",null),
	stained_claypurple(159,10,"STAINED_CLAY",null),
	stained_clayblue(159,11,"STAINED_CLAY",null),
	stained_claybrown(159,12,"STAINED_CLAY",null),
	stained_claygreen(159,13,"STAINED_CLAY",null),
	stained_clayred(159,14,"STAINED_CLAY",null),
	stained_clayblack(159,15,"STAINED_CLAY",null),
	hay_block(170,0,"HAY_BLOCK",null),
	carpetwhite(171,0,"CARPET",null),
	carpetorange(171,1,"CARPET",null),
	carpetmagenta(171,2,"CARPET",null),
	carpetlblue(171,3,"CARPET",null),
	carpetyellow(171,4,"CARPET",null),
	carpetlgreen(171,5,"CARPET",null),
	carpetpink(171,6,"CARPET",null),
	carpetgray(171,7,"CARPET",null),
	carpetlgray(171,8,"CARPET",null),
	carpetcyan(171,9,"CARPET",null),
	carpetpurple(171,10,"CARPET",null),
	carpetblue(171,11,"CARPET",null),
	carpetbrown(171,12,"CARPET",null),
	carpetgreen(171,13,"CARPET",null),
	carpetred(171,14,"CARPET",null),
	carpetblack(171,15,"CARPET",null),
	hard_clay(172,0,"HARD_CLAY",null),
	coal_block(173,0,"COAL_BLOCK",null),

	//Items
	iron_spade(0,0,"IRON_SPADE",null),
	iron_pickaxe(0,0,"IRON_PICKAXE",null),
	iron_axe(0,0,"IRON_AXE",null),
	flint_and_steel(0,0,"FLINT_AND_STEEL",null),
	apple(0,0,"APPLE",null),
	bow(0,0,"BOW",null),
	arrow(0,0,"ARROW",null),
	coal(0,0,"COAL",null),
	charcoal(0,0,"COAL",null),
	diamond(0,0,"DIAMOND",null),
	iron_ingot(0,0,"IRON_INGOT",null),
	gold_ingot(0,0,"GOLD_INGOT",null),
	iron_sword(0,0,"IRON_SWORD",null),
	wood_sword(0,0,"WOOD_SWORD",null),
	wood_spade(0,0,"WOOD_SPADE",null),
	wood_pickaxe(0,0,"WOOD_PICKAXE",null),
	wood_axe(0,0,"WOOD_AXE",null),
	stone_sword(0,0,"STONE_SWORD",null),
	stone_spade(0,0,"STONE_SPADE",null),
	stone_pickaxe(0,0,"STONE_PICKAXE",null),
	stone_axe(0,0,"STONE_AXE",null),
	diamond_sword(0,0,"DIAMOND_SWORD",null),
	diamond_spade(0,0,"DIAMOND_SPADE",null),
	diamond_pickaxe(0,0,"DIAMOND_PICKAXE",null),
	diamond_axe(0,0,"DIAMOND_AXE",null),
	stick(0,0,"STICK",null),
	bowl(0,0,"BOWL",null),
	mushroom_soup(0,0,"MUSHROOM_SOUP",null),
	gold_sword(0,0,"GOLD_SWORD",null),
	gold_spade(0,0,"GOLD_SPADE",null),
	gold_pickaxe(0,0,"GOLD_PICKAXE",null),
	gold_axe(0,0,"GOLD_AXE",null),
	string(0,0,"STRING",null),
	feather(0,0,"FEATHER",null),
	gunpowder(0,0,"SULPHUR",null),
	wood_hoe(0,0,"WOOD_HOE",null),
	stone_hoe(0,0,"STONE_HOE",null),
	iron_hoe(0,0,"IRON_HOE",null),
	diamond_hoe(0,0,"DIAMOND_HOE",null),
	gold_hoe(0,0,"GOLD_HOE",null),
	seeds(0,0,"SEEDS",null),
	wheat(0,0,"WHEAT",null),
	bread(0,0,"BREAD",null),
	leather_helmet(0,0,"LEATHER_HELMET",null),
	leather_chestplate(0,0,"LEATHER_CHESTPLATE",null),
	leather_leggings(0,0,"LEATHER_LEGGINGS",null),
	leather_boots(0,0,"LEATHER_BOOTS",null),
	chainmail_helmet(0,0,"CHAINMAIL_HELMET",null),
	chainmail_chestplate(0,0,"CHAINMAIL_CHESTPLATE",null),
	chainmail_leggings(0,0,"CHAINMAIL_LEGGINGS",null),
	chainmail_boots(0,0,"CHAINMAIL_BOOTS",null),
	iron_helmet(0,0,"IRON_HELMET",null),
	iron_chestplate(0,0,"IRON_CHESTPLATE",null),
	iron_leggings(0,0,"IRON_LEGGINGS",null),
	iron_boots(0,0,"IRON_BOOTS",null),
	diamond_helmet(0,0,"DIAMOND_HELMET",null),
	diamond_chestplate(0,0,"DIAMOND_CHESTPLATE",null),
	diamond_leggings(0,0,"DIAMOND_LEGGINGS",null),
	diamond_boots(0,0,"DIAMOND_BOOTS",null),
	gold_helmet(0,0,"GOLD_HELMET",null),
	gold_chestplate(0,0,"GOLD_CHESTPLATE",null),
	gold_leggings(0,0,"GOLD_LEGGINGS",null),
	gold_boots(0,0,"GOLD_BOOTS",null),
	flint(0,0,"FLINT",null),
	pork(0,0,"PORK",null),
	grilled_pork(0,0,"GRILLED_PORK",null),
	painting(0,0,"PAINTING",null),
	golden_apple1(0,0,"GOLDEN_APPLE",null),
	golden_apple2(0,0,"GOLDEN_APPLE",null),
	sign(0,0,"SIGN",null),
	wood_door(0,0,"WOOD_DOOR",null),
	bucket(0,0,"BUCKET",null),
	water_bucket(0,0,"WATER_BUCKET",null),
	lava_bucket(0,0,"LAVA_BUCKET",null),
	minecart(0,0,"MINECART",null),
	saddle(0,0,"SADDLE",null),
	iron_door(0,0,"IRON_DOOR",null),
	redstone(0,0,"REDSTONE",null),
	snow_ball(0,0,"SNOW_BALL",null),
	boat(0,0,"BOAT",null),
	leather(0,0,"LEATHER",null),
	milk_bucket(0,0,"MILK_BUCKET",null),
	clay_brick(0,0,"CLAY_BRICK",null),
	clay_ball(0,0,"CLAY_BALL",null),
	sugar_cane(0,0,"SUGAR_CANE",null),
	paper(0,0,"PAPER",null),
	book(0,0,"BOOK",null),
	slime_ball(0,0,"SLIME_BALL",null),
	storage_minecart(0,0,"STORAGE_MINECART",null),
	powered_minecart(0,0,"POWERED_MINECART",null),
	egg(0,0,"EGG",null),
	compass(0,0,"COMPASS",null),
	fishing_rod(0,0,"FISHING_ROD",null),
	watch(0,0,"WATCH",null),
	glowstone_dust(0,0,"GLOWSTONE_DUST",null),
	raw_fish(0,0,"RAW_FISH",null),
	cooked_fish(0,0,"COOKED_FISH",null),
	ink_sack(0,0,"INK_SACK",null),
	reddye(0,0,"INK_SACK",null),
	greendye(0,0,"INK_SACK",null),
	browndye(0,0,"INK_SACK",null),
	bluedye(0,0,"INK_SACK",null),
	purpledye(0,0,"INK_SACK",null),
	cyandye(0,0,"INK_SACK",null),
	lgreydye(0,0,"INK_SACK",null),
	greydye(0,0,"INK_SACK",null),
	pinkdye(0,0,"INK_SACK",null),
	lgreendye(0,0,"INK_SACK",null),
	yellowdye(0,0,"INK_SACK",null),
	lbluedye(0,0,"INK_SACK",null),
	magentadye(0,0,"INK_SACK",null),
	orangedye(0,0,"INK_SACK",null),
	whitedye(0,0,"INK_SACK",null),
	bone(0,0,"BONE",null),
	sugar(0,0,"SUGAR",null),
	cake(0,0,"CAKE",null),
	bed(0,0,"BED",null),
	diode(0,0,"DIODE",null),
	cookie(0,0,"COOKIE",null),
	shears(0,0,"SHEARS",null),
	melon(0,0,"MELON",null),
	pumpkin_seeds(0,0,"PUMPKIN_SEEDS",null),
	melon_seeds(0,0,"MELON_SEEDS",null),
	raw_beef(0,0,"RAW_BEEF",null),
	cooked_beef(0,0,"COOKED_BEEF",null),
	raw_chicken(0,0,"RAW_CHICKEN",null),
	cooked_chicken(0,0,"COOKED_CHICKEN",null),
	rotten_flesh(0,0,"ROTTEN_FLESH",null),
	ender_pearl(0,0,"ENDER_PEARL",null),
	blaze_rod(0,0,"BLAZE_ROD",null),
	ghast_tear(0,0,"GHAST_TEAR",null),
	gold_nugget(0,0,"GOLD_NUGGET",null),
	nether_stalk(0,0,"NETHER_STALK",null),
	glass_bottle(0,0,"GLASS_BOTTLE",null),
	spider_eye(0,0,"SPIDER_EYE",null),
	fermented_spider_eye(0,0,"FERMENTED_SPIDER_EYE",null),
	blaze_powder(0,0,"BLAZE_POWDER",null),
	magma_cream(0,0,"MAGMA_CREAM",null),
	brewing_stand_item(0,0,"BREWING_STAND_ITEM",null),
	cauldron_item(0,0,"CAULDRON_ITEM",null),
	eye_of_ender(0,0,"EYE_OF_ENDER",null),
	speckled_melon(0,0,"SPECKLED_MELON",null),
	creeper_egg(0,0,"MONSTER_EGG",null),
	skeleton_egg(0,0,"MONSTER_EGG",null),
	spider_egg(0,0,"MONSTER_EGG",null),
	zombie_egg(0,0,"MONSTER_EGG",null),
	slime_egg(0,0,"MONSTER_EGG",null),
	ghast_egg(0,0,"MONSTER_EGG",null),
	zombie_pigman_egg(0,0,"MONSTER_EGG",null),
	enderman_egg(0,0,"MONSTER_EGG",null),
	cavespider_egg(0,0,"MONSTER_EGG",null),
	silverfish_egg(0,0,"MONSTER_EGG",null),
	blaze_egg(0,0,"MONSTER_EGG",null),
	magmacube_egg(0,0,"MONSTER_EGG",null),
	bat_egg(0,0,"MONSTER_EGG",null),
	witch_egg(0,0,"MONSTER_EGG",null),
	pig_egg(0,0,"MONSTER_EGG",null),
	sheep_egg(0,0,"MONSTER_EGG",null),
	cow_egg(0,0,"MONSTER_EGG",null),
	chicken_egg(0,0,"MONSTER_EGG",null),
	squid_egg(0,0,"MONSTER_EGG",null),
	wolf_egg(0,0,"MONSTER_EGG",null),
	mooshroom_egg(0,0,"MONSTER_EGG",null),
	ocelot_egg(0,0,"MONSTER_EGG",null),
	horse_egg(0,0,"MONSTER_EGG",null),
	villager_egg(0,0,"MONSTER_EGG",null),
	exp_bottle(0,0,"EXP_BOTTLE",null),
	fireball(0,0,"FIREBALL",null),
	book_and_quill(0,0,"BOOK_AND_QUILL",null),
	emerald(0,0,"EMERALD",null),
	item_frame(0,0,"ITEM_FRAME",null),
	flower_pot_item(0,0,"FLOWER_POT_ITEM",null),
	carrot_item(0,0,"CARROT_ITEM",null),
	potato_item(0,0,"POTATO_ITEM",null),
	baked_potato(0,0,"BAKED_POTATO",null),
	poisonous_potato(0,0,"POISONOUS_POTATO",null),
	empty_map(0,0,"EMPTY_MAP",null),
	golden_carrot(0,0,"GOLDEN_CARROT",null),
	skeleton_skull(0,0,"SKULL_ITEM",null),
	wither_skeleton_skull(0,0,"SKULL_ITEM",null),
	zombie_skull(0,0,"SKULL_ITEM",null),
	human_skull(0,0,"SKULL_ITEM",null),
	creeper_skull(0,0,"SKULL_ITEM",null),
	carrot_stick(0,0,"CARROT_STICK",null),
	nether_star(0,0,"NETHER_STAR",null),
	pumpkin_pie(0,0,"PUMPKIN_PIE",null),
	firework(0,0,"FIREWORK",null),
	firework_charge(0,0,"FIREWORK_CHARGE",null),
	enchanted_book(0,0,"ENCHANTED_BOOK",null),
	redstone_comparator(0,0,"REDSTONE_COMPARATOR",null),
	nether_brick_item(0,0,"NETHER_BRICK_ITEM",null),
	quartz(0,0,"QUARTZ",null),
	explosive_minecart(0,0,"EXPLOSIVE_MINECART",null),
	hopper_minecart(0,0,"HOPPER_MINECART",null),
	iron_barding(0,0,"IRON_BARDING",null),
	gold_barding(0,0,"GOLD_BARDING",null),
	diamond_barding(0,0,"DIAMOND_BARDING",null),
	leash(0,0,"LEASH",null),
	name_tag(0,0,"NAME_TAG",null),
	gold_record(0,0,"GOLD_RECORD",null),
	green_record(0,0,"GREEN_RECORD",null),
	record_3(0,0,"RECORD_3",null),
	record_4(0,0,"RECORD_4",null),
	record_5(0,0,"RECORD_5",null),
	record_6(0,0,"RECORD_6",null),
	record_7(0,0,"RECORD_7",null),
	record_8(0,0,"RECORD_8",null),
	record_9(0,0,"RECORD_9",null),
	record_10(0,0,"RECORD_10",null),
	record_11(0,0,"RECORD_11",null),
	record_12(0,0,"RECORD_12",null),

	//Potions

	;

	private int id;
	private int meta;
	private String realname;
	private EItemCat category;

	private EItem(int id, int meta, String realname, EItemCat category) {
		this.id = id;
		this.meta = meta;
		this.realname = realname;
		this.category = category;
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
				IllegalArgumentException e = new IllegalArgumentException(
						"No enum constant EItem." + name);
				e.printStackTrace();
			}
		}
		else {
			NullPointerException e = new NullPointerException("Name is null");
			e.printStackTrace();
		}

		return null;

	}

	public static EItem searchBy(String name, int meta) {
		ArrayList<EItem> values = (ArrayList<EItem>) Arrays.asList(values());

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
}
