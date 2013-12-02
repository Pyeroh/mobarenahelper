package model.enums;

/**
 * Les alias de monstre correspondant à un type de monstre
 * @author Pyeroh
 *
 */
public enum EMonsterAliases {
	zombie(EMonsters.zombie), 
	zombies(EMonsters.zombie, true),
	skeleton(EMonsters.skeleton),
	skeletons(EMonsters.skeleton, true),
	spider(EMonsters.spider),
	spiders(EMonsters.spider, true),
	creeper(EMonsters.creeper),
	creepers(EMonsters.creeper, true),
	wolf(EMonsters.wolf),
	wolves(EMonsters.wolf, true),
	zombie_pigman(EMonsters.zombie_pigman),
	zombie_pigmen(EMonsters.zombie_pigman, true),
	powered_creeper(EMonsters.powered_creeper),
	powered_creepers(EMonsters.powered_creeper, true),
	angry_wolf(EMonsters.angry_wolf),
	angry_wolves(EMonsters.angry_wolf, true),
	giant(EMonsters.giant),
	giants(EMonsters.giant, true),
	ghast(EMonsters.ghast),
	ghasts(EMonsters.ghast, true),
	enderman(EMonsters.enderman),
	endermen(EMonsters.enderman, true),
	silverfish(EMonsters.silverfish),
	cave_spider(EMonsters.cave_spider),
	cave_spiders(EMonsters.cave_spider, true),
	blaze(EMonsters.blaze),
	blazes(EMonsters.blaze, true),
	snowman(EMonsters.snowman),
	snowmen(EMonsters.snowman, true),
	snow_golem(EMonsters.snowman),
	snow_golems(EMonsters.snowman, true),
	iron_golem(EMonsters.iron_golem),
	iron_golems(EMonsters.iron_golem, true),
	witch(EMonsters.witch),
	witches(EMonsters.witch, true),
	wither(EMonsters.wither),
	withers(EMonsters.wither, true),
	wither_skeleton(EMonsters.wither_skeleton),
	wither_skeletons(EMonsters.wither_skeleton, true),
	baby_zombie(EMonsters.baby_zombie),
	baby_zombies(EMonsters.baby_zombie, true),
	baby_pigman(EMonsters.baby_pigman),
	baby_pigmen(EMonsters.baby_pigman, true),
	zombie_villager(EMonsters.zombie_villager),
	zombie_villagers(EMonsters.zombie_villager, true),
	chicken(EMonsters.chicken),
	chickens(EMonsters.chicken, true),
	cow(EMonsters.cow),
	cows(EMonsters.cow, true),
	mushroom_cow(EMonsters.mushroom_cow),
	mushroom_cows(EMonsters.mushroom_cow, true),
	pig(EMonsters.pig),
	pigs(EMonsters.pig, true),
	sheep(EMonsters.sheep),
	squid(EMonsters.squid),
	squids(EMonsters.squid, true),
	villager(EMonsters.villager),
	villagers(EMonsters.villager, true),
	ocelot(EMonsters.ocelot),
	ocelots(EMonsters.ocelot, true),
	bat(EMonsters.bat),
	bats(EMonsters.bat, true),
	exploding_sheep(EMonsters.exploding_sheep),
	slime(EMonsters.slime),
	slimes(EMonsters.slime, true),
	slime_tiny(EMonsters.slime_tiny),
	slimes_tiny(EMonsters.slime_tiny, true),
	slime_small(EMonsters.slime_small),
	slimes_small(EMonsters.slime_small, true),
	slime_big(EMonsters.slime_big),
	slimes_big(EMonsters.slime_big, true),
	slime_huge(EMonsters.slime_huge),
	slimes_huge(EMonsters.slime_huge, true),
	magmacube(EMonsters.magmacube),
	magmacubes(EMonsters.magmacube, true),
	magmacube_tiny(EMonsters.magmacube_tiny),
	magmacubes_tiny(EMonsters.magmacube_tiny, true),
	magmacube_small(EMonsters.magmacube_small),
	magmacubes_small(EMonsters.magmacube_small, true),
	magmacube_big(EMonsters.magmacube_big),
	magmacubes_big(EMonsters.magmacube_big, true),
	magmacube_huge(EMonsters.magmacube_huge),
	magmacubes_huge(EMonsters.magmacube_huge, true);
	
	private EMonsters monstre;
	private boolean pluriel;

	EMonsterAliases(EMonsters monstre){
		this.monstre = monstre;
		this.pluriel = false;
	}
	
	EMonsterAliases(EMonsters monstre, boolean pluriel) {
		this.monstre = monstre;
		this.pluriel = pluriel;
	}

	public EMonsters getMonstre() {
		return monstre;
	}

	public boolean isPluriel() {
		return pluriel;
	}
	
	/**
	 * Renvoie l'alias de monstre "pluriel" (un creeper, des creepers) de la constante en cours.
	 * Attention, certaines constantes n'ont pas de pluriel, dans ce cas, la valeur retournée est
	 * la constante elle-même.
	 * @return
	 */
	public EMonsterAliases getPlural() {
		EMonsterAliases plural = this;
		
		if(!plural.isPluriel()) {
			EMonsterAliases[] values = values();
			for(int i=0;i<values.length;i++) {
				if(values[i].getMonstre()==plural.getMonstre() && values[i].isPluriel()) {
					plural = values[i];
				}
			}
		}
		
		return plural;
	}
	
	public static EMonsterAliases getByName(String monster) {
		return valueOf(monster.trim().replace('-', '_'));
	}

}
