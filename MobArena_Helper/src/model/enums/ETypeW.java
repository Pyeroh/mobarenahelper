package model.enums;

import java.awt.Image;
import java.awt.Toolkit;

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
		this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gui/"+nom.toLowerCase()+".png"));
	}

	public String getNom() {
		return nom;
	}

	public Image getImage() {
		return image;
	}

	public static String[] namevalues(){

		ETypeW[] values = values();
		String[] namevalues = new String[values.length-2];
		for (int i=0;i<namevalues.length;i++) {
			StringBuffer nom = new StringBuffer(values[i].getNom());
			nom.replace(0, 1, nom.substring(0, 1).toUpperCase());
			namevalues[i] = nom.toString();
		}
		return namevalues;
	}

}
