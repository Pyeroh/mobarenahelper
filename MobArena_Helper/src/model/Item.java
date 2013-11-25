package model;

import model.enums.EItem;
import model.lists.EnchantList;
import model.lists.ItemList;

/**
 * L'existence réelle d'un item. Représente un item, dans une certaine quantité, et auquel est associé certains enchantements.
 * @author Pyeroh
 * @see EItem
 * @see ItemList
 */
public class Item {

	private EItem item;
	private int quantity = 1;
	private EnchantList enchantements = new EnchantList();
	
	/**
	 * Instancie un Item avec ce qu'il est, sa quantité, et ses enchantements.
	 * @param item
	 * @param quantity
	 * @param enchantments
	 */
	public Item(EItem item, int quantity, String[] enchantments) {
		this.item = item;
		this.quantity = quantity;
		
		if (enchantments!=null) {
			enchantements.fill(enchantments);
		}
		
	}
	
	public EItem getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return quantity+" "+item.getGuiName();
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
				item.append(":" + this.item.getMeta() + ":" + quantity);
			else {
				if (quantity > 1) {
					item.append(":" + quantity);
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