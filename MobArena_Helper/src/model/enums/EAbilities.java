package model.enums;

/**
 * Les abilités des boss
 * @author Pyeroh
 *
 */
public enum EAbilities {
	arrows("Arrows"),
	fireballs("Fireballs"),
	fire_aura("Fire-aura"),
	lightning_aura("Lightning Aura"),
	living_bomb("Living Bomb"),
	obsidian_bomb("Obsidian Bomb"),
	chain_lightning("Chain Lightning"),
	disorient_target("Disorient Target"),
	disorient_nearby("Disorient Nearby"),
	disorient_distant("Disorient Distant"),
	root_target("Root Target"),
	warp_to_player("Warp to Player"),
	shuffle_positions("Shuffle Positions"),
	flood("Flood"),
	throw_target("Throw Target"),
	throw_nearby("Throw Nearby"),
	throw_distant("Throw Distant"),
	pull_target("Pull Target"),
	pull_nearby("Pull Nearby"),
	pull_distant("Pull Distant");

	private String nom;

	EAbilities(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public String toString() {
		return name().replace('_', '-');
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues(){

		EAbilities[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
	
	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link EAbilities#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EAbilities getByName(String name) {

		if (name!=null) {
			EAbilities[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EAbilities." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

}
