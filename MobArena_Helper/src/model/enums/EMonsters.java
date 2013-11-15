package model.enums;

import model.EnumName;

/**
 * Les différents monstres ajoutables dans une vague
 * @author Pyeroh
 *
 */
public enum EMonsters {

	zombie(EnumName.getString("EMonsters.0")), //$NON-NLS-1$
	skeleton(EnumName.getString("EMonsters.1")), //$NON-NLS-1$
	spider(EnumName.getString("EMonsters.2")), //$NON-NLS-1$
	creeper(EnumName.getString("EMonsters.3")), //$NON-NLS-1$
	wolf(EnumName.getString("EMonsters.4")), //$NON-NLS-1$
	zombie_pigman(EnumName.getString("EMonsters.5")), //$NON-NLS-1$
	powered_creeper(EnumName.getString("EMonsters.6")), //$NON-NLS-1$
	angry_wolf(EnumName.getString("EMonsters.7")), //$NON-NLS-1$
	giant(EnumName.getString("EMonsters.8")), //$NON-NLS-1$
	ghast(EnumName.getString("EMonsters.9")), //$NON-NLS-1$
	enderman(EnumName.getString("EMonsters.10")), //$NON-NLS-1$
	silverfish(EnumName.getString("EMonsters.11")), //$NON-NLS-1$
	cave_spider(EnumName.getString("EMonsters.12")), //$NON-NLS-1$
	blaze(EnumName.getString("EMonsters.13")), //$NON-NLS-1$
	snowman(EnumName.getString("EMonsters.14")), //$NON-NLS-1$
	iron_golem(EnumName.getString("EMonsters.15")), //$NON-NLS-1$
	witch(EnumName.getString("EMonsters.16")), //$NON-NLS-1$
	wither(EnumName.getString("EMonsters.17")), //$NON-NLS-1$
	wither_skeleton(EnumName.getString("EMonsters.18")), //$NON-NLS-1$
	baby_zombie(EnumName.getString("EMonsters.19")), //$NON-NLS-1$
	baby_pigman(EnumName.getString("EMonsters.20")), //$NON-NLS-1$
	zombie_villager(EnumName.getString("EMonsters.21")), //$NON-NLS-1$
	chicken(EnumName.getString("EMonsters.22")), //$NON-NLS-1$
	cow(EnumName.getString("EMonsters.23")), //$NON-NLS-1$
	mushroom_cow(EnumName.getString("EMonsters.24")), //$NON-NLS-1$
	pig(EnumName.getString("EMonsters.25")), //$NON-NLS-1$
	sheep(EnumName.getString("EMonsters.26")), //$NON-NLS-1$
	squid(EnumName.getString("EMonsters.27")), //$NON-NLS-1$
	villager(EnumName.getString("EMonsters.28")), //$NON-NLS-1$
	ocelot(EnumName.getString("EMonsters.29")), //$NON-NLS-1$
	bat(EnumName.getString("EMonsters.30")), //$NON-NLS-1$
	exploding_sheep(EnumName.getString("EMonsters.31")), //$NON-NLS-1$
	slime(EnumName.getString("EMonsters.32")), //$NON-NLS-1$
	slime_tiny(EnumName.getString("EMonsters.33")), //$NON-NLS-1$
	slime_small(EnumName.getString("EMonsters.34")), //$NON-NLS-1$
	slime_big(EnumName.getString("EMonsters.35")), //$NON-NLS-1$
	slime_huge(EnumName.getString("EMonsters.36")), //$NON-NLS-1$
	magmacube(EnumName.getString("EMonsters.37")), //$NON-NLS-1$
	magmacube_tiny(EnumName.getString("EMonsters.38")), //$NON-NLS-1$
	magmacube_small(EnumName.getString("EMonsters.39")), //$NON-NLS-1$
	magmacube_big(EnumName.getString("EMonsters.40")), //$NON-NLS-1$
	magmacube_huge(EnumName.getString("EMonsters.41")); //$NON-NLS-1$

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
						"No enum constant EMonsters." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}
		
	}
	
}
