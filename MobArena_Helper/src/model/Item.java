package model;

import java.util.ArrayList;

import model.enums.EEnchantment;
import model.enums.EItem;

public class Item implements Comparable<Item> {

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
	
	public String getMap() {

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

	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		int oid, tid;
		EItem oitem, titem;
		oitem = o.getItem();
		titem = this.item;
		oid = oitem.getId();
		tid = titem.getId();
		
		if(tid > oid) return -1;
		else if (tid < oid) return 1;
		else {
			if(titem.getMeta() > oitem.getMeta()) return -1;
			else if(titem.getMeta() < oitem.getMeta()) return 1;
			else return 0;
		}
	}

}

class Armor extends Item {

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
