package model;

import model.enums.EItem;
import model.lists.EnchantList;
import model.lists.ItemList;

/**
 * L'existence r�elle d'un item. Repr�sente un item, dans une certaine quantit�, et auquel est associ� certains enchantements.
 * @author Pyeroh
 * @see EItem
 * @see ItemList
 */
public class Item extends AbstractItem {

	private EItem item;
	private EnchantList enchantements = new EnchantList();
	
	/**
	 * Instancie un Item avec ce qu'il est, sa quantit�, et ses enchantements.
	 * @param item
	 * @param quantity
	 * @param enchantments
	 */
	public Item(EItem item, int quantity, String[] enchantments) {
		super(quantity);
		this.item = item;
				
		if (enchantments!=null) {
			enchantements.fill(enchantments);
		}
		
	}
	
	public EItem getItem() {
		return item;
	}
	
	@Override
	public String toString() {
		return getQuantity()+" "+item.getGuiName();
	}

	public EnchantList getEnchantements() {
		return enchantements;
	}
	
	/**
	 * Renvoie la chaine correspondant aux informations de l'Item.
	 * @return la chaine correspondant aux informations de l'Item.
	 */
	public String getString() {

		if (item!=null) {
			StringBuffer item = new StringBuffer(this.item.getRealName()
					.toLowerCase());
			if (this.item.getMeta() != 0)
				item.append(":" + this.item.getMeta() + ":" + getQuantity());
			else {
				if (getQuantity() > 1) {
					item.append(":" + getQuantity());
				}
			}
			for (int i = 0; i < enchantements.size(); i++) {

				if (i == 0)
					item.append(" ");
				else
					item.append(";");

				item.append(enchantements.get(i).getString());
			}
			return item.toString();
		}
		else return "";
	}

}