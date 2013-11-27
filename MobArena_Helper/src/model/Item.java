package model;

import model.enums.EItem;
import model.lists.ItemList;

/**
 * L'existence r�elle d'un item. Repr�sente un item, dans une certaine quantit�, et auquel est associ� certains enchantements.
 * @author Pyeroh
 * @see EItem
 * @see ItemList
 */
public class Item extends AbstractItem {

	private EItem item;
	
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
			getEnchantements().fill(enchantments);
		}
		
	}
	
	public EItem getItem() {
		return item;
	}
	
	@Override
	public String toString() {
		return getQuantity()+" "+item.getGuiName();
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
			item.append(getEnchantements().getString());
			return item.toString();
		}
		else return "";
	}

}