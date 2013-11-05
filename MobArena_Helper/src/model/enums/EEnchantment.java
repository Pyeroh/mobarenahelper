package model.enums;

public enum EEnchantment {

	//Armor
	protection(0,4),
	fire_protection(1,4),
	feather_falling(2,4),
	blast_protection(3,4),
	projectile_protection(4,4),
	respiration(5,3),
	aqua_affinity(6,1),
	thorns(7,3),

	//Weapons
	sharpness(16,5),
	smite(17,5),
	bane_of_arthropods(18,5),
	knockback(19,2),
	fire_aspect(20,2),
	looting(21,3),

	//Tools
	efficiency(32,5),
	silk_touch(33,1),
	unbreaking(34,3),
	fortune(35,3),
	//luck_of_the_sea(61,3),
	//lure(62,3),

	//Bow
	power(48,5),
	punch(49,2),
	flame(50,1),
	infinity(51,1);
	;

	private int eid;
	private int lvlmax;

	private EEnchantment(int eid, int lvlmax) {
		this.eid = eid;
		this.lvlmax = lvlmax;
	}

	public int getEid() {
		return eid;
	}

	public String getName() {
		String name = name().replace('_', ' ');
		String first = ""+name.charAt(0);
		name = name.replaceFirst("^[a-z]", first.toUpperCase());
		return name;
	}

	public int getLvlmax() {
		return lvlmax;
	}

	/**
	 * Trouve l'EEnchantment correspondant au nom passé en paramètre. La comparaison est faite par rapport à la méthode
	 * getName().
	 * @param name le nom recherché
	 * @return la constante associée au nom passé en paramètre
	 * @throws IllegalArgumentException si la constante recherchée n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EEnchantment getByName(String name) {

		if (name!=null) {
			EEnchantment[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getName().equalsIgnoreCase(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EEnchantment." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

	public static EEnchantment getById(int id) {

		EEnchantment[] values = values();
		int i = 0;
		while(i < values.length && values[i].getEid()!=id) {
			i++;
		}
		if(i < values.length) {
			return values[i];
		}
		else {
			throw new IllegalArgumentException(
					"No enum constant EEnchantment for id " + id);
		}


	}

}
