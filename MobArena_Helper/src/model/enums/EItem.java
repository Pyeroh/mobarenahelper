package model.enums;

import java.util.ArrayList;

public enum EItem {
	
	//Blocks
	STONE(1,0,"stone",EItemCat.block),
	GRASS(0,0,null,null),
	DIRT(0,0,null,null),
	COBBLESTONE(0,0,null,null),
	oakWOOD(0,0,null,null),
	redWOOD(0,0,null,null),
	birchWOOD(0,0,null,null),
	jungleWOOD(0,0,null,null),
	oakSAPLING(0,0,null,null),
	redSAPLING(0,0,null,null),
	birchSAPLING(0,0,null,null),
	jungleSAPLING(0,0,null,null),
	SAND(0,0,null,null),
	GRAVEL(0,0,null,null),
	GOLD_ORE(0,0,null,null),
	IRON_ORE(0,0,null,null),
	COAL_ORE(0,0,null,null),
	oakLOG(0,0,null,null),
	redLOG(0,0,null,null),
	birchLOG(0,0,null,null),
	jungleLOG(0,0,null,null),
	oakLEAVES(0,0,null,null),
	redLEAVES(0,0,null,null),
	birchLEAVES(0,0,null,null),
	jungleLEAVES(0,0,null,null),
	GLASS(0,0,null,null),
	LAPIS_ORE(0,0,null,null),
	LAPIS_BLOCK(0,0,null,null),
	DISPENSER(0,0,null,null),
	SANDSTONE(0,0,null,null),
	SANDSTONEchiseled(0,0,null,null),
	SANDSTONEsmooth(0,0,null,null),
	NOTE_BLOCK(0,0,null,null),
	POWERED_RAIL(0,0,null,null),
	DETECTOR_RAIL(0,0,null,null),
	PISTON_STICKY_BASE(0,0,null,null),
	WEB(0,0,null,null),
	LONG_GRASS(0,0,null,null),
	LONG_GRASSfern(0,0,null,null),
	DEAD_BUSH(0,0,null,null),
	PISTON_BASE(0,0,null,null),
	WOOLwhite(0,0,null,null),
	WOOLorange(0,0,null,null),
	WOOLmagenta(0,0,null,null),
	WOOLlblue(0,0,null,null),
	WOOLyellow(0,0,null,null),
	WOOLlgreen(0,0,null,null),
	WOOLpink(0,0,null,null),
	WOOLgray(0,0,null,null),
	WOOLlgray(0,0,null,null),
	WOOLcyan(0,0,null,null),
	WOOLpurple(0,0,null,null),
	WOOLblue(0,0,null,null),
	WOOLbrown(0,0,null,null),
	WOOLgreen(0,0,null,null),
	WOOLred(0,0,null,null),
	WOOLblack(0,0,null,null),
	YELLOW_FLOWER(0,0,null,null),
	RED_ROSE(0,0,null,null),
	BROWN_MUSHROOM(0,0,null,null),
	RED_MUSHROOM(0,0,null,null),
	GOLD_BLOCK(0,0,null,null),
	IRON_BLOCK(0,0,null,null),
	stoneSTEP(0,0,null,null),
	sandSTEP(0,0,null,null),
	cobbleSTEP(0,0,null,null),
	brickSTEP(0,0,null,null),
	stonebrickSTEP(0,0,null,null),
	netherbrickSTEP(0,0,null,null),
	quartzSTEP(0,0,null,null),
	BRICK(0,0,null,null),
	TNT(0,0,null,null),
	BOOKSHELF(0,0,null,null),
	MOSSY_COBBLESTONE(0,0,null,null),
	OBSIDIAN(0,0,null,null),
	TORCH(0,0,null,null),
	WOOD_STAIRS(0,0,null,null),
	CHEST(0,0,null,null),
	DIAMOND_ORE(0,0,null,null),
	DIAMOND_BLOCK(0,0,null,null),
	WORKBENCH(0,0,null,null),
	FURNACE(0,0,null,null),
	LADDER(0,0,null,null),
	RAILS(0,0,null,null),
	COBBLESTONE_STAIRS(0,0,null,null),
	LEVER(0,0,null,null),
	STONE_PLATE(0,0,null,null),
	WOOD_PLATE(0,0,null,null),
	REDSTONE_ORE(0,0,null,null),
	REDSTONE_TORCH_ON(0,0,null,null),
	STONE_BUTTON(0,0,null,null),
	SNOW(0,0,null,null),
	ICE(0,0,null,null),
	SNOW_BLOCK(0,0,null,null),
	CACTUS(0,0,null,null),
	CLAY(0,0,null,null),
	JUKEBOX(0,0,null,null),
	FENCE(0,0,null,null),
	PUMPKIN(0,0,null,null),
	NETHERRACK(0,0,null,null),
	SOUL_SAND(0,0,null,null),
	GLOWSTONE(0,0,null,null),
	JACK_O_LANTERN(0,0,null,null),
	TRAP_DOOR(0,0,null,null),
	SMOOTH_BRICK(0,0,null,null),
	mossSMOOTH_BRICK(0,0,null,null),
	crackSMOOTH_BRICK(0,0,null,null),
	chisSMOOTH_BRICK(0,0,null,null),
	HUGE_MUSHROOM_1(0,0,null,null),
	HUGE_MUSHROOM_2(0,0,null,null),
	IRON_FENCE(0,0,null,null),
	THIN_GLASS(0,0,null,null),
	MELON_BLOCK(0,0,null,null),
	VINE(0,0,null,null),
	FENCE_GATE(0,0,null,null),
	BRICK_STAIRS(0,0,null,null),
	SMOOTH_STAIRS(0,0,null,null),
	MYCEL(0,0,null,null),
	WATER_LILY(0,0,null,null),
	NETHER_BRICK(0,0,null,null),
	NETHER_FENCE(0,0,null,null),
	NETHER_BRICK_STAIRS(0,0,null,null),
	ENCHANTMENT_TABLE(0,0,null,null),
	ENDER_STONE(0,0,null,null),
	DRAGON_EGG(0,0,null,null),
	REDSTONE_LAMP_OFF(0,0,null,null),
	REDSTONE_LAMP_ON(0,0,null,null),
	oakWOOD_STEP(0,0,null,null),
	redWOOD_STEP(0,0,null,null),
	birchWOOD_STEP(0,0,null,null),
	jungleWOOD_STEP(0,0,null,null),
	SANDSTONE_STAIRS(0,0,null,null),
	EMERALD_ORE(0,0,null,null),
	ENDER_CHEST(0,0,null,null),
	TRIPWIRE_HOOK(0,0,null,null),
	EMERALD_BLOCK(0,0,null,null),
	SPRUCE_WOOD_STAIRS(0,0,null,null),
	BIRCH_WOOD_STAIRS(0,0,null,null),
	JUNGLE_WOOD_STAIRS(0,0,null,null),
	BEACON(0,0,null,null),
	COBBLE_WALL(0,0,null,null),
	mossCOBBLE_WALL(0,0,null,null),
	WOOD_BUTTON(0,0,null,null),
	ANVIL(0,0,null,null),
	ANVILmid(0,0,null,null),
	ANVILbad(0,0,null,null),
	TRAPPED_CHEST(0,0,null,null),
	GOLD_PLATE(0,0,null,null),
	IRON_PLATE(0,0,null,null),
	DAYLIGHT_DETECTOR(0,0,null,null),
	REDSTONE_BLOCK(0,0,null,null),
	QUARTZ_ORE(0,0,null,null),
	HOPPER(0,0,null,null),
	QUARTZ_BLOCK(0,0,null,null),
	chiseledQUARTZ_BLOCK(0,0,null,null),
	pillarQUARTZ_BLOCK(0,0,null,null),
	QUARTZ_STAIRS(0,0,null,null),
	ACTIVATOR_RAIL(0,0,null,null),
	DROPPER(0,0,null,null),
	STAINED_CLAYwhite(0,0,null,null),
	STAINED_CLAYorange(0,0,null,null),
	STAINED_CLAYmagenta(0,0,null,null),
	STAINED_CLAYlblue(0,0,null,null),
	STAINED_CLAYyellow(0,0,null,null),
	STAINED_CLAYlgreen(0,0,null,null),
	STAINED_CLAYpink(0,0,null,null),
	STAINED_CLAYgray(0,0,null,null),
	STAINED_CLAYlgray(0,0,null,null),
	STAINED_CLAYcyan(0,0,null,null),
	STAINED_CLAYpurple(0,0,null,null),
	STAINED_CLAYblue(0,0,null,null),
	STAINED_CLAYbrown(0,0,null,null),
	STAINED_CLAYgreen(0,0,null,null),
	STAINED_CLAYred(0,0,null,null),
	STAINED_CLAYblack(0,0,null,null),
	HAY_BLOCK(0,0,null,null),
	CARPETwhite(0,0,null,null),
	CARPETorange(0,0,null,null),
	CARPETmagenta(0,0,null,null),
	CARPETlblue(0,0,null,null),
	CARPETyellow(0,0,null,null),
	CARPETlgreen(0,0,null,null),
	CARPETpink(0,0,null,null),
	CARPETgray(0,0,null,null),
	CARPETlgray(0,0,null,null),
	CARPETcyan(0,0,null,null),
	CARPETpurple(0,0,null,null),
	CARPETblue(0,0,null,null),
	CARPETbrown(0,0,null,null),
	CARPETgreen(0,0,null,null),
	CARPETred(0,0,null,null),
	CARPETblack(0,0,null,null),
	HARD_CLAY(0,0,null,null),
	COAL_BLOCK(0,0,null,null),
	
