package model.enums;

import model.EnumName;

/**
 * La quantité de monstres
 * @author Pyeroh
 *
 */
public enum EAmount {
	verylow(EnumName.getString("EAmount.0")), //$NON-NLS-1$
	low(EnumName.getString("EAmount.1")), //$NON-NLS-1$
	medium(EnumName.getString("EAmount.2")), //$NON-NLS-1$
	high(EnumName.getString("EAmount.3")), //$NON-NLS-1$
	veryhigh(EnumName.getString("EAmount.4")), //$NON-NLS-1$
	psycho(EnumName.getString("EAmount.5")); //$NON-NLS-1$

	private String nom;

	EAmount(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public String getName() {
		String name = nom;
		name.replace(" ", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		name = name.toLowerCase();
		return name;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues(){

		EAmount[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link EAmount#getName()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EAmount getByName(String name) {

		if (name!=null) {
			EAmount[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EAmount." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}

}
