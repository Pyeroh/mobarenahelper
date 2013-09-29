package model;

import model.enums.EMonsters;

public class Monstre {
	private EMonsters monstre;
	private int probability;
	
	/**
	 * Instancie un monstre, avec une probabilité dans la liste  des monstres d'une vague.
	 * Si le monstre est unique dans la vague, sa proba est de 0.
	 * @param monstre
	 * @param proba
	 */
	public Monstre(EMonsters monstre, int proba){
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
	
	public String toString() {
		String ret = monstre + " : " + probability;
		return ret;
	}
}
