package model;

import java.io.Serializable;

import model.enums.EMonsters;
import model.lists.MonsterList;

/**
 * L'existence r�elle d'un monstre, c'est � dire un monstre et la probabilit� qu'il a d'apparaitre.
 *
 * @author Pyeroh
 * @see EMonsters
 * @see MonsterList
 */
public class Monstre implements Serializable {

	private static final long serialVersionUID = 1080295976675702353L;

	private EMonsters monstre;

	private int probability;

	/**
	 * Instancie un monstre, avec une probabilit� dans la liste des monstres d'une vague. Si le monstre est unique dans
	 * la vague, sa proba est de 0.
	 *
	 * @param monstre
	 * @param proba
	 */
	public Monstre(EMonsters monstre, int proba) {
		this.monstre = monstre;
		this.probability = proba;
	}

	public EMonsters getMonstre() {
		return monstre;
	}

	public void setMonstre(EMonsters monstre) {
		this.monstre = monstre;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		String ret = monstre + " : " + probability;
		return ret;
	}
}
