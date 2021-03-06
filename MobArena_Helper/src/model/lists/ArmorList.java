package model.lists;

import java.util.ArrayList;

import model.enums.EItem;
import model.exceptions.ArenaException;
import model.item.*;

/**
 * Liste des pi�ces d'armure ; permet de remplir une liste � partir d'une chaine, et de la trier
 *
 * @author Pyeroh
 *
 */
public class ArmorList extends ItemList {

	private static final long serialVersionUID = -6274717578188692826L;

	public ArmorList() {
		super();
	}

	public ArmorList(ArrayList<AbstractItem> list) {
		super(list);
	}

	/**
	 * Remplis la liste avec la chaine de caract�res pass�e en param�tre, en la d�coupant. G�re �galement
	 * l'enchantement.
	 *
	 * @throws ArenaException
	 */
	@Override
	public void fill(String armor) throws ArenaException {

		if (!armor.trim().isEmpty()) {
			String[] sArmor = armor.replace('\'', ' ').split(",");
			for (int i = 0; i < sArmor.length; i++) {
				// SE : sans espace --> test d'enchantement
				String sArmorSE[] = sArmor[i].trim().split(" ");

				String[] tab_item = sArmorSE[0].split(":");
				int data = 0;
				switch (tab_item.length) {
				case 1:
				case 2:
					break;
				case 3:
					data = Integer.parseInt(tab_item[1]);
					break;
				default:
					break;
				}

				String[] enchantments = null;
				if (sArmorSE.length == 2) {
					enchantments = sArmorSE[1].split(";");
				}

				if (tab_item[0].matches("\\d+")) {
					EItem ei = EItem.searchBy(Integer.parseInt(tab_item[0]), data);
					if (ei != null)
						try {
							this.add(new Armor(ei, enchantments));
						}
						catch (ArenaException e) {
							throw new ArenaException("Unknown armor : " + tab_item[0] + (data != 0 ? ":" + data : ""));
						}
					else {
						CustomItem ci = new CustomItem(Integer.parseInt(tab_item[0]), data);
						ci.getEnchantements().fill(enchantments);
						this.add(ci);
					}
				}
				else {
					try {
						this.add(new Armor(EItem.searchBy(tab_item[0], data), enchantments));
					}
					catch (ArenaException e) {
						throw new ArenaException("Unknown armor : " + tab_item[0] + (data != 0 ? ":" + data : ""));
					}
				}

			}
		}
	}

	@Override
	public void sort() {
		int size = this.size();
		triRapide(this, 0, size - 1);
	}

	private int partition(ArmorList list, int deb, int fin) {
		int compt = deb;
		AbstractItem pivot = list.get(deb);

		for (int i = deb + 1; i <= fin; i++) {
			float lid = (list.get(i).getItem().getId() - 298) / 4f;
			float pivid = (pivot.getItem().getId() - 298) / 4f;

			lid = lid - (int) lid;
			pivid = pivid - (int) pivid;
			if (lid < pivid) {
				compt++;
				echanger(list, compt, i);
			}
		}
		echanger(list, deb, compt);
		return compt;
	}

	/**
	 * M�thode utilis�e pour trier la liste
	 *
	 * @see ItemList
	 */
	protected void triRapide(ArmorList list, int deb, int fin) {
		if (deb < fin) {
			int positionPivot = partition(list, deb, fin);
			triRapide(list, deb, positionPivot - 1);
			triRapide(list, positionPivot + 1, fin);
		}
	}

}