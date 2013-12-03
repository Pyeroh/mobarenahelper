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
	
	public static void load() {
		ERewardType[] values = values();
		for(int i=0;i<values.length;i++) {
			values[i].nom = EnumName.getString("ERewardType."+i);
		}
	}
	
}
