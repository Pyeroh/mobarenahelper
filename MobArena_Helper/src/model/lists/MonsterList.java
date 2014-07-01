package model.lists;

import java.util.ArrayList;

import model.data.*;
import model.enums.EMonsters;

/**
 * Liste de monstres liée à une vague
 *
 * @author Pyeroh
 * @see Wave
 * @see Monstre
 * @see EMonsters
 */
public class MonsterList extends ArrayList<Monstre> {

	private static final long serialVersionUID = -7703494044357940586L;

	/**
	 * Renvoie la probabilité cumulée de la liste
	 *
	 * @return la somme des "probabilités" des monstres de la liste
	 */
	public int getTotalNumber() {
		int tot = 0;
		for (int i = 0; i < this.size(); i++) {
			tot += this.get(i).getProbability();
		}

		return tot;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (this.size() != 0) {
			for (int i = 0; i < this.size(); i++) {
				buffer.append("(" + this.get(i).toString() + ")/");
			}
			String ret = buffer.substring(0, buffer.length() - 1);
			return ret;
		}
		else {
			return "";
		}
	}

	@Override
	public boolean contains(Object o) {
		EMonsters monster = (EMonsters) o;
		boolean contain = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).getMonstre() == monster) {
				contain = true;
			}
		}
		return contain;

	}

}
