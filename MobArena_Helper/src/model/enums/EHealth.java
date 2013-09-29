package model.enums;

public enum EHealth {
	verylow("Very low"),
	low("Low"),
	medium("Medium"),
	high("High"),
	veryhigh("Very high"),
	psycho("Psycho");

	private String nom;

	EHealth(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static String[] namevalues(){

		EHealth[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}

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
				IllegalArgumentException e = new IllegalArgumentException(
						"No enum constant "
								+ EMonsters.angry_wolf.getDeclaringClass()
								.getName() + "." + name);
				e.printStackTrace();
			}
		}
		else {
			NullPointerException e = new NullPointerException("Name is null");
			e.printStackTrace();
		}

		return null;

	}

}
