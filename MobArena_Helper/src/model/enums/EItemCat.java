package model.enums;

/**
 * Les catégories d'item existant
 * @author Pyeroh
 *
 */
public enum EItemCat {
	all("All"),
	block("Building blocks"),
	decoration("Decoration blocks"),
	redstone("Redstone"),
	transport("Transportation"),
	misc("Miscellaneous"),
	food("Foodstuffs"),
	tool("Tools"),
	weapon("Combat"),
	potion("Brewing"),
	materials("Materials");
	
	private String gui_name;
	
	EItemCat(String gui_name) {
		this.gui_name = gui_name;
	}

	public String getGui_name() {
		return gui_name;
	}
	
	/**
	 * Renvoie la liste des noms des constantes.
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues(){

		EItemCat[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getGui_name();
		}
		return namevalues;
	}
	
	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link EItemCat#getGui_name()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static EItemCat getByName(String name) {

		if (name!=null) {
			EItemCat[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getGui_name().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EItemCat." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

}