	//Items
	IRON_SPADE(0,0,null,null),
	IRON_PICKAXE(0,0,null,null),
	IRON_AXE(0,0,null,null),
	FLINT_AND_STEEL(0,0,null,null),
	APPLE(0,0,null,null),
	BOW(0,0,null,null),
	ARROW(0,0,null,null),
	COAL(0,0,null,null),
	charCOAL(0,0,null,null),
	DIAMOND(0,0,null,null),
	IRON_INGOT(0,0,null,null),
	GOLD_INGOT(0,0,null,null),
	IRON_SWORD(0,0,null,null),
	WOOD_SWORD(0,0,null,null),
	WOOD_SPADE(0,0,null,null),
	WOOD_PICKAXE(0,0,null,null),
	WOOD_AXE(0,0,null,null),
	STONE_SWORD(0,0,null,null),
	STONE_SPADE(0,0,null,null),
	STONE_PICKAXE(0,0,null,null),
	STONE_AXE(0,0,null,null),
	DIAMOND_SWORD(0,0,null,null),
	DIAMOND_SPADE(0,0,null,null),
	DIAMOND_PICKAXE(0,0,null,null),
	DIAMOND_AXE(0,0,null,null),
	STICK(0,0,null,null),
	BOWL(0,0,null,null),
	MUSHROOM_SOUP(0,0,null,null),
	GOLD_SWORD(0,0,null,null),
	GOLD_SPADE(0,0,null,null),
	GOLD_PICKAXE(0,0,null,null),
	GOLD_AXE(0,0,null,null),
	STRING(0,0,null,null),
	FEATHER(0,0,null,null),
	SULPHUR(0,0,null,null),
	WOOD_HOE(0,0,null,null),
	STONE_HOE(0,0,null,null),
	IRON_HOE(0,0,null,null),
	DIAMOND_HOE(0,0,null,null),
	GOLD_HOE(0,0,null,null),
	SEEDS(0,0,null,null),
	WHEAT(0,0,null,null),
	BREAD(0,0,null,null),
	LEATHER_HELMET(0,0,null,null),
	LEATHER_CHESTPLATE(0,0,null,null),
	LEATHER_LEGGINGS(0,0,null,null),
	LEATHER_BOOTS(0,0,null,null),
	CHAINMAIL_HELMET(0,0,null,null),
	CHAINMAIL_CHESTPLATE(0,0,null,null),
	CHAINMAIL_LEGGINGS(0,0,null,null),
	CHAINMAIL_BOOTS(0,0,null,null),
	IRON_HELMET(0,0,null,null),
	IRON_CHESTPLATE(0,0,null,null),
	IRON_LEGGINGS(0,0,null,null),
	IRON_BOOTS(0,0,null,null),
	DIAMOND_HELMET(0,0,null,null),
	DIAMOND_CHESTPLATE(0,0,null,null),
	DIAMOND_LEGGINGS(0,0,null,null),
	DIAMOND_BOOTS(0,0,null,null),
	GOLD_HELMET(0,0,null,null),
	GOLD_CHESTPLATE(0,0,null,null),
	GOLD_LEGGINGS(0,0,null,null),
	GOLD_BOOTS(0,0,null,null),
	FLINT(0,0,null,null),
	PORK(0,0,null,null),
	GRILLED_PORK(0,0,null,null),
	PAINTING(0,0,null,null),
	GOLDEN_APPLE1(0,0,null,null),
	GOLDEN_APPLE2(0,0,null,null),
	SIGN(0,0,null,null),
	WOOD_DOOR(0,0,null,null),
	BUCKET(0,0,null,null),
	WATER_BUCKET(0,0,null,null),
	LAVA_BUCKET(0,0,null,null),
	MINECART(0,0,null,null),
	SADDLE(0,0,null,null),
	IRON_DOOR(0,0,null,null),
	REDSTONE(0,0,null,null),
	SNOW_BALL(0,0,null,null),
	BOAT(0,0,null,null),
	LEATHER(0,0,null,null),
	MILK_BUCKET(0,0,null,null),
	CLAY_BRICK(0,0,null,null),
	CLAY_BALL(0,0,null,null),
	SUGAR_CANE(0,0,null,null),
	PAPER(0,0,null,null),
	BOOK(0,0,null,null),
	SLIME_BALL(0,0,null,null),
	STORAGE_MINECART(0,0,null,null),
	POWERED_MINECART(0,0,null,null),
	EGG(0,0,null,null),
	COMPASS(0,0,null,null),
	FISHING_ROD(0,0,null,null),
	WATCH(0,0,null,null),
	GLOWSTONE_DUST(0,0,null,null),
	RAW_FISH(0,0,null,null),
	COOKED_FISH(0,0,null,null),
	INK_SACK(0,0,null,null),
	reddye(0,0,null,null),
	greendye(0,0,null,null),
	browndye(0,0,null,null),
	bluedye(0,0,null,null),
	purpledye(0,0,null,null),
	cyandye(0,0,null,null),
	lgreydye(0,0,null,null),
	greydye(0,0,null,null),
	pinkdye(0,0,null,null),
	lgreendye(0,0,null,null),
	yellowdye(0,0,null,null),
	lbluedye(0,0,null,null),
	magentadye(0,0,null,null),
	orangedye(0,0,null,null),
	whitedye(0,0,null,null),
	BONE(0,0,null,null),
	SUGAR(0,0,null,null),
	CAKE(0,0,null,null),
	BED(0,0,null,null),
	DIODE(0,0,null,null),
	COOKIE(0,0,null,null),
	SHEARS(0,0,null,null),
	MELON(0,0,null,null),
	PUMPKIN_SEEDS(0,0,null,null),
	MELON_SEEDS(0,0,null,null),
	RAW_BEEF(0,0,null,null),
	COOKED_BEEF(0,0,null,null),
	RAW_CHICKEN(0,0,null,null),
	COOKED_CHICKEN(0,0,null,null),
	ROTTEN_FLESH(0,0,null,null),
	ENDER_PEARL(0,0,null,null),
	BLAZE_ROD(0,0,null,null),
	GHAST_TEAR(0,0,null,null),
	GOLD_NUGGET(0,0,null,null),
	NETHER_STALK(0,0,null,null),
	GLASS_BOTTLE(0,0,null,null),
	SPIDER_EYE(0,0,null,null),
	FERMENTED_SPIDER_EYE(0,0,null,null),
	BLAZE_POWDER(0,0,null,null),
	MAGMA_CREAM(0,0,null,null),
	BREWING_STAND_ITEM(0,0,null,null),
	CAULDRON_ITEM(0,0,null,null),
	EYE_OF_ENDER(0,0,null,null),
	SPECKLED_MELON(0,0,null,null),
	
