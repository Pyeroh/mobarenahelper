package model.enums;

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

	public static String[] namevalues(){

		EGrowth[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
}
