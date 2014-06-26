package model.enums;

import model.EnumName;

/**
 * Les deux catégories de vague
 *
 * @author Pyeroh
 *
 */
public enum ECatW {
	recurrent(EnumName.getString("ECatW.0")), //$NON-NLS-1$
	single(EnumName.getString("ECatW.1")); //$NON-NLS-1$

	private String nom;

	ECatW(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 *
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues() {

		ECatW[] values = values();
		String[] namevalues = new String[values.length];
		for (int i = 0; i < namevalues.length; i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

	public static void load() {
		ECatW[] values = values();
		for (int i = 0; i < values.length; i++) {
			values[i].nom = EnumName.getString("ECatW." + i);
		}
	}

}
