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
	
	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link EGrowth#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EGrowth getByName(String name) {

		if (name!=null) {
			EGrowth[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EGrowth." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}
}
