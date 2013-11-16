package model.enums;

import model.EnumName;

/**
 * Les abilités des boss
 * @author Pyeroh
 *
 */
public enum EAbilities {
	arrows(EnumName.getString("EAbilities.0")), //$NON-NLS-1$
	fireballs(EnumName.getString("EAbilities.1")), //$NON-NLS-1$
	fire_aura(EnumName.getString("EAbilities.2")), //$NON-NLS-1$
	lightning_aura(EnumName.getString("EAbilities.3")), //$NON-NLS-1$
	living_bomb(EnumName.getString("EAbilities.4")), //$NON-NLS-1$
	obsidian_bomb(EnumName.getString("EAbilities.5")), //$NON-NLS-1$
	chain_lightning(EnumName.getString("EAbilities.6")), //$NON-NLS-1$
	disorient_target(EnumName.getString("EAbilities.7")), //$NON-NLS-1$
	disorient_nearby(EnumName.getString("EAbilities.8")), //$NON-NLS-1$
	disorient_distant(EnumName.getString("EAbilities.9")), //$NON-NLS-1$
	root_target(EnumName.getString("EAbilities.10")), //$NON-NLS-1$
	warp_to_player(EnumName.getString("EAbilities.11")), //$NON-NLS-1$
	shuffle_positions(EnumName.getString("EAbilities.12")), //$NON-NLS-1$
	flood(EnumName.getString("EAbilities.13")), //$NON-NLS-1$
	throw_target(EnumName.getString("EAbilities.14")), //$NON-NLS-1$
	throw_nearby(EnumName.getString("EAbilities.15")), //$NON-NLS-1$
	throw_distant(EnumName.getString("EAbilities.16")), //$NON-NLS-1$
	pull_target(EnumName.getString("EAbilities.17")), //$NON-NLS-1$
	pull_nearby(EnumName.getString("EAbilities.18")), //$NON-NLS-1$
	pull_distant(EnumName.getString("EAbilities.19")), //$NON-NLS-1$
	fetch_target(EnumName.getString("EAbilities.20")), //$NON-NLS-1$
	fetch_nearby(EnumName.getString("EAbilities.21")), //$NON-NLS-1$
	fetch_distant(EnumName.getString("EAbilities.22")); //$NON-NLS-1$

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
						"No enum constant EAbilities." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}

}