	MONSTER_EGG(0,0,null,null),
	creeper_egg(0,0,null,null),
	skeleton_egg(0,0,null,null),
	spider_egg(0,0,null,null),
	zombie_egg(0,0,null,null),
	slime_egg(0,0,null,null),
	ghast_egg(0,0,null,null),
	zombie_pigman_egg(0,0,null,null),
	enderman_egg(0,0,null,null),
	cavespider_egg(0,0,null,null),
	silverfish_egg(0,0,null,null),
	blaze_egg(0,0,null,null),
	magmacube_egg(0,0,null,null),
	bat_egg(0,0,null,null),
	witch_egg(0,0,null,null),
	pig_egg(0,0,null,null),
	sheep_egg(0,0,null,null),
	cow_egg(0,0,null,null),
	chicken_egg(0,0,null,null),
	squid_egg(0,0,null,null),
	wolf_egg(0,0,null,null),
	mooshroom_egg(0,0,null,null),
	ocelot_egg(0,0,null,null),
	horse_egg(0,0,null,null),
	villager_egg(0,0,null,null),
	
	
	EXP_BOTTLE(0,0,null,null),
	FIREBALL(0,0,null,null),
	BOOK_AND_QUILL(0,0,null,null),
	EMERALD(0,0,null,null),
	ITEM_FRAME(0,0,null,null),
	FLOWER_POT_ITEM(0,0,null,null),
	CARROT_ITEM(0,0,null,null),
	POTATO_ITEM(0,0,null,null),
	BAKED_POTATO(0,0,null,null),
	POISONOUS_POTATO(0,0,null,null),
	EMPTY_MAP(0,0,null,null),
	GOLDEN_CARROT(0,0,null,null),
	SKULL_ITEM(0,0,null,null),
	//autres � ajouter
	CARROT_STICK(0,0,null,null),
	NETHER_STAR(0,0,null,null),
	PUMPKIN_PIE(0,0,null,null),
	FIREWORK(0,0,null,null),
	FIREWORK_CHARGE(0,0,null,null),
	ENCHANTED_BOOK(0,0,null,null),
	REDSTONE_COMPARATOR(0,0,null,null),
	NETHER_BRICK_ITEM(0,0,null,null),
	QUARTZ(0,0,null,null),
	EXPLOSIVE_MINECART(0,0,null,null),
	HOPPER_MINECART(0,0,null,null),
	IRON_BARDING(0,0,null,null),
	GOLD_BARDING(0,0,null,null),
	DIAMOND_BARDING(0,0,null,null),
	LEASH(0,0,null,null),
	NAME_TAG(0,0,null,null),
	GOLD_RECORD(0,0,null,null),
	GREEN_RECORD(0,0,null,null),
	RECORD_3(0,0,null,null),
	RECORD_4(0,0,null,null),
	RECORD_5(0,0,null,null),
	RECORD_6(0,0,null,null),
	RECORD_7(0,0,null,null),
	RECORD_8(0,0,null,null),
	ECORD_9(0,0,null,null),
	RECORD_10(0,0,null,null),
	RECORD_11(0,0,null,null),
	RECORD_12(0,0,null,null),
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
	
	public ArrayList<EItem> getByCategory(EItemCat category) {
		EItem[] values = values();
		ArrayList<EItem> items = new ArrayList<>();
		
		for(int i=0;i<values.length;i++) {
			EItem item = values[i];
			if(item.getCategory()==category){
				items.add(item);
			}
			
		}
		
		return null;
	}
	
}
