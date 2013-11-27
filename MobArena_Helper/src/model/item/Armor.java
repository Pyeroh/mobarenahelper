package model.item;

import model.enums.EItem;
import model.lists.ArmorList;

/**
 * Une pi�ce d'armure
 * @author Pyeroh
 * @see Item
 * @see ArmorList
 */
public class Armor extends Item {

	/**
	 * Instancie une pi�ce d'armure avec l'objet qu'elle repr�sente, et ses enchantements.
	 * Sa quantit� est toujours de 1 en tant qu'Armor, car il est difficile de porter
	 * plus d'une pi�ce d'armure � la fois...
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
	 * @param numberformat permet de sp�cifier si l'on d�sire voir le r�sultat au format num�rique ou non.
	 * @return la chaine correspondant aux informations de la pi�ce d'armure.
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
