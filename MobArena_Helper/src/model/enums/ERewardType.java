package model.enums;

import model.EnumName;

/**
 * Les deux types de récompense de vague
 * @author Pyeroh
 *
 */
public enum ERewardType {

	every(EnumName.getString("ERewardType.0")), //$NON-NLS-1$
	after(EnumName.getString("ERewardType.1")); //$NON-NLS-1$
	
	private String nom;
	
	private ERewardType(String nom) {
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

		ERewardType[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
	
	public static ERewardType getByName(String name) {
		if (name!=null) {
			ERewardType[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant ERewardType." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}
	}
	
	public static void load() {
		ERewardType[] values = values();
		for(int i=0;i<values.length;i++) {
			values[i].nom = EnumName.getString("ERewardType."+i);
		}
	}
	
}
