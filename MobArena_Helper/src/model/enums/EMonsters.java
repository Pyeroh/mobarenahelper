package model.enums;

import model.EnumName;

/**
 * Les différents monstres ajoutables dans une vague
 *
 * @author Pyeroh
 *
 */
public enum EMonsters {

	zombie(0), //$NON-NLS-1$
	skeleton(1), //$NON-NLS-1$
	spider(2), //$NON-NLS-1$
	creeper(3), //$NON-NLS-1$
	wolf(4), //$NON-NLS-1$
	zombie_pigman(5), //$NON-NLS-1$
	powered_creeper(6), //$NON-NLS-1$
	angry_wolf(7), //$NON-NLS-1$
	giant(8), //$NON-NLS-1$
	ghast(9), //$NON-NLS-1$
	enderman(10), //$NON-NLS-1$
	silverfish(11), //$NON-NLS-1$
	cave_spider(12), //$NON-NLS-1$
	blaze(13), //$NON-NLS-1$
	enderdragon(42),//$NON-NLS-1$
	snowman(14), //$NON-NLS-1$
	iron_golem(15), //$NON-NLS-1$
	witch(16), //$NON-NLS-1$
	wither(17), //$NON-NLS-1$
	wither_skeleton(18), //$NON-NLS-1$
	baby_zombie(19), //$NON-NLS-1$
	baby_pigman(20), //$NON-NLS-1$
	zombie_villager(21), //$NON-NLS-1$
	baby_zombie_villager(43),//$NON-NLS-1$
	chicken(22), //$NON-NLS-1$
	cow(23), //$NON-NLS-1$
	mushroom_cow(24), //$NON-NLS-1$
	pig(25), //$NON-NLS-1$
	sheep(26), //$NON-NLS-1$
	squid(27), //$NON-NLS-1$
	villager(28), //$NON-NLS-1$
	ocelot(29), //$NON-NLS-1$
	bat(30), //$NON-NLS-1$
	horse(44),//$NON-NLS-1$
	donkey(45),//$NON-NLS-1$
	mule(46),//$NON-NLS-1$
	skeleton_horse(47),//$NON-NLS-1$
	undead_horse(48),//$NON-NLS-1$
	exploding_sheep(31), //$NON-NLS-1$
	slime(32), //$NON-NLS-1$
	slime_tiny(33), //$NON-NLS-1$
	slime_small(34), //$NON-NLS-1$
	slime_big(35), //$NON-NLS-1$
	slime_huge(36), //$NON-NLS-1$
	magmacube(37), //$NON-NLS-1$
	magmacube_tiny(38), //$NON-NLS-1$
	magmacube_small(39), //$NON-NLS-1$
	magmacube_big(40), //$NON-NLS-1$
	magmacube_huge(41); //$NON-NLS-1$

	private String nom;

	private int idLang;

	EMonsters(int idLang) {
		this.idLang = idLang;
	}

	public String getNom() {
		return nom;
	}

	public int getIdLang() {
		return idLang;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 *
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues() {

		EMonsters[] values = values();
		String[] namevalues = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 *
	 * @param name
	 *            ce qui peut être renvoyé par {@link EMonsters#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException
	 *             si la constante n'existe pas
	 * @throws NullPointerException
	 *             si le paramètre vaut {@code null}
	 */
	public static EMonsters getByName(String name) {

		if (name != null) {
			EMonsters[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			}
			else {
				throw new IllegalArgumentException("No enum constant EMonsters." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}

	public static void load() {
		EMonsters[] values = values();
		for (int i = 0; i < values.length; i++) {
			values[i].nom = EnumName.getString("EMonsters." + values[i].idLang);
		}
	}

}
