package model.enums;

import model.EnumName;

/**
 * La croissance d'une vague
 * @author Pyeroh
 *
 */
public enum EGrowth {
	old(EnumName.getString("EGrowth.0")), //$NON-NLS-1$
	slow(EnumName.getString("EGrowth.1")), //$NON-NLS-1$
	medium(EnumName.getString("EGrowth.2")), //$NON-NLS-1$
	fast(EnumName.getString("EGrowth.3")), //$NON-NLS-1$
	psycho(EnumName.getString("EGrowth.4")); //$NON-NLS-1$

	private String nom;

	EGrowth(String nom){
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

		EGrowth[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
}
