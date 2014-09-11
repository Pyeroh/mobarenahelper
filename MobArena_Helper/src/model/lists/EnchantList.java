package model.lists;

import java.util.ArrayList;

import model.enums.EEnchantment;
import model.item.Enchantment;
import model.item.Item;

/**
 * Liste d'enchantements pour un item donné
 *
 * @author Pyeroh
 * @see Item
 */
public class EnchantList extends ArrayList<Enchantment> {

	private static final long serialVersionUID = -8007639127841701265L;

	@Override
	public boolean contains(Object o) {
		Enchantment e = (Enchantment) o;
		int i = 0;
		while (i < size() && get(i).getEnchantement() != e.getEnchantement())
			i++;
		if (i == size())
			return false;
		return true;
	}

	/**
	 * Remplis la liste avec le tableau de chaînes passé en paramètre
	 *
	 * @param enchantments
	 */
	public void fill(String[] enchantments) {
		for (String enchant : enchantments) {
			String[] e_caracs = enchant.split(":");
			int id = Integer.parseInt(e_caracs[0]);
			int lvl = Integer.parseInt(e_caracs[1]);
			this.add(new Enchantment(EEnchantment.getById(id), lvl));
		}
	}

	/**
	 * Renvoie l'index de l'enchantement passé en paramètre
	 *
	 * @param e
	 *            l'enchantement recherché
	 * @return -1 si l'enchantement en question n'existe pas dans la liste, son indice sinon
	 */
	public int indexofEEnchantment(EEnchantment e) {
		int index = -1, i = 0;
		while (i < size() && get(i).getEnchantement() != e) {
			i++;
		}
		if (i < this.size())
			index = i;
		return index;
	}

	/**
	 * Renvoie la liste des constantes qui composent la liste
	 *
	 * @return
	 */
	public ArrayList<EEnchantment> getEEnchantmentList() {
		ArrayList<EEnchantment> eenchantment = new ArrayList<EEnchantment>();
		for (int i = 0; i < size(); i++) {
			eenchantment.add(get(i).getEnchantement());
		}
		return eenchantment;
	}

	public String getString() {
		StringBuffer enchant = new StringBuffer("");
		for (int i = 0; i < size(); i++) {

			if (i == 0)
				enchant.append(" ");
			else
				enchant.append(";");

			enchant.append(get(i).getString());
		}
		return enchant.toString();
	}

}
