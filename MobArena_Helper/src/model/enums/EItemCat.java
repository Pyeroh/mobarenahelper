package model.enums;

import model.EnumName;

/**
 * Les catégories d'item existant
 *
 * @author Pyeroh
 *
 */
public enum EItemCat {
	all(EnumName.getString("EItemCat.0")), //$NON-NLS-1$
	block(EnumName.getString("EItemCat.1")), //$NON-NLS-1$
	decoration(EnumName.getString("EItemCat.2")), //$NON-NLS-1$
	redstone(EnumName.getString("EItemCat.3")), //$NON-NLS-1$
	transport(EnumName.getString("EItemCat.4")), //$NON-NLS-1$
	misc(EnumName.getString("EItemCat.5")), //$NON-NLS-1$
	food(EnumName.getString("EItemCat.6")), //$NON-NLS-1$
	tool(EnumName.getString("EItemCat.7")), //$NON-NLS-1$
	weapon(EnumName.getString("EItemCat.8")), //$NON-NLS-1$
	potion(EnumName.getString("EItemCat.9")), //$NON-NLS-1$
	materials(EnumName.getString("EItemCat.10")); //$NON-NLS-1$

	private String gui_name;

	EItemCat(String gui_name) {
		this.gui_name = gui_name;
	}

	public String getGui_name() {
		return gui_name;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 *
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues() {

		EItemCat[] values = values();
		String[] namevalues = new String[values.length];
		for (int i = 0; i < namevalues.length; i++) {
			namevalues[i] = values[i].getGui_name();
		}
		return namevalues;
	}

	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 *
	 * @param name
	 *            ce qui peut être renvoyé par {@link EItemCat#getGui_name()}
	 * @return la constante
	 * @throws IllegalArgumentException
	 *             si la constante n'existe pas
	 * @throws NullPointerException
	 *             si le paramètre vaut {@code null}
	 */
	public static EItemCat getByName(String name) {

		if (name != null) {
			EItemCat[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getGui_name().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			}
			else {
				throw new IllegalArgumentException("No enum constant EItemCat." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}

	public static void load() {
		EItemCat[] values = values();
		for (int i = 0; i < values.length; i++) {
			values[i].gui_name = EnumName.getString("EItemCat." + i);
		}
	}

}
