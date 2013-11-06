package model.enums;

/**
 * Les différents monstres ajoutables dans une vague
 * @author Pyeroh
 *
 */
public enum EMonsters {

	zombie("Zombie"),
	skeleton("Skeleton"),
	spider("Spider"),
	creeper("Creeper"),
	wolf("Wolf"),
	zombie_pigman("Zombie pigman"),
	powered_creeper("Powered creeper"),
	angry_wolf("Angry wolf"),
	giant("Giant"),
	ghast("Ghast"),
	enderman("Enderman"),
	silverfish("Silverfish"),
	cave_spider("Cave spider"),
	blaze("Blaze"),
	snowman("Snowman"),
	iron_golem("Iron golem"),
	witch("Witch"),
	wither("Wither"),
	wither_skeleton("Wither skeleton"),
	baby_zombie("Baby zombie"),
	baby_pigman("Baby pigman"),
	zombie_villager("Zombie villager"),
	chicken("Chicken"),
	cow("Cow"),
	mushroom_cow("Mushroom cow"),
	pig("Pig"),
	sheep("Sheep"),
	squid("Squid"),
	villager("Villager"),
	ocelot("Ocelot"),
	bat("Bat"),
	exploding_sheep("Exploding sheep"),
	slime("Slime"),
	slime_tiny("Slime tiny"),
	slime_small("Slime small"),
	slime_big("Slime big"),
	slime_huge("Slime huge"),
	magmacube("Magmacube"),
	magmacube_tiny("Magmacube tiny"),
	magmacube_small("Magmacube small"),
	magmacube_big("Magmacube big"),
	magmacube_huge("Magmacube huge");

	private String nom;

	EMonsters(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues(){

		EMonsters[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
	
	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link EMonsters#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EMonsters getByName(String name) {
		
		if (name!=null) {
			EMonsters[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EMonsters." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}
		
	}
	
}
