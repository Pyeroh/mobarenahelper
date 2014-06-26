package model.lists;

import java.util.ArrayList;

import model.enums.EItem;
import model.item.*;

/**
 * Liste d'items ; permet de remplir une liste à partir d'une chaine et de la trier
 *
 * @author Pyeroh
 *
 */
public class ItemList extends ArrayList<AbstractItem> {

	private static final long serialVersionUID = -1822352239305240836L;

	public ItemList() {
		super();
	}

	public ItemList(ArrayList<AbstractItem> list) {
		super(list);
	}

	/**
	 * Remplis la liste à partir de la chaine de caractères contenant les différents items. Gère également
	 * l'enchantement.
	 *
	 * @param items
	 */
	public void fill(String items) {

		if (!items.trim().isEmpty()) {
			String[] sItem = items.replace('\'', ' ').split(",");
			for (int i = 0; i < sItem.length; i++) {
				// SE : sans espace --> test d'enchantement
				String sItemSE[] = sItem[i].trim().split(" ");

				String[] tab_item = sItemSE[0].split(":");
				int data = 0;
				int quantity = 1;
				switch (tab_item.length) {
				case 1:
					break;
				case 2:
					quantity = Integer.parseInt(tab_item[1]);
					break;
				case 3:
					data = Integer.parseInt(tab_item[1]);
					quantity = Integer.parseInt(tab_item[2]);
					break;
				default:
					break;
				}

				String[] enchantments = null;
				if (sItemSE.length == 2) {
					enchantments = sItemSE[1].split(";");
				}

				if (tab_item[0].matches("\\d+")) {
					EItem ei = EItem.searchBy(Integer.parseInt(tab_item[0]), data);
					if (ei != null)
						this.add(new Item(ei, quantity, enchantments));
					else {
						CustomItem ci = new CustomItem(Integer.parseInt(tab_item[0]), data, quantity);
						if (enchantments != null) {
							ci.getEnchantements().fill(enchantments);
						}
						this.add(ci);
					}
				}
				else if (tab_item[0].matches("\\$ ?\\d+([,\\.]\\d+)?")) {
					this.add(new Money(Float.parseFloat(tab_item[0].substring(1))));
				}
				else {
					this.add(new Item(EItem.searchBy(tab_item[0], data), quantity, enchantments));
				}

			}
		}
	}

	/**
	 * Renvoie la liste des items sous forme de chaîne, séparés par des virgules
	 *
	 * @return
	 */
	public String getString() {
		StringBuffer sItems = new StringBuffer();
		if (this.size() == 1) {
			String item = this.get(0).getString();
			sItems.append(item);
		}
		else if (this.size() > 1) {
			for (int i = 0; i < this.size(); i++) {
				sItems.append(this.get(i).getString() + ", ");
			}
			int length = sItems.length();
			sItems.delete(length - 2, length);
		}

		return sItems.toString().trim();
	}

	/**
	 * Vérifie si l'EItem passé en paramètre a déjà un Item associé dans la liste
	 *
	 * @param e
	 * @return {@code true} si l'EItem existe, {@code false} sinon
	 */
	public boolean containsEItem(EItem e) {
		return indexofEItem(e) != -1;
	}

	/**
	 * Renvoie la liste des constantes qui composent les items de la liste
	 *
	 * @return la liste des constantes
	 * @see EItem
	 */
	public ArrayList<EItem> getEItemList() {
		ArrayList<EItem> eitems = new ArrayList<>();
		for (int i = 0; i < size(); i++) {
			eitems.add(get(i).getItem());
		}
		return eitems;
	}

	/**
	 * Renvoie la position d'un EItem dans la liste
	 *
	 * @param e
	 * @return l'index de l'objet, -1 sinon
	 */
	public int indexofEItem(EItem e) {
		int index = -1, i = 0;
		while (i < size() && get(i).getItem() != e) {
			i++;
		}
		if (i < this.size())
			index = i;
		return index;
	}

	/**
	 * Permet de trier la liste
	 */
	public void sort() {
		int size = this.size();
		triRapide(this, 0, size - 1);
	}

	private int partition(ItemList list, int deb, int fin) {
		int compt = deb;
		AbstractItem pivot = list.get(deb);

		for (int i = deb + 1; i <= fin; i++) {
			EItem litem = list.get(i).getItem();
			EItem pivitem = pivot.getItem();
			if ((litem.getId() < pivitem.getId()) || (litem.getId() == pivitem.getId() && litem.getMeta() < pivitem.getMeta())) {
				compt++;
				echanger(list, compt, i);
			}
		}
		echanger(list, deb, compt);
		return compt;
	}

	protected void triRapide(ItemList list, int deb, int fin) {
		if (deb < fin) {
			int positionPivot = partition(list, deb, fin);
			triRapide(list, deb, positionPivot - 1);
			triRapide(list, positionPivot + 1, fin);
		}
	}

	protected void echanger(ItemList list, int deb, int fin) {
		AbstractItem temp = list.get(deb);
		list.set(deb, list.get(fin));
		list.set(fin, temp);
	}
}