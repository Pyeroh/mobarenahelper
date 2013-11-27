package model.item;

import model.enums.EItem;
import model.lists.ArmorList;

/**
 * Une pièce d'armure
 * @author Pyeroh
 * @see Item
 * @see ArmorList
 */
public class Armor extends Item {

	/**
	 * Instancie une pièce d'armure avec l'objet qu'elle représente, et ses enchantements.
	 * Sa quantité est toujours de 1 en tant qu'Armor, car il est difficile de porter
	 * plus d'une pièce d'armure à la fois...
	 * @param item
	 * @param enchantements
	 */
	public Armor(EItem item, String[] enchantements) {
		super(item, 1, enchantements);
	}
	
	@Override
	public String toString() {
		return getItem().getGuiName();
	}
	
	@Override
	public String getString() {
		return getString(true);
	}
	
	/**
	 * Voir la description de {@link #getString()}.
	 * @param numberformat permet de spécifier si l'on désire voir le résultat au format numérique ou non.
	 * @return la chaine correspondant aux informations de la pièce d'armure.
	 */
	public String getString(boolean numberformat) {
		
		EItem thisitem = getItem();
		int thisquantity = getQuantity();
		
		if (thisitem!=null) {
			StringBuffer item = new StringBuffer(
					(numberformat ? thisitem.getId() : thisitem.getRealName())
							+ "");
			if (thisitem.getMeta() != 0)
				item.append(":" + thisitem.getMeta() + ":" + thisquantity);
			else {
				if (thisquantity > 1) {
					item.append(":" + thisquantity);
				}
			}
			item.append(getEnchantements().getString());
			return item.toString();
		}
		else return "";
		
	}
	
}
