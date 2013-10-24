package model;

import java.util.ArrayList;

import model.enums.EItem;

public class Armor extends Item {

	public Armor(EItem item, String[] enchantements) {
		super(item, 1, enchantements);
	}
	
	public String toString() {
		return getItem().getName();
	}
	
	public String getMap() {

		EItem thisitem = getItem();
		int thisquantity = getQuantity();
		ArrayList<Enchantment> thisenchantements = getEnchantements();
		
		StringBuffer item = new StringBuffer(thisitem.getId()+"");
		
		if(thisitem.getMeta()!=0) item.append(":"+thisitem.getMeta()+":"+thisquantity);
		else {
			if(thisquantity>1) {
				item.append(":"+thisquantity);
			}
		}
		
		for(int i=0;i<thisenchantements.size();i++) {
			
			if(i==0) item.append(" ");
			else item.append(";");
			
			item.append(thisenchantements.get(i).toString());
		}
		
		return item.toString();
	}
	
}