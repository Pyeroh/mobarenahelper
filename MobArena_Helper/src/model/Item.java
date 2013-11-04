package model;

import java.util.ArrayList;

import model.enums.EEnchantment;
import model.enums.EItem;

public class Item {

	private EItem item;
	private int quantity = 1;
	private ArrayList<Enchantment> enchantements = new ArrayList<>();
	
	public Item(EItem item, int quantity, String[] enchantments) {
		this.item = item;
		this.quantity = quantity;
		
		if (enchantments!=null) {
			for (String enchant : enchantments) {
				String[] e_caracs = enchant.split(":");
				int id = Integer.parseInt(e_caracs[0]);
				int lvl = Integer.parseInt(e_caracs[1]);
				this.enchantements.add(new Enchantment(
						EEnchantment.getById(id), lvl));
			}
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
	
	public String toString() {
		return quantity+" "+item.getName();
	}

	public ArrayList<Enchantment> getEnchantements() {
		return enchantements;
	}
	
	public String getString() {

		StringBuffer item = new StringBuffer(this.item.getRealName().toLowerCase());
		
		if(this.item.getMeta()!=0) item.append(":"+this.item.getMeta()+":"+quantity);
		else {
			if(quantity>1) {
				item.append(":"+quantity);
			}
		}
		
		for(int i=0;i<enchantements.size();i++) {
			
			if(i==0) item.append(" ");
			else item.append(";");
			
			item.append(enchantements.get(i).toString());
		}
		
		return item.toString();
	}

}