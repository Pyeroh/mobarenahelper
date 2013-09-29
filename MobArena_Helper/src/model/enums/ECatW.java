package model.enums;

public enum ECatW {
	recurrent("Recurrent"),
	single("Single");

	private String nom;

	ECatW(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public static String[] namevalues(){

		ECatW[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

}
