package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum EItem {

	//Blocks
	stone(1,0,"STONE",EItemCat.block),
	grass(0,0,"GRASS",null),
	dirt(0,0,"DIRT",null),
	cobblestone(0,0,"COBBLESTONE",null),
	oakwood(0,0,"WOOD",null),
	redwood(0,0,"WOOD",null),
	birchwood(0,0,"WOOD",null),
	junglewood(0,0,"WOOD",null),
	oaksapling(0,0,"SAPLING",null),
	redsapling(0,0,"SAPLING",null),
	birchsapling(0,0,"SAPLING",null),
	junglesapling(0,0,"SAPLING",null),
	sand(0,0,"SAND",null),
	gravel(0,0,"GRAVEL",null),
	gold_ore(0,0,"GOLD_ORE",null),
	iron_ore(0,0,"IRON_ORE",null),
	coal_ore(0,0,"COAL_ORE",null),
	oaklog(0,0,"LOG",null),
	redlog(0,0,"LOG",null),
	birchlog(0,0,"LOG",null),
	junglelog(0,0,"LOG",null),
	oakleaves(0,0,"LEAVES",null),
	redleaves(0,0,"LEAVES",null),
	birchleaves(0,0,"LEAVES",null),
	jungleleaves(0,0,"LEAVES",null),
	glass(0,0,"GLASS",null),
	lapis_ore(0,0,"LAPIS_ORE",null),
	lapis_block(0,0,"LAPIS_BLOCK",null),
	dispenser(0,0,"DISPENSER",null),
	sandstone(0,0,"SANDSTONE",null),
	sandstonechiseled(0,0,"SANDSTONE",null),
	sandstonesmooth(0,0,"SANDSTONE",null),
	note_block(0,0,"NOTE_BLOCK",null),
	powered_rail(0,0,"POWERED_RAIL",null),
	detector_rail(0,0,"DETECTOR_RAIL",null),
	piston_sticky_base(0,0,"PISTON_STICKY_BASE",null),
	web(0,0,"WEB",null),
	long_grass(0,0,"LONG_GRASS",null),
	fern(0,0,"LONG_GRASS",null),
	dead_bush(0,0,"DEAD_BUSH",null),
	piston_base(0,0,"PISTON_BASE",null),
	woolwhite(0,0,"WOOL",null),
	woolorange(0,0,"WOOL",null),
	woolmagenta(0,0,"WOOL",null),
	woollblue(0,0,"WOOL",null),
	woolyellow(0,0,"WOOL",null),
	woollgreen(0,0,"WOOL",null),
	woolpink(0,0,"WOOL",null),
	woolgray(0,0,"WOOL",null),
	woollgray(0,0,"WOOL",null),
	woolcyan(0,0,"WOOL",null),
	woolpurple(0,0,"WOOL",null),
	woolblue(0,0,"WOOL",null),
	woolbrown(0,0,"WOOL",null),
	woolgreen(0,0,"WOOL",null),
	woolred(0,0,"WOOL",null),
	woolblack(0,0,"WOOL",null),
	yellow_flower(0,0,"YELLOW_FLOWER",null),
	red_rose(0,0,"RED_ROSE",null),
	brown_mushroom(0,0,"BROWN_MUSHROOM",null),
	red_mushroom(0,0,"RED_MUSHROOM",null),
	gold_block(0,0,"GOLD_BLOCK",null),
	iron_block(0,0,"IRON_BLOCK",null),
	stonestep(0,0,"STEP",null),
	sandstep(0,0,"STEP",null),
	cobblestep(0,0,"STEP",null),
	brickstep(0,0,"STEP",null),
	stonebrickstep(0,0,"STEP",null),
	netherbrickstep(0,0,"STEP",null),
	quartzstep(0,0,"STEP",null),
	brick(0,0,"BRICK",null),
	tnt(0,0,"TNT",null),
	bookshelf(0,0,"BOOKSHELF",null),
	mossy_cobblestone(0,0,"MOSSY_COBBLESTONE",null),
	obsidian(0,0,"OBSIDIAN",null),
	torch(0,0,"TORCH",null),
	wood_stairs(0,0,"WOOD_STAIRS",null),
	chest(0,0,"CHEST",null),
	diamond_ore(0,0,"DIAMOND_ORE",null),
	diamond_block(0,0,"DIAMOND_BLOCK",null),
	workbench(0,0,"WORKBENCH",null),
	furnace(0,0,"FURNACE",null),
	ladder(0,0,"LADDER",null),
	rails(0,0,"RAILS",null),
	cobblestone_stairs(0,0,"COBBLESTONE_STAIRS",null),
	lever(0,0,"LEVER",null),
	stone_plate(0,0,"STONE_PLATE",null),
	wood_plate(0,0,"WOOD_PLATE",null),
	redstone_ore(0,0,"REDSTONE_ORE",null),
	redstone_torch_on(0,0,"REDSTONE_TORCH_ON",null),
	stone_button(0,0,"STONE_BUTTON",null),
	snow(0,0,"SNOW",null),
	ice(0,0,"ICE",null),
	snow_block(0,0,"SNOW_BLOCK",null),
	cactus(0,0,"CACTUS",null),
	clay(0,0,"CLAY",null),
	jukebox(0,0,"JUKEBOX",null),
	fence(0,0,"FENCE",null),
	pumpkin(0,0,"PUMPKIN",null),
	netherrack(0,0,"NETHERRACK",null),
	soul_sand(0,0,"SOUL_SAND",null),
	glowstone(0,0,"GLOWSTONE",null),
	jack_o_lantern(0,0,"JACK_O_LANTERN",null),
	trap_door(0,0,"TRAP_DOOR",null),
	smooth_brick(0,0,"SMOOTH_BRICK",null),
	mosssmooth_brick(0,0,"SMOOTH_BRICK",null),
	cracksmooth_brick(0,0,"SMOOTH_BRICK",null),
	chissmooth_brick(0,0,"SMOOTH_BRICK",null),
	huge_mushroom_1(0,0,"HUGE_MUSHROOM_1",null),
	huge_mushroom_2(0,0,"HUGE_MUSHROOM_1",null),
	iron_fence(0,0,"IRON_FENCE",null),
	thin_glass(0,0,"THIN_GLASS",null),
	melon_block(0,0,"MELON_BLOCK",null),
	vine(0,0,"VINE",null),
	fence_gate(0,0,"FENCE_GATE",null),
	brick_stairs(0,0,"BRICK_STAIRS",null),
	smooth_stairs(0,0,"SMOOTH_STAIRS",null),
	mycel(0,0,"MYCEL",null),
	water_lily(0,0,"WATER_LILY",null),
	nether_brick(0,0,"NETHER_BRICK",null),
	nether_fence(0,0,"NETHER_FENCE",null),
	nether_brick_stairs(0,0,"NETHER_BRICK_STAIRS",null),
	enchantment_table(0,0,"ENCHANTMENT_TABLE",null),
	ender_stone(0,0,"ENDER_STONE",null),
	dragon_egg(0,0,"DRAGON_EGG",null),
	redstone_lamp_off(0,0,"REDSTONE_LAMP_OFF",null),
	redstone_lamp_on(0,0,"REDSTONE_LAMP_ON",null),
	oakwood_step(0,0,"WOOD_STEP",null),
	redwood_step(0,0,"WOOD_STEP",null),
	birchwood_step(0,0,"WOOD_STEP",null),
	junglewood_step(0,0,"WOOD_STEP",null),
	sandstone_stairs(0,0,"SANDSTONE_STAIRS",null),
	emerald_ore(0,0,"EMERALD_ORE",null),
	ender_chest(0,0,"ENDER_CHEST",null),
	tripwire_hook(0,0,"TRIPWIRE_HOOK",null),
	emerald_block(0,0,"EMERALD_BLOCK",null),
	spruce_wood_stairs(0,0,"SPRUCE_WOOD_STAIRS",null),
	birch_wood_stairs(0,0,"BIRCH_WOOD_STAIRS",null),
	jungle_wood_stairs(0,0,"JUNGLE_WOOD_STAIRS",null),
	beacon(0,0,"BEACON",null),
	cobble_wall(0,0,"COBBLE_WALL",null),
	mosscobble_wall(0,0,"COBBLE_WALL",null),
	wood_button(0,0,"WOOD_BUTTON",null),
	anvil(0,0,"ANVIL",null),
	anvilmid(0,0,"ANVIL",null),
	anvilbad(0,0,"ANVIL",null),
	trapped_chest(0,0,"TRAPPED_CHEST",null),
	gold_plate(0,0,"GOLD_PLATE",null),
	iron_plate(0,0,"IRON_PLATE",null),
	daylight_detector(0,0,"DAYLIGHT_DETECTOR",null),
	redstone_block(0,0,"REDSTONE_BLOCK",null),
	quartz_ore(0,0,"QUARTZ_ORE",null),
	hopper(0,0,"HOPPER",null),
	quartz_block(0,0,"QUARTZ_BLOCK",null),
	chiseledquartz_block(0,0,"QUARTZ_BLOCK",null),
	pillarquartz_block(0,0,"QUARTZ_BLOCK",null),
	quartz_stairs(0,0,"QUARTZ_STAIRS",null),
	activator_rail(0,0,"ACTIVATOR_RAIL",null),
	dropper(0,0,"DROPPER",null),
	stained_claywhite(0,0,"STAINED_CLAY",null),
	stained_clayorange(0,0,"STAINED_CLAY",null),
	stained_claymagenta(0,0,"STAINED_CLAY",null),
	stained_claylblue(0,0,"STAINED_CLAY",null),
	stained_clayyellow(0,0,"STAINED_CLAY",null),
	stained_claylgreen(0,0,"STAINED_CLAY",null),
	stained_claypink(0,0,"STAINED_CLAY",null),
	stained_claygray(0,0,"STAINED_CLAY",null),
	stained_claylgray(0,0,"STAINED_CLAY",null),
	stained_claycyan(0,0,"STAINED_CLAY",null),
	stained_claypurple(0,0,"STAINED_CLAY",null),
	stained_clayblue(0,0,"STAINED_CLAY",null),
	stained_claybrown(0,0,"STAINED_CLAY",null),
	stained_claygreen(0,0,"STAINED_CLAY",null),
	stained_clayred(0,0,"STAINED_CLAY",null),
	stained_clayblack(0,0,"STAINED_CLAY",null),
	hay_block(0,0,"HAY_BLOCK",null),
	carpetwhite(0,0,"CARPET",null),
	carpetorange(0,0,"CARPET",null),
	carpetmagenta(0,0,"CARPET",null),
	carpetlblue(0,0,"CARPET",null),
	carpetyellow(0,0,"CARPET",null),
	carpetlgreen(0,0,"CARPET",null),
	carpetpink(0,0,"CARPET",null),
	carpetgray(0,0,"CARPET",null),
	carpetlgray(0,0,"CARPET",null),
	carpetcyan(0,0,"CARPET",null),
	carpetpurple(0,0,"CARPET",null),
	carpetblue(0,0,"CARPET",null),
	carpetbrown(0,0,"CARPET",null),
	carpetgreen(0,0,"CARPET",null),
	carpetred(0,0,"CARPET",null),
	carpetblack(0,0,"CARPET",null),
	hard_clay(0,0,"CARPET",null),
	coal_block(0,0,"CARPET",null),

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
