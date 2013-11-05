package model;

import model.enums.EItem;
import model.lists.EnchantList;

public class Armor extends Item {

	public Armor(EItem item, String[] enchantements) {
		super(item, 1, enchantements);
	}
	
	public String toString() {
		return getItem().getName();
	}
	
	public String getString() {
		return getString(true);
	}
	
	public String getString(boolean numberformat) {
		
		EItem thisitem = getItem();
		int thisquantity = getQuantity();
		EnchantList thisenchantements = getEnchantements();
		
		StringBuffer item = new StringBuffer((numberformat ? thisitem.getId() : thisitem.getRealName())+"");
		
		if(thisitem.getMeta()!=0) item.append(":"+thisitem.getMeta()+":"+thisquantity);
		else {
			if(thisquantity>1) {
				item.append(":"+thisquantity);
			}
		}
		
		for(int i=0;i<thisenchantements.size();i++) {
			
			if(i==0) item.append(" ");
			else item.append(";");
			
			item.append(thisenchantements.get(i).getString());
		}
		
		return item.toString();
		
	}
	
}
