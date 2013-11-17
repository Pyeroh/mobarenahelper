package model.enums;

import java.awt.Image;

import javax.swing.ImageIcon;

import model.EnumName;

/**
 * Les types de vague possibles
 * @author Pyeroh
 *
 */
public enum ETypeW {
	Default(EnumName.getString("ETypeW.0")), //$NON-NLS-1$
	Special(EnumName.getString("ETypeW.1")), //$NON-NLS-1$
	Swarm(EnumName.getString("ETypeW.2")), //$NON-NLS-1$
	Boss(EnumName.getString("ETypeW.3")), //$NON-NLS-1$
	Supply(EnumName.getString("ETypeW.4")), //$NON-NLS-1$
	Upgrade(EnumName.getString("ETypeW.5")); //$NON-NLS-1$

	private String nom;
	private Image image;

	ETypeW(String nom){
		this.nom = nom;
		this.image = new ImageIcon(getClass().getClassLoader().getResource("gui/pics/"+name().toLowerCase()+".png")).getImage(); //$NON-NLS-1$ //$NON-NLS-2$
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
			namevalues[i] = values[i].getNom();
		}
		return namevalues;
	}
	
	/**
	 * Renvoie la constante associée au nom passé en paramètre.
	 * @param name ce qui peut être renvoyé par {@link ETypeW#getNom()}
	 * @return la constante
	 * @throws IllegalArgumentException si la constante n'existe pas
	 * @throws NullPointerException si le paramètre vaut {@code null}
	 */
	public static ETypeW getByName(String name) {

		if (name!=null) {
			ETypeW[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getNom().equals(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant ETypeW." + name); //$NON-NLS-1$
			}
		}
		else {
			throw new NullPointerException("Name is null"); //$NON-NLS-1$
		}

	}
	
	public static void load() {
		ETypeW[] values = values();
		for(int i=0;i<values.length;i++) {
			values[i].nom = EnumName.getString("ETypeW."+i);
		}
	}
	

}
