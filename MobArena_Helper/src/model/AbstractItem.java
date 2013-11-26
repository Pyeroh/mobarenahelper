package model;

public abstract class AbstractItem {

	private int quantity = 1;

	public AbstractItem(int quantity) {
		this.quantity = quantity;
	}
	
	public AbstractItem() {}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public abstract String getString();
	
}
