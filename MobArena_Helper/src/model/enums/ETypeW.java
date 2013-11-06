package model.enums;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * Les types de vague possibles
 * @author Pyeroh
 *
 */
public enum ETypeW {
	Default("default"),
	Special("special"),
	Swarm("swarm"),
	Boss("boss"),
	Supply("supply"),
	Upgrade("upgrade");

	private String nom;
	private Image image;

	ETypeW(String nom){
		this.nom = nom;
		this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui/pics/"+nom.toLowerCase()+".png"));
	}

	public String getNom() {
		return nom;
	}

	public Image getImage() {
		return image;
	}

	/**
	 * Renvoie la liste des noms des constantes.
	 * @return la liste des noms des constantes.
	 */
	public static String[] namevalues(){

		ETypeW[] values = values();
		String[] namevalues = new String[values.length];
		for (int i=0;i<namevalues.length;i++) {
			StringBuffer nom = new StringBuffer(values[i].name());
			namevalues[i] = nom.toString();
		}
		return namevalues;
	}

}
