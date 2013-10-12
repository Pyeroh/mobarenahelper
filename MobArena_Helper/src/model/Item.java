package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.enums.EEnchantment;
import model.enums.EItem;

public class Item {

	private EItem item;
	private int quantity = 1;
	private ArrayList<Enchantment> enchantements = new ArrayList<>();
	
	public Item(EItem item, int quantity, String[] enchantements) {
		this.item = item;
		this.quantity = quantity;
		
		for (String enchant : enchantements) {
			String[] e_caracs = enchant.split(":");
			int id = Integer.parseInt(e_caracs[0]);
			int lvl = Integer.parseInt(e_caracs[1]);
			this.enchantements.add(new Enchantment(EEnchantment.getById(id), lvl));
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
	
	protected String getMap() {
		//TODO getMap() pour Item
		StringBuffer item = new StringBuffer(this.item.getRealName().toLowerCase());
		if(this.item.getMeta()!=0) {
			item.append(":"+this.item.getMeta()+":"+quantity);
		}
		else {
			if(quantity>1) {
				item.append(":"+quantity);
			}
		}
		return item.toString();
	}

}

class Armor extends Item {

	public Armor(EItem item, String[] enchantements) {
		super(item, 1, enchantements);
	}
	
}
