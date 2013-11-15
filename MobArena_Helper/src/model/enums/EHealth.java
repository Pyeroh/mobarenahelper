package model.enums;

import model.EnumName;

/**
 * Les diff�rentes valeurs de sant� existant
 * @author Pyeroh
 *
 */
public enum EHealth {
	verylow(EnumName.getString("EHealth.0")), //$NON-NLS-1$
	low(EnumName.getString("EHealth.1")), //$NON-NLS-1$
	medium(EnumName.getString("EHealth.2")), //$NON-NLS-1$
	high(EnumName.getString("EHealth.3")), //$NON-NLS-1$
	veryhigh(EnumName.getString("EHealth.4")), //$NON-NLS-1$
	psycho(EnumName.getString("EHealth.5")); //$NON-NLS-1$

	private String nom;

	EHealth(String nom){
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

		EHealth[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

	/**
	 * Renvoie la constante associ�e au nom pass� en param�tre.
	 * @param name ce qui peut �tre renvoy� par {@link EHealth#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le param�tre vaut {@code null}
	 */
	public static EHealth getByName(String name) {

		if (name!=null) {
			EHealth[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EHealth." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}

}
