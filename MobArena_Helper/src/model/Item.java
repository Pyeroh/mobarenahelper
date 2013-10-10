package model;

import model.enums.EItem;

public class Item {

	private EItem item;
	private int quantity = 1;
	
	public Item(EItem item, int quantity) {
		this.item = item;
		this.quantity = quantity;
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
	
}
