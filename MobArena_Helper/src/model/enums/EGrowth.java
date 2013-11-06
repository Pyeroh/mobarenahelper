package model.enums;

/**
 * La croissance d'une vague
 * @author Pyeroh
 *
 */
public enum EGrowth {
	old("Old"),
	slow("Slow"),
	medium("Medium"),
	fast("Fast"),
	psycho("Psycho");

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
